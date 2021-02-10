package people;

import manager.*;
import ui.Vypis;

public class KontrolnyDispecer extends Dispecer
{
	public KontrolnyDispecer(int id)
	{
		super(id);
	}

	public void priestupky()
	{
		Vypis.priestupkyVodicov();
	}
	
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
			
			Vypis.udelenaPokuta(idVodic);
		
			Transport.removePriestupok(idVodic);
			vodic.removeAktivnyPriestupok();
		}
	}
}
