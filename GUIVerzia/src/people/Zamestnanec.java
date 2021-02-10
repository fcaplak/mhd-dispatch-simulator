package people;

import manager.Autentifikator;
import manager.Util;
import ui.Vypis;

public abstract class Zamestnanec extends Clovek
{
	private int kod;
	private int id;
	protected int dobaPrestavky;
	
	public Zamestnanec(int id)
	{
		super();
		this.id = id;
		kod = Util.getRandomInterval(1001, 9999);
		Autentifikator.pridajKod(kod, this);
		//System.out.println("V podniku mame noveho zamestnanca, prihlasuje sa pod kodom * "+ kod +" *");
	}
	
	public void infoKtoSom()
	{
		Vypis.infoZamestnanec(this);
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
			//String vozidla = " ";
			//String vozidla = ( ((Vodic)this).getTypVozidla() == 0) ? "autobusu" : ( ((Vodic)this).getTypVozidla() == 1) ? "trolejbusu" : "elektricky";
			// museli sme pretypovat na podtriedu (downcast) aby sme mohli zavolat jej metodu
			return vodic; //+ " " + vozidla;
		}
		return null;
	}
	
}