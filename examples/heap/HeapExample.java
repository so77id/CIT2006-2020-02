import java.util.Scanner;  // Import the Scanner class
import java.util.Comparator;
import java.util.PriorityQueue;


public class HeapExample {
  public static class Heap<Key> {
      private Key[] data;
      private int n;
      private int size;
      private Comparator cmp;


      public Heap(Comparator<Key> cmp){
        this.size = 10;
        this.data = (Key[]) new Object[this.size];
        this.n = 0;
        this.cmp = cmp;
      }

      public void insert(Key v) {
        if((this.n + 1) >= this.size) this.realloc();
        this.data[++this.n] = v;
        this.swim(this.n);
      }

      public Key top(){
        return this.data[1];
      }

      public Key delMax(){
        Key max = this.data[1];
        this.exch(1, this.n--);
        // this.data[n+1]=null;
        sink(1);
        return max;
      }

      public int size() {
        return this.n;
      }

      public boolean empty(){
        return this.n == 0;
      }


      private void realloc(){
        this.size *= 2;
        Key[] data = (Key[]) new Object[this.size];
        for(int i=0; i <= this.n; i++){
          data[i] = this.data[i];
        }
        this.data = data;
      }

      private boolean less(int i, int j){
        return this.cmp.compare(this.data[i], this.data[j]) < 0;
      }

      private void exch(int i, int j){
        Key tmp = this.data[i];
        this.data[i] = this.data[j];
        this.data[j] = tmp;
      }


      private void sink(int k){
        int j;
        while(2*k <= this.n) {
           j = 2*k;
           if (j < this.n && less(j, j+1)) j++;
           if (!less(k, j)) break;
           exch(k, j);
           k = j;
        }
      }

      private void swim(int k) {
        while(k > 1 && less(k/2, k)) {
          exch(k/2, k);
          k /= 2;
        }
      }
  }

  public static class Pair<K, V> {
    private K first;
    private V second;;

    public Pair(K first, V second) {
      this.first = first;
      this.second = second;
    }

    public K  first() {return this.first;}
    public V second() {return this.second;}
  }


  public static void main(String[] args){
    int n, buff1;
    String buff2;

    Scanner scanner = new Scanner(System.in);  // Create a Scanner object
    // Heap<Pair<Integer, String>> heap = new Heap<Pair<Integer, String>>((a, b) -> {
      
    //   return (a.first() + a.second().charAt(0)) - (b.first() + b.second().charAt(0));
    // });
    PriorityQueue<Pair<Integer, String>> heap = new 
             PriorityQueue<Pair<Integer, String>>(10, (a, b) -> {return b.first()  - a.first();}); 

    n = scanner.nextInt();
    for(int i=0; i<n; i++) {
      buff1 = scanner.nextInt();
      buff2 = scanner.next();

      Pair tmp = new Pair(buff1, buff2);

      heap.add(tmp);
    }
    System.out.println("------");
    while(!heap.isEmpty()) {
      Pair tmp = heap.poll();
      System.out.println(tmp.first()+ " " + tmp.second());
    }
  }
}