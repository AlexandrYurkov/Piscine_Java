package ex00;

import java.util.UUID;

public class Transaction {
    private String identifier;
    private User recipient;
    private User sender;
    private String transCat;
    private Integer amount;

    public Transaction(String transCat) {
        this.transCat = transCat;
        this.amount = 0;
    }

    public int getAmount(){
        return (amount);
    }

    public void setAmount(Integer amount){
        if ((transCat.equals("INCOME")) && (amount > 0)){
            this.amount = amount;
        }

        else if ((transCat.equals("OUTCOME")) && (amount < 0)){
            this.amount = amount;
        }
    }

    public void setTransCat(String transCat){
        this.transCat = transCat;
    }

    public String getTransCat(){
        return (transCat);
    }

    public void setIdentifier(UUID id){
        this.identifier = id.toString();
    }

    public void setRecipient(User recipient){
        this.recipient = recipient;
    }

    public void setSender(User sender){
        this.sender = sender;
    }
}
