package projetpoo;

import java.util.*;
import java.io.*;
import scheduleio.*;
import java.lang.*;

public class main {

  public static void main (String [] args)throws IOException  {//Fonction principale
    Map<String,Activity> mapAct = readActivities("projetpoo/__activity__.txt");
    Collection<PrecedenceConstraint> collecPCons = PrecConsCollec("projetpoo/__precedentConstraint__.txt",mapAct);

    Collection<MeetConstraint> collecMeetCons = meetConsCollec("projetpoo/__meetConstraint__.txt",mapAct);
    Collection<MaxSpanConstraint> collecMaxSpan = maxSpanCollec("projetpoo/__maxSpanConstraint__.txt",mapAct);



    ArrayList<Activity> activites = new ArrayList<>();
    for (String name : mapAct.keySet()) {
      activites.add(mapAct.get(name));
    }

    System.out.println("Emploi du temps trouvé avec les contraintes de précédence fournies:");

    Schedule edt = Schedule.computeSchedule(activites,collecPCons);
    System.out.println(edt);

    System.out.println("L'emploi du temps ne satisfait pas toutes les contraintes");

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
    return constraintCollec;
  }

  public static Collection<MeetConstraint> meetConsCollec (String filename, Map<String,Activity> mapAct) throws IOException {

    BufferedReader fileReader = new BufferedReader (new FileReader (filename));

    Collection<String> validIds = mapAct.keySet();

    OrderedPairReader constraintReader = new OrderedPairReader(fileReader,validIds,"_meets_");

    Collection<MeetConstraint> collecMeet = new ArrayList<MeetConstraint>();

    for (OrderedPair<String,String> pair : constraintReader.readAll()) {
      MeetConstraint constraint = new MeetConstraint(mapAct.get(pair.getFirst()),mapAct.get(pair.getSecond()));
      collecMeet.add(constraint);
    }
    return collecMeet;
  }



  public static Collection<MaxSpanConstraint> maxSpanCollec (String filename, Map<String, Activity> mapAct) throws IOException, IllegalArgumentException {

    BufferedReader fileReader = new BufferedReader (new FileReader (filename));

    Collection<String> validIds = mapAct.keySet();

    StringsStringReader constraintReader = new StringsStringReader(fileReader,validIds,",","_within_");

    Collection<MaxSpanConstraint> collecMaxSpan = new ArrayList<MaxSpanConstraint>();

    for (OrderedPair<List<String>,String> pair : constraintReader.readAll()) {
      //il faut récupérer dans la liste List<String> chaque Strring
      ArrayList<Activity> withinAct = new ArrayList<Activity>();
      withinAct.add(mapAct.get(pair.getFirst()));
      withinAct.add(mapAct.get(pair.getSecond()));
      System.out.println(mapAct.get(p);

      int dureeTotale = 0;

      for (Activity act : withinAct) {
        dureeTotale += act.getDuree();
      }

      MaxSpanConstraint constraint = new MaxSpanConstraint(withinAct,dureeTotale);
      collecMaxSpan.add(constraint);
    }
    System.out.println(collecMaxSpan);
    return collecMaxSpan;
  }
}
