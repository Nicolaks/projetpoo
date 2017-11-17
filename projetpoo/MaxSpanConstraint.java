package projetpoo;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaxSpanConstraint implements Constraint {


  ArrayList<Activity> listActivite = new ArrayList<> ();
  int dureeTotal;


  public MaxSpanConstraint (ArrayList<Activity> listActivite,int dureeTotal) {
    this.listActivite = listActivite;
    this.dureeTotal = dureeTotal;
  }

  @Override
  public boolean isSatisfied(Schedule edt) {
    int dureeTouteAct = 0;
    for (Activity i : listActivite) {
      dureeTouteAct += i.getDuree();
    }

    if (dureeTouteAct <= dureeTotal) {
      return true;
    } else {
      System.out.println("Les contraintes de durée maximum pour plusieurs activités ne peuvent pas être satisfaites");
      return false;
    }

  }

}
