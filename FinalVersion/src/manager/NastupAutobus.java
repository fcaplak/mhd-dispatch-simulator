package manager;

import people.Cestujuci;

public class NastupAutobus implements Strategy
{
	@Override
	public String nastupDoVozidla(Cestujuci cestujuci) {
		cestujuci.setDruhVozidla("autobus");
		
		return "autobus";
	}
}
