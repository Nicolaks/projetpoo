package projetpoo;

import java.util.*;


/**
 * Class Schedule
 */
public class Schedule {

/**
 * La HashMap contenant les Activity en clés et les date sous format GregorianCalendar pour les valeurs
 * @see Activity
 * @see GregorianCalendar
 */
  private HashMap<Activity, GregorianCalendar> edt;

/**
 * Constructeur Schedule
 *
 * <p>Lors de la construction du Schedule il intergre edt, l'emploi du temps de type HashMap.</p>
 *
 * @see Schedule#addSchedule
 * @see Schedule#getEdt
 * @see Schedule#getDateForActivity
 * @see Schedule#getRepresentation
 * @see Schedule#satisfies
 * @see Schedule#getSortedActivities
 * @see Schedule#affichageHeureMinute
 * @see Schedule#toString
 * @see Schedule#next
 * @see Schedule#computeSchedule
 *
 */
  public Schedule (){
    this.edt = new HashMap<> ();
  }

/**
 * Méthode addSchedule
 *
 * <p>Ajoute dans le Schedule une clé Activity et sa valeur GregorianCalendar qui sont l'activité ajoutée  et sa date de début</p>
 *
 * @see Activity
 * @see GregorianCalendar
 *
 * @param a
 * 		variable de type Activity a asscoier avec une date
 * @param greg
 * 		variable de type GregorianCalendar a associer avec une activité
 *
 * @return edt
 * 		retourne le Schedule edt (modifié)
 *
 */
  public HashMap addSchedule (Activity a, GregorianCalendar greg ){
    this.edt.put(a,greg);
    return this.edt;
  }

/**
 * Méthode getEdt
 *
 * <p>Permet d'obtenir l' edt de type Schedule</p>
 *
 * @return edt
 * 		retourne le Schedule contenant l'ensemble des activités (Activity) et de leur date associée (GregorianCalendar)
 *
 */
  public HashMap getEdt(){
    return this.edt;
  }

/**
 * Méthode getDateForActivity
 *
 * <p>Permet d'obtenir la date (GregorianCalendar) d'une Activité (Activity) donnée</p>
 *
 * @see Activity
 * @see GregorianCalendar
 *
 * @param a
 * 		variable de type Activity

 *  @return GregorianCalendar
 * 		retourne un GregorianCalendar, date associé à l' Activity prise en paramètre
 *
 */
  public GregorianCalendar getDateForActivity(Activity a){
    return this.edt.get(a);
  }

/**
 * Méthode getRepresentation
 *
 * <p>Donne une représentation lisible de l'emploi du temps edt, en ne renvoyant que, pour chaque activité, leur nom, l'année, le mois, le jour, l'heure et la minute de celle ci</p>
 *
 * @return res
 *		variable de type String contenant tout le teste à afficher
 *
 */
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

/**
 * Méthode satisfies
 *
 * <p>verifie si les contraintes sont bien validées et renvoie true si c'est le cas, false dans le cas contraire</p>
 *
 * @return "true/false"
 *		retourne un boolean
 *
 */
  public boolean satisfies (Collection<PrecedenceConstraint> toutesContraintes) {
    for (PrecedenceConstraint contrainte: toutesContraintes) {
      if (!contrainte.isSatisfied(this.edt.get(contrainte.first), this.edt.get(contrainte.second))) {
        return false;
      }
    }
    return true;
  }

/**
 * Méthode getSortedActivities
 *
 * <p>trie les Activités dans leur ordre chronologique par rapport à leur date</p>
 *
 * @return listeAct
 * 		retourne une ArrayList contenant toutes les activités (Activity) triées
 *
 */
  private ArrayList<Activity> getSortedActivities(){
    Set<Activity> set = this.edt.keySet();

  	ArrayList<Activity> listeAct = new ArrayList<Activity>(set);
  	int n = this.edt.size();
  	for ( int i=0 ; i<n ; i++) {
  		int min = i;
  		for ( int j=i+1 ; j<n ; j++) {
  			if (this.edt.get(listeAct.get(j)).compareTo(this.edt.get(listeAct.get(min)))<=0){
  				min=j;
  			}
  		}
  		if (min != i ) {
  			Collections.swap(listeAct,i,min);
  		}
  	}
  	return listeAct;
  }

/**
 * Méthode affichageHeureMinute
 *
 * <p>affichage de l'heure</p>
 *
 * @param cal
 * 		prend une variable de type GregorianCalendar
 *
 * @return
 * 		un String qui contient l'heure du GregorianCalendar donnée
 *
 */
  private String affichageHeureMinute (GregorianCalendar cal) {
    return cal.get(GregorianCalendar.HOUR_OF_DAY)+"";
  }

/**
 * Méthode toString
 *
 * <p>affichage des activités, heures et minutes de début d'activité et ce avec une activité par ligne, et dans lo'rdre chronologique</p>
 *
 * @return res
 * 		variable de type String contenant la chaine de charactères  représentant les activités et leur horaire
 *
 */
  public String toString () {

    ArrayList<Activity> liste = this.getSortedActivities();
    int n = liste.size();

    String res = "\n";
    for (Activity i : liste) {
      res += i.getAct()+" : "+this.edt.get(i).get(GregorianCalendar.HOUR_OF_DAY)+"h"+this.edt.get(i).get(GregorianCalendar.MINUTE)+"\n";
    }
    return res;
  }

/**
 * Méthode next
 *
 * <p>verifie si les activités sont toutes valides par rapport aux contraintes</p>
 *
 * @param activites
 * 		variable de type ArrayList contenant des variables de type Activity, liste des activités à tester
 * @param contraintes
 * 		variable de type Collection contenant des variablede type PrecedenceConstraint,  étant les contraintes de précedence à prendre en compte
 * @param scheduled
 * 		variable de type ArrayList contenant des variables de type Activity, liste des activités de l'emploi du temps
 * @return i
 * 		variable de type Activity
 *
 * @throw NoSuchElementException
 *
 */
   private static Activity next (ArrayList<Activity> activites, Collection<PrecedenceConstraint> contraintes,ArrayList<Activity> scheduled) {

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

/**
 * Méthode computeSchedule
 *
 * <p>Ajoute les activités de activites(ArrayList de variables de type Activity) en tenant compte des contraintes dans l'emploidu temps</p>
 *
 * @param activites
 * 		variable de type ArrayList contenant des variables de type Activity, liste des activités à tester
 * @param contraintes
 * 		variable de type Collection contenant des variablede type PrecedenceConstraint,  étant les contraintes de précedence à prendre en compte
 * @return edt
 * 		variable de type Schedule qui
 *
 */
   public static Schedule computeSchedule(ArrayList<Activity> activites, Collection<PrecedenceConstraint> contraintes) {
     Schedule edt = new Schedule();
     GregorianCalendar date = new GregorianCalendar(2017,10,27,8,0);
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
