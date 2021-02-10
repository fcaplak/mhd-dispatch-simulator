package people;

public class ProfesionalnyVodic extends Vodic
{
	public ProfesionalnyVodic(int id)
	{
		super(id);
		this.maximalneMeskanie = 0; // profesionalny vodic nebude meskat ani minutu
		this.dobaPrestavky = 5; // profesionalny vodic ma iba 5 minutovu prestavku
		this.platZaJazdu = 4.0;
		
		this.odratajZaMeskanie = 0;
		this.odratajZaRychlost = 30;
		
		this.sancaNaPriestupok = 5;
		
		this.celkovyZarobok = 1000;
	}
	
	public void skratPrestavku()
	{
		this.dobaPrestavky = 2;  // profesionalnemu vodicovi sa skrati prestavka na 2 minuty
	}
}
