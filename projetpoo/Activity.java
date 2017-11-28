package projetpoo;
/**
 * @author
 * Aubry Nicolas, Dimitri Chagneux, Sami Zaizafoun, Martin Jacqueline
 * La class Activity
 */
import java.util.GregorianCalendar;

/**
   * Lance la class Activity qui permet de représenter des crénaux horaires
   */

public class Activity {

  private String descr;
  private int duree;

  /**
   * Le constructeur prend en entrée une description et une durée.
   * @param descr
   * La description doit être un String.
   * @param duree
   * La durée doit être un int.
   */
  public Activity (String descr, int duree) {
    this.descr=descr;
    this.duree=duree;
  }

 /**
  * @return
  * Retourne la représentation
  */
  public String getRepresentation () {
    return descr+" "+duree;
  }

  /**
   * @return
   *Retourne la description
   */
  public String getAct () {
    return this.descr;
  }

  /**
   * @return
   * Retourne la durée
   */
  public int getDuree () {
    //System.out.println("duree test"+this.duree);
    return this.duree;
  }
}
