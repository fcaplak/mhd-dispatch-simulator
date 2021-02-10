package manager;

import people.Vodic;

public final class Priestupok
{
	protected Vodic vodic;
	protected int typPriestupku; // 0 - meskanie zo zastavky, 1 - vysoka rychlost
	
	public Priestupok(Vodic vodic, int typPriestupku)
	{
		this.vodic = vodic;
		this.typPriestupku = typPriestupku;
	}
	
	public int getTypPriestupku()
	{
		return typPriestupku;
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
