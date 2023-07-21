import java.util.UUID;

public class TransactionsService {
    private Transaction transaction;
    private final UserArrayList userList = new UserArrayList();
    private final TransactionsLinkedList transactionsList = new TransactionsLinkedList();

    public TransactionsService() {}

    public void addUser(String name, int balance){
        User user = new User(name, balance);
        userList.add(user);
    }
    public int usersBalance(int id){
        return this.userList.getUserID(id).getBalance();
    }
    public User[] getUsers() {
        return this.userList.getList();
    }
    public void transaction(int userId_1, int userId_2, int summa){
        try {
            User user1 = userList.getUserID(userId_1);
            User user2 = userList.getUserID(userId_2);
            if(summa < 0){ //Дублируется транзакция? Надо, чего нибудь придумать.
                int debit = -1 * summa;
                System.out.println("summa < 0 = " + summa);
                Transaction trans = new Transaction(user1, user2, summa, TranslationCategory.CREDIT);
//                trans.confirmation(); // костыль не подтверждать транзакцию второй раз.
                Transaction tr = new Transaction(trans.getUuid(), user2, user1, debit, TranslationCategory.DEBIT);
                if(tr.confirmationTrans()){
                    transactionsList.addTransaction(trans);
                    transactionsList.addTransaction(tr);
                    tr.confirmation();
                }else
                    throw new IllegalTransactionException("Операция неможет быть выполнена!");
            }
            else if(summa > 0){
                int credit = -1 * summa;
                Transaction trans = new Transaction(user1, user2, summa, TranslationCategory.DEBIT);
                Transaction tr = new Transaction(trans.getUuid(), user2, user1, credit, TranslationCategory.CREDIT);
                if(tr.confirmationTrans()){
                    transactionsList.addTransaction(trans);
                    transactionsList.addTransaction(tr);
                    tr.confirmation();
                }else
                    throw new IllegalTransactionException("Операция неможет быть выполнена!");
                }
            }catch (UserNotFoundException e){
                System.out.println(e.getMessage());
            }
    }

    public Transaction[] listTransactions(int idUser){
        Transaction[] list = transactionsList.toArrayTransaction();
        int count = countTransactions(list, idUser);
        Transaction[] result = new Transaction[count];
        for (int i = 0, j = 0; i < list.length; i++){
            if(list[i].getSender().getIdentifier() == idUser || list[i].getRecipient().getIdentifier() == idUser){
                result[j] = list[i];
                ++j;
            }
        }
        return result;
    }

    public Transaction[] badTransactions(){
        TransactionsLinkedList bad = new TransactionsLinkedList();
        Transaction[] tmp = transactionsList.toArrayTransaction();
        for(int i = 0; i < tmp.length && i+1 != tmp.length; ){
            if(tmp[i].getUuid().equals(tmp[i+1].getUuid()))
                i+=2;
            else{
                int j = 0;
                while (j < tmp.length ){
                    if(i == j)
                        j++;
                    if(!tmp[i].getUuid().equals(tmp[j].getUuid()))
                        j++;
                    else
                        break;
                }
                if(j >= tmp.length)
                    bad.addTransaction(tmp[i]);
                i++;
            }
        }
        return bad.toArrayTransaction();
    }


    private int countTransactions(Transaction[] list, int idUser){
        int count = 0;
        for (int i = 0; i < list.length; i++){
            if(list[i].getSender().getIdentifier() == idUser || list[i].getRecipient().getIdentifier() == idUser)
                count++;
        }
        return count;
    }
//    setTransactionsList должен быть private, для проверок оставлен как public
    public void setTransactionsList(Transaction transaction){
        this.transactionsList.addTransaction(transaction);
    }


    public UUID[] toArrayUUIDTransactions() {
        Transaction[] transactions= transactionsList.toArrayTransaction();
        UUID[] result = new UUID[transactions.length];
        for (int i = 0; i < transactions.length; i++)
            result[i] = transactions[i].getUuid();
        return result;
    }

    public void deleteTransaction(String uuid, int userID){
        this.transactionsList.removeTransaction(uuid, userID);
    }
}
