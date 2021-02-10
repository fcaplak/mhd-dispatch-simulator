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
	}

}
