import java.util.Scanner;  // Import the Scanner class

class StringExample
{
    // Your program begins with a call to main().
    // Prints "Hello, World" to the terminal window.
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        String s0 = new String("Hola");
        // String s1 = new String("mundo");
        

        String s1 = scanner.next();  // Read user input
        String s2 = scanner.next();  // Read user input

        for(int i=0; i<s1.length(); i++){
            System.out.print(s1.charAt(i));
            if (s1.charAt(i) == '?') System.out.print(" --> RECURSIVIDAD");
            System.out.print("\n");
        }
    }
}
