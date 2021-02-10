package people;

public class SkusobnyVodic extends Vodic
{
	public SkusobnyVodic(int id, int typVozidla)
	{
		super(id, typVozidla);
		this.maximalneMeskanie = 5; // skusobny vodic bude moct meskat az 5 minut
		this.dobaPrestavky = 20; // skusobny vodic ma az 20 minutovu prestavku
		this.platZaJazdu = 6.0;
		
		this.odratajZaMeskanie = 35;
		this.odratajZaRychlost = 70;
		
		this.sancaNaPriestupok = 25;
	}
	
	public void skratPrestavku()
	{
		this.dobaPrestavky = 10; // skusobnemu vodicovi sa skrati prestavka na 10 minut
	}
}
