package connections;

import manager.*;

public class Zastavka
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