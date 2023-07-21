public class TransactionsLinkedList implements TransactionsList{
    private Node first;
    private Node last;
    private int size;

    TransactionsLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    @Override
    public void addTransaction(Transaction transaction) {
        if(size == 0){
            this.first = new Node(transaction);
        }else{
            if(first.getNext() == null) {
                this.last = new Node(null, this.first, transaction);
                this.first.setNext(this.last);
            }else {
                Node tmp = this.last;
                this.last = new Node(null, tmp, transaction);
                this.last.getPrevious().setNext(last);
            }
        }
        size++;
    }

    @Override
    public void removeTransaction(String id) {
        Node tmp = this.first;

        while (tmp.getNext() != null){
            if(tmp.getValue().getUuid().toString().equals(id)){
                deleteNode(tmp);
                size--;
                return;
            }
            tmp = tmp.getNext();
        }
        if(tmp.getValue().getUuid().toString().equals(id) && tmp.getNext() == null){
            deleteNode(tmp);
            size--;
        }else{
            throw new TransactionsListNotFoundException("No such id found!");
        }

    }



    public void removeTransaction(String uuid, int userID) {
        Node tmp = this.first;


        while (tmp.getNext() != null){

            if(tmp.getValue().getUuid().toString().equals(uuid) &&
                    (tmp.getValue().getRecipient().getIdentifier() == userID ||
                            tmp.getValue().getSender().getIdentifier() == userID)){
                deleteNode(tmp);
                size--;
                return;
            }
            tmp = tmp.getNext();
        }
        if(tmp.getValue().getUuid().toString().equals(uuid) && tmp.getNext() == null
                && (tmp.getValue().getRecipient().getIdentifier() == userID ||
                        tmp.getValue().getSender().getIdentifier() == userID)){
            deleteNode(tmp);
            size--;
        }else{
            throw new TransactionsListNotFoundException("No such id found!");
        }

    }
    private void deleteNode(Node node) {
        if(node.getNext() == null && node.getPrevious()==null){
            this.last = null;
            this.first = null;
            throw new TransactionsListNotFoundException("All list delete!");
        }
        if(node.getNext() == null){
            node.getPrevious().setNext(null);
            this.last = node.getPrevious();
            return;
        }if(node.getPrevious()== null){
            node.getNext().setPrevious(null);
            this.first = node.getNext();
        }else{
            node.getPrevious().setNext(node.getNext());
            node.getNext().setPrevious(node.getPrevious());
        }
    }

    @Override
    public Transaction[] toArrayTransaction() {
        Transaction[] result = new Transaction[size];
        Node tmp = first;
        for (int i = 0; i < result.length && tmp != null; i++){
            result[i] = tmp.getValue();
            tmp = tmp.getNext();
        }
        return result;
    }

    @Override
    public String toString() {
        return "TransactionsLinkedList{" +
                "first=" + first.getValue() +
                ", last=" + last.getValue() +
                ", size=" + size +
                '}';
    }
}
