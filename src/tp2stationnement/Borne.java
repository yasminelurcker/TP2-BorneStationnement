
/*                            TP2 - YASMINE KADDOURI                                */
/*                            Borne de stationnement    
/*                               18 septembre 2018                                  */




package tp2stationnement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Borne {
	
//		VARIABLES D'INSTANCE
		private double zone; 					// tarif alloué à la zone de la borne en question
		private double totalArgent; 			// variable permettant de calculer le total des transactions de la journée pour l'encaisse
		private boolean stationnementPayant; 	// valide si le stationnement au moment précis payant
		private Transaction transactionEnCours;
		private double paiementEnCours;
		private GregorianCalendar date ;
		private GregorianCalendar heureDebut;			//heure debut et heure fin sont deux objets differents utilises lors de la creation de la transaction
		private GregorianCalendar heureFin;
		private GregorianCalendar dureeStationnement;
		
		
		
		CarteDeCredit carteCourante;
		private int nMinutes;
		private int finPeriodePayante;
		double paiementMaximum = zone*2; 
	
//		CONSTRUCTEUR
	public Borne (int zone) {
	
				this.zone = zone;
				this.totalArgent = 0;
	}

//		MÉTHODES DE LA BORNE	
	public double ajouterTemps(double tempsEnMin) {
		
		return this.nMinutes +=tempsEnMin;
	}
	public double ajouterMonnaie(double paiement)
	{
		double coutMinutes = zone/60;
		return this.nMinutes * coutMinutes ;
	}
	
	public void tarifParZone(String nuZone)		// tarif par heure déterminée en fonction de la zone du stationnement 
	{
		switch(nuZone)							// les zones Z1 à Z4 n'ont pas le même tarif
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
	public boolean verifierHeure() 
	{
		GregorianCalendar date = new GregorianCalendar();	// moment du début de la transaction
		int jSemaine = date.get(Calendar.DAY_OF_WEEK);
		int hJour = date.get(Calendar.HOUR_OF_DAY);
		
		
		
		 if(jSemaine == 2 || jSemaine == 3 || jSemaine == 4 ||jSemaine == 5 || jSemaine == 6)
		{
			 
		//LUNDI AU VENDREDI  9h-21h
				if(hJour >= 9 && hJour < 21)  			
					return true;
				else
					return false;
			}
		 //SAMEDI 9h-18h
			else if(jSemaine == 7)						
				{
					if(hJour >= 9 && hJour < 18)		
						return true;
					else
						return false;	
				}
		//DIMANCHE 13-18h
			else if(jSemaine == 1)						
			{
					if(hJour >= 13 && hJour < 18)	
						return true;
			else
				return false; 	
			}
				else
					return false;
	}
	

	
	public boolean verifierEmplacement (String emplacement)
	{
		if(emplacement.matches("[A-Z][0-9]{3}"))		// expression rï¿½guliï¿½re validant le numï¿½ro du stationnement 
		{			
			this.transactionEnCours = new Transaction(emplacement);
			heureDebut = new GregorianCalendar();
			heureFin = new GregorianCalendar();																//deux objets calendriers differents et independents pour le debut et la fin
			return true;
		}
		else 
			return false;
	}

		public String calculerMinsStat()
		{
			SimpleDateFormat sdf = new SimpleDateFormat(" HH:mm "); //format d'affichage
			
			int nMinutes = transactionEnCours.getnMinutes();
			this.date = new GregorianCalendar();
			String heureDebut = sdf.format(this.date.getTime());
			dureeStationnement = new GregorianCalendar();
			dureeStationnement.add(Calendar.MINUTE,nMinutes);
			String tempsEcoule = sdf.format(dureeStationnement.getTime());
		
			transactionEnCours.setHeureDebut(heureDebut);
			transactionEnCours.setHeureFin(tempsEcoule);
			return "tempsEcoule";
		}
	public double AjouterMinutes(double paiementEnCours) {
		
		double minutesAjoutees = paiementEnCours*60/zone;
		return Math.round(minutesAjoutees);
	}

	public double ajouterMonnaie(Piece valeur) {
		
		double minutesAjoutees = 0;
		double paiementEnCours = 0.00;
		double coutMinute = zone/60; 
		int nMinutes =  (int)(valeur.getValeur() / coutMinute) ;
		
		if(transactionEnCours.getnMinutes() + AjouterMinutes( paiementEnCours) > 120)	
			return 0;
			
		
		
		
		
		
		
		
		transactionEnCours.getPrixTransaction();

		if (paiementEnCours <paiementMaximum)
		{
		double montant = valeur.getValeur();
			if (valeur.getValeur() == 0.25)
			  this.paiementEnCours =+ 0.25;
			if (valeur.getValeur() == 1.00)
				  this.paiementEnCours =+ 1.00;  
			if (valeur.getValeur() == 2.00)
				  this.paiementEnCours =+ 2.00;
			return " pièce valide";
		}
		else
			return "Piece invalide";	
	}
	
	public String Mettre25Carte(CarteDeCredit carte) 
	{
		double prix = transactionEnCours.getPrixTransaction();
		double valeur = 0.25;
		double prixMax = zone*2;
		double coutMinute = zone/60; 
		int nbMinutes = (int) (valeur/coutMinute);
		String minutesStat;

		if (prix + valeur < paiementMaximum) {
			minutesStat = calculerTempsTotalStat();
		}
		return "x";
	}
		
	public String calculerTempsTotalStat()
	{
		SimpleDateFormat sdf = new SimpleDateFormat(" HH:mm "); 
		int nbMinutes = transactionEnCours.getnMinutes();
		this.date = new GregorianCalendar();
		String heureDebut = sdf.format(this.date.getTime());
		
		dureeStationnement = new GregorianCalendar();
		dureeStationnement.add(Calendar.MINUTE,nMinutes);
		String heureFin = sdf.format(dureeStationnement.getTime());
		transactionEnCours.setHeureDebut(heureDebut);
		transactionEnCours.setHeureFin(heureFin);
		
		return heureFin;  
	}
	
	public boolean calculerStatGratuit()
	{ 
		dureeStationnement = new GregorianCalendar();
		
		if(dureeStationnement.get(Calendar.HOUR_OF_DAY) >= finPeriodePayante)
		{ 
			dureeStationnement.set(Calendar.HOUR_OF_DAY,finPeriodePayante);
			dureeStationnement.set(Calendar.MINUTE,0);
			SimpleDateFormat sdf = new SimpleDateFormat(" HH:mm ");
			String heureFin = sdf.format(dureeStationnement.getTime());
			
			transactionEnCours.setHeureFin(heureFin);
			return true;
		}
		return stationnementPayant;
	}


		/*GregorianCalendar dateExpiration = carte.getExpiration();		
		
		this.carteCourante = carte;
		
		return " ";
	
	
	public double calculerPrix(boolean toucheMax)
	{		
		double prixStationnement = 0;
		if (prixStationnement  < prixMaximum) {
			
		toucheMax = false;
		
		prixStationnement += 0.25;
		return prixStationnement;
	}
		}*/


	public void setZone(int zone) 
	{
		this.zone = zone;
	}
	public double encaisser() 
	{
		double montantActuel = this.totalArgent;
		this.totalArgent = 0; 
		return montantActuel;
	}

}


