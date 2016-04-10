package prims;

import java.math.BigDecimal;
import java.util.ArrayList;

import core.Prim;

public class BasicList extends Prim { // TODO: add AcidicList

  public ArrayList<Prim> data;
  public BasicList(){
    this.data = new ArrayList<Prim>();
  }
  
  @Override
  public BigDecimal getNum() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ArrayList<Prim> toList() {
    return data;
  }


  public String toString(){
    String res = "[";
    if(data.size() > 0){
      res += data.get(0);
      for(int i = 1; i < data.size(); i++){
        res+= " " + data.get(i);
      }
    }
    res += "]";
    return res;
  }  

}
