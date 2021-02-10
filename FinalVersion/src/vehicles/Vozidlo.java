package vehicles;

import java.util.ArrayList;
import java.util.Collections;

import connections.*;
import manager.Transport;
import people.*;

public abstract class Vozidlo
{
	protected int id;
	protected Zastavka konecnaZastavka;
	protected Zastavka aktualnaZastavka;
	protected ArrayList<Zastavka> zastavky;
	protected Vodic vodic;
	protected Linka linka;
	
	Cestujuci cestujuci;
	
	public Vozidlo(int id)
	{
		this.id = id;
		Transport.addVozidlo(id, this);
	}
	
	public abstract void skontrolujPohanac();
	
	public ArrayList<Zastavka> getZastavky()
	{
		return this.zastavky;
	}
	
	public void setKonecnaZastavka(Zastavka z)
	{
		this.konecnaZastavka = z;
	}
	
	public Zastavka getKonecnaZastavka()
	{
		return this.konecnaZastavka;
	}
	
	/**
	 * Zisti slovne s diakritikou druh vozidla
	 * @return
	 */
	public String getTyp()
	{
		String ret = null;
		if(this instanceof Autobus)
			ret = "Autobus";
		else if(this instanceof Trolejbus)
			ret = "Trolejbus";
		else if(this instanceof Elektricka)
			ret = "Elektrièka";
		
		return ret;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public Vodic getVodic()
	{
		return this.vodic;
	}
	
	public void removeVodic()
	{
		this.vodic = null;
	}
	
	public Linka getLinka()
	{
		return this.linka;
	}
	
	public String getLoc()
	{
		String loc;
		if(this.vodic != null)
		{
			loc = "v premávke na linke "+ this.linka.getCislo() +"'";
		} else loc = "vozovòa";
		return loc;
	}
	
	/**
	 * K danemu vozidlu priradi linku l
	 * @param l
	 */
	public void setLinka(Linka l)
	{
		this.linka = l;
		zastavky = new ArrayList<Zastavka>(this.linka.getZastavky());
		aktualnaZastavka = zastavky.get(0);
		konecnaZastavka = zastavky.get((zastavky.size())-1);
	}
	
	/**
	 * K danemu vozidlo priradi vodica v
	 * @param v
	 */
	public void setVodic(Vodic v)
	{
		this.vodic = v;
	}
	
	public Cestujuci getCestujuci()
	{
		return this.cestujuci;
	}

	public void removeLinka()
	{
		this.linka = null;
	}
	
	/**
	 * Vozidlo obrati svoje pole zastavok, tam kde koncilo znovu zacne
	 */
	public void obratSmer()
	{
		this.setKonecnaZastavka( this.getZastavky().get(0) ); // cielova zastavka po spatnej trase bude aktualna pociatocna
		Collections.reverse(this.zastavky);

	}

	public Zastavka getAktualnaZastavka() {
		return this.aktualnaZastavka;
	}

	public void setAktualnaZastavka(Zastavka zastavka) {
		this.aktualnaZastavka = zastavka;
	}
	
}
