class Stack<T extends Comparable<T>> {
  private Node<T> head;

  public Stack() {
    this.head = null;
  }

  public void push(T value) {
    Node<T> n_node = new Node<T>(value, this.head);
    this.head = n_node;
  }

  public void pop() {
    if (this.head != null) {
      this.head = this.head.getNext();
    }
  }

  public boolean empty(){
    if (this.head == null) return true;
    else return false;
  }

  public T top(){
    return this.head.getValue();
  }
}
