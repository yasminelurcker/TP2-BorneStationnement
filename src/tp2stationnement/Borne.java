package tp2stationnement;

import java.util.Calendar;
import java.util.GregorianCalendar;

	public class Borne {

		private int zone;
		private double totalArgent;
		private boolean stationnementPayant;
		private GregorianCalendar date ;
		private double chuteComptant;
		private double MAX_MONTANT; 
		
		
	public Borne (int zone, GregorianCalendar [][] horaire) {
	
				this.zone = zone;
				this.MAX_MONTANT = 6.00;
				
			}
	public void verifierHeure() {
			GregorianCalendar date = new GregorianCalendar();
	 
			if(date.get(Calendar.DAY_OF_WEEK )== 1)
				if (date.get(Calendar.HOUR_OF_DAY) <13 || date.get(Calendar.HOUR_OF_DAY)>18);
						stationnementPayant = false;
	
						
			if(date.get(Calendar.DAY_OF_WEEK )== 2||
					date.get(Calendar.DAY_OF_WEEK )== 3||
					date.get(Calendar.DAY_OF_WEEK )== 4||
					date.get(Calendar.DAY_OF_WEEK )== 5||
					date.get(Calendar.DAY_OF_WEEK )== 6)
						stationnementPayant = false;
				if (date.get(Calendar.HOUR_OF_DAY) <9|| date.get(Calendar.HOUR_OF_DAY)>21);
						stationnementPayant = false;			
	
						
			if(date.get(Calendar.DAY_OF_WEEK )== 7)
				if (date.get(Calendar.HOUR_OF_DAY) <9|| date.get(Calendar.HOUR_OF_DAY)>18);
						stationnementPayant = false;

}
	
	public boolean EmplacementValide(String emplacement) {
		// Validation de l'emplacement
		
		
		return true;
	}

	public boolean PaiementValide("$$$") { 
		return true; 
		
	
	}
	
	
	public double getChuteComptant() {
		return chuteComptant;
	}
	public boolean insererComptant(Piece pieceCourante) {
		
		if ((pieceCourante.getValeur() + this.chuteComptant) > this.MAX_MONTANT) {
			return false;
		}
		else
			this.chuteComptant = chuteComptant + pieceCourante.getValeur();
	}
	public boolean CarteValide(CarteDeCredit carteCourante) {
	
		if (carteCourante.expiration.after( new GregorianCalendar())) {
			return true;
		}
		return false;
	}
	// Reçoit le paiement crédit
	// reçoit le paiement cash
	//imprime la facture
		
		
		
	}
	// Valide le paiement
	
// Imprime la facture
// append('' all...\n + )
// transaction.gettypepaiement +
	

