import java.util.Scanner;  // Import the Scanner class

class IfElseWhileForExample
{
    // Your program begins with a call to main().
    // Prints "Hello, World" to the terminal window.
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Number of iterations:");
        int n = scanner.nextInt();  // Read int input
        int i = 1;

        if (n % 2 == 0) {
          System.out.println("the number is pair");
        } else {
          System.out.println("the number is odd");
        }


        System.out.println("Par number");
        while(i < n) {
          if (i % 2 == 0) {
            System.out.println(i);
          }
          i++;
        }

        System.out.println("divisible by 3");
        for (i=1; i < n; i++) {
          if (i % 3 == 0) {
            System.out.println(i);
          }
        }
    }
}
