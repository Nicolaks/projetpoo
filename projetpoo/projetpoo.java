package projetpoo;

import java.util.GregorianCalendar;//Importations de GregorianCalendar

public class projetpoo {

    public static void main (String [] args) {//Fonction principale

      Activity ip1 = new Activity("Description",30);
      Activity ip2 = new Activity("Description",10);

      System.out.println(ip1.getRepresentation());

      GregorianCalendar date1 = new GregorianCalendar();
      GregorianCalendar date2 = new GregorianCalendar();

      PrecedenceConstraint osef = new PrecedenceConstraint(ip1,ip2);

      System.out.println(PrecedenceConstraint.isSatisfied(date1,date2));



  }
}
