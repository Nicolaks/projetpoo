package projetpoo;

import java.util.ArrayList;
import java.util.Set;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.GregorianCalendar;
import java.util.NoSuchElementException;

public class Schedule {

  private HashMap<Activity, GregorianCalendar> edt;

  public Schedule (){
    this.edt = new HashMap<> ();
  }

  public HashMap addSchedule (Activity a, GregorianCalendar greg ){
    this.edt.put(a,greg);
    return this.edt;
  }

  public HashMap getEdt(){
    return this.edt;
  }

  public GregorianCalendar getDateForActivity(Activity a){
    return this.edt.get(a);
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

  private String affichageHeureMinute (GregorianCalendar cal) {
    return cal.get(GregorianCalendar.HOUR_OF_DAY)+"";
  }

  public String toString () {

    ArrayList<Activity> liste = this.getSortedActivities();
    int n = liste.size();

    String res = "Emploi du temps : \n";
    for (Activity i : liste) {
      res += i.getAct()+" : "+this.edt.get(i).get(GregorianCalendar.HOUR_OF_DAY)+"h"+this.edt.get(i).get(GregorianCalendar.MINUTE)+"\n";
    }
    return res;
  }



   private static Activity next (ArrayList<Activity> activites, ArrayList<PrecedenceConstraint> contraintes,ArrayList<Activity> scheduled) {

     for (Activity i : activites) {
       boolean ok = true;
       for (PrecedenceConstraint contraint : contraintes){
         if (i == contraint.second && !scheduled.contains(contraint.first)){
           ok = false;
           break;
         }
       }
       if (ok) {
         return i;
       }
     }
     throw new NoSuchElementException("pas possible");
   }


   public static Schedule computeSchedule(ArrayList<Activity> activites, ArrayList<PrecedenceConstraint> contraintes) {
     Schedule edt = new Schedule();
     GregorianCalendar date = new GregorianCalendar(2017,10,27,8,0);


     /*

     - Parcourir la liste des activitées si un activites est "libre" la mettre en première (pas de contrainte).
     - Stocker les activitées qui on comme contrainte l'activité de la liste juste avant.
     - Affiche dans l'odre.

     */
     ArrayList<Activity> reste = new ArrayList<Activity> (activites);
     ArrayList<Activity> tableau = new ArrayList<Activity>();

     while (!reste.isEmpty()) {
        Activity nextAct = Schedule.next(reste,contraintes,tableau);

        tableau.add(nextAct);
        reste.remove(nextAct);
     }
     for (Activity i : tableau) {
       GregorianCalendar newDate = (GregorianCalendar) date.clone();
       edt.addSchedule(i,newDate);
       date.add(GregorianCalendar.MINUTE, i.getDuree());

     }
     return edt;
   }

}
