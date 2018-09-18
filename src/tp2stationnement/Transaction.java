package tp2stationnement;
import java.util.Calendar;
import java.util.GregorianCalendar;

	
	public class Transaction {
	
		// variables
		private double montant;
		private boolean carte;
		private String emplacement;
		private int nMinutes;
		GregorianCalendar heureDebut;
		GregorianCalendar heureFin;
		
		
		GregorianCalendar today = new GregorianCalendar();
		private boolean valide;	
			
	

		
		public Transaction(String emplacement) {
			this.emplacement = emplacement;
			this.nMinutes = 0;
			this.montant = 0;
			
		}
		
		public void paiement(boolean carte) {
				
			if (carte) {
					
				String numeroCarte = "4582333333333333"; 
				GregorianCalendar expiration = new GregorianCalendar(2018, 10, 28);
				CarteDeCredit carteCourante = new CarteDeCredit(numeroCarte, expiration);
					
				this.valide = today.before(carteCourante.expiration);
							
				}
				else {
					
					;
				}
			}

		public double getMontant() {
			return montant;
		}

		public void setMontant(double montant) {
			this.montant = montant;
		}

		public boolean isCarte() {
			return carte;
		}

		public void setCarte(boolean carte) {
			this.carte = carte;
		}

		public String getEmplacement() {
			return emplacement;
		}

		public void setEmplacement(String emplacement) {
			this.emplacement = emplacement;
		}

		public int getnMinutes() {
			return nMinutes;
		}

		public void setnMinutes(int nMinutes) {
			this.nMinutes = nMinutes;
		}

		public GregorianCalendar getHeureDebut() {
			return heureDebut;
		}

		public void setHeureDebut(GregorianCalendar heureDebut) {
			this.heureDebut = heureDebut;
		}

		public GregorianCalendar getHeureFin() {
			return heureFin;
		}

		public void setHeureFin(GregorianCalendar heureFin) {
			this.heureFin = heureFin;
		}

		public GregorianCalendar getToday() {
			return today;
		}

		public void setToday(GregorianCalendar today) {
			this.today = today;
		}

		public boolean isValide() {
			return valide;
		}

		public void setValide(boolean valide) {
			this.valide = valide;
		}
		
		
		
		}	
	
				



