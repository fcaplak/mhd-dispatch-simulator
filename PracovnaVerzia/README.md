# Dispečing MHD

### Objektovo-orientované programovanie LS 2020

Autor: [Filip Čaplák](https://github.com/fcaplak)

## Zmeny oproti verzii, ktorú som prezentoval (aktuálne) :

- Polymorfizmus (metóda *skratPrestavky*), ktorú som nevolal z nadtriedy *Zamestnanec* ale z triedy *Vodic*, ktorá ju používala som upravil tak, že metóda *skratPrestavky* sa nachádza bez tela (je abstraktná) v triede *Zamestnanec*, ktorú som zmenil na abstraktnú) a v podtriedach *Vodic*, *SkusobnyVodic*, *ProfesionalnyVodic* je prekonaná a pri volaní v cykle, kde je vodič pretypovaný na nadtriedu *Zamestnanec* sa vykoná prekonaná metóda daného typu vodiča. U dispečera tiež musí byť prekonaná, ale v našom programe nerátame s implmentáciou prestávok pre dispečerov, takže sa nachádza len s prázdnym telom.

```java
public void skratPrestavky()
{
	for(Zamestnanec v: Transport.getVodici().values())
	{
		Vypis.sprava("#"+v.getId()+" prestavka pred skratenim "+v.getDobaPrestavky()+"m");
		((Zamestnanec)v).skratPrestavku(); // POLYMOFIZMUS - tato metoda je prekonana v podtriedach, kazda meni prestavku o iny cas (podla typu vodica)
		Vypis.sprava("#"+v.getId()+" prestavka po skrateni "+v.getDobaPrestavky()+"m");
	}
}
```

- Pridané ohodnotenie vodiča na konci každej prejdenej trasy. Výplatu za každú jazdu majú typy vodičov rôznu ktorá je uložená v atribúde *platZaJazdu*.

- Implementovaná trieda *KontrolnyDispecer*, príkazy sú dostupné dole (kontrolní dispečeri slúžia na kontrolu vodičov, udeľovanie pokút...)

- Pridaná trieda *Priestupky*, ktorej objekty si držia v sebe informáciu každého vykonaného priestupku u vodiča, nachádzajú sa v HashMape v triede *Transport*.

## Odpovede (pred prezentáciou):
*Je program  funkčný a pokrýva principiálne časti zadania a zámeru projektu?*

Hlavná logika dispečerov, vodičov, liniek a zastávok ja hotová.
Vodiči zatiaľ ešte nerobia priestupky (meškanie) a nie sú ešte hotoví kontrolní dispečeri, ktorí ich môžu pokutovať.
Taktiež v tejto verzii ešte nie sú cestujúci.


*Máte vybudovanú hierarchiu tried s agregáciou a uplatnením polymorfizmu?*

Človek je najvyyšie v hierarchii, jeho podtriedy sú - Cestujuci, Zamestnanec..
Zamestnancove podtriedy sú ďalej - Vodic, Dispecer...
Agregácia - Vodiči má atribút vozidlo, linku, zase Vozidlo má atribút vodic...

Uplatnenie polymorfizmu nastáva pri príkaze dispečera 'skratPrestavky', kde celé pole vodičov sa prebehne a vykoná sa im metóda na skrátenie prestávok podľa typu vodiča

*Je oddelená  aplikačná logika od používateľského rozhrania ?*

V programe je zvlášť balík s názvom 'ui', v ktorom sú triedy CitajVstup a Vypis, ktoré sa stará výhradne o používateľský vstup z konzole a výstup na základe pokynov od programu.
Zvyšok tried mimo balíka 'ui' sa zaoberajú programovou logikou.

*Čo som este použil:*

V programe sa mi vyskytuje downcast, aby som mohol použiť metódu podtriedy.
Chyby vo vstupe pri príkazoch som chytal pomocou try catch pretože by bolo neefektívne ifovať príkaz kde su 3 argumenty

## Aktuálne dostupné linky:

- Autobusy: 32, 39
 - Trolejbusy: 207
 - Električky: 1, 3

## Zoznam príkazov:

