package tokens;

import java.util.ArrayList;

import core.Prim;
import core.Token;

public class StackPop extends Token {

  @Override
  public void eval(ArrayList<Prim> args) {
    if(canEval(args)){
      args.remove(0);
    }
  }

  @Override
  public boolean canEval(ArrayList<Prim> args) {
    return args.size() >= 1;
  }


}
