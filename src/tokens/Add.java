package tokens;

import java.math.BigDecimal;

public class Add extends NumDyadic {

	@Override
	public BigDecimal getOutput(BigDecimal a, BigDecimal b) {
		return a.add(b);
	}

}
