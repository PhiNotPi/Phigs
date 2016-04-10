package tokens;

import java.math.BigDecimal;


public class Exponentiate extends NumDyadic {

	@Override
	public BigDecimal getOutput(BigDecimal a, BigDecimal b) {
		return BigDecimal.valueOf(Math.pow(a.doubleValue(),b.doubleValue()));
	}

}
