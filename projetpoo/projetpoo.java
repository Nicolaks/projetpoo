package projetpoo;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.GregorianCalendar;

/**
 * Class projetpoo
 */
public class projetpoo {
	
/**
 * Méthode Main du package
 */
  public static void main (String [] args) {//Fonction principale
    Schedule edt = new Schedule();
    
    Activity act1 = new Activity("POO",40);
    Activity act2 = new Activity("TE",60);
    Activity act3 = new Activity("Maths",10);
    Activity act4 = new Activity("Anglais",40);
    
    GregorianCalendar date1 = new GregorianCalendar(2017,10,17,13,50);
    GregorianCalendar date2 = new GregorianCalendar(2017,10,27,14,15);
    GregorianCalendar date3 = new GregorianCalendar(2017,10,10,15,15);
    GregorianCalendar date4 = new GregorianCalendar(2017,10,10,10,15);
	
    /*
    PrecedenceConstraint contrainte1 = new PrecedenceConstraint(act1,act2);
    PrecedenceConstraint contrainte2 = new PrecedenceConstraint(act3,act4);
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
    
    ArrayList<Activity> listeActi = new ArrayList<>();
    listeActi.add(act1);
    listeActi.add(act2);
    listeActi.add(act3);
    listeActi.add(act4);
    
    System.out.println(edt.toString());
    
    System.out.println(reprActivite);
    
    System.out.println(edt.satisfies(toutesContraintes));
    
    Schedule edtTrie = Schedule.computeSchedule(listeActi,toutesContraintes);
    
    System.out.println(edtTrie);
	*/
	
    ArrayList<Activity> ensemble = new ArrayList<> ();
    ensemble.add(act1);
    ensemble.add(act2);
    ensemble.add(act3);
    ensemble.add(act4);

    MeetConstraint contraint1 = new MeetConstraint(act2,act1);
    MeetConstraint contraint2 = new MeetConstraint(act3,act4);
    PrecedenceConstraint contrainte1 = new PrecedenceConstraint(act1,act2);
    PrecedenceConstraint contrainte2 = new PrecedenceConstraint(act3,act4);
    PrecedenceConstraint contraint3 = new PrecedenceConstraint(act4,act1);

    ArrayList<BinaryConstraint> listeContrainte = new ArrayList<>();
    listeContrainte.add(contraint1);
    listeContrainte.add(contraint2);
    listeContrainte.add(contraint3);
    listeContrainte.add(contrainte1);
    listeContrainte.add(contrainte2);


    MaxSpanConstraint msc = new MaxSpanConstraint(ensemble,40);
    System.out.println(msc.isSatisfied(edt));
    //msc.isSatisfied(edt);

    ArrayList<PrecedenceConstraint> contraintePrec = new ArrayList<PrecedenceConstraint> ();
    for (BinaryConstraint contrainte : listeContrainte) {
      if ( contrainte instanceof PrecedenceConstraint ) {
        contraintePrec.add((PrecedenceConstraint) contrainte);
      }
    }


    Schedule edtemps = Schedule.computeSchedule(ensemble,contraintePrec);
    System.out.println(edtemps);
  }
}
