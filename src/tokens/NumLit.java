package tokens;

import java.util.ArrayList;

import prims.Num;

import core.Prim;
import core.Token;

public class NumLit extends Token {

	String text;
	
	public NumLit(String text){
		this.text = text;
	}
	
	@Override
	public void eval(ArrayList<Prim> args) {
		args.add(0,new Num(text));
	}

	@Override
	public boolean canEval(ArrayList<Prim> args) {
		return true;
	}

}
