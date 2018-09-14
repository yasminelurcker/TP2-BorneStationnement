package tp2stationnement;
import java.util.Calendar;
import java.util.GregorianCalendar;

	
	public class Transaction {
	
		// variables
		
		private double montant;
		private boolean carte;
		private boolean valide;
		private String emplacement;
		
		GregorianCalendar heureDebut;
		GregorianCalendar heureFin;
		GregorianCalendar today = new GregorianCalendar();	
			
	
		// constructeur
		
		public Transaction( GregorianCalendar heureDebut, String emplacement, boolean carte) {
			
				this.emplacement = emplacement;
				this.heureDebut = heureDebut;
				this.paiement(carte);	
				}
		
		public void paiement(boolean carte) {
				
			if (carte) {
					
				String numeroCarte = "4582333333333333"; 
				GregorianCalendar expiration = new GregorianCalendar(2018, 10, 28);
				CarteDeCredit carteCourante = new CarteDeCredit(numeroCarte, expiration);
					
				this.valide = today.before(carteCourante.expiration);
							
				}
				else {
					// Paiment en pièces
					
				}	
			}
		}	
				



