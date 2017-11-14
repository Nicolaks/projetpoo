package projetpoo;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public interface Constraint {//Interface Constraint

  /*Je ne sais pas si c'est la bonne méthode pour le isSatisfied*/
  public abstract boolean isSatisfied(Schedule edtConstraint);


}
