package connections;

import java.util.ArrayList;

import manager.Transport;

public class Linka
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
	
	public String getTyp()
	{
		return (this.typVozidiel == 2) ? ("Elektrièková") : (this.typVozidiel == 1) ? ("Trolejbusová") : ("Autobusová"); 
	}
	
	public String getZasZac()
	{
		if(this.zastavky != null)
			return this.zastavky.get(0).getMeno();
		else
			return "";
	}
	public void addZastavka(Zastavka z)
	{
		this.zastavky.add(z);
	}
	
	public ArrayList<Zastavka> getZastavky()
	{
		return this.zastavky;
	}
}
