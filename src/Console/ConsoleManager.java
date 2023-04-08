package Console;

public class ConsoleManager {
  public static void clear() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
  
  public static void resetColor() {
    System.out.print(Colors.RESET);
  }
  
  public static void print(IMessage m) {
    print(m.getMessage(), m.getColor());
  }
  
  public static void print(String text, Colors ...colors) {
    String color = "";
    for (Colors c : colors)
      color += c;
      
    System.out.print(color + "" + text + Colors.RESET);
  }
  
  public static void print(String text) {
    System.out.print(text);
  }
  
  public static void print() {
    print(" ");
  }

  public static void println(IMessage m) {
    println(m.getMessage(), m.getColor());
  }
  
  public static void println(String text, Colors ...colors) {
    String color = "";
    for (Colors c : colors)
      color += c;

    System.out.println(color + text + Colors.RESET);
  }

  public static void println(String text) {
    System.out.println(text);
  }
  
  public static void println() {
    print(" ");
  }
}
