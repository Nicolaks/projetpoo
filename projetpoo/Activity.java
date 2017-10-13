package projetpoo;

import java.util.GregorianCalendar;

public class Activity {

  private String descr;
  private int duree;

  public Activity (String descr, int duree){

    this.descr=descr;
    this.duree=duree;

  }

  public String getRepresentation() {

    return descr+" "+duree;

  }

}
