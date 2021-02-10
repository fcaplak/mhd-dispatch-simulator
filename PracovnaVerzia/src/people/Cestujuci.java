package people;

import controllers.Transport;

public class Cestujuci extends Clovek
{
	public Cestujuci()
	{
		super();
		Transport.addCestujuci(this);
	}

}
