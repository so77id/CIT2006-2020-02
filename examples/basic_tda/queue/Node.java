class Node<T extends Comparable<T>> {
    private T value;
    private Node next;

    public Node(T value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public Node() {
        this.value = null;
        this.next = null;
    }

    public T getValue() { return this.value; }
    public Node getNext() { return this.next; }

    public void setValue(T value) { this.value = value; }
    public void setNext(Node next) { this.next = next; }
}
