package projetpoo;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.GregorianCalendar;//Importations de GregorianCalendar

public class projetpoo {
/*
  public LinkedHashMap<Integer, String> sortHashMapByValues(HashMap<Integer, String> passedMap) {
  List<Integer> mapKeys = new ArrayList<>(passedMap.keySet());
  List<String> mapValues = new ArrayList<>(passedMap.values());
  Collections.sort(mapValues);
  Collections.sort(mapKeys);

  LinkedHashMap<Integer, String> sortedMap =
      new LinkedHashMap<>();

  Iterator<String> valueIt = mapValues.iterator();
  while (valueIt.hasNext()) {
      String val = valueIt.next();
      Iterator<Integer> keyIt = mapKeys.iterator();

      while (keyIt.hasNext()) {
          Integer key = keyIt.next();
          String comp1 = passedMap.get(key);
          String comp2 = val;

          if (comp1.equals(comp2)) {
              keyIt.remove();
              sortedMap.put(key, val);
              break;
          }
      }
  }
  return sortedMap;
  }
*/
    public static void main (String [] args) {//Fonction principale

      Activity ip1 = new Activity("155 minutes",155);
      Activity ip2 = new Activity("10 minutes",10);
      //System.out.println("getDuree ip1 = "+ip1.getDuree());
      //System.out.println("getDuree ip2 = "+ip2.getDuree());
      Schedule edt = new Schedule();

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

      //PrecedenceConstraint.isSatisfied() Récuperer date1 et date2
      /*K1:(v1,v2), k2:(v3)*/


    }

    public static void addActivity(Schedule edt){
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
        Activity chepoActivity = new Activity(nomActivite,duration);
        GregorianCalendar chepoDate = new GregorianCalendar(an,mois,jour,heure,minute);

        /*System.out.println(chepoActivity.getRepresentation()+"\n" +"YEAR "+
          chepoDate.get(GregorianCalendar.YEAR)+" MONTH "+chepoDate.get(GregorianCalendar.MONTH)+
          " DAY_OF_MONTH "+chepoDate.get(GregorianCalendar.DAY_OF_MONTH)+" HOUR_OF_DAY "+
          chepoDate.get(GregorianCalendar.HOUR_OF_DAY)+" MINUTE "+chepoDate.get(GregorianCalendar.MINUTE));*/

        edt.addSchedule(chepoActivity, chepoDate);
      }
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
