
public class Program {
    public static void main(String[] args) {

        User user1 = new User( "User1", 100);
        User user2 = new User( "User2", 100);
        User user3 = new User( "User3", 100);
        User user4 = new User( "User4", 100);
        Transaction test = new Transaction(user1, user2, 20, TranslationCategory.DEBIT);
        test.confirmation();
        System.out.println(user1);
        System.out.println(user2);
        System.out.println("---------------------");
        Transaction credit = new Transaction(user1, user2, -50, TranslationCategory.CREDIT);
        credit.confirmation();
        System.out.println(user1);
        System.out.println(user2);

        System.out.println("---------------------");
        Transaction credit1 = new Transaction(user1, user2, 0, TranslationCategory.CREDIT);
        credit1.confirmation();

        System.out.println("---------------------");
        Transaction credit2 = new Transaction(user3, user4, 50, TranslationCategory.DEBIT);
        credit2.confirmation();
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
        System.out.println(user4);
    }
}
