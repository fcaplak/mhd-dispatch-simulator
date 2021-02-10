package vehicles;

import java.util.ArrayList;
import java.util.Collections;

import connections.*;
import controllers.Transport;
import people.*;

public class Vozidlo
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
	
	public void setLinka(Linka l)
	{
		this.linka = l;
		zastavky = new ArrayList<Zastavka>(this.linka.getZastavky());
		aktualnaZastavka = zastavky.get(0);
		konecnaZastavka = zastavky.get((zastavky.size())-1);
		System.out.println("*** aktualna: "+aktualnaZastavka.getMeno()+" konecna: " +konecnaZastavka.getMeno());
	}
	
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
	
	public void obratSmer()
	{
		this.setKonecnaZastavka( this.getZastavky().get(0) ); // cielova zastavka po spatnej trase bude aktualna pociatocna
		Collections.reverse(this.zastavky);

		System.out.println("Vozidlo #"+ this.getId() +" na zastavke "+ this.aktualnaZastavka.getMeno() +" zmenil smer na "+ this.getKonecnaZastavka().getMeno());
	}

	public Zastavka getAktualnaZastavka() {
		return this.aktualnaZastavka;
	}

	public void setAktualnaZastavka(Zastavka zastavka) {
		this.aktualnaZastavka = zastavka;
	}
	
}
