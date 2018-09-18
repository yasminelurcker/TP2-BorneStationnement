package tp2stationnement;
import java.util.GregorianCalendar;

public class CarteDeCredit {

	private String numeroCarte;
	GregorianCalendar expiration;

public CarteDeCredit(String numeroCarte, GregorianCalendar expiration) {
	
	if(numeroCarte.length() == 16)
	{
		this.numeroCarte = numeroCarte;
		this.expiration = expiration;
		
	}
	
	}

public String getNumeroCarte() {
	return numeroCarte;
}


public GregorianCalendar getExpiration() {
	return expiration;
}

}

