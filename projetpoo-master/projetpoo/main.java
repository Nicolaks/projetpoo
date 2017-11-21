package projetpoo;
/**
    * BinaryConstraint est une classe abstraite implémentant l'interface Constraint.
    *  @param first
    *   Prend le paramètre first.
    *  @param second
    *   Prend le paramètre second.



    */


import java.util.*;
import java.io.*;
import scheduleio.*;
import java.lang.*;

public class main {

  public static void main (String [] args)throws IOException  {//Fonction principale
    Map<String,Activity> mapAct = readActivities("projetpoo/__activity__.txt");
    Collection<PrecedenceConstraint> collecPCons = PrecConsCollec("projetpoo/__precedentConstraint__.txt",mapAct);



    ArrayList<Activity> activites = new ArrayList<>();
    for (String name : mapAct.keySet()) {
      activites.add(mapAct.get(name));
    }

    Schedule edt = Schedule.computeSchedule(activites,collecPCons);
    System.out.println(edt);

  }

  public static Map<String, Activity> readActivities (String filename) throws IOException {

    BufferedReader fileReader = new BufferedReader (new FileReader (filename));

    IdStringStringReader activityReader = new IdStringStringReader(fileReader, "=", "_lasting_");

    Map<String,Activity> mapActivity = new HashMap<String,Activity>();

    for (Map.Entry<String, OrderedPair<String, String>> strings: activityReader.readAll().entrySet()) {
      String id = strings.getKey();
      OrderedPair<String, String> activityStrings = strings.getValue();
      String description = activityStrings.getFirst();
      int duration = Integer.parseInt(activityStrings.getSecond());

      Activity activite = new Activity(description,duration);
      mapActivity.put(id,activite);
    }
    return mapActivity;
  }

  public static Collection<PrecedenceConstraint> PrecConsCollec (String filename, Map<String,Activity> mapAct) throws IOException {


    BufferedReader fileReader = new BufferedReader (new FileReader (filename));

    Collection<String> validIds = mapAct.keySet();

    OrderedPairReader constraintReader = new OrderedPairReader(fileReader,validIds,"_before_");

    Collection<PrecedenceConstraint> constraintCollec = new ArrayList<PrecedenceConstraint>();

    for (OrderedPair<String,String> pair : constraintReader.readAll()) {
      PrecedenceConstraint constraint = new PrecedenceConstraint(mapAct.get(pair.getFirst()),mapAct.get(pair.getSecond()));
      constraintCollec.add(constraint);
    }

    System.out.println("Les contraintes de précédence sont satisfaites");
    return constraintCollec;

  }
}
