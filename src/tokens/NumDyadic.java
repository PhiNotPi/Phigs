package tokens;

import java.math.BigDecimal;
import java.util.ArrayList;

import prims.*;

import core.Prim;
import core.Token;

public abstract class NumDyadic extends Token {

  public NumDyadic() {
  }

  public boolean canEval(ArrayList<Prim> args) {
    return args.size() >= 2;
  }

  public abstract BigDecimal getOutput(BigDecimal a, BigDecimal b);

  @Override
  public void eval(ArrayList<Prim> args) {
    Prim[] inputs = getArgs(args);
    args.add(0, listRecurse(inputs[0], inputs[1]));
  }

  public Prim listRecurse(Prim a, Prim b) {
    if (a instanceof BasicList && b instanceof BasicList) {
      BasicList res = new BasicList();
      for (int i = 0; i < a.toList().size() && i < b.toList().size(); i++) {
        res.data.add(listRecurse(a.toList().get(i), b.toList().get(i)));
      }
      return res;
    } else if (a instanceof BasicList && !(b instanceof BasicList)) {
      BasicList res = new BasicList();
      for (int i = 0; i < a.toList().size(); i++) {
        res.data.add(listRecurse(a.toList().get(i), b));
      }
      return res;
    } else if (!(a instanceof BasicList) && b instanceof BasicList) {
      BasicList res = new BasicList();
      for (int i = 0; i < b.toList().size(); i++) {
        res.data.add(listRecurse(a, b.toList().get(i)));
      }
      return res;
    } else {
      return new Num(getOutput(a.getNum(), b.getNum()));
    }
  }

  public Prim[] getArgs(ArrayList<Prim> args) {
    Prim[] res = new Prim[2];
    if (args.size() > 0) {
      res[1] = args.remove(0);
    } else {
      res[1] = new Num("0");
    }
    if (args.size() > 0) {
      res[0] = args.remove(0);
    } else {
      res[0] = new Num("0");
    }
    return res;
  }

}
