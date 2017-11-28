package projetpoo;

import java.util.GregorianCalendar;

/**
 * Class PrecedenceConstraint
 */
public class PrecedenceConstraint extends BinaryConstraint implements Constraint {//Représente des contraintes de précédence, first avant second
/**
 * Constructeur PrecedenceConstraint
 * @param first
 * 		first est une activité de type Activity 
 * @param second
 * 		second est une activité de type Activity
 *
 * @see PrecedenceConstraint#first
 * @see PrecedenceConstraint#second  
 */
  public PrecedenceConstraint (Activity first,Activity second) {
    super(first, second);
  }

/**
 * Vérifie si PrecedenceConstraint est satisfiée
 * 
 * @param date1
 * 		date1 est une variable de type GregorianCalendar
 * @param date2
 * 		date2 est une variable de type GregorianCalendar
 * 
 * @return Un booléen qui défini si la contrainte de précedence est validée
 */
  public boolean isSatisfied (GregorianCalendar date1, GregorianCalendar date2) {
    int dureeHeure=0;//initialise la duree qui sert a determiner le nombre d'heure(s) du ip1
    int saveDuree = first.getDuree();
    int dureeMinutes = first.getDuree();//nb de minutes - les heures (toujours inferieure à 60)

    while(dureeMinutes>=60){//soustrait 60 minutes a la durée tant que nbMinutes >60)
      dureeMinutes=dureeMinutes-60;
      dureeHeure=dureeHeure+1;
    }

    GregorianCalendar finDate1 = date1;
    finDate1.add(GregorianCalendar.MINUTE, first.getDuree());

  //  	VERIFICATION

    int compare =  date2.compareTo(finDate1) ;
    return (compare >= 0);
  }
}
