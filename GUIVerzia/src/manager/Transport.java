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
			"Cintor�n Sl�vi�ie �dolie", "Telev�zia","Zoo","Lafranconi","Kr�ovsk� �dolie","Chatam S�fer","Zochova","Koll�rovo n�m.",
			"Blument�l","Ra�ianske m�to","Trnavsk� m�to","Zimn� �tadi�n","Bajkalsk�","Sabinovsk�","Trnavsk�","Martinsk� cintor�n",
			"Clementisova","Ivansk� cesta","S�hvezdn�", "Hlavn� stanica","N�m. Franza Liszta","�rad vl�dy SR","STU","Vysok�, Tchibo Outlet",
			"Po�tov�, Martinus","N�mestie SNP","SND","N�m. �. �t�ra", "Kuklovsk�","Z� Majern�kova","Matejkova","Tom�nkova","Hany Meli�kovej",
			"Pri podchode","Janotova","Molecova","Botanick� z�hrada","Pri Hab�nskom mlyne","Pri Suchom mlyne","Nemocnica Kram�re","Magursk�",
			"B�rdo�ova","Sokolsk�","Komis�rky","P�chovsk�","Z�humenice, Drevona","Cintor�n Ra�a","Hybe�ova","He�kova","�ernock�ho","Pekn� cesta",
			"Mal� Kras�any","Vozov�a Kras�any","�ST Vinohrady","N�m. Biely kr�","Mlad� garda","Riazansk�","Pionierska","Urs�nyho","Americk� n�m.",
			"Mari�nska","Kamenn� n�m.","�af�rikovo n�m.","Sad J. Kr�a, Divadlo Ar�na","Farsk�ho","Jungmannova", "�ST �elezn� studienka","Patr�nka",
			"H�ro�ova","Vala�sk�","Lovinsk�ho","Vozov�a Hrobo�ova","Horsk� park","B�dkova","�erven� kr�", "Jan�ova","Radvansk�","Inoveck�","Hrad",
			"Z�mock�","Partiz�nska","Kozia","Hod�ovo n�m.","Karad�i�ova","Kva�alova","Salezi�ni", "Z�humenica, Drevona"
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
