package projetpoo;

import java.time.LocalDateTime;
import java.util.GregorianCalendar;//Importations de GregorianCalendar

public class projetpoo {
/*
  private int year = 1997;
  private int month = 02;
  private int dayOfMonth = 05;
  private int hourOfDay = 17;
  private int minute = 31;
*/
    public static void main (String [] args) {//Fonction principale

      Activity ip1 = new Activity("155 minutes",155);
      Activity ip2 = new Activity("10 minutes",10);
      //System.out.println("getDuree ip1 = "+ip1.getDuree());
      //System.out.println("getDuree ip2 = "+ip2.getDuree());

      //System.out.println(ip1.getRepresentation());

      GregorianCalendar date1 = new GregorianCalendar(1994,01,05,12,30);
      GregorianCalendar date2 = new GregorianCalendar(1994,01,05,14,29);

      PrecedenceConstraint osef = new PrecedenceConstraint(ip1,ip2);

      System.out.println(osef.isSatisfied(date1,date2));



  }
}
