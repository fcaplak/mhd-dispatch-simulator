package controllers;

import ui.*;

public class Main
{
	public static void main(String[] args)
	{
		Transport.vytvorZastavky(); // vytvori instancie s menami zastavok z pola a vlozi do hashmapy
		Vypis.privitanie();

		Vypis.sprava("\nZamestnavam vodicov:");
		Podnik.zamestnajVodicov();
		
		
		Vypis.sprava("\nZamestnavam dispecera:");
		Podnik.zamestnajDispecerov();
		
		Podnik.vytvorLinky();
		Podnik.pripravVozidla();
		
		Vypis.sprava("\n* Napis prikazy pre zobrazenie zoznamu prikazov");
		
		CitajVstup.init(); // Tato metoda spracovava pouzivatelovu konzolu a prikazmi zavola metody danej triedy
		
	}
}
