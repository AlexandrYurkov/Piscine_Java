public class Node {
    private Node next;
    private Node previous;
    private Transaction value;

    public Node(Node next, Node previous, Transaction value) {
        this.next = next;
        this.previous = previous;
        this.value = value;
    }

    public Node(Transaction value){
        this.next = null;
        this.previous = null;
        this.value = value;
    }

    public Transaction getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }
    public Node getPrevious(){
        return previous;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
