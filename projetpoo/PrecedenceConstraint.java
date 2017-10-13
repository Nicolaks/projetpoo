package projetpoo;

import java.util.GregorianCalendar;

public class PrecedenceConstraint {//Représente des contraintes de précédence, first avant second

  Activity first;
  Activity second;

  public PrecedenceConstraint(Activity first,Activity second){

    this.first=first;
    this.second=second;

  }


  public boolean isSatisfied(GregorianCalendar date1, GregorianCalendar date2){

    int dureeHeure=0;//initialise la duree qui sert a determiner le nombre d'heure(s) du ip1
    int dureeMinutes = first.getDuree();//nb de minutes - les heures (toujours inferieure à 60)

    while(dureeMinutes>=60){//soustrait 60 minutes a la durée tant que nbMinutes >60)
      dureeMinutes=dureeMinutes-60;
      dureeHeure=dureeHeure+1;
    }
    System.out.println("dureeHeure : "+ dureeHeure +" dureeMinutes : "+ dureeMinutes );//test ou s'en branle
    //            ENTREE DE LA VERIFICATION

    //System.out.println(" YEAR "+date1.get(GregorianCalendar.YEAR)+" MONTH "+date1.get(GregorianCalendar.MONTH)+" DAY_OF_MONTH "+date1.get(GregorianCalendar.DAY_OF_MONTH)+" HOUR_OF_DAY "+date1.get(GregorianCalendar.HOUR_OF_DAY)+" MINUTE "+date1.get(GregorianCalendar.MINUTE));
    //System.out.println(" YEAR "+date2.get(GregorianCalendar.YEAR)+" MONTH "+date2.get(GregorianCalendar.MONTH)+" DAY_OF_MONTH "+date2.get(GregorianCalendar.DAY_OF_MONTH)+" HOUR_OF_DAY "+date2.get(GregorianCalendar.HOUR_OF_DAY)+" MINUTE "+date2.get(GregorianCalendar.MINUTE));

    if(
      (date1.get(GregorianCalendar.HOUR_OF_DAY)+dureeHeure < date2.get(GregorianCalendar.HOUR_OF_DAY))//test si l'heure de date2 est supérieure à (l'heure de date1 + la durée en heure)
    ||//sinon
      (
      (date1.get(GregorianCalendar.MINUTE)+dureeMinutes<=date2.get(GregorianCalendar.MINUTE))
      &&
      (date1.get(GregorianCalendar.HOUR_OF_DAY)+dureeHeure == date2.get(GregorianCalendar.HOUR_OF_DAY))
      )
    )
    {
      return true;
    }
    else
    {
      return false;
    }

    /*                A FAIRE
    t1=14h30
    t2=15h00

    d=00h45

    t1+d.h=14
    t2.h=15

    t1+d=15h15

    donc pas bon
    */

  }
}
