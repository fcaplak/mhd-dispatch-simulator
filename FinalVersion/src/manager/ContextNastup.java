package manager;

import people.Cestujuci;

public class ContextNastup {
	private Strategy strategy;
	
	public ContextNastup(Strategy strategy){
		this.strategy = strategy;
	}
	
	public String spustiNastupStrategy(Cestujuci c) {
		return strategy.nastupDoVozidla(c);
	}
	
}
