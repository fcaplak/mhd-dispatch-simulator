package people;

import manager.Transport;

public class Cestujuci extends Clovek
{
	public Cestujuci()
	{
		super();
		Transport.addCestujuci(this);
	}

}
