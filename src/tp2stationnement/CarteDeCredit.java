package tp2stationnement;
import java.util.GregorianCalendar;

public class CarteDeCredit {

	private String numeroCarte;
	private String expiration;
	private boolean expValide;

public CarteDeCredit(String numeroCarte, String expiration) {
	
	if(numeroCarte.length() == 16)
	{
		this.numeroCarte = numeroCarte;
		this.expiration = expiration;
		expValide = false;
	}
	
	}

public String getNumeroCarte() {
	return numeroCarte;
}


public String getExpiration() {
	return expiration;
}
public void setDateExpValide(boolean expValide)
{
	this.expValide = expValide;
}
}

