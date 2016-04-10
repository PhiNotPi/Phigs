package tokens;

import java.util.ArrayList;

import prims.BasicList;
import prims.SignalListBegin;

import core.Prim;
import core.Token;

public class ListEnd extends Token {

  @Override
  public void eval(ArrayList<Prim> args) {
    BasicList res = new BasicList();
    while(args.size() > 0 && !(args.get(0) instanceof SignalListBegin)){
      res.data.add(0, args.remove(0));
    }
    if(args.size() > 0 && args.get(0) instanceof SignalListBegin){
      args.remove(0); // removing the signal
    }
    args.add(0, res);
  }

  @Override
  public boolean canEval(ArrayList<Prim> args) {
    boolean res = false;
    for(int i = 0; i < args.size(); i++){
      if(args.get(i) instanceof SignalListBegin){
        res = true;
      }
    }
    return res;
  }

}
