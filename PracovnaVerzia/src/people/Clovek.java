package people;

import controllers.Util;

public class Clovek
{
	protected String meno;
	protected int vek;
	
	public Clovek()
	{
		this.meno = Util.getRandomName();
		this.vek = Util.getRandomInterval(21, 60);
	}
	
	public String getMeno()
	{
		return this.meno;
	}
	
	public int getVek()
	{
		return this.vek;
	}
}
