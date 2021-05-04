class List<T> {
    private Node<T> head;

    public list() {
        this.head = null;
    }

    // Insert on head
    public void insert(T value) {
        Node<T> n_node = new Node<T>(value, this.head);
        this.head = n_node;
    }

    // Insert on tail
    public void insert(T value) {
        Node<T> n_node = new Node<T>(value);
        // Node<T> n_node = new Node<T>(value, null);
        Node<T> tmp;

        if (!this.head) {
            this.head = n_node;
            return;
        }

        for(tmp = this.head; tmp.getNext(); tmp = tmp.getNext());

        tmp.setNext(n_node);
    }

    // Insert in Order
    public void insert(T value) {
        Node<T> n_node = new Node<T>(value);
        Node tmp;
        
        if(this.head == null) {
            this.head = n_node;
            return;
        }

        if(this.head.getValue() > n_node.getValue()) {
            n_node.setNext(this.head);
            this.head = n_node;
            return;
        }

        for(tmp = this.head; tmp.getNext(); tmp = tmp.getNext()) {
            if(tmp.getNext().getValue() > n_node.getValue()) {
              n_node.setNext(tmp.getNext());
              tmp.setNext(n_node);
              return
            }
        }
      
        tmp.setNext(n_node);
    }


    // Remove first element
    public Node<T> remove() {
        Node<T> ret = this.head;

        if (this.head == null) return ret;

        this.head = this.head.getNext();

        return ret;
    }

    // Remove last element
    public Node<T> remove() {
        Node<T> ret = this.head;
        Node<T> tmp;

        if (this.head == null) return ret;

        if (tmp.getNext() == null) {
            this.head = null;
            return ret;
        }

        for(tmp = this.head; tmp.getNext().getNext(); tmp = tmp.getNext());

        ret = tmp.getNext();

        tmp.setNext(null);

        return ret;
    }

    // Remove specific element
    public Node<T> remove(T value) {
        Node<T> ret = null;
        Node<T> tmp;

        if (this.head == null) { return null; }
        if (this.head.getValue() == value ) {
            ret = this.head;
            this.head = this.head.getNext();
            return ret;
        }

        for(tmp = this.head; tmp.getNext(); tmp = tmp.getNext()) {
            if (tmp.getNext().getValue() == value){
                ret = tmp.getNext();
                tmp.setNext(tmp.getNext().getNext());
                return ret;
            }
        }
        return ret;
    }

    // Search if contain specific element
    public boolean search(T value) {
        if (this.head == null) { return false; }
        for (Node<T> tmp = head; tmp; tmp = tmp.getNext()) {
            if (tmp.getValue() == value) return true;
        }
        return false;
    }

    // is empty
    public boolean empty() {
        return this.head ? false : true;
    }
}

class ListWithTail<T> {
    private Node<T> head;
    private Node<T> tail;
  
    public ListWithTail(){
        this.head = this.tail = null;
    }
  
    // insert on tail
    public void insert(T value) {
      Node<T> n_node = new Node(value);
  
      if(this.head == this.tail && this.head == null) {
        this.head = this.tail = n_node;
        return;
      }
  
      this.tail.setNext(n_node);
      this.tail = n_node;
    }
  }


