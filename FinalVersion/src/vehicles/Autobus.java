package vehicles;

public class Autobus extends Vozidlo
{
	protected boolean prebehlaKontrolaPaliva = false;
	
	public Autobus(int id)
	{
		super(id);
	}

	public void kontrolaPaliva()
	{
		this.prebehlaKontrolaPaliva = true;
	}
	
	@Override
	public void skontrolujPohanac()
	{
		kontrolaPaliva();
	}
}
