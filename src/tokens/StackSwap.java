package tokens;

import java.util.ArrayList;

import core.Prim;
import core.Token;

public class StackSwap extends Token {

  @Override
  public void eval(ArrayList<Prim> args) {
    if(canEval(args)){
      Prim a = args.remove(0);
      Prim b = args.remove(0);
      args.add(0, a);
      args.add(0, b);
    }

  }

  @Override
  public boolean canEval(ArrayList<Prim> args) {
    return args.size() >= 2;
  }


}
