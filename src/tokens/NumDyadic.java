package tokens;

import java.math.BigDecimal;
import java.util.ArrayList;

import prims.Num;

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
		BigDecimal [] inputs = getArgs(args);
		BigDecimal res = getOutput(inputs[0],inputs[1]);
		args.add(0, new Num(res));
	}
	
	public BigDecimal[] getArgs(ArrayList<Prim> args){
		BigDecimal[] res = new BigDecimal[2];
		if(args.size() > 0){
			res[1] = args.remove(0).getNum();
		}
		else {
			res[1] = new BigDecimal("0");
		}
		if(args.size() > 0){
			res[0] = args.remove(0).getNum();
		}
		else {
			res[0] = new BigDecimal("0");
		}
		return res;
	}

}
