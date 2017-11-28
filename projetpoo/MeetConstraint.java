package projetpoo;
/**
   * @author
   * Aubry Nicolas, Dimitri Chagneux, Sami Zaizafoun, Martin Jacqueline
   * Lance la class MeetConstraint qui implémente l'interface Constraint.
   */
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/**
   * Lance la class MaxSpanConstraint qui implémente l'interface Constraint, et qui hérite de la classe BinaryConstraint.
   */
public class MeetConstraint extends BinaryConstraint implements Constraint {
  /**
     * Utilise la méthode super(), car la class hérite de BinaryConstraint.
     * @param first
     * Prend comme premier paramètre une activité.
     * @param second
     * Prend en second paramètre une activité.
     *
     */

  public MeetConstraint (Activity first,Activity second) {
    super(first, second);
  }
  /**
     * Lance la class isSatisfied qui vérifie si deux GregorianCalendar sont compatibles.
     * @return
     * Retourne un booléen.
     * @param date1
     * Prend comme premier paramètre un GregorianCalendar.
     * @param date2
     * Prend comme second paramètre un autre GregorianCalendar.
     */
  public boolean isSatisfied (GregorianCalendar date1, GregorianCalendar date2) {
    int dureeHeure=0;
    int saveDuree = first.getDuree();
    int dureeMinutes = first.getDuree();

    while(dureeMinutes>=60){
      dureeMinutes=dureeMinutes-60;
      dureeHeure=dureeHeure+1;
    }

    GregorianCalendar finDate1 = date1;
    finDate1.add(GregorianCalendar.MINUTE, first.getDuree());


    int compare =  date2.compareTo(finDate1) ;

    return (compare == 0);
  }
}
