package controllers;

import java.util.HashMap;

import people.Zamestnanec;
import ui.Vypis;

public final class Autentifikator
{
	private static HashMap<Integer, Zamestnanec> kody = new HashMap<Integer, Zamestnanec>();
	
	public static void pridajKod(int kod, Zamestnanec zamestnanec)
	{
		kody.put(kod, zamestnanec);
	}
	
	public static Zamestnanec prihlas(int kod)
	{
		if( kody.get(kod) != null )
		{
			Vypis.prihlasenie(true);
			System.out.println("Prihlaseny zamestnanec "+ kody.get(kod));
			return kody.get(kod);
		}
		else
		{
			Vypis.prihlasenie(false);
		}
		return null;
	}
}
