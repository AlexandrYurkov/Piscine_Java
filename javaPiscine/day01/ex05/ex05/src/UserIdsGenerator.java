public class UserIdsGenerator {
    private int idUser = 0;
    private static final UserIdsGenerator instance = new UserIdsGenerator();
    UserIdsGenerator(){
    }

    public int getIdUser() {
        return idUser;
    }

    public static UserIdsGenerator getInstance() {
        return instance;
    }

    public int generateId(){
        this.idUser += 1;
        return getIdUser();
    }
}
