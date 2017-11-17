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


  public boolean isSatisfied(Schedule edtConstraint);


}
