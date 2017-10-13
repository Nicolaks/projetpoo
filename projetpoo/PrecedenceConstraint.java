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
    System.out.println(date1.get(GregorianCalendar.YEAR));
    System.out.println(" YEAR "+date1.get(GregorianCalendar.YEAR)+" MONTH "+date1.get(GregorianCalendar.MONTH)+" DAY_OF_MONTH "+date1.get(GregorianCalendar.DAY_OF_MONTH)+" HOUR_OF_DAY "+date1.get(GregorianCalendar.HOUR_OF_DAY)+" MINUTE "+date1.get(GregorianCalendar.MINUTE));
    System.out.println(" YEAR "+date2.get(GregorianCalendar.YEAR)+" MONTH "+date2.get(GregorianCalendar.MONTH)+" DAY_OF_MONTH "+date2.get(GregorianCalendar.DAY_OF_MONTH)+" HOUR_OF_DAY "+date2.get(GregorianCalendar.HOUR_OF_DAY)+" MINUTE "+date2.get(GregorianCalendar.MINUTE));

    /*if(
    date1.HOUR_OF_DAY
    )*/





    //            SORTIE DE LA VERIFICATION
    System.out.println("test recuperation dans isSatisfied"+first.getDuree());
    return true;
  }
}
