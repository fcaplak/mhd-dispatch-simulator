package manager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import connections.Linka;
import people.*;
import vehicles.*;

public final class Podnik
{
	/**
	 * Vytvori instancie vodicov a prida ich do pola kam patria Vodici
	 * @param pocetSkus
	 * @param pocetObyc
	 * @param pocetProf
	 */
	public static void zamestnajVodicov(int pocetSkus, int pocetObyc, int pocetProf) {
		
		for(int i = 0; i < pocetSkus; i++)
			new SkusobnyVodic(RandomUtil.getRandomInterval(1001, 9999));
		
		for(int i = 0; i < pocetObyc; i++)
			new Vodic(RandomUtil.getRandomInterval(1001, 9999));

		for(int i = 0; i < pocetProf; i++)
			new ProfesionalnyVodic(RandomUtil.getRandomInterval(1001, 9999));

	}

	/**
	 * Vytvori instancie dispecerov a kontrolnych dispecerov prida ich do pola
	 * @param pocetDis
	 * @param pocetKonDis
	 */
	public static void zamestnajDispecerov(int pocetDis, int pocetKonDis) {
		
		for(int i = 0; i < pocetDis; i++)
			new Dispecer(RandomUtil.getRandomInterval(1001, 9999)); 
		
		for(int i = 0; i < pocetKonDis; i++)
			new KontrolnyDispecer(RandomUtil.getRandomInterval(1001, 9999));
	}

	/**
	 * Vytvori instancie o pocte vozidiel o ake sme si ziadali (autobusy, trolejbusy, elektricky)
	 * @param pocetAutob
	 * @param pocetTrolej
	 * @param pocetElek
	 */
	public static void pripravVozidla(int pocetAutob, int pocetTrolej, int pocetElek) {

		for(int i = 0; i < pocetAutob; i++)
			new Autobus(RandomUtil.getRandomInterval(1001, 9999));
		
		for(int i = 0; i < pocetTrolej; i++)
			new Trolejbus(RandomUtil.getRandomInterval(1001, 9999));

		for(int i = 0; i < pocetElek; i++)
			new Elektricka(RandomUtil.getRandomInterval(1001, 9999));
	}
	
