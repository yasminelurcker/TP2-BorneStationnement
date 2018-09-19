package tp2stationnement;
import java.util.Calendar;
import java.util.GregorianCalendar;

	
	public class Transaction {
	
		// variables
		private double montant;
		private double prixTransaction;
		private boolean carte;
		private String emplacement;
		private int nMinutes;
		private String heureDebut;
		private String heureFin;
		private boolean valide;	

		GregorianCalendar today = new GregorianCalendar();

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
		public double getPrixTransaction() {
			return prixTransaction;
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

		public String getHeureDebut() {
			return heureDebut;
		}

		public void setHeureDebut(String heureDebut2) {
			this.heureDebut = heureDebut2;
		}

		public String getHeureFin() {
			return heureFin;
		}

		public void setHeureFin(String tempsEcoule) {
			this.heureFin = tempsEcoule;
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
	
				



