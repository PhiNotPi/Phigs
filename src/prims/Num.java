package prims;

import java.math.BigDecimal;
import java.math.MathContext;

import core.Prim;


public class Num extends Prim {

	BigDecimal val;
	public Num(BigDecimal t) {
		this.val = t;
	}
	public Num(String t) {
		this.val = new BigDecimal(t);
	}

	@Override
	public BigDecimal getNum() {
		if(val != null){
			return val;
		}
		return new BigDecimal("0");
	}
	
	public String toString(){
		return this.getNum().round(new MathContext(30)).stripTrailingZeros().toPlainString();
	}

}
