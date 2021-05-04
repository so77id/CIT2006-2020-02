class List<T extends Comparable<T>> {
    private Node<T> head;

    public List() {
        this.head = null;
    }

    // Insert in Order
    public void insert(T value) {
        Node<T> n_node = new Node<T>(value);
        Node tmp;

        if(this.head == null) {
            this.head = n_node;
            return;
        }

        if(this.head.getValue().compareTo(n_node.getValue()) > 0) {
            n_node.setNext(this.head);
            this.head = n_node;
            return;
        }

        for(tmp = this.head; tmp.getNext() != null; tmp = tmp.getNext()) {
            if(tmp.getNext().getValue().compareTo(n_node.getValue()) > 0) {
              n_node.setNext(tmp.getNext());
              tmp.setNext(n_node);
              return;
            }
        }

        tmp.setNext(n_node);
    }

    // Remove specific element
    public Node<T> remove(T value) {
        Node<T> ret = null;
        Node<T> tmp;

        if (this.head == null) { return null; }
        if (this.head.getValue().compareTo(value) == 0 ) {
            ret = this.head;
            this.head = this.head.getNext();
            return ret;
        }

        for(tmp = this.head; tmp.getNext() != null; tmp = tmp.getNext()) {
            if (tmp.getNext().getValue().compareTo(value) == 0){
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
        for (Node<T> tmp = head; tmp != null; tmp = tmp.getNext()) {
            if (tmp.getValue().compareTo(value) == 0) return true;
        }
        return false;
    }

    // is empty
    public boolean empty() {
        return this.head != null ? false : true;
    }

    // print list
    public void print() {
        for(Node<T> tmp = this.head; tmp != null; tmp = tmp = tmp.getNext()) {
            System.out.print(tmp.getValue() + "-");
        }
    }
}
