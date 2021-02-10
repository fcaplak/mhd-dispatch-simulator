package manager;

import people.Cestujuci;

public class NastupTrolejbus implements Strategy
{
	@Override
	public String nastupDoVozidla(Cestujuci cestujuci) {
		cestujuci.setDruhVozidla("trolejbus");
		
		return "trolejbus";
	}
}
