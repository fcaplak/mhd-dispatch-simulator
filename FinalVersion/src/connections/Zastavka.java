package connections;

import java.io.Serializable;

import manager.*;

public class Zastavka implements Serializable
{
	protected String meno;
	
	public Zastavka(String meno)
	{
		this.meno = meno;
		Transport.addZastavka(meno, this);
	}
	
	public String getMeno()
	{
		return this.meno;
	}
}