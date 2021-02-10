package people;

import connections.*;
import manager.Transport;
import manager.Util;
import ui.Vypis;
import vehicles.Vozidlo;

public class Vodic extends Zamestnanec
{
	protected Vozidlo vozidlo = null;
	protected Linka linka = null;
	protected int maximalneMeskanie; // maximalny pocet minut kolko moze vodic meskat
	protected double platZaJazdu; // vodicove ohodnotenie za kazdu jednu prejdenu trasu (jednym smerom)
	protected double celkovyZarobok = 0; // celkove peniaze vodica

	protected int odratajZaMeskanie = 20;
	protected int odratajZaRychlost = 50;
	
	protected int sancaNaPriestupok = 10; // 10 percentna sanca, ze pocas prechadzani zastavok vodic vykona priestupok
	
	boolean aktivnyPriestupok = false;
	
	public Vodic(int id)
	{
		super(id);
		Transport.addVodic(id, this);
		this.maximalneMeskanie = 3; // obycajny vodic moze meskat najviac do 3 minut
		this.dobaPrestavky = 15; // obycajny vodic ma 15 minutovu prestavku
		this.platZaJazdu = 4.5;
	}

	public void dostanVyplatenuJazdu() // metoda sa zavola po prejdeni jedneho smeru trasy
	{
		this.celkovyZarobok += this.platZaJazdu;
		Vypis.vyplatenaJazda(platZaJazdu, celkovyZarobok);
	}
	
	public void skratPrestavku()
	{
		this.dobaPrestavky = 7; // obycajnemu vodicovi sa skrati prestavka na 7 minut
	}
	
	public void pokutaZaMeskanie()
	{
		this.celkovyZarobok -= this.odratajZaMeskanie;
	}
	
	public void pokutaZaRychlost()
	{
		this.celkovyZarobok -= this.odratajZaRychlost;
	}
	
	public int getPokutaMeskanie()
	{
		return this.odratajZaMeskanie;
	}
	
	public int getPokutRychlost()
	{
		return this.odratajZaRychlost;
	}
	
	public double getCelkovyZarobok()
	{
		return this.celkovyZarobok;
	}
	
	
	public void setCelkovyZarobok(double novyZarobok)
	{
		this.celkovyZarobok = novyZarobok;
	}
	
	public Vozidlo getVozidlo()
	{
		return this.vozidlo;
	}
	
	public String getVozidloTab()
	{
		if(this.vozidlo == null)
			return "";
		return this.vozidlo.getTyp()+" #"+this.vozidlo.getId();
	}
	
	public void setVozidlo(Vozidlo vozidlo)
	{
		this.vozidlo = vozidlo;
	}
	
	public void removeVozidlo()
	{
		this.vozidlo = null;
	}
	
	public Linka getLinka()
	{
		return linka;
	}
	
	public String getLinkaNum()
	{
		if(linka == null)
			return "";
		return Integer.toString(linka.getCislo());
	}

	public void setLinka(Linka linka)
	{
		this.linka = linka;
	}
	
	
	public void prejdi() // prejdeme jednu trasu
	{
		while(this.getVozidlo().getAktualnaZastavka() != this.getVozidlo().getKonecnaZastavka())
			this.posun();
	}
	
	public void removeAktivnyPriestupok()
	{
		this.aktivnyPriestupok = false;
	}
	
	public void posun() // prejdeme jednu zastavku
	{
		if( this.getVozidlo().getZastavky().indexOf(this.getVozidlo().getAktualnaZastavka()) < this.getVozidlo().getZastavky().size()-1 )
		{
			this.getVozidlo().setAktualnaZastavka(this.getVozidlo().getZastavky().get(this.getVozidlo().getZastavky().indexOf(this.getVozidlo().getAktualnaZastavka())+1));
			//System.out.println("[ "+this.linka.getCislo()+" ] -> "+ this.getVozidlo().getKonecnaZastavka().getMeno() + " | je momentalne v zastavke " +this.getVozidlo().getAktualnaZastavka().getMeno());
		
			/*
			if( !this.aktivnyPriestupok && Util.getRandomInterval(0, 100) < sancaNaPriestupok) // Vodic vykonal priestupok
			{
				Integer typPriestupku = Util.getRandomInterval(0, 1);
				Transport.addPriestupok(this, typPriestupku);
				Vypis.pokutaVodicovi(0);
				
				this.aktivnyPriestupok = true;
			}*/
		}
		else
		{
			//Vypis.prestavkaVodic(this);
			
			//this.dostanVyplatenuJazdu();
			this.getVozidlo().obratSmer();
		}
	}	
}
