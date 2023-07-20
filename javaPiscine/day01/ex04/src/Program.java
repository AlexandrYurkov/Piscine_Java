import java.util.Arrays;

public class Program {
    public static void main(String[] args) {



//        System.out.println(user1);
//        System.out.println(user2);
//        System.out.println("---------------------");
//        Transaction credit = new Transaction(user1, user2, -50, TranslationCategory.CREDIT);
//        credit.confirmation();
//        System.out.println(user1);
//        System.out.println(user2);
//
//        System.out.println("---------------------");
//        Transaction credit1 = new Transaction(user1, user2, 0, TranslationCategory.CREDIT);
//        credit1.confirmation();
//        System.out.println(user1);
//        System.out.println(user2);
//
//        System.out.println("---------------------");
//        Transaction credit2 = new Transaction(user3, user4, -50, TranslationCategory.CREDIT);
//        credit2.confirmation();
//        System.out.println(user3);
//        System.out.println(user4);
//        System.out.println("---------------------");
//        System.out.println(user1);
//        System.out.println(user2);
//        System.out.println(user3);
//        System.out.println(user4);
//        System.out.println("---------------------");
//
//        User[] users = new User[10];
//        for(int i = 0; i < 10; i++){
//            users[i] = new User("User_" + i, 100+i*10);
//        }
//        User user = new User("test", 100);
//        UserArrayList test = new UserArrayList();
//        for (User value : users) {
//            test.add(value);
//        }
//        test.add(user);
//        test.add(users[1]);
//        System.out.println(test.getUserIndex(11));
//        try{
//            System.out.println(test.getUserID(13));
//        } catch (UserNotFoundException e){
//            System.out.println(e.getMessage());
//        }
//        System.out.println(test.getUserID(12));
//        System.out.println(test.sizeUser());
//        LinkedList<User> users = new LinkedList<>();
//        for(int i = 0; i < 12; i++){
//            users.add(new User("user" + i, i*10+100));
//        }
//        users.add(new User("test", 111));
//        System.out.println(Arrays.toString(users.toArray()));
//        System.out.println(users.listIterator(3).previous());
//
        TransactionsService service = new TransactionsService();
        for (int i = 0; i < 13; i++)
            service.addUser("User" + (i+1), 100 + i * 30);
        User user11 = new User( "User11", 100);
        User user12 = new User( "User12", 100);
        Transaction test1 = new Transaction(user11, user12, 20, TranslationCategory.DEBIT);
        test1.confirmation();
        Transaction test2 = new Transaction(user11, user12, -20, TranslationCategory.CREDIT);
        test2.confirmation();
        service.setTransactionsList(test1);
        service.setTransactionsList(test2);
//        System.out.println(Arrays.toString(service.getUsers()));
        System.out.println(service.usersBalance(1));
        System.out.println(service.usersBalance(2));
        try{
            service.transaction(1,2, 30);
            service.transaction(3,4, -30);
            service.transaction(5,6, 43);
            service.transaction(5,3, 13);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        System.out.println(Arrays.toString(service.listTransactions(1)));

        System.out.println(service.usersBalance(3));
        System.out.println(service.usersBalance(4));
        System.out.println(Arrays.toString(service.toArrayUUIDTransactions()));
        System.out.println("------------------------------");
        System.out.println(Arrays.toString(service.badTransactions()));


    }
}
