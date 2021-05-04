import java.util.Scanner;  // Import the Scanner class

class RecursionExample
{
    public static int fibonacci(int n, int l){
      // System.out.println(l + "-->" + n);
      if(n == 1) {
        return 1;
      }
      if(n == 2) {
        return 1;
      }

      return fibonacci(n-1, l+1) + fibonacci(n-2, l+1);
    }

    public static void main(String args[])
    {
      Scanner scanner = new Scanner(System.in);  // Create a Scanner object

      System.out.println("enter the fibonacci number you want to know");
      int n = scanner.nextInt();
      int fib = fibonacci(n, 0);

      System.out.println("The fibonacci number is: "+ fib);

    }
};


// f(5) = 5
// f(4) = 3
// F(3) = 2
// f(2) = 1
// F(1) = 1
