package projetpoo;

import java.util.GregorianCalendar;

public class Activity {//class Activity permettant représenter des crénaux horaires

  private String descr;//Description du crénaux
  private int duree;//En minute

  public Activity (String descr, int duree) {

    this.descr=descr;
    this.duree=duree;

  }

  public String getRepresentation () {
    return descr+" "+duree;
  }

  public String getAct () {
    return this.descr;
  }

  public int getDuree () {
    //System.out.println("duree test"+this.duree);
    return this.duree;

  }

}
