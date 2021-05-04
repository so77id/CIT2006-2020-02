import java.util.Scanner;  // Import the Scanner class

public class Main {
  public static void main(String[] args){
    int n, buff;
    Scanner scanner = new Scanner(System.in);  // Create a Scanner object

    List<Integer> myList = new List<Integer>();
    System.out.println("Ingrese al tamaño de la lista:");
    n = scanner.nextInt();

    System.out.println("Ingrese los " + n + " datos de la lista:");
    for(int i=0; i < n; i++){
      buff = scanner.nextInt();
      myList.insert(buff);
    }
    myList.print();

    System.out.println("Que valor quiere eliminar de la lista?: ");
    buff = scanner.nextInt();

    myList.remove(buff);

    myList.print();

    // int n;
    // String buff;
    // Scanner scanner = new Scanner(System.in);  // Create a Scanner object
    //
    // List<String> myList = new List<String>();
    // System.out.println("Ingrese al tamaño de la lista:");
    // n = scanner.nextInt();
    //
    // System.out.println("Ingrese los " + n + " datos de la lista:");
    // for(int i=0; i < n; i++){
    //   buff = scanner.next();
    //   myList.insert(buff);
    // }
    // myList.print();
    //
    // System.out.println("Que valor quiere eliminar de la lista?: ");
    // buff = scanner.next();
    //
    // myList.remove(buff);
    //
    // myList.print();

    // int n;
    // float buff;
    // Scanner scanner = new Scanner(System.in);  // Create a Scanner object
    //
    // List<Float> myList = new List<Float>();
    // System.out.println("Ingrese al tamaño de la lista:");
    // n = scanner.nextInt();
    //
    // System.out.println("Ingrese los " + n + " datos de la lista:");
    // for(int i=0; i < n; i++){
    //   buff = scanner.nextFloat();
    //   myList.insert(buff);
    // }
    // myList.print();
    //
    // System.out.println("Que valor quiere eliminar de la lista?: ");
    // buff = scanner.nextFloat();
    //
    // myList.remove(buff);
    //
    // myList.print();

  }
}
