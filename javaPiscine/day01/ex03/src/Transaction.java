import java.util.UUID;

public class Transaction {
    private UUID uuid;
    private User sender; // отправитель
    private User recipient; // получатель
    private int summa;
    private TranslationCategory trancCategory;

    public Transaction(User sender, User recipient, int summa, TranslationCategory trancCategory) {
        this.uuid = UUID.randomUUID();
        this.sender = sender;
        this.recipient = recipient;
        this.summa = summa;
        this.trancCategory = trancCategory;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public int getSumma() {
        return summa;
    }

    public void setSumma(int summa) {
        this.summa = summa;
    }

    public TranslationCategory getTrancCategory() {
        return trancCategory;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "uuid=" + uuid +
                ", sender=" + sender +
                ", recipient=" + recipient +
                ", summa=" + summa +
                ", trancCategory=" + trancCategory +
                '}';
    }

    public boolean checkTransaction() {
        if (sender.getBalance() < 0) {
            System.err.println("У отправителя отрицательный баланс");
            return false;
        }
        if (getTrancCategory().equals(TranslationCategory.DEBIT)) {
            {
                if (getSumma() < 0) {
                    System.err.println("Не верная сумма");
                    return false;
                } else {
                    return true;
                }
            }
        } else {
            if (getSumma() > 0) {
                System.err.println("Не верная сумма");
                return false;
            } else {
                return true;
            }

//        switch (getTrancCategory()){
//            case DEBIT-> {
//                if(getSumma() < 0) {
//                    System.err.println("Не верная сумма");
//                    return false;
//                }
//            }
//            case CREDIT-> {
//                if(getSumma() > 0) {
//                    System.err.println("Не верная сумма");
//                    return false;
//                }
//            }
//        }
//        return true;
        }
    }

    public void confirmation(){
        if(!checkTransaction()){
            System.err.println("В операции отказано!");
        }else {
            this.sender.setBalance(this.sender.getBalance() - this.getSumma());
            this.recipient.setBalance(this.recipient.getBalance() + this.getSumma());
            System.out.println("Оперция успешна");
        }
    }

}
