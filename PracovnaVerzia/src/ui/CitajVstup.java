package ui;

import java.util.Scanner;

import controllers.Autentifikator;
import people.*;

public class CitajVstup
{
	public static void init()
	{
		Zamestnanec prihlaseny = null;
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] cmd = input.split(" ");
		
		while( !cmd[0].equals("koniec"))
		{
			switch(cmd[0])
			{
				case "ktosom": // prikaz dostupny pre kazdeho
				{
					Vypis.infoZamestnanec(prihlaseny);
				} break;
				case "prikazy":
				{
					Vypis.zoznamPrikazov();
				} break;
				
				case "odhlas":
				{	
					if(prihlaseny != null)
					{
						prihlaseny = null;
						Vypis.sprava("* Odhlasil si sa.");
					}
				} break;
			}
			// -----------  Neprihlaseny -----------
			
			if(prihlaseny == null && cmd[0].equals("prihlas"))
				try { prihlaseny = Autentifikator.prihlas(Integer.parseInt(cmd[1])); } catch(Exception e) { Vypis.spatnyVstup(); }
			
			// -----------  Vodic -----------
			
			if(prihlaseny instanceof Vodic)
				switch (cmd[0])
				{
					case "posun": {
						((Vodic)prihlaseny).posun(); // downcast aby sme mohli pouzit metodu podtriedy
					} break;
					
					case "prejdi": {
						((Vodic)prihlaseny).prejdi();
					} break;
				}
			
			// ----------- KontrolnyDispecer -----------
			
			if(prihlaseny instanceof KontrolnyDispecer)
			switch (cmd[0])
			{
				// Kontrolny dispecer
				
				case "priestupky": {
					((KontrolnyDispecer)prihlaseny).priestupky();
				} break;
				case "pokuta": {
					try {  ((KontrolnyDispecer)prihlaseny).pokuta(Integer.parseInt(cmd[1])); } catch(Exception e) { Vypis.spatnyVstup(); }
				} break;
			}
			
			// ----------- Dispecer -----------
			
			if(prihlaseny instanceof Dispecer)
			switch (cmd[0])
			{
				// Dispecer
			
				case "presun": {
					try { ((Dispecer)prihlaseny).presun(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]), Integer.parseInt(cmd[3])); } catch(Exception e) { Vypis.spatnyVstup(); }
				} break;
				case "vozidla": {
					((Dispecer)prihlaseny).vozidla();
				} break;
				case "vodici": {
					((Dispecer)prihlaseny).vodici();
				} break;
				case "linky": {
					((Dispecer)prihlaseny).linky();
				} break;
				case "info": {
					try { ((Dispecer)prihlaseny).infoVodica(Integer.parseInt(cmd[1])); } catch(Exception e) { Vypis.spatnyVstup(); }
				} break;
				case "skratPrestavky": {
					((Dispecer)prihlaseny).skratPrestavky();
				} break;
			}
			
			input = sc.nextLine();
			cmd = input.split(" ");
		}
		Vypis.sprava("Koniec programu.");
		sc.close();
	}
}
