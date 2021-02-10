package ui;

import connections.*;
import controllers.Priestupok;
import controllers.Transport;
import people.*;
import vehicles.Vozidlo;

public final class Vypis
{
	public static void privitanie()
	{
		System.out.println("*** Vitaj v nasom dopravnom podniku! ***");
		return;
	}
	
	public static void sprava(String text)
	{
		System.out.println(text);
		return;
	}
	
	public static void prihlasenie(boolean status)
	{
		System.out.println(status ? "* Uspesne si sa prihlasil!" : "* Prihlasenie sa nepodarilo!");
		return;
	}
	
	public static void vozidla()
	{
		for(Vozidlo v: Transport.getVozidla().values())
		{
			if(v.getLinka() == null)
				System.out.println(v.getClass().getSimpleName() +" #" + v.getId() + " -- vo vozovni");
			else
				System.out.println(v.getClass().getSimpleName() +" #" + v.getId() + " -- v premavke, vodic #"+v.getVodic().getId());
		}
	}
	
	public static void vodici()
	{
		for(Vodic v: Transport.getVodici().values())
		{
				System.out.println("#" + v.getId() + " " + v.getMeno()+ ", " + v.getTyp());
		}
	}

	public static void infoZamestnanec(Zamestnanec prihlaseny)
	{
		if(prihlaseny == null)
		{
			System.out.println("* Info: si ako neprihlaseny");
			return;
		}
		System.out.println("* Som prihlaseny ako:");
		System.out.print("#" +prihlaseny.getId() + " - " + prihlaseny.getMeno() + ", " + prihlaseny.getVek() + "r., " + prihlaseny.getTyp());
		if(prihlaseny instanceof Vodic && ((Vodic)prihlaseny).getVozidlo() != null)
			System.out.print(" #"+((Vodic)prihlaseny).getVozidlo().getId());
		
		System.out.println();
	}
	
	public static void infoVodica(int idVodica)
	{
		Vodic vodic = Transport.getVodici().get(idVodica);
		if(vodic == null)
			return;
		
		System.out.println("* Vyziadane informacie o vodicovi:");
		System.out.print("#" +vodic.getId() + " " + vodic.getMeno() + ", " + vodic.getVek() + "r., " + vodic.getTyp());
		if(vodic.getLinka() != null && vodic.getVozidlo() != null)
			System.out.print(" #"+ vodic.getVozidlo().getId() + " na linke " + vodic.getLinka().getCislo());
		System.out.println();
	}

	public static void linky()
	{
		System.out.println("* Zoznam liniek:");
		for(Linka l: Transport.getLinky().values())
		{
				System.out.print(l.getCislo() + "'");
				for(Zastavka z: l.getZastavky())
						System.out.print(" - " + z.getMeno());
				System.out.println();
		}
	}
	
	public static void priestupkyVodicov()
	{
		System.out.println("* Vykonane priestupky ktore mozno pokutovat:");
		for(Priestupok p: Transport.getPriestupky().values())
		{
			System.out.println((p.getTypPriestupku() == 1) ? "Vysoka rychlost" : "Meskanie" + " - vodic #"+p.getVodic().getId());
		}
		System.out.println("Napis: pokuta ID_VODICA pre udelenie pokuty danemu vodicovi");
	}
	
	
	public static void presunutieDispecerom(int idVodic, int idVozidlo, int cisloLinky) {
		System.out.println("Presunul si vodica #"+idVodic+" do vozidla #"+idVozidlo+" a pripojil do linky "+cisloLinky+"'");
	}
	
	public static void zoznamPrikazov()
	{
		System.out.println("Zoznam prikazov:");
		System.out.println();
		System.out.println("----- Pre vsetkych -----");
		System.out.println(" ktosom - zobrazi sa informacia o prihlaseni a zakladne atributy prihlaseneho cloveka");
		System.out.println();
		System.out.println("----- Pre neprihlaseneho uzivatela -----");
		System.out.println(" prihlas KOD_ZAMESTNANCA - prihlasis sa ako zamestnanec (pouzi kod ktory bol vypisany hore ked zamestnanec nastupil do podniku)");
		System.out.println();
		System.out.println("----- Pre vodicov -----");
		System.out.println(" posun - vozidlo prejde o jednu zastavku");
		System.out.println(" prejdi - vozidlo prejde vsetky zastavky od pociatocnej po koncovu, a zobrazi sa ako dlho trva prestavka");
		System.out.println(" cestujuci - *na tomto prikaze sa pracuje*");
		System.out.println();
		System.out.println("----- Pre dispecerov -----");
		System.out.println(" presun ID_VODICA ID_VOZIDLA LINKA - vodic ktory je vo vozidle sa presunie do vozidla ktore je vo vozovni a je prideleny na linku, jeho stare vozidlo pojde do vozovne, ak nie je vo vozidle tak sa mu len vozidlo z vozovne priradi aj s linkou");
		System.out.println(" vozidla - vypise vozidla + vozidla z vozovne");
		System.out.println(" linky - zobrazi vsetky dostupne linky");
		System.out.println(" vodici - zobrazi zoznam vsetkych vodicov");
		System.out.println(" info ID_VODICA - zobrazi podrobnejsie informacie o vodicovi");
		System.out.println(" skratPrestavky - vsetkym vodicom sa skratia prestavky na nastaveny cas podla typu vodica");
		System.out.println();
		System.out.println("----- Pre kontrolnych dispecerov -----");
		System.out.println(" priestupky - vypise zoznam priestupkov vodicov ktore je mozne pokutovat");
		System.out.println(" pokuta ID_VODICA - pokutujes vodica ktory spachal dany priestupok zo zoznamu");
	}

	public static void prestavkaVodic(Vodic vodic) {
		System.out.println("* Mam prestavku na "+vodic.getDobaPrestavky()+" minut");
	}

	public static void spatnyVstup() {
		System.out.println("Zadal si neplatny vstup");
	}

	public static void udelenaPokuta(int idVodic) {
		Vodic vodic = Transport.getVodici().get(idVodic);
		Priestupok priestupok = Transport.getPriestupky().get(idVodic);
		
		System.out.println("* Vodic #"+vodic.getId()+" bol pokutovany za " + ((priestupok.getTypPriestupku() == 0) ? ("meskanie vo vyske "+vodic.getPokutaMeskanie()) : ("rychlost vo vyske "+vodic.getPokutRychlost())));
		
	}

	public static void pokutaVodicovi(int typ)
	{
			System.out.println("* "+ ( (typ == 0) ? "Meskal si" : "Siel si velkou rychlostou") + ", tvoj priestupok bol zaznamenany a budes za neho pokutovany!");
	}

	public static void vyplatenaJazda(double platZaJazdu, double celkovyZarobok) {
		System.out.println("* Bola ti vyplatena hodnota "+ platZaJazdu +", tvoj celkovy zarobok je " + celkovyZarobok);
	}

}