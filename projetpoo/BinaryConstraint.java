package projetpoo;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class BinaryConstraint implements Constraint {

  protected Activity first;
  protected Activity second;

  public BinaryConstraint (Activity first,Activity second) {
    this.first=first;
    this.second=second;
  }

  public int getDureeFirst () {
    return first.getDuree();
  }

  public int getDureeSecond () {
    return second.getDuree();
  }

  public abstract boolean isSatisfied(GregorianCalendar date1,GregorianCalendar date2);

  public boolean isSatisfied(Schedule edt){
    GregorianCalendar date1 = edt.getDateForActivity(this.first);
    GregorianCalendar date2 = edt.getDateForActivity(this.second);
    return isSatisfied(date1,date2);
  }
}
