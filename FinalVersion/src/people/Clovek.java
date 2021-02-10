package people;

import manager.RandomUtil;

public class Clovek
{
	protected String meno;
	protected int vek;
	
	public Clovek()
	{
		this.meno = RandomUtil.getRandomName();
		this.vek = RandomUtil.getRandomInterval(21, 60);
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
