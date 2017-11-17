package projetpoo;

import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.io.*;
import scheduleio.*;
import java.lang.*;

public class main {

  public static void main (String [] args)throws IOException  {//Fonction principale
    
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

}
