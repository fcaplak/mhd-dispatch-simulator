package manager;

import people.Cestujuci;

public class NastupElektricka implements Strategy
{
	@Override
	public String nastupDoVozidla(Cestujuci cestujuci) {
		cestujuci.setDruhVozidla("elektricka");
		
		return "elektricka";
	}
}
