package projetpoo;

import java.util.Scanner;
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
      Schedule edt = new Schedule();


      /*
      //condition
      for(int i=0;i<2;i++){
        addActivity(edt);
        //edt.addSchedule(chepAct,chepGreg);
      }
      */

    int choix;
    System.out.println("Voulez vous entrer une acivite? [1 = Yes / 0 = No]");
    Scanner scan2 = new Scanner(System.in);
    choix = scan2.nextInt();
    while(choix == 1){
      addActivity(edt);
      System.out.println(edt.getRepresentation());
      //System.out.println(ip1.getRepresentation());
      System.out.println("Voulez vous entrer une acivite? [1 = Yes / 0 = No]");
      scan2 = new Scanner(System.in);
      choix = scan2.nextInt();
      }
      System.out.println(edt.getRepresentation());
    }

    public static /*Pair<Activity, GregorianCalendar>*/void addActivity(Schedule edt){
        //INPUT activite
        System.out.println("entrez l'activite en format AAAA MM JJ HH mm nomActivite DUREE");
        Scanner scan = new Scanner(System.in);
        int an = scan.nextInt();
        int mois = scan.nextInt();
        int jour = scan.nextInt();
        int heure = scan.nextInt();
        int minute = scan.nextInt();
        String nomActivite = scan.next();
        int duration = scan.nextInt();
        //System.out.println(an +" "+ mois +" "+ jour +" "+ heure +" "+ minute +" "+ nomActivite +" "+ duration);
        Activity chepoActivity = new Activity(nomActivite,duration);
        GregorianCalendar chepoDate = new GregorianCalendar(an,mois,jour,heure,minute);

        System.out.println(chepoActivity.getRepresentation()+"\n" +"YEAR "+
          chepoDate.get(GregorianCalendar.YEAR)+" MONTH "+chepoDate.get(GregorianCalendar.MONTH)+
          " DAY_OF_MONTH "+chepoDate.get(GregorianCalendar.DAY_OF_MONTH)+" HOUR_OF_DAY "+
          chepoDate.get(GregorianCalendar.HOUR_OF_DAY)+" MINUTE "+chepoDate.get(GregorianCalendar.MINUTE));

        edt.addSchedule(chepoActivity, chepoDate);



      }/*
      else{
        System.out.println("ressai");
      }*/

      ////////return new Pair<>(chepoActivity,chepoDate) ;
      //Fin INPUT




      /*          //COMPARAISON
      GregorianCalendar date1 = new GregorianCalendar(1994,01,05,12,30);
      GregorianCalendar date2 = new GregorianCalendar(1994,01,05,15,4);

      PrecedenceConstraint PrecConstraint = new PrecedenceConstraint(ip1,ip2);

      int durMin = 120;
      int durMax = 240;
      PrecedenceConstraintWithDuration PrecConstraintWDur = new PrecedenceConstraintWithDuration(ip1,ip2,durMin,durMax);

      System.out.println(PrecConstraint.isSatisfied(date1,date2));

      System.out.println(PrecConstraintWDur.isSatisfied(date1,date2,durMin,durMax));
      */            //FIN COMPARAISON


}
