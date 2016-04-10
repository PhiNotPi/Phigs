package tokens;

import java.math.BigDecimal;

public class Subtract extends NumDyadic {

  @Override
  public BigDecimal getOutput(BigDecimal a, BigDecimal b) {
    return a.subtract(b);
  }

}
