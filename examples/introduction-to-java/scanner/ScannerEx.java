import java.util.Scanner;  

class ScannerEx
{
    public static void main(String args[])
    {
        Scanner stdin = new Scanner(System.in);  
        
        System.out.println("Ingrese una palabra");
        String str = stdin.next();
        System.out.println("La palabra ingresada es: " + str);
        
        System.out.println("Ingrese un numero");
        int num = stdin.nextInt();
        System.out.println("El numero ingresado es: " + num);

        System.out.println("Ingrese un numero flotante");
        float fl = stdin.nextFloat();
        System.out.println("El numero flotante ingresado es: " + fl);
    }
}
