package projetpoo;

/*
-Ajouter ce qu'il faut la fonction super pour récuperer les choses de PrecedenceConstraint

*/


public class PrecedenceConstraintWithDuration extends PrecedenceConstraint {

	private int durMin;
	private int durMAx;


	public PrecedenceConstraintWithDuration(int durMin, int durMax) {

		this.durMin = durMin;
		this.durMAx = durMax;

	}

}
