package tokens;

import java.math.BigDecimal;

public class Multiply extends NumDyadic {

  @Override
  public BigDecimal getOutput(BigDecimal a, BigDecimal b) {
    return a.multiply(b);
  }

}
