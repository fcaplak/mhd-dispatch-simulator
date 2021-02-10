package people;

import connections.Linka;
import manager.Transport;
import ui.Vypis;
import vehicles.Vozidlo;

public class Dispecer extends Zamestnanec
{
	public Dispecer(int id)
	{
		super(id);
		Transport.addDispecer(this);
	}
	
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
	
	public void vozidla()
	{
		Vypis.vozidla();
	}
	
	public void vodici()
	{
		Vypis.vodici();
	}

	public void linky()
	{
		Vypis.linky();
	}
	
	public void infoVodica(int idVodic) // zobrazi informacie o vodicovi (id, meno, vek, posledna zastavka, aky je to typ vodica - skusobny..)
	{
		Vypis.infoVodica(idVodic);
	}
	
	public void skratPrestavky()
	{
		for(Zamestnanec v: Transport.getVodici().values())
		{
			//Vypis.sprava("#"+v.getId()+" prestavka pred skratenim "+v.getDobaPrestavky()+"m");
			((Zamestnanec)v).skratPrestavku(); // POLYMOFIZMUS - tato metoda je prekonana v podtriedach, kazda meni prestavku o iny cas (podla typu vodica)
			//Vypis.sprava("#"+v.getId()+" prestavka po skrateni "+v.getDobaPrestavky()+"m");
		}
	}

	public void skratPrestavku() {
		// dispecer nema implementovane prestavky
	}
	
}
