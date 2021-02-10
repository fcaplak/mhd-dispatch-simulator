package people;

import connections.Linka;
import manager.Transport;
import vehicles.Vozidlo;

public class Dispecer extends Zamestnanec
{
	public Dispecer(int id)
	{
		super(id);
		Transport.addDispecer(this);
	}
	
	/**
	 * Presunie vodica s idVodic do vozidla idVozidlo a napoji ho na linku cisloLinky
	 * @param idVodic
	 * @param idVozidlo
	 * @param cisloLinky
	 */
	public void presun(int idVodic, int idVozidlo, int cisloLinky)
	{
		Vodic vodic = Transport.getVodici().get(idVodic);
		Linka linka = Transport.getLinky().get(cisloLinky);
		
		Vozidlo vozidlo = Transport.getVozidla().get(idVozidlo);
		
		if(vodic.getVozidlo() != null) 
		{
			vodic.removeVozidlo(); // stare vozidlo nebude patrit vodicovi
			vozidlo.removeVodic(); // stare vozidlo nebude mat vodica
			vozidlo.removeLinka(); // odpojime vozidlo od linky a pojde do vozovne
		}
		vodic.setVozidlo(vozidlo); // nastavime mu nove vozidlo
		vodic.setLinka(linka); // zapiseme mu novu linku
		
		vozidlo.setVodic(vodic); // novemu vozidlu nastavime vodica
		vozidlo.setLinka(linka); // zapiseme mu novu linku - dali sme ho prec z vozovne
		//Vypis.presunutieDispecerom(idVodic, idVozidlo, cisloLinky);
	}
	
	/**
	 * Tymto prikazom sa prebehne cele pole vodicov a skratia sa im prestavky
	 */
	public void skratPrestavky()
	{
		for(Zamestnanec v: Transport.getVodici().values())
		{
			((Zamestnanec)v).skratPrestavku(); // POLYMOFIZMUS - tato metoda je prekonana v podtriedach, kazda meni prestavku o iny cas (podla typu vodica)
		}
	}

	public void skratPrestavku() {
		// dispecer nema implementovane prestavky
	}
	
}
