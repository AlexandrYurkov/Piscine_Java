import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Menu {
    private static String profile;
    private static String password = "12345";
    private static String[] message = {"1. Добавить пользователя",
            "2. Посмотреть баланс пользователей",
            "3. Осуществить перевод",
            "4. Посмотреть все переводы конкретного пользователя",
           "5. DEV - удалить перевод по ID",
            "6. DEV - проверить корректность переводов",
            "7. Завершить выполнение"};
    private TransactionsService service;

    public Menu(String profile) throws IOException {
        if(profile.equals("dev") || profile.equals("Dev")){
            System.out.println("Введите пароль:");
            if(authentication()){
                Menu.profile = profile;
                toStringMenu();
                service = new TransactionsService();
            }else{
                throw new PasswordException("Введен не верный пароль!");
            }
        }else if(profile.equals("production") || profile.equals("Production")){
            Menu.profile = profile;
            toStringMenu();
            service = new TransactionsService();
        }else{
            throw new ManagerMenuException("Пользователя не найдено");
        }

    }
    public void toStringMenu(){
            for(String e : message)
                System.out.println(e);
            System.out.println("--------------------------------");

    }
    private boolean authentication() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String password = reader.readLine();
        if(!Menu.password.equals(password))
            throw new PasswordException("Введен не верный пароль, повторите ввод");
        else
            return true;
    }

    public void managerMenu(int number) throws IOException {
        switch (number){
            case 1 :
                addUser();
                toStringMenu();
                break;
            case 2 :
                balanceUsers();
                toStringMenu();
                break;
            case 3 :
                transactions();
                toStringMenu();
                break;
            case 4 :
                transactionsList();
                toStringMenu();
                break;
            case 5 :
                if(profile.equals("dev") || profile.equals("Dev")){
                    deleteTransaction();
                }else{
                    System.out.println("В доступе отказано! Перезапустите программу от пользователя 'dev'");
                }
                toStringMenu();
                break;
            case 6 :
                if(profile.equals("dev") || profile.equals("Dev")){
                    checkTransactions();
                }else{
                    System.out.println("В доступе отказано! Перезапустите программу от пользователя 'dev'");
                }
                toStringMenu();
                break;
            default:
                throw new ManagerMenuException("Выберите верный вариант меню!");
        }
    }

    private void addUser() throws IOException {
        System.out.println("Введите имя и баланс пользователя:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] date = reader.readLine().split(" ");
        service.addUser(date[0], Integer.parseInt(date[1]));
        User[] users = service.getUsers();
        System.out.println("--------------------------------");
        System.out.println("Пользователь добавлен с id = " + users[users.length -1].getIdentifier());
        System.out.println("--------------------------------");
    }

    private void balanceUsers(){
        User[] users = service.getUsers();
        System.out.println("--------------------------------");
        for(User user : users)
            System.out.println(user.getIdentifier() + ": " + user.getName() + " Balance = " + user.getBalance());
        System.out.println("--------------------------------");
    }

    private void transactions(){
        System.out.println("Введите id-отправителя, id-получается и сумму перевода");
        Scanner scan = new Scanner(System.in);
        int user1 = scan.nextInt();
        int user2 = scan.nextInt();
        int summa = scan.nextInt();
        System.out.println("--------------------------------");
        try {
            service.transaction(user1, user2, summa);
            System.out.println("--------------------------------");
        }catch (IllegalTransactionException e){
            System.out.println(e.getMessage());
            System.out.println("--------------------------------");
        }
    }

    public void transactionsList(){
        System.out.println("Введите id пользователя:");
        Scanner scan = new Scanner(System.in);
        int userID = scan.nextInt();
        Transaction[] result = service.listTransactions(userID);
        for(Transaction a : result){
            User name = (a.getRecipient() == null) ? a.getSender() : a.getRecipient();
            if(name.getIdentifier() == userID){
                System.out.println("To " + name.getName() + "(id = " + name.getIdentifier() + ") " +
                    a.getSumma() + " with id = " + a.getUuid());
            }
        }
        System.out.println("--------------------------------");
    }

    public void deleteTransaction(){
        System.out.println("Введите id пользователя и id перевода:");
        Scanner scan = new Scanner(System.in);
        int userID = scan.nextInt();
        String uuid = scan.nextLine();
        String[] result = service.deleteTransaction(uuid, userID);
        System.out.println("Перевод To " + result[0] + "(id = " +
                result[1] + ") " + result[2] + " удален");
        System.out.println("--------------------------------");
    }

    //6. DEV - проверить корректность переводов
//    Результаты проверки:
//Mike(id = 2) имеет неподтвержденный перевод id = 1fc852e7-914f-4bfd-913d-0313aab1ed99 от John(id = 1) на сумму 150
    public void checkTransactions(){
        System.out.println("Результаты проверки:");
        Transaction[] result = service.badTransactions();
        for(Transaction a : result){
            System.out.println(
                    a.getSender().getName() + "(id = " + a.getSender().getIdentifier()
                    + ") имеет неподтвержденный перевод id = " + a.getUuid() + "от "
                    + a.getRecipient().getName() + "(id = " + a.getRecipient().getIdentifier()
                    + ") на сумму " + a.getSumma());
        }
        System.out.println("--------------------------------");
    }

}//





