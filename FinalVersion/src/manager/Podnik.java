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
		l39.addZastavka(Transport.getZastavky().get("Cintorín Slávièie údolie"));
		l39.addZastavka(Transport.getZastavky().get("Televízia"));
		l39.addZastavka(Transport.getZastavky().get("Zoo"));
		l39.addZastavka(Transport.getZastavky().get("Lafranconi"));
		l39.addZastavka(Transport.getZastavky().get("Krá¾ovské údolie"));
		l39.addZastavka(Transport.getZastavky().get("Chatam Sófer"));
		l39.addZastavka(Transport.getZastavky().get("Zochova"));
		l39.addZastavka(Transport.getZastavky().get("Kollárovo nám."));
		l39.addZastavka(Transport.getZastavky().get("Blumentál"));
		l39.addZastavka(Transport.getZastavky().get("Raèianske mýto"));
		l39.addZastavka(Transport.getZastavky().get("Trnavské mýto"));
		l39.addZastavka(Transport.getZastavky().get("Zimný štadión"));
		l39.addZastavka(Transport.getZastavky().get("Bajkalská"));
		l39.addZastavka(Transport.getZastavky().get("Sabinovská"));
		l39.addZastavka(Transport.getZastavky().get("Trnavská"));
		l39.addZastavka(Transport.getZastavky().get("Martinský cintorín"));
		l39.addZastavka(Transport.getZastavky().get("Clementisova"));
		l39.addZastavka(Transport.getZastavky().get("Ivanská cesta"));
		l39.addZastavka(Transport.getZastavky().get("Súhvezdná"));
		
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
		l32.addZastavka(Transport.getZastavky().get("Kuklovská"));
		l32.addZastavka(Transport.getZastavky().get("ZŠ Majerníkova"));
		l32.addZastavka(Transport.getZastavky().get("Matejkova"));
		l32.addZastavka(Transport.getZastavky().get("Tománkova"));
		l32.addZastavka(Transport.getZastavky().get("Hany Melièkovej"));
		l32.addZastavka(Transport.getZastavky().get("Pri podchode"));
		l32.addZastavka(Transport.getZastavky().get("Janotova"));
		l32.addZastavka(Transport.getZastavky().get("Molecova"));
		l32.addZastavka(Transport.getZastavky().get("Botanická záhrada"));
		l32.addZastavka(Transport.getZastavky().get("Zoo"));
		l32.addZastavka(Transport.getZastavky().get("Pri Habánskom mlyne"));
		l32.addZastavka(Transport.getZastavky().get("Pri Suchom mlyne"));
		l32.addZastavka(Transport.getZastavky().get("Nemocnica Kramáre"));
		l32.addZastavka(Transport.getZastavky().get("Magurská"));
		l32.addZastavka(Transport.getZastavky().get("Bárdošova"));
		l32.addZastavka(Transport.getZastavky().get("Sokolská"));
		l32.addZastavka(Transport.getZastavky().get("Hlavná stanica"));
		
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
		l207.addZastavka(Transport.getZastavky().get("ŽST Železná studienka"));
		l207.addZastavka(Transport.getZastavky().get("Patrónka"));
		l207.addZastavka(Transport.getZastavky().get("Hýrošova"));
		l207.addZastavka(Transport.getZastavky().get("Valašská"));
		l207.addZastavka(Transport.getZastavky().get("Lovinského"));
		l207.addZastavka(Transport.getZastavky().get("Vozovòa Hroboòova"));
		l207.addZastavka(Transport.getZastavky().get("Horský park"));
		l207.addZastavka(Transport.getZastavky().get("Búdkova"));
		l207.addZastavka(Transport.getZastavky().get("Èervený kríž"));
		l207.addZastavka(Transport.getZastavky().get("Janèova"));
		l207.addZastavka(Transport.getZastavky().get("Radvanská"));
		l207.addZastavka(Transport.getZastavky().get("Inovecká"));
		l207.addZastavka(Transport.getZastavky().get("Hrad"));
		l207.addZastavka(Transport.getZastavky().get("Zámocká"));
		l207.addZastavka(Transport.getZastavky().get("Partizánska"));
		l207.addZastavka(Transport.getZastavky().get("Kozia"));
		l207.addZastavka(Transport.getZastavky().get("Hodžovo nám."));
		l207.addZastavka(Transport.getZastavky().get("Kollárovo nám."));
		l207.addZastavka(Transport.getZastavky().get("Americké nám."));
		l207.addZastavka(Transport.getZastavky().get("Karadžièova"));
		l207.addZastavka(Transport.getZastavky().get("Kvaèalova"));
		l207.addZastavka(Transport.getZastavky().get("Saleziáni"));
		l207.addZastavka(Transport.getZastavky().get("Zimný štadión"));
		
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
		l1.addZastavka(Transport.getZastavky().get("Hlavná stanica"));
		l1.addZastavka(Transport.getZastavky().get("Nám. Franza Liszta"));
		l1.addZastavka(Transport.getZastavky().get("Úrad vlády SR"));
		l1.addZastavka(Transport.getZastavky().get("STU"));
		l1.addZastavka(Transport.getZastavky().get("Vysoká, Tchibo Outlet"));
		l1.addZastavka(Transport.getZastavky().get("Poštová, Martinus"));
		l1.addZastavka(Transport.getZastavky().get("Námestie SNP"));
		l1.addZastavka(Transport.getZastavky().get("SND"));
		l1.addZastavka(Transport.getZastavky().get("Nám. ¼. Štúra"));
		
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
		l3.addZastavka(Transport.getZastavky().get("Komisárky"));
		l3.addZastavka(Transport.getZastavky().get("Púchovská"));
		l3.addZastavka(Transport.getZastavky().get("Záhumenica, Drevona"));
		l3.addZastavka(Transport.getZastavky().get("Cintorín Raèa"));
		l3.addZastavka(Transport.getZastavky().get("Hybešova"));
		l3.addZastavka(Transport.getZastavky().get("Heèkova"));
		l3.addZastavka(Transport.getZastavky().get("Èernockého"));
		l3.addZastavka(Transport.getZastavky().get("Pekná cesta"));
		l3.addZastavka(Transport.getZastavky().get("Malé Krasòany"));
		l3.addZastavka(Transport.getZastavky().get("Vozovòa Krasòany"));
		l3.addZastavka(Transport.getZastavky().get("ŽST Vinohrady"));
		l3.addZastavka(Transport.getZastavky().get("Nám. Biely kríž"));
		l3.addZastavka(Transport.getZastavky().get("Mladá garda"));
		l3.addZastavka(Transport.getZastavky().get("Riazanská"));
		l3.addZastavka(Transport.getZastavky().get("Pionierska"));
		l3.addZastavka(Transport.getZastavky().get("Ursínyho"));
		l3.addZastavka(Transport.getZastavky().get("Raèianske mýto"));
		l3.addZastavka(Transport.getZastavky().get("Blumentál"));
		l3.addZastavka(Transport.getZastavky().get("Americké nám."));
		l3.addZastavka(Transport.getZastavky().get("Mariánska"));
		l3.addZastavka(Transport.getZastavky().get("Kamenné nám."));
		l3.addZastavka(Transport.getZastavky().get("Šafárikovo nám."));
		l3.addZastavka(Transport.getZastavky().get("Sad J. Krá¾a, Divadlo Aréna"));
		l3.addZastavka(Transport.getZastavky().get("Farského"));
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
