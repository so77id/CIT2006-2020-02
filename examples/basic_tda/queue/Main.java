import java.util.Scanner;  // Import the Scanner class


public class Main {
  public static void main(String[] args){
    // int n;
    // int buff;
    // Scanner scanner = new Scanner(System.in);  // Create a Scanner object
    //
    // Queue<Integer> myQueue = new Queue<Integer>();
    // System.out.println("Ingrese la cantidad de datos que va a adicionar a la cola");
    // n = scanner.nextInt();
    //
    // for(int i=0; i < n; i++){
    //   buff = scanner.nextInt();
    //   myQueue.enqueue(buff);
    //
    // }
    //
    // while(!myQueue.empty()){
    //   buff = myQueue.top();
    //   myQueue.dequeue();
    //   System.out.println(buff);
    // }

    int n;
    String buff;
    Scanner scanner = new Scanner(System.in);  // Create a Scanner object

    Queue<String> myQueue = new Queue<String>();
    System.out.println("Ingrese la cantidad de datos que va a adicionar a la cola");
    n = scanner.nextInt();

    for(int i=0; i < n; i++){
      buff = scanner.next();
      myQueue.enqueue(buff);
    }

    while(!myQueue.empty()){
      buff = myQueue.top();
      myQueue.dequeue();
      System.out.println(buff);
    }
  }
}