	/**
	 * Staticky vytvori linky a naplni ich zastavkami ktore k nim koresponduju
	 */
	public static void vytvorLinky() {
		
		/* ------------ Autobusova linka 39' -------------*/
	      
		Linka l39 = new Linka(39, 0); // vytvorime linku s cislom 39 pre autobusy
		
		
		// uz dalej pristupujeme do pola 
		l39.addZastavka(Transport.getZastavky().get("Cintor�n Sl�vi�ie �dolie"));
		l39.addZastavka(Transport.getZastavky().get("Telev�zia"));
		l39.addZastavka(Transport.getZastavky().get("Zoo"));
		l39.addZastavka(Transport.getZastavky().get("Lafranconi"));
		l39.addZastavka(Transport.getZastavky().get("Kr�ovsk� �dolie"));
		l39.addZastavka(Transport.getZastavky().get("Chatam S�fer"));
		l39.addZastavka(Transport.getZastavky().get("Zochova"));
		l39.addZastavka(Transport.getZastavky().get("Koll�rovo n�m."));
		l39.addZastavka(Transport.getZastavky().get("Blument�l"));
		l39.addZastavka(Transport.getZastavky().get("Ra�ianske m�to"));
		l39.addZastavka(Transport.getZastavky().get("Trnavsk� m�to"));
		l39.addZastavka(Transport.getZastavky().get("Zimn� �tadi�n"));
		l39.addZastavka(Transport.getZastavky().get("Bajkalsk�"));
		l39.addZastavka(Transport.getZastavky().get("Sabinovsk�"));
		l39.addZastavka(Transport.getZastavky().get("Trnavsk�"));
		l39.addZastavka(Transport.getZastavky().get("Martinsk� cintor�n"));
		l39.addZastavka(Transport.getZastavky().get("Clementisova"));
		l39.addZastavka(Transport.getZastavky().get("Ivansk� cesta"));
		l39.addZastavka(Transport.getZastavky().get("S�hvezdn�"));
		
		// serializujeme objekt linky 39
		try {
	         FileOutputStream fileOut = new FileOutputStream("linka39.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(l39);
	         out.close();
	         fileOut.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
		
		/* ------------ Autobusova linka 32' -------------*/
		
		Linka l32 = new Linka(32, 0);
		l32.addZastavka(Transport.getZastavky().get("Kuklovsk�"));
		l32.addZastavka(Transport.getZastavky().get("Z� Majern�kova"));
		l32.addZastavka(Transport.getZastavky().get("Matejkova"));
		l32.addZastavka(Transport.getZastavky().get("Tom�nkova"));
		l32.addZastavka(Transport.getZastavky().get("Hany Meli�kovej"));
		l32.addZastavka(Transport.getZastavky().get("Pri podchode"));
		l32.addZastavka(Transport.getZastavky().get("Janotova"));
		l32.addZastavka(Transport.getZastavky().get("Molecova"));
		l32.addZastavka(Transport.getZastavky().get("Botanick� z�hrada"));
		l32.addZastavka(Transport.getZastavky().get("Zoo"));
		l32.addZastavka(Transport.getZastavky().get("Pri Hab�nskom mlyne"));
		l32.addZastavka(Transport.getZastavky().get("Pri Suchom mlyne"));
		l32.addZastavka(Transport.getZastavky().get("Nemocnica Kram�re"));
		l32.addZastavka(Transport.getZastavky().get("Magursk�"));
		l32.addZastavka(Transport.getZastavky().get("B�rdo�ova"));
		l32.addZastavka(Transport.getZastavky().get("Sokolsk�"));
		l32.addZastavka(Transport.getZastavky().get("Hlavn� stanica"));
		
		// serializujeme objekt linky 32
		try {
	         FileOutputStream fileOut = new FileOutputStream("linka32.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(l32);
	         out.close();
	         fileOut.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
		
		/* ------------ Trolejbusova linka 207' -------------*/
		
		Linka l207 = new Linka(207, 1);
		l207.addZastavka(Transport.getZastavky().get("�ST �elezn� studienka"));
		l207.addZastavka(Transport.getZastavky().get("Patr�nka"));
		l207.addZastavka(Transport.getZastavky().get("H�ro�ova"));
		l207.addZastavka(Transport.getZastavky().get("Vala�sk�"));
		l207.addZastavka(Transport.getZastavky().get("Lovinsk�ho"));
		l207.addZastavka(Transport.getZastavky().get("Vozov�a Hrobo�ova"));
		l207.addZastavka(Transport.getZastavky().get("Horsk� park"));
		l207.addZastavka(Transport.getZastavky().get("B�dkova"));
		l207.addZastavka(Transport.getZastavky().get("�erven� kr�"));
		l207.addZastavka(Transport.getZastavky().get("Jan�ova"));
		l207.addZastavka(Transport.getZastavky().get("Radvansk�"));
		l207.addZastavka(Transport.getZastavky().get("Inoveck�"));
		l207.addZastavka(Transport.getZastavky().get("Hrad"));
		l207.addZastavka(Transport.getZastavky().get("Z�mock�"));
		l207.addZastavka(Transport.getZastavky().get("Partiz�nska"));
		l207.addZastavka(Transport.getZastavky().get("Kozia"));
		l207.addZastavka(Transport.getZastavky().get("Hod�ovo n�m."));
		l207.addZastavka(Transport.getZastavky().get("Koll�rovo n�m."));
		l207.addZastavka(Transport.getZastavky().get("Americk� n�m."));
		l207.addZastavka(Transport.getZastavky().get("Karad�i�ova"));
		l207.addZastavka(Transport.getZastavky().get("Kva�alova"));
		l207.addZastavka(Transport.getZastavky().get("Salezi�ni"));
		l207.addZastavka(Transport.getZastavky().get("Zimn� �tadi�n"));
		
		// serializujeme objekt linky 207
		try {
	         FileOutputStream fileOut = new FileOutputStream("linka207.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(l207);
	         out.close();
	         fileOut.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
		
		/* ------------ Elektrickova linka 1' -------------*/
		
		Linka l1 = new Linka(1, 2);
		l1.addZastavka(Transport.getZastavky().get("Hlavn� stanica"));
		l1.addZastavka(Transport.getZastavky().get("N�m. Franza Liszta"));
		l1.addZastavka(Transport.getZastavky().get("�rad vl�dy SR"));
		l1.addZastavka(Transport.getZastavky().get("STU"));
		l1.addZastavka(Transport.getZastavky().get("Vysok�, Tchibo Outlet"));
		l1.addZastavka(Transport.getZastavky().get("Po�tov�, Martinus"));
		l1.addZastavka(Transport.getZastavky().get("N�mestie SNP"));
		l1.addZastavka(Transport.getZastavky().get("SND"));
		l1.addZastavka(Transport.getZastavky().get("N�m. �. �t�ra"));
		
		// serializujeme objekt linky 1
		try {
	         FileOutputStream fileOut = new FileOutputStream("linka1.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(l1);
	         out.close();
	         fileOut.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
		
		/* ------------ Elektrickova linka 3' -------------*/
		
		Linka l3 = new Linka(3, 2);
		l3.addZastavka(Transport.getZastavky().get("Komis�rky"));
		l3.addZastavka(Transport.getZastavky().get("P�chovsk�"));
		l3.addZastavka(Transport.getZastavky().get("Z�humenica, Drevona"));
		l3.addZastavka(Transport.getZastavky().get("Cintor�n Ra�a"));
		l3.addZastavka(Transport.getZastavky().get("Hybe�ova"));
		l3.addZastavka(Transport.getZastavky().get("He�kova"));
		l3.addZastavka(Transport.getZastavky().get("�ernock�ho"));
		l3.addZastavka(Transport.getZastavky().get("Pekn� cesta"));
		l3.addZastavka(Transport.getZastavky().get("Mal� Kras�any"));
		l3.addZastavka(Transport.getZastavky().get("Vozov�a Kras�any"));
		l3.addZastavka(Transport.getZastavky().get("�ST Vinohrady"));
		l3.addZastavka(Transport.getZastavky().get("N�m. Biely kr�"));
		l3.addZastavka(Transport.getZastavky().get("Mlad� garda"));
		l3.addZastavka(Transport.getZastavky().get("Riazansk�"));
		l3.addZastavka(Transport.getZastavky().get("Pionierska"));
		l3.addZastavka(Transport.getZastavky().get("Urs�nyho"));
		l3.addZastavka(Transport.getZastavky().get("Ra�ianske m�to"));
		l3.addZastavka(Transport.getZastavky().get("Blument�l"));
		l3.addZastavka(Transport.getZastavky().get("Americk� n�m."));
		l3.addZastavka(Transport.getZastavky().get("Mari�nska"));
		l3.addZastavka(Transport.getZastavky().get("Kamenn� n�m."));
		l3.addZastavka(Transport.getZastavky().get("�af�rikovo n�m."));
		l3.addZastavka(Transport.getZastavky().get("Sad J. Kr�a, Divadlo Ar�na"));
		l3.addZastavka(Transport.getZastavky().get("Farsk�ho"));
		l3.addZastavka(Transport.getZastavky().get("Jungmannova"));
		
		// serializujeme objekt linky 3
		try {
	         FileOutputStream fileOut = new FileOutputStream("linka3.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(l3);
	         out.close();
	         fileOut.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
	}
	
	public final static class Autentifikator
	{
		private static HashMap<Integer, Zamestnanec> kody = new HashMap<Integer, Zamestnanec>();
		
		/**
		 * Prida kod ktory patri k zamestnancovi do hasovacej mapy kody
		 * @param kod
		 * @param zamestnanec
		 */
		public static void pridajKod(int kod, Zamestnanec zamestnanec)
		{
			kody.put(kod, zamestnanec);
		}
		
		/**
		 * Kod ktory pride sa overi ci existuje v hasovacej mape, ak ano, kod vratime ako spravny
		 * @param kod
		 * @return
		 */
		public static Zamestnanec prihlas(int kod)
		{
			if( kody.get(kod) != null )
			{
				return kody.get(kod);
			}
			return null;
		}
	}

}
