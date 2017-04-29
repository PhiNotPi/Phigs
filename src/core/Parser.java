package core;

import tokens.*;

public class Parser {

  public static TokenList parseString(TokenList parent, String s) {
    TokenList res = new TokenList(parent);
    boolean parsing_number = false;
    boolean after_dot = false;
    String numLit = "";
    for(int i=0;i<s.length();i++){
      char c = s.charAt(i);
      if ('0' <= c && c <= '9') {
        parsing_number = true;
        numLit += Character.toString(c);
        continue;
      }
      if (c == '.') {
        if (!after_dot){
          after_dot = true;
          numLit += ".";
          continue;
        }
      }
      if (parsing_number) {
        res.shift(new NumLit(numLit));
        parsing_number = false;
        after_dot = false;
        numLit = "";
      }
      switch (c) {
      case '+':
        res.shift(new Add());
        break;
      case '-':
        res.shift(new Subtract());
        break;
      case '*':
        res.shift(new Multiply());
        break;
      case '/':
        res.shift(new Divide());
        break;
      case '^':
        res.shift(new Exponentiate());
        break;
      case '\\':
        res.shift(new StackSwap());
        break;
      case '#':
        res.shift(new StackPop());
        break;
      case '[':
        res.shift(new ListBegin());
        break;
      case ']':
        res.shift(new ListEnd());
        break;
      default:
        break;
      }
    }
    if (parsing_number) {
      res.shift(new NumLit(numLit));
      parsing_number = false;
      after_dot = false;
      numLit = "";
    }
    res.shift(new StackPrint());
    return res;
  }

}
