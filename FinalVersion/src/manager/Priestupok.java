package manager;

import people.Vodic;

public final class Priestupok
{
	protected Vodic vodic;
	protected int typPriestupku; // 0 - meskanie zo zastavky, 1 - vysoka rychlost
	protected int vyska;
	
	public Priestupok(Vodic vodic, int typPriestupku)
	{
		this.vodic = vodic;
		this.typPriestupku = typPriestupku;
		this.vyska = (typPriestupku == 0) ? vodic.getPokutaMeskanie() : vodic.getPokutaRychlost();
	}
	
	public int getTypPriestupku()
	{
		return typPriestupku;
	}
	
	public int getIdVodica()
	{
		return this.vodic.getId();
	}
	
	/**
	 * Vrati slovne o aky druh priestupku sa jednalo
	 * @return
	 */
	public String getDruh()
	{
		return (typPriestupku == 1) ? "Vysoka rychlost" : "Meskanie zo zastavky"; 
	}
	
	public int getVyska()
	{
		return vyska;
	}

	public void setTypPriestupku(int typPriestupku)
	{
		this.typPriestupku = typPriestupku;
	}
	
	public Vodic getVodic()
	{
		return this.vodic;
	}
}