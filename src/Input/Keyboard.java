package Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Keyboard {
  private static BufferedReader kb = new BufferedReader(
      new InputStreamReader(System.in));
  
  public static void multipleChoiceInt(MultipleChoice<Integer> handler) throws Exception {
    int value = getInt();
    handler.handle(Integer.valueOf(value));
  }
  
  public static void multipleChoiceString(MultipleChoice<String> handler) throws Exception {
    String value = getString();
    handler.handle(value);
  }
  
  public static void multipleChoiceChar(MultipleChoice<Character> handler) {
    char value = getChar();
    handler.handle(Character.valueOf(value));
  }
  
  public static void multipleChoiceCharln(MultipleChoice<Character> handler) throws Exception {
    char value = getCharln();
    handler.handle(Character.valueOf(value));
  }
  
  public static String getString() {
    try {
      return kb.readLine();
    } catch (IOException err) {
      return null;
    } 
  }
  
  public static char getChar() {
    try {
      char result = Character.toChars(kb.read())[0];
      return result;
    } catch (IOException err) {
      return ' ';
    }
  }
  
  public static char getCharln() throws Exception {
    try {
      String result = kb.readLine();
      if (result.length() > 1)
        throw new Exception("is not a char"); 
      return result.charAt(0);
    } catch (IOException err) {
      return ' ';
    } 
  }
  
  public static int getInt() throws Exception {
    try {
      return Integer.valueOf(kb.readLine()).intValue();
    } catch (IOException err) {
      throw new Exception("is not a int");
    } 
  }
  
  public static long getLong() throws Exception {
    try {
      return Long.valueOf(kb.readLine()).longValue();
    } catch (IOException err) {
      throw new Exception("is not a long");
    } 
  }
  
  public static short getShort() throws Exception {
    try {
      return Short.valueOf(kb.readLine()).shortValue();
    } catch (IOException err) {
      throw new Exception("is not a short");
    } 
  }
  
  public static Byte getByte() throws Exception {
    try {
      return Byte.valueOf(Byte.parseByte(kb.readLine()));
    } catch (IOException err) {
      throw new Exception("is not a byte");
    } 
  }
  
  public static float getFloat() throws Exception {
    try {
      return Float.valueOf(kb.readLine()).floatValue();
    } catch (IOException err) {
      throw new Exception("is not a float");
    } 
  }
  
  public static double getDouble() throws Exception {
    try {
      return Double.valueOf(kb.readLine()).doubleValue();
    } catch (IOException err) {
      throw new Exception("is not a double");
    } 
  }
  
  public static boolean getBoolean() throws Exception {
    try {
      String result = getString().toLowerCase();
      if (result == "false" || result == "f" || result == "n" || result == "no")
        return false; 
      if (result == "true" || result == "t" || result == "y" || result == "yes")
        return true; 
      throw new Exception("is not a boolean");
    } catch (IOException err) {
      return false;
    } 
  }
}
