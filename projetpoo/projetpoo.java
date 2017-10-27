package projetpoo;

import java.util.ArrayList;
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

      Schedule edt = new Schedule();

      Activity act1 = new Activity("POO",40);
      Activity act2 = new Activity("TE",60);
      Activity act3 = new Activity("Maths",10);
      Activity act4 = new Activity("POO",40);

      GregorianCalendar date1 = new GregorianCalendar(2017,10,17,13,50);
      GregorianCalendar date2 = new GregorianCalendar(2017,10,27,14,15);
      GregorianCalendar date3 = new GregorianCalendar(2017,10,10,14,15);
      GregorianCalendar date4 = new GregorianCalendar(2017,10,10,10,15);

      PrecedenceConstraint contrainte1 = new PrecedenceConstraint(act1,act2);
      PrecedenceConstraint contrainte2 = new PrecedenceConstraint(act3,act1);
      PrecedenceConstraint contrainte3 = new PrecedenceConstraint(act4,act1);

      ArrayList<PrecedenceConstraint> toutesContraintes= new ArrayList<> ();
      toutesContraintes.add(contrainte1);
      toutesContraintes.add(contrainte2);
      toutesContraintes.add(contrainte3);

      edt.addSchedule(act1,date1);
      edt.addSchedule(act2,date2);
      edt.addSchedule(act3,date3);
      edt.addSchedule(act4,date4);

      String reprActivite = edt.getRepresentation();

      System.out.println(reprActivite);

      System.out.println(edt.satisfies(toutesContraintes));


    }


}
