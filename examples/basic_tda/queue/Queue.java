class Queue<T extends Comparable<T>> {
  private Node<T> head;
  private Node<T> tail;

  public Queue() {
    this.head = this.tail = null;
  }

  public void enqueue(T value){
    Node n_node = new Node(value);
    // no elements
    if(this.head == null && this.tail == null) {
      this.head = this.tail = n_node;
    }
    else {
      // n elements
      this.tail.setNext(n_node);
      this.tail = n_node;
    }
  }

  public void dequeue() {
    // no elements
    if(this.head == null && this.tail == null) return;
    // 1 element
    if(this.head == this.tail) {
      this.head = this.tail = null;
      return;
    }
    // n elements
    this.head = this.head.getNext();
  }

  public boolean empty(){
    if (this.head == null) return true;
    else return false;
  }

  public T top(){
    return this.head.getValue();
  }
}
