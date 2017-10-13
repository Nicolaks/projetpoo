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

    /*
    dureeHeure
    while durée>= 60:
      durée−=60
      dureeHeure+=1

      date1.Heure+=dureeHeure <= date2.Heure

    if (this.first.duree){

      return true;

    } else {

      return false;

    }*/
    System.out.println(first.duree);
  }
}
