package projetpoo;

import java.util.*;
import java.io.*;
import scheduleio.*;
import java.lang.*;

/**
 * @author
 * Aubry Nicolas, Dimitri Chagneux, Sami Zaizafoun, Martin Jacqueline
 * Class main
 */
public class main {
/**
 * Méthode Main du package
 */
  public static void main (String [] args)throws IOException  {//Fonction principale
    Map<String,Activity> mapAct = readActivities("projetpoo/data/" +/*__activity__.txt"*/args[0]);
    Collection<PrecedenceConstraint> collecPCons = PrecConsCollec("projetpoo/data/" +/*__precedentConstraint__.txt"*/args[1],mapAct);

    Collection<MeetConstraint> collecMeetCons = meetConsCollec("projetpoo/data/" +/*__meetConstraint__.txt"*/args[2],mapAct);
    Collection<MaxSpanConstraint> collecMaxSpan = maxSpanCollec("projetpoo/data/" +/*__maxSpanConstraint__.txt"*/args[3],mapAct); //inverse l'ordre des deuwx premières activités si la première est à 0
    System.out.println(args[0]+" || "+args[1]+" || "+args[2]+" || "+args[3]);



    ArrayList<Activity> activites = new ArrayList<>();
    for (String name : mapAct.keySet()) {
      activites.add(mapAct.get(name));
    }

    System.out.println("Emploi du temps trouvé avec les contraintes de précédence fournies:");

    Schedule edt = Schedule.computeSchedule(activites,collecPCons);
    System.out.println(edt);

    System.out.println("L'emploi du temps ne satisfait pas toutes les contraintes");

  }


 /**
  * Méthode readActivities.
  *
  * @param filename
  *		Le nom du fichier doit etre un String.
  *
  * @return
  *		Retourne les clefs des identifiants donnés dans le fichier, et pour valeurs les instances d'activités correspondantes.
 */
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

 /**
  * Méthode PrecConsCollec.
  *
  * @param filename
  *		Le nom du fichier doit etre un String.
  *
  * @param mapAct
  *		L'identifiant et l'instance de l'activité.
  *
  * @return
  *		Retourne une collection d'instances de la classe « PrecedenceConstraint ».
 */
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

 /**
  * Méthode meetConsCollec.
  *
  * @param filename
  *		Le nom du fichier doit etre un String.
  *
  * @param mapAct
  *		L'identifiant et l'instance de l'activité.
  *
  * @return
  *		Retourne une collection d'instances de la classe « MeetConstraint ».
 */
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


 /**
  * Méthode maxSpanCollec.
  *
  * @param filename
  *		Le nom du fichier doit etre un String.
  *
  * @param mapAct
  *		L'identifiant et l'instance de l'activité.
  *
  * @return
  *		Retourne une collection d'instances de la classe « MaxSpanConstraint ».
 */
  public static Collection<MaxSpanConstraint> maxSpanCollec (String filename, Map<String, Activity> mapAct) throws IOException, IllegalArgumentException {

    BufferedReader fileReader = new BufferedReader (new FileReader (filename));

    Collection<String> validIds = mapAct.keySet();

    StringsStringReader constraintReader = new StringsStringReader(fileReader,validIds,",","_within_");

    Collection<MaxSpanConstraint> collecMaxSpan = new ArrayList<MaxSpanConstraint>();

    for (OrderedPair<List<String>,String> pair : constraintReader.readAll()) {
      List<String> stringList = pair.getFirst();
      ArrayList<Activity> withinAct = new ArrayList<Activity>();

      for (int i = 0; i < stringList.size(); i++) {

        for (Map.Entry<String,Activity> mapActEntry : mapAct.entrySet()) {
          String mapActKey = mapActEntry.getKey();
          Activity mapActValue = mapActEntry.getValue();
          if (mapActKey.equals(stringList.get(i))) {
            withinAct.add(mapAct.get(mapActKey));
          }
        }
      }

	  int duration = Integer.parseInt(pair.getSecond());
      MaxSpanConstraint constraint = new MaxSpanConstraint(withinAct,duration);
      collecMaxSpan.add(constraint);

    }
    return collecMaxSpan;
  }
}
