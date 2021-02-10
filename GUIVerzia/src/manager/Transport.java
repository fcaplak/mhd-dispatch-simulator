package manager;

import java.util.ArrayList;
import java.util.HashMap;

import connections.*;
import people.*;
import vehicles.Vozidlo;

public final class Transport
{
	/* Polia/HashMapy pre udrziavanie dat postav */
	private static ArrayList<Cestujuci> cestujuci = new ArrayList<Cestujuci>();
	private static ArrayList<Dispecer> dispeceri = new ArrayList<Dispecer>();
	private static HashMap<Integer, Vodic> vodici = new HashMap<Integer, Vodic>(); // key = id vodica, hodnota = objekt vodica
	
	private static HashMap<Integer, Priestupok> priestupky = new HashMap<Integer, Priestupok>(); // mapa aktivnych priestupkov, ktore neboli pokutovane

	/* HashMapy pre triedy pripojeni */
	private static HashMap<Integer, Linka> linky = new HashMap<Integer, Linka>(); // key = cislo linky, hodnota = objekt linky
	private static HashMap<String, Zastavka> zastavky = new HashMap<String, Zastavka>(); // key = meno zastavky, hodnota = objekt zastavka
	private static HashMap<Integer, Vozidlo> vozidla = new HashMap<Integer, Vozidlo>(); // key = id vozidla, hodnota = objekt vozidlo

	/* Polia retazcov pre mena */
	private static String[] mena =
	{
			"Keshawn","Konnor","Darwin","Antonio","Julian","Braedon","Colton","Skyler","Jamar","Immanuel","Daniel","Zachariah",
			"Ernest","Nasir","Stanley","Ahmed","Kyson","Nehemiah","Myles","River","Howard","Camron","Justus","Trevor","Joshua",
			"Rolando","Quinn","Dawson","Keagan","Jensen","Emilio","Yandel","Quintin","Memphis","Chace","Sincere","Cullen","Deon",
			"Noel","Peyton","Muhammad","Beckham","Shaun","John","Jakobe","Vaughn","Gunnar","Walker","Kamron", "Makhi"
	};
	
	/* Polia retazcov pre priezviska */
	private static String[] priezviska =
	{
			"Griffin", "Chaney","Nelson","Mckinney","Avila","Tapia","Proctor","Watkins","Villegas","Larson","Ford","Lutz","Merritt",
			"Orr","Mata","Craig","Stanley","Esparza","Morrow","Hanna","Leon","Hutchinson","Rosario","Henson","Hess","Ward","Mitchell",
			"Waller","Cross","Johnston","Blackburn","Gonzalez","Patrick","Brennan","Norris","George","Rich","Keller","Bonilla","Cooley",
			"Santana","Sanchez","Mcdowell","Mcgee","Cochran","Jacobs","Powell","Dennis","Baker", "Dudley"
	};
	
	/* Polia retazcov pre zastavky */
	private static String[] nazvyZastavok =
	{		
			"Cintorín Slávièie údolie", "Televízia","Zoo","Lafranconi","Krá¾ovské údolie","Chatam Sófer","Zochova","Kollárovo nám.",
			"Blumentál","Raèianske mýto","Trnavské mýto","Zimný štadión","Bajkalská","Sabinovská","Trnavská","Martinský cintorín",
			"Clementisova","Ivanská cesta","Súhvezdná", "Hlavná stanica","Nám. Franza Liszta","Úrad vlády SR","STU","Vysoká, Tchibo Outlet",
			"Poštová, Martinus","Námestie SNP","SND","Nám. ¼. Štúra", "Kuklovská","ZŠ Majerníkova","Matejkova","Tománkova","Hany Melièkovej",
			"Pri podchode","Janotova","Molecova","Botanická záhrada","Pri Habánskom mlyne","Pri Suchom mlyne","Nemocnica Kramáre","Magurská",
			"Bárdošova","Sokolská","Komisárky","Púchovská","Záhumenice, Drevona","Cintorín Raèa","Hybešova","Heèkova","Èernockého","Pekná cesta",
			"Malé Krasòany","Vozovòa Krasòany","ŽST Vinohrady","Nám. Biely kríž","Mladá garda","Riazanská","Pionierska","Ursínyho","Americké nám.",
			"Mariánska","Kamenné nám.","Šafárikovo nám.","Sad J. Krá¾a, Divadlo Aréna","Farského","Jungmannova", "ŽST Železná studienka","Patrónka",
			"Hýrošova","Valašská","Lovinského","Vozovòa Hroboòova","Horský park","Búdkova","Èervený kríž", "Janèova","Radvanská","Inovecká","Hrad",
			"Zámocká","Partizánska","Kozia","Hodžovo nám.","Karadžièova","Kvaèalova","Saleziáni", "Záhumenica, Drevona"
	};
	
	// Vytvoria sa instancie zastavok ktore budu mat mena podla pola retazcov
	public static void vytvorZastavky()
	{
		for(int i = 0; i < nazvyZastavok.length; i++)
		{
			new Zastavka(Transport.nazvyZastavok[i]);
		}
	}
	
	public static String[] getMena()
	{
		return mena;
	}
	
	public static String[] getPriezviska()
	{
		return priezviska;
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
	
	public static ArrayList<Cestujuci> getCestujuci() {
		return cestujuci;
	}
	
	public static HashMap<String, Zastavka> getZastavky() {
		return zastavky;
	}
	
	public static HashMap<Integer, Priestupok> getPriestupky() {
		return priestupky;
	}
	
	public static void addCestujuci(Cestujuci c) {
		cestujuci.add(c);
	}
	
	public static void addVozidlo(int id, Vozidlo v) {
		vozidla.put(id, v);
	}
	
	public static void addVodic(int id, Vodic v) {
		vodici.put(id, v);
	}
	
	public static void addDispecer(Dispecer d) {
		dispeceri.add(d);
	}
	
	public static void addLinka(int cisloLinky, Linka l) {
		linky.put(cisloLinky, l);
	}
	
	public static void addZastavka(String menoZastavky, Zastavka z) {
		zastavky.put(menoZastavky, z);
	}
	
	public static void addPriestupok(Vodic vodic, int typPriestupku) {
		priestupky.put(vodic.getId(), new Priestupok(vodic, typPriestupku));
	}
	
	public static void removePriestupok(int idVodica)
	{
		priestupky.remove(idVodica); // odstranime vyskyt priestupku po pokutovani
	}
}
