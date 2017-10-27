package projetpoo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.GregorianCalendar;

public class Schedule {

  private HashMap<Activity, GregorianCalendar> edt;

  public Schedule (){
    this.edt = new HashMap<> ();
  }

  public HashMap addSchedule(Activity a, GregorianCalendar greg ){
    this.edt.put(a,greg);
    return this.edt;
  }

  public String getRepresentation(){
    String res="";
    for ( Activity keys : this.edt.keySet()){
      GregorianCalendar temp= this.edt.get(keys);
      res+= keys.getRepresentation()+" | "+
        temp.get(GregorianCalendar.YEAR)+"/"+temp.get(GregorianCalendar.MONTH)+
        "/"+temp.get(GregorianCalendar.DAY_OF_MONTH)+" : "+
        temp.get(GregorianCalendar.HOUR_OF_DAY)+"h"+temp.get(GregorianCalendar.MINUTE)+"\n";
    }
    return res;
  }

  public boolean satisfies(ArrayList<PrecedenceConstraint> toutesContraintes){
    for(PrecedenceConstraint contrainte: toutesContraintes) {
      if (!contrainte.isSatisfied(this.edt.get(contrainte.first), this.edt.get(contrainte.second))) {
        return false;
      }
    }
    return true;
  }
}
