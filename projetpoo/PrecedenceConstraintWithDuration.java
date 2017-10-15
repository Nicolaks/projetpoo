package projetpoo;

/*
-Ajouter ce qu'il faut la fonction super pour récuperer les choses de PrecedenceConstraint

*/


public class PrecedenceConstraintWithDuration extends PrecedenceConstraint {

	private int durMin;
	private int durMAx;


	public PrecedenceConstraintWithDuration(Activity first,Activity second,int durMin, int durMax) {

		super( first, second);//Permet de récuperer les attributs de la methode hérité

		this.durMin = durMin;
		this.durMAx = durMax;

	}

	public String getPrec(){//Retourne juste durMin et durMax

		return this.durMin + " " + this.durMAx;
	}

}
