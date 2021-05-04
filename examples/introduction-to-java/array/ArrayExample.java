import java.util.Scanner;  // Import the Scanner class

class ArrayExample
{
    // Your program begins with a call to main().
    // Prints "Hello, World" to the terminal window.
    public static void main(String args[])
    {
        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};

        System.out.println(cars.length);

        System.out.println("For index iteration");
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i]);
        }

        System.out.println("For each iteration");
        for (String car:cars) {
          System.out.println(car);
        }

        System.out.println("Print matrix");
        int[][] matrix = { {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1} };

        System.out.println("Print numbers");
        for (int i = 0; i < matrix.length; ++i) {
          for(int j = 0; j < matrix[i].length; ++j) {
            System.out.print(matrix[i][j]+", ");
          }
          System.out.println("\n-------");
        }


        System.out.println("Print matrix with diferente row sizes");
        int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7}, {8, 9}, {0} };

        System.out.println("Print numbers");
        for (int i = 0; i < myNumbers.length; ++i) {
          for(int j = 0; j < myNumbers[i].length; ++j) {
            System.out.print(myNumbers[i][j]+", ");
          }
          System.out.println("\n-------");
        }
    }
}
