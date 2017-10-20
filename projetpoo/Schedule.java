package projetpoo;

import java.util.Arrays;
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
      res+= keys.getRepresentation()+"\n";
    }
    return res;
  }
}
