package core;
import java.util.ArrayList;

public abstract class Token {

  public abstract void eval(ArrayList<Prim> args);
  public abstract boolean canEval(ArrayList<Prim> args);

}
