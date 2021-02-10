# Dispečing MHD (simulátor)

### Objektovo-orientované programovanie LS 2020

Autor: [Filip Čaplák](https://github.com/fcaplak)

(správa o realizácii projektu sa nachádza vo FinalVersion priečinku ako .pdf súbor)

## Zámer projektu 

Projekt sa nazýva Dispečing MHD, a hlavným cieľom je simulovať kontrolu nad mestskou hromadnou dopravou. V programe vystupujú Zamestnanci ako Vodiči, Dispečeri a Kontrolný dispečeri, ktorí majú za úlohu pokutovať priestupky u vodičov. Program funguje tak, že do predpripravených liniek najprv dispečeri priradia vodičov s vozidlami, a potom vodiči môžu danú linku obsluhovať posuvom po zástavkách. Vodič môže byť skúšobný, obyčajný alebo profesionálny. Každý vodič má iné percento šance na vykonanie priestupku akým je meškanie zo zastávky alebo vysoká rýchlosť. Ak bol tento priestupok zaznamenaný, vodič nie je pokutovaný hneď, ale túto prácu musí spraviť kontrolný dispečer, ktorý udeľuje pokuty. Môžeme teda hrať za 3 rozdielne typy postáv v simulácii.

## Porovnanie oproti verzii, ktorú som prezentoval :

Vo verzii, ktorú som prezentoval mi chýbali viaceré kritériá. Mal som hotové len GUI a RTTI a štandardnú (nie vlastnú) výnimku. Nemal som napríklad lambda výraz, rozhranie... Oproti prezentovanej verzii a finálnej som ale všetko chýbajúce doplnil. Nižšie je zoznam kritérií, ktoré som splnil vo svojom programe.

- Lambda výrazy
- RTTI
- GUI
- Event handlery
- Vlastná výnimka
- Dve hierarchie dedenia s polymorfizmom
- Vnorená trieda
- Rozhradnie s návrhovým vzorom Strategy
- Serializácia

## Aktuálne dostupné linky:

- Autobusy: 32, 39
 - Trolejbusy: 207
 - Električky: 1, 3

## Postup testovania:

- Na prvej obrazovke si vyberieme počty zamestnancov a vozidiel.
- Následne ich vidíme v tabuľke, a prihlásime sa s kódom Dispečera.
- U dispečera priradíme nami vybranému vodičovi vozidlo a linku
- Odhlásime sa, a teraz sa prihlásime s kódom vodiča ktorému sme priradili vozidlo
- Prejdeme zastávky, zobrazí sa nám náhodne, že vodič vykonal priestupok
- Teraz sa odhlásime, prihlásime sa do Kontrolného Dispečera a vidíme tam vodičov priestupok
- Môžeme ho pokutovať
- Odhlásime sa a znovu môžeme hrať za vodiča alebo dispečera
