package controllers;

import java.util.ArrayList;
import java.util.HashMap;

import connections.Linka;
import people.*;
import vehicles.Vozidlo;

public class Data
{
	private static HashMap<Integer, Linka> linky = new HashMap<Integer, Linka>(); // key = cislo linky, hodnota = objekt linky
	private static HashMap<Integer, Vodic> vodici = new HashMap<Integer, Vodic>(); // key = id vodica, hodnota = objekt vodica
	private static ArrayList<Dispecer> dispeceri = new ArrayList<Dispecer>();
	private static HashMap<Integer, Vozidlo> vozidla = new HashMap<Integer, Vozidlo>(); // key = id vozidla, hodnota = objekt vozidlo
	
	private static String[] mena =
	{
			"Keshawn","Konnor","Darwin","Antonio","Julian","Braedon","Colton","Skyler","Jamar","Immanuel","Daniel","Zachariah",
			"Ernest","Nasir","Stanley","Ahmed","Kyson","Nehemiah","Myles","River","Howard","Camron","Justus","Trevor","Joshua",
			"Rolando","Quinn","Dawson","Keagan","Jensen","Emilio","Yandel","Quintin","Memphis","Chace","Sincere","Cullen","Deon",
			"Noel","Peyton","Muhammad","Beckham","Shaun","John","Jakobe","Vaughn","Gunnar","Walker","Kamron", "Makhi"
	};
	
	private static String[] priezviska =
	{
			"Griffin", "Chaney","Nelson","Mckinney","Avila","Tapia","Proctor","Watkins","Villegas","Larson","Ford","Lutz","Merritt",
			"Orr","Mata","Craig","Stanley","Esparza","Morrow","Hanna","Leon","Hutchinson","Rosario","Henson","Hess","Ward","Mitchell",
			"Waller","Cross","Johnston","Blackburn","Gonzalez","Patrick","Brennan","Norris","George","Rich","Keller","Bonilla","Cooley",
			"Santana","Sanchez","Mcdowell","Mcgee","Cochran","Jacobs","Powell","Dennis","Baker", "Dudley"
	};
			
	
	public static String[] getMena()
	{
		return mena;
	}
	
	public static String[] getPriezviska()
	{
		return mena;
	}

	public static HashMap<Integer, Vodic> getVodici() {
		return vodici;
	}
	
	public static HashMap<Integer, Linka> getLinky() {
		return linky;
	}
	
	public static HashMap<Integer, Vozidlo> getVozidla() {
		return vozidla;
	}
	
	public static ArrayList<Dispecer> getDispeceri() {
		return dispeceri;
	}
	
	public static void addVozidlo(int id, Vozidlo v)
	{
		vozidla.put(id, v);
	}
	
	public static void addVodic(int id, Vodic v)
	{
		vodici.put(id, v);
	}
	
	public static void addDispecer(Dispecer d)
	{
		dispeceri.add(d);
	}
	
	public static void addLinka(int cisloLinky, Linka l)
	{
		linky.put(cisloLinky, l);
	}
}
