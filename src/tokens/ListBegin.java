package tokens;

import java.util.ArrayList;

import prims.SignalListBegin;

import core.Prim;
import core.Token;

public class ListBegin extends Token {

  @Override
  public void eval(ArrayList<Prim> args) {
    args.add(0,new SignalListBegin());
    
  }

  @Override
  public boolean canEval(ArrayList<Prim> args) {
    return true;
  }

}
