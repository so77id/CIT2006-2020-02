import java.util.Scanner;  // Import the Scanner class


class GenericClass
{
    public static void main(String args[])
    {
        // Pair p1 = new Pair(1, 2);
        // System.out.println("Pair  first:" + p1.getFirst()  + " second:" + p1.getSecond());

        // p1.setFirst(3);
        // p1.setSecond(5);        

        // System.out.println("Pair  first:" + p1.getFirst()  + " second:" + p1.getSecond());


        // System.out.println("------------------");

        // PairGeneric p2 = new PairGeneric<String>("hola", "chao");
        // System.out.println("Pair  first:" + p2.getFirst()  + " second:" + p2.getSecond());

        // p2.setFirst("!!");
        // p2.setSecond("??");        

        // System.out.println("Pair  first:" + p2.getFirst()  + " second:" + p2.getSecond());


        System.out.println("------------------");

        PairGenericTwo p3 = new PairGenericTwo<Integer, String>(1, "string");
        System.out.println("Pair  first:" + p3.getFirst()  + " second:" + p3.getSecond());

        p3.setFirst(3);
        p3.setSecond("Another string");        

        System.out.println("Pair  first:" + p3.getFirst()  + " second:" + p3.getSecond());
    }
};

class Pair {
    private int first;
    private int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() { return this.first; }
    public int getSecond() { return this.second; }

    public void setFirst(int first) { this.first = first; }
    public void setSecond(int second) { this.second = second; }
}



class PairGeneric<T> {
    private T first;
    private T second;

    public PairGeneric(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() { return this.first; }
    public T getSecond() { return this.second; }

    public void setFirst(T first) { this.first = first; }
    public void setSecond(T second) { this.second = second; }
}



class PairGenericTwo<T, K> {
    private T first;
    private K second;

    public PairGenericTwo(T first, K second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() { return this.first; }
    public K getSecond() { return this.second; }

    public void setFirst(T first) { this.first = first; }
    public void setSecond(K second) { this.second = second; }
}
