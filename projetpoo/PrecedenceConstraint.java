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
    int saveDuree = first.getDuree();
    int dureeMinutes = first.getDuree();//nb de minutes - les heures (toujours inferieure à 60)

    while(dureeMinutes>=60){//soustrait 60 minutes a la durée tant que nbMinutes >60)
      dureeMinutes=dureeMinutes-60;
      dureeHeure=dureeHeure+1;
    }
    System.out.println("dureeHeure : "+ dureeHeure +" dureeMinutes : "+ dureeMinutes);//affiche le temps de l'activite 1 en heures & minutes

    GregorianCalendar finDate1 = new GregorianCalendar(date1.get(GregorianCalendar.YEAR),date1.get(GregorianCalendar.MONTH),date1.get(GregorianCalendar.DAY_OF_MONTH),date1.get(GregorianCalendar.HOUR_OF_DAY),date1.get(GregorianCalendar.MINUTE)+saveDuree);//creer le calendar qui est au moment de fin de first

    //		AFFICHAGE DES DATES

    System.out.println("Date1     YEAR "+date1.get(GregorianCalendar.YEAR)+" MONTH "+date1.get(GregorianCalendar.MONTH)+" DAY_OF_MONTH "+date1.get(GregorianCalendar.DAY_OF_MONTH)+" HOUR_OF_DAY "+date1.get(GregorianCalendar.HOUR_OF_DAY)+" MINUTE "+date1.get(GregorianCalendar.MINUTE));
    System.out.println("Date1 fin YEAR "+finDate1.get(GregorianCalendar.YEAR)+" MONTH "+finDate1.get(GregorianCalendar.MONTH)+" DAY_OF_MONTH "+finDate1.get(GregorianCalendar.DAY_OF_MONTH)+" HOUR_OF_DAY "+finDate1.get(GregorianCalendar.HOUR_OF_DAY)+" MINUTE "+finDate1.get(GregorianCalendar.MINUTE));
    System.out.println("Date2     YEAR "+date2.get(GregorianCalendar.YEAR)+" MONTH "+date2.get(GregorianCalendar.MONTH)+" DAY_OF_MONTH "+date2.get(GregorianCalendar.DAY_OF_MONTH)+" HOUR_OF_DAY "+date2.get(GregorianCalendar.HOUR_OF_DAY)+" MINUTE "+date2.get(GregorianCalendar.MINUTE));

    //  	VERIFICATION

    int compare =  date2.compareTo(finDate1) ;
    System.out.println("finDate1 VS. date2 :"+ compare);//renvoie 1 si finDate1<date2 || 0 si finDate1==date2 || -1 si finDate1>date2

    if (compare == 0 || compare > 0) {
    	return true;
    }else {
    	return false;
    }

    /*		ANCIEN CODE NON FONCTIONNEL POUR JOURS DIFFERENTS ET DECALAGE(VOIR ANCIENT COMMIT)
    if(
      (finDate1.get(GregorianCalendar.HOUR_OF_DAY) < date2.get(GregorianCalendar.HOUR_OF_DAY))//test si l'heure de date2 est supérieure à (l'heure de date1 + la durée en heure)
    ||//sinon
      (
      (finDate1.get(GregorianCalendar.MINUTE)<=date2.get(GregorianCalendar.MINUTE))
      &&
      (finDate1.get(GregorianCalendar.HOUR_OF_DAY) == date2.get(GregorianCalendar.HOUR_OF_DAY))
      )
    )
    {
      return true;
    }
    else
    {
      return false;
    }*/
  }
}
