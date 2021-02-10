package vehicles;

public class Trolejbus extends Vozidlo
{
	protected boolean prebehlaKontrolaZberacov = false;
	
	public Trolejbus(int id)
	{
		super(id);
	}

	public void kontrolaZberacov()
	{
		this.prebehlaKontrolaZberacov = true;
	}
	
	@Override
	public void skontrolujPohanac()
	{
		kontrolaZberacov();
	}

}
