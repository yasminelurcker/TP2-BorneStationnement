package tp2stationnement;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Borne {

	
		private double zone; 					// tarif allou� � la zone de la borne en question
		private double totalArgent; 			// variable permettant de calculer le total des transactions de la journ�e pour l'encaisse
		private boolean stationnementPayant; 	// valide si le stationnement au moment pr�cis est payant
		private Transaction transactionEnCours;
		private double paiementEnCours;
		private GregorianCalendar date ;
		CarteDeCredit carteCourante;
		private int nMinutes;
		
		
		
	public Borne (int zone) {
	
				this.zone = zone;
			}
	
	public double ajouterTemps(double tempsEnMin) {
		
		return this.nMinutes +=tempsEnMin;
		
	}
	public double ajouterMonnaie(double paiement)
	{
		double coutMinutes = zone/60;
		return this.nMinutes * coutMinutes ;
	}
	
	public void tarifParZone(String nuZone)		// tarif par heure d�termin� en fonction de la zone du stationnement 
	
	{
		switch(nuZone)							// les zones Z1 � Z4 n'ont pas le m�me tarif
		{
			case "Zone1": this.zone = 3.00;
				break;
			case "Zone2": this.zone = 2.50;
				break;
			case "Zone3": this.zone = 2.00;
				break;
			case "Zone4": this.zone = 1.50;
				break;
		}
	}

	public void verifierHeure() {
		GregorianCalendar date = new GregorianCalendar();
 
		if(date.get(Calendar.DAY_OF_WEEK )== 1)
			if (date.get(Calendar.HOUR_OF_DAY) <13 ||	// le dimanche entre 13 et 18h 
				date.get(Calendar.HOUR_OF_DAY)>18);
					stationnementPayant = false;

					
		if(date.get(Calendar.DAY_OF_WEEK )==2||			// du lundi au vendredi entre 9 et 21h
				date.get(Calendar.DAY_OF_WEEK )== 3||	
				date.get(Calendar.DAY_OF_WEEK )== 4||	
				date.get(Calendar.DAY_OF_WEEK )== 5||	
				date.get(Calendar.DAY_OF_WEEK )== 6)	
					stationnementPayant = false;
			if (date.get(Calendar.HOUR_OF_DAY) <9|| 	
				date.get(Calendar.HOUR_OF_DAY)>21);
					stationnementPayant = false;			

					
		if(date.get(Calendar.DAY_OF_WEEK )== 7)			// le samedi entre 9 et 18h
			if (date.get(Calendar.HOUR_OF_DAY) <9|| 
				date.get(Calendar.HOUR_OF_DAY)>18);
					stationnementPayant = false;
}
	
	public boolean verifierEmplacement (String emplacement)
	{
		if(emplacement.matches("[A-Z][0-9]{3}"))		// expression r�guli�re validant le num�ro du stationnement 
		{
			this.transactionEnCours = new Transaction(emplacement);
			return true;
		}
		else 
			return false;
	}

	public String ajouterMonnaie(Piece valeur) {
		
		double paiementEnCours = 0.00;
		double paiementMaximum = 6.00;
		double coutMinute = zone/60; 
		int nMinutes;
		
		
		if (paiementEnCours <paiementMaximum)
		{
		double montant = valeur.getValeur();
			if (valeur.getValeur() == 0.25)
			  this.paiementEnCours =+ 0.25;
			if (valeur.getValeur() == 1.00)
				  this.paiementEnCours =+ 1.00;  
			if (valeur.getValeur() == 2.00)
				  this.paiementEnCours =+ 2.00;
		}
		return "Piece invalide";	
	}
	
	public String traiterCarte(CarteDeCredit carte) {
	
		GregorianCalendar dateExpiration = carte.getExpiration();		
		
		this.carteCourante = carte;
		
		return " ";
	}


	public void setZone(int zone) {
		this.zone = zone;
	}

}


