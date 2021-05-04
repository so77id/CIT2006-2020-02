import java.util.Scanner;  // Import the Scanner class

class FunctionExample
{
    private static int fibonacci(int n){
      if(n == 1) {
        return 1;
      }
      if(n == 2) {
        return 1;
      }
      int prev = 1;
      int actual = 1;
      int aux = 1;

      for(int i=3; i<n+1 ; i++){
        aux = actual + prev;
        prev = actual;
        actual = aux;
      }

      return actual;
    }

    public static void main(String args[])
    {
      Scanner scanner = new Scanner(System.in);  // Create a Scanner object

      System.out.println("enter the fibonacci number you want to know");
      int n = scanner.nextInt();
      int fib = fibonacci(n);

      System.out.println("The fibonacci number is: "+ fib);

    }
};
