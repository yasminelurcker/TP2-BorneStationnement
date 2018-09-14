package tp2stationnement;

public class Piece {
	
	private double valeur;
	
	public Piece (double montant ) {
		if (montant ==0.25 || montant == 1.00 ||montant == 2.00)
			this.valeur = montant;
		
	}

	public double getValeur() {
		return valeur;
	}
}
