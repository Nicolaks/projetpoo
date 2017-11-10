package projetpoo;

import java.util.GregorianCalendar;


public class PrecedenceConstraintWithDuration extends PrecedenceConstraint {

	private int durMin;
	private int durMAx;


	public PrecedenceConstraintWithDuration (Activity first,Activity second,int durMin, int durMax) {

		super( first, second);//Permet de recuperer les attributs de la methode heritee

		this.durMin = durMin;
		this.durMAx = durMax;

	}

	public String getPrec(){//Retourne juste durMin et durMax
		return this.durMin + " " + this.durMAx;
	}

	public boolean isSatisfied (GregorianCalendar date1, GregorianCalendar date2,int durMin, int durMax){
		int dureeHeure = 0;//initialise la duree qui sert a determiner le nombre d'heure(s) du ip1
	  int saveDuree = first.getDuree();
	  int dureeMinutes = first.getDuree();//nb de minutes - les heures (toujours inferieure à 60)

    while (dureeMinutes>=60) {//soustrait 60 minutes a la durée tant que nbMinutes >60)
      dureeMinutes = dureeMinutes-60;
      dureeHeure = dureeHeure+1;
    }
    System.out.println("dureeHeure : "+ dureeHeure +" dureeMinutes : "+ dureeMinutes);//affiche le temps de l'activite 1 en heures & minutes

    GregorianCalendar finDate1 = new GregorianCalendar(date1.get(GregorianCalendar.YEAR),date1.get(GregorianCalendar.MONTH),
		date1.get(GregorianCalendar.DAY_OF_MONTH),date1.get(GregorianCalendar.HOUR_OF_DAY),
		date1.get(GregorianCalendar.MINUTE)+saveDuree);//creer le calendar qui est au moment de fin de first

    GregorianCalendar minVoirDate2 = new GregorianCalendar(date2.get(GregorianCalendar.YEAR),date2.get(GregorianCalendar.MONTH),
		date2.get(GregorianCalendar.DAY_OF_MONTH),date2.get(GregorianCalendar.HOUR_OF_DAY),
		date2.get(GregorianCalendar.MINUTE)-durMin);//creer le calendar qui est durMin avant le debut de second

    GregorianCalendar maxVoirDate2 = new GregorianCalendar(date2.get(GregorianCalendar.YEAR),date2.get(GregorianCalendar.MONTH),
		date2.get(GregorianCalendar.DAY_OF_MONTH),date2.get(GregorianCalendar.HOUR_OF_DAY),
		date2.get(GregorianCalendar.MINUTE)-durMax);//creer le calendar qui est durMax avant le debut de second

    //  	VERIFICATION

    int compare =  date2.compareTo(finDate1) ;

		//renvoie 1 si finDate1<date2 || 0 si finDate1==date2 || -1 si finDate1>date2

    if (compare == 0 || compare > 0) {return true;}
    else {return false;}
  }
}
