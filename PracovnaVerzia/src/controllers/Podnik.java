package controllers;

import connections.Linka;
import people.*;
import vehicles.*;

public final class Podnik
{
	public static void zamestnajVodicov() {
		// Zamestname vodicov (id, 0/1/2 - typ autobusar, trolejbusar, elektrickar)
		new SkusobnyVodic(1100, 0);
		new Vodic(1111, 2);
		new ProfesionalnyVodic(1150, 1);
		new SkusobnyVodic(1160, 1);
		new Vodic(1170, 1);
	}

	public static void zamestnajDispecerov() {
		// vytvorime jedneho dispecera s ID 2002, cez ktoreho budeme skusat prikazy
		new Dispecer(2002); 
		
		// vytvorime jedneho kontrolnehoDispecera s ID 5001, cez ktoreho budeme testovat system pokutovania
		new KontrolnyDispecer(5001);
	}

	public static void pripravVozidla() {
		// Vytvorime instancie vozidiel, ktore sa rovno zapisu do ArrayListu vozidla (maju to v konstruktore)
		new Autobus(1337);
		new Trolejbus(1338);
		new Elektricka(1339);
	}
	
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
	}

}
