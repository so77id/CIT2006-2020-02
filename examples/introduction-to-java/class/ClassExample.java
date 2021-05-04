import java.util.Scanner;  // Import the Scanner class


class ClassExample
{
    public static void main(String args[])
    {
      Dog d1 = new Dog("Chola", "miauuuu");
      d1.toBark();
    }
};

class Dog {
  private String name;
  private String bark;

  public Dog(String new_name, String new_bark) {
    name = new_name;
    bark = new_bark;
  }

  public String getName(){
    return name;
  }

  public void setName(String new_name) {
    name = new_name;
  }

  public String getBark(){
    return bark;
  }

  public void setBark(String new_bark) {
    bark = new_bark;
  }

  public void toBark(){
    System.out.println(bark);
  }
}
