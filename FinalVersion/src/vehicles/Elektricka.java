package vehicles;

public class Elektricka extends Vozidlo
{
	protected boolean prebehlaKontrolaPantografu = false;
	
	
	public Elektricka(int id)
	{
		super(id);
	}

	public void kontrolaPantografu()
	{
		this.prebehlaKontrolaPantografu = true;
	}
	
	@Override
	public void skontrolujPohanac()
	{
		kontrolaPantografu();
	}
}
