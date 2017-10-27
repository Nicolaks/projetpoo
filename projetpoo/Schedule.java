package projetpoo;

import java.util.ArrayList;
import java.util.Set;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.GregorianCalendar;

public class Schedule {

  private HashMap<Activity, GregorianCalendar> edt;

  public Schedule (){
    this.edt = new HashMap<> ();
  }

  public HashMap addSchedule (Activity a, GregorianCalendar greg ){
    this.edt.put(a,greg);
    return this.edt;
  }

  public String getRepresentation() {
    String res="";
    for (Activity keys : this.edt.keySet()) {
      GregorianCalendar temp = this.edt.get(keys);
      res += keys.getRepresentation()+" | "+
        temp.get(GregorianCalendar.YEAR)+"/"+temp.get(GregorianCalendar.MONTH)+
        "/"+temp.get(GregorianCalendar.DAY_OF_MONTH)+" : "+
        temp.get(GregorianCalendar.HOUR_OF_DAY)+"h"+temp.get(GregorianCalendar.MINUTE)+"\n";
    }
    return res;
  }

  public boolean satisfies (ArrayList<PrecedenceConstraint> toutesContraintes) {
    for (PrecedenceConstraint contrainte: toutesContraintes) {
      if (!contrainte.isSatisfied(this.edt.get(contrainte.first), this.edt.get(contrainte.second))) {
        return false;
      }
    }
    return true;
  }


  private ArrayList<Activity> getSortedActivities(){
    Set<Activity> set = this.edt.keySet();
  	ArrayList<Activity> listeAct = new ArrayList<Activity>(set);
  	int n = this.edt.size();
  	for ( int i=0 ; i<n ; i++) {
  		int min = i;
  		for ( int j=i+1 ; j<n ; j++) {
  			if (this.edt.get(listeAct.get(j)).compareTo(this.edt.get(listeAct.get(min)))<0){
  				min=j;
  			}
  		}
  		if (min != i ) {
  			Collections.swap(listeAct,i,min);
  		}

  	}
  	return listeAct;
  }


   public String toString () {

      ArrayList<Activity> liste = this.getSortedActivities();
      int n = liste.size();
      String res = "Emploi du temps :\n";
      for (int i=0;i<n;i++) {
        res += liste.get(i).getAct()+" "+liste.get(i).getDuree()+"\n";
      }

      return res;

   }

  //  private Activity next (ArrayList<Activity> activites, ArrayList<PrecedenceConstraint> contraintes,ArrayList<Activity> scheduled) {
   //
   //
   //
  //  }


}
