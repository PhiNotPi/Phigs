package tokens;

import java.math.BigDecimal;
import java.math.MathContext;

public class Divide extends NumDyadic {

  @Override
  public BigDecimal getOutput(BigDecimal a, BigDecimal b) {
    return a.divide(b, MathContext.DECIMAL128);
  }

}
