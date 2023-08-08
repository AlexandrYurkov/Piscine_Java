public class User {
    private int identifier;
    private String name;
    private int balance;

    public User(String name, int balance) {
        this.identifier = UserIdsGenerator.getInstance().generateId();
        this.name = name;
        this.balance = balance;
    }

    public int getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "identifier= " + identifier +
                ", name= '" + name + '\'' +
                ", balance= " + balance +
                '}';
    }
}
