package projetpoo;

import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MeetConstraint extends BinaryConstraint implements Constraint {

  public MeetConstraint (Activity first,Activity second) {
    super(first, second);
  }

  public boolean isSatisfied (GregorianCalendar date1, GregorianCalendar date2) {
    int dureeHeure=0;
    int saveDuree = first.getDuree();
    int dureeMinutes = first.getDuree();

    while(dureeMinutes>=60){
      dureeMinutes=dureeMinutes-60;
      dureeHeure=dureeHeure+1;
    }

    GregorianCalendar finDate1 = date1;
    finDate1.add(GregorianCalendar.MINUTE, first.getDuree());


    int compare =  date2.compareTo(finDate1) ;

    return (compare == 0);
  }
}
