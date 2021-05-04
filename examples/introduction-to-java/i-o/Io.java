import java.util.Scanner;  

class Io
{
    public static void main(String args[])
    {
        // Create a Scanner object
        Scanner stdin = new Scanner(System.in);  
        System.out.println("Ingresa dos ints:");

        int a = stdin.nextInt();
        int b = stdin.nextInt();

        System.out.println("el primer numero es: " + a);
        System.out.println("el segundo numero es: " +  b);

        System.out.println("La suma de los numeros es: " + (a+b));
    }
}
