package projetpoo;

import java.util.GregorianCalendar;

public class PrecedenceConstraint extends BinaryConstraint implements Constraint {//Représente des contraintes de précédence, first avant second

  public PrecedenceConstraint (Activity first,Activity second) {
    super(first, second);
  }

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