##### Pre vsetkych:
- ktosom - v pripade prihlaseneho pouzivatela sa zobrazi jeho id, meno, vek, typ zamestnania,ak nie je prihlaseny, zobrazi sa len informacia o stave prihlasenia)

#####  Neprihlaseny:
- prihlas KOD_ZAMESTNANCA - na prihlasenie ako zamestnanec

#### Ako zamestnanec:

#####  Vodic:
- posun - vozidlo prejde o jednu zastavku
- prejdi - vozidlo prejde vsetky zastavky od pociatocnej po koncovu, a zobrazi sa ako dlho trva prestavka

#####  Dispecer:
- presun *ID_VODICA* *ID_VOZIDLA* *LINKA* - vodic ktory je vo vozidle sa presunie do vozidla ktore je vo vozovni a je prideleny na linku, jeho stare vozidlo pojde do vozovne, ak nie je vo vozidle tak sa mu len vozidlo z vozovne priradi aj s linkou
- vozidla - vypise vozidla + vozidla z vozovne
- linky - zobrazi vsetky dostupne linky
- vodici - zobrazi zoznam vsetkych vodicov (id, meno, typ vodica, linka, idVozidla)
- info *ID_VODICA* - zobrazi informacie o vodicovi (id, meno, vek, posledna zastavka, aky je to typ vodica - skusobny..)
- skratPrestavky - vsetkym vodicom sa skratia prestavky o ich hodnotu (POLYMORFIZMUS), mozme to chapat ako mimoriadnu situaciu na ceste, kde je potrebne zabezpecit aby bola MHD doprava hustejsia

##### Kontrolny Dispecer:
*ma k dispozicii vsetky prikazy ako Dispecer, navyse:*
- priestupky - vypise zoznam priestupkov vodicov ktore je mozne pokutovat
- pokuta *ID_VODICA* - pokutujes vodica ktory spachal dany priestupok zo zoznamu

## Postup testovania:

- Po spustení programu sa do podniku zamestnajú vodiči a jeden dispečer.
- Môžme si pozrieť príkazy napísaním *prikazy*
- Môžme sa prihlásiť. Všimneme si na úvodných správach kódy k prihláseniu ako zamestnanec.
- Napíšeme: *prihlas KOD_ZAMESTNANCA* (doporučujem prihlásiť sa najprv ako dispečer, pretože ten má najväčšie právomoci v našom programe), takže vyberáme kód posledného zamestnanca.
- Vypíše sa nám správa o prihlásení.
- Môžme si vypísať atribúty zamestnanca pod ktorým sme prihlásený príkazom *ktosom*
- Skúsime si vypísať vozidlá, vodičov a linky (príkazy *vodici* *vozidla* *linky*)
- Priradíme vodičovi vozidlo a napojíme ho do linky. Pozrieme sa na predošlom výpise na autobusára, autobus a linku 31,39 - ktoré sú momentálne autobusové. Pozeráme sa na ID.
- Zadáme príkaz: *presun* *ID_VODICA* *ID_VOZIDLA* *LINKA* a vypíše sa nám, že sme vodičovi priradili vozidlo a napojili ho do linky.
- Teraz po napísaní *vozidla*, *vodiči* si všimene, že zobrazujú informáciu naviac ku ktorej linke patria.
- Môžme skúsiť polymorfizmus: napíšeme príkaz *skratPrestavky* a testovací výstup vypíše u každého vodiča ako dlho mu trvala prestávka pred a po zavolaní príkazu.
- Keď už je vodič priradený k vozidlu a linke, odhlásime sa príkazom *odhlas*
- Teraz sa prihlásime k nášmu vodičovi ktorému sme priradili vozidlo (print úvodných správ kde sú kódy je v rovnakom poradí ako print po zadaní vodici, takže podľa toho zistíme aký kód má ktorý zamestnanec)
- Príkazom posun si všimneme, že sa vodič posunul o jednu zastávku.
- Príkazom prejdi vodič prejde celý zvyšok svojej trasy.
- Znovu ak dáme posun, vypíše sa koľko trvala vodičovi prestávka a že sa s vozidlom obrátil do druhého smeru.
- Ďalšie volania posun/prejdi sú analogické (len do obráteného smeru)