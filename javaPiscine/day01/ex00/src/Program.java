
public class Program {
    public static void main(String[] args) {
        User user1 = new User(1, "User1", 100);
        User user2 = new User(2, "User2", 100);
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
        System.out.println(user1);
        System.out.println(user2);
    }
}
