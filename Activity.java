package projetpoo;

import java.util.GregorianCalendar;

public class Activity {//class Activity permettant représenter des crénaux horaires

  private String descr;//Description du crénaux
  private int duree;//En minute

  public Activity (String descr, int duree){

    this.descr=descr;
    this.duree=duree;

  }

  public String getRepresentation() {//Retourne la répresentation de la description plus la durée

    return descr+" "+duree;

  }

  public int getDuree(){//Retourne la représentation de la durée
    //System.out.println("duree test"+this.duree);
    return this.duree;

  }

}
