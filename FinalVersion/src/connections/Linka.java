package connections;

import java.io.Serializable;
import java.util.ArrayList;

import manager.Transport;

public class Linka implements Serializable
{
	protected int cislo;
	protected int typVozidiel; // 0/1/2 - autobusova/trolejbusova/elektrickova linka
	
	ArrayList<Zastavka> zastavky = new ArrayList<Zastavka>(); // linka bude obsahovat zastavky
	
	public Linka(int cislo, int typVozidiel)
	{
		this.cislo = cislo;
		this.typVozidiel = typVozidiel;
		Transport.addLinka(cislo, this);
	}
	
	public int getCislo()
	{
		return this.cislo;
	}
	
	public int getTypVozidiel()
	{
		return this.typVozidiel;
	}
	
	/**
	 * Zisti v slovnej forme o aky typ linky sa jedná
	 * @return
	 */
	public String getTyp()
	{
		return (this.typVozidiel == 2) ? ("Elektrièková") : (this.typVozidiel == 1) ? ("Trolejbusová") : ("Autobusová"); 
	}
	
	/**
	 * Zisti zaciatocnu zastavku linky z pola zastavok
	 * @return
	 */
	public String getZasZac()
	{
		if(this.zastavky != null)
			return this.zastavky.get(0).getMeno();
		else
			return "";
	}
	
	/**
	 * Prida do pola zastavok objekt zastavky ktora prisla ako argument.
	 * @param z
	 */
	public void addZastavka(Zastavka z)
	{
		this.zastavky.add(z);
	}
	
	public ArrayList<Zastavka> getZastavky()
	{
		return this.zastavky;
	}
}
