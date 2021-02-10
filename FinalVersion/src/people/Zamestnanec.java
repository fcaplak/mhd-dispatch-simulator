package people;

import manager.Podnik;
import manager.RandomUtil;

public abstract class Zamestnanec extends Clovek
{
	private int kod;
	private int id;
	protected int dobaPrestavky;
	
	public Zamestnanec(int id)
	{
		super();
		this.id = id;
		kod = RandomUtil.getRandomInterval(1001, 9999);
		Podnik.Autentifikator.pridajKod(kod, this);
	}
	
	
	public int getId()
	{
		return id;
	}
	
	public abstract void skratPrestavku();
	
	public int getDobaPrestavky()
	{
		return dobaPrestavky;
	}
	
	public int getKod()
	{
		return this.kod;
	}
	
	/**
	 * Zistime slovne typ daneho zamestnanca
	 * @return
	 */
	public String getTyp()
	{
		if(this instanceof Dispecer)
		{
			if(this instanceof KontrolnyDispecer)
				return "Kontroln� dispe�er";
			else
				return "Dispe�er";
		}
		else if(this instanceof Vodic)
		{
			String vodic = (this instanceof SkusobnyVodic) ? "Sk��obn� vodi�" : (this instanceof ProfesionalnyVodic) ? "Profesion�lny vodi�" : "Vodi�";
			return vodic;
		}
		return null;
	}
	
}