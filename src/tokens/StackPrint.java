package tokens;

import java.util.ArrayList;

import core.Prim;
import core.Token;

public class StackPrint extends Token {

  @Override
  public void eval(ArrayList<Prim> args) {
    for(int i = args.size()-1; i >= 0; i--){
      System.out.print(args.get(i) + " ");
    }
    System.out.println();
  }

  @Override
  public boolean canEval(ArrayList<Prim> args) {
    return false;
  }


}
