package people;

import manager.*;

public class KontrolnyDispecer extends Dispecer
{
	public KontrolnyDispecer(int id)
	{
		super(id);
	}

	/**
	 * V pripade ze ma idVodic aktivny priestupok a nebol za neho pokutovane, pokutuje ho
	 * @param idVodic
	 */
	public void pokuta(int idVodic)
	{
		Vodic vodic = Transport.getVodici().get(idVodic);
		Priestupok priestupok = Transport.getPriestupky().get(idVodic);
		if( priestupok != null ) // vodic so zadanym ID vykonal nejaky priestupok
		{
			if(priestupok.getTypPriestupku() == 0)
				((Vodic)vodic).pokutaZaMeskanie();
			else
				((Vodic)vodic).pokutaZaRychlost();
			
			Transport.removePriestupok(idVodic);
			
			vodic.removeAktivnyPriestupok();
		}
	}
}
