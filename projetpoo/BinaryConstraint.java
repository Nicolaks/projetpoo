package projetpoo;
/**
 * @author
 * Aubry Nicolas, Dimitri Chagneux, Sami Zaizafoun, Martin Jacqueline
 * La class BinaryConstraint
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
   * Lance la class BinaryConstraint qui gère les contraintes si une activité est avant une autre.
   * Elle implémente l'interface Constraint.
   */

public abstract class BinaryConstraint implements Constraint {

  protected Activity first;
  protected Activity second;
  /**
     * @param first
     * le paramètre first est de type Activity.
     * @param second
     * Le paramètre second est aussi de type Activity.
     */
  public BinaryConstraint (Activity first,Activity second) {
    this.first=first;
    this.second=second;
  }
  /**
     * @return
     * Retourne la première durée.
     */
  public int getDureeFirst () {
    return first.getDuree();
  }
  /**
     * @return
     * Retourne la durée de la seconde activité
     */
  public int getDureeSecond () {
    return second.getDuree();
  }

  /**
     * Classe isSatisfied abstraite de type booléen, qui vérifie si les activités sont compatibles.
     * @param date1
     * Prend en premier paramètre un GregorianCalendar.
     * @param date2
     * Prend en second paramètre un autre GregorianCalendar.
     * @return
     * Et retourne un booléen.
     */

  public abstract boolean isSatisfied(GregorianCalendar date1,GregorianCalendar date2);
  /**
     * @return
     * Retourne un booléen.
     * @param edt
     * Prend en paramètre un Schedule.
     */
  public boolean isSatisfied(Schedule edt){
    GregorianCalendar date1 = edt.getDateForActivity(this.first);
    GregorianCalendar date2 = edt.getDateForActivity(this.second);
    return isSatisfied(date1,date2);
  }
}
