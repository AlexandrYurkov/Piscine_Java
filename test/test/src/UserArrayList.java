public class UserArrayList implements UserList {
    private User[] list;
    private int size = 0;
    int capacity = 10;

    public UserArrayList() {
        this.list = new User[capacity];
    }

    private UserArrayList(int newCapacity) {
        this.list = new User[newCapacity];
    }

    @Override
    // return UserArrayList
    public User[] add(User user) {
        if (size + 1 >= capacity) {
            list = copyList().list; //error memory?
            list[size] = user;
            this.size++;
            return list;
        }
        list[size] = user;
        this.size++;
        return this.list;
    }

    @Override
    public User getUserID(int id) {
        if (id > this.size)
            throw new UserNotFoundException("You are addressing a non-existent id " + id);
        return getUserIndex(id - 1);
    }

    @Override
    public User getUserIndex(int index) {
        return this.list[index];
    }

    @Override
    public int sizeUser() {
        return this.size;
    }

    public User[] getList() {
        User[] result = new User[size];
        for (int i = 0; i < size; i++)
            result[i] = list[i];
        return result;
    }

    private UserArrayList copyList() {
        int newLen = (int) ((capacity * 1.5) + 1);
        UserArrayList tmp = new UserArrayList(newLen);
        for (int i = 0; i < this.sizeUser(); i++) {
            tmp.add(this.getUserIndex(i));
        }
        return tmp;
    }

}