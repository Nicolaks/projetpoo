package projetpoo;
/**
   * @author
   * Aubry Nicolas, Dimitri Chagneux, Sami Zaizafoun, Martin Jacqueline
   * Lance la class MaxSpanConstraint qui implémente l'interface Constraint.
   */
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/**
   * La class MaxSpanConstraint.
   */
public class MaxSpanConstraint implements Constraint {


  ArrayList<Activity> listActivite = new ArrayList<> ();
  int dureeTotal;

  /**
     *
     *@param listActivite
     * Prend comme premier paramètre un ArrayList de type Activity.
     * @param dureeTotal
     * Prend en second paramètre un int qui représente la durée totale que l'on ne veut pas dépasser.
     */
  public MaxSpanConstraint (ArrayList<Activity> listActivite,int dureeTotal) {
    this.listActivite = listActivite;
    this.dureeTotal = dureeTotal;
  }

  /**
     * @param edt
     * Prend en entrée un Schedule et vérifie si il satisfait les constraintes.
     * @return
     * Retourne un booléen.
     */
  @Override
  public boolean isSatisfied(Schedule edt) {
    int dureeTouteAct = 0;
    for (Activity i : listActivite) {
      dureeTouteAct += i.getDuree();
    }

    if (dureeTouteAct <= dureeTotal) {
      return true;
    } else {
      return false;
    }
  }
}
