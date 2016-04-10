package core;
import java.util.ArrayList;
import java.util.Scanner;

public class Interpreter {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    for (;;) {
      System.out.print("Phigs> ");
      String line = keyboard.nextLine();
      if (line.equals("quit")) {
        break;
      }
      TokenList prog = Parser.parseString(null, line);
      prog.eval();
    }
    keyboard.close();
  }

}
