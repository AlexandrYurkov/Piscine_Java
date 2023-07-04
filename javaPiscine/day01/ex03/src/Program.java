import java.util.Arrays;
import java.util.LinkedList;

public class Program {
    public static void main(String[] args) {

//        User user1 = new User( "User1", 100);
//        User user2 = new User( "User2", 100);
//        User user3 = new User( "User3", 100);
//        User user4 = new User( "User4", 100);
//        Transaction test1 = new Transaction(user1, user2, 20, TranslationCategory.DEBIT);
//        test1.confirmation();
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
        TransactionsLinkedList test = new TransactionsLinkedList();
        User one = new User("One", 1111);
        User two = new User("Two", 2222);
        Transaction q = new Transaction( one, two,50, TranslationCategory.DEBIT);
        q.confirmation();
        Transaction t = new Transaction( one, two,50, TranslationCategory.DEBIT);
        t.confirmation();
        Transaction t1 = new Transaction( one, two,-50, TranslationCategory.CREDIT);
        t1.confirmation();
        Transaction v = new Transaction( two, one,50, TranslationCategory.DEBIT);
        t1.confirmation();

        test.addTransaction(q);
        test.addTransaction(t);
        test.addTransaction(t1);
        test.addTransaction(v);
        Transaction[] qwe= test.toArrayTransaction();
        System.out.println(Arrays.toString(test.toArrayTransaction()));
        for(int i = 0; i < qwe.length; i++){
            System.out.println(i + " qwe = " +qwe[i].getUuid());
        }
        System.out.println("--------------end_qwe-----------------");
        try{
            String s = qwe[3].getUuid().toString();
            System.out.println("Delete " + s);
            test.removeTransaction(s);
        } catch (TransactionsListNotFoundException e){
            System.out.println(e.getMessage());
        }

        Transaction[] asd = test.toArrayTransaction();
        System.out.println("-------------------------------");
        for(int i = 0; i < asd.length; i++){
            System.out.println(i + " asd = " +asd[i].getUuid());
        }

    }
}
