package people;

import manager.ContextNastup;
import manager.NastupAutobus;
import manager.NastupElektricka;
import manager.NastupTrolejbus;
import manager.Transport;
import vehicles.Autobus;
import vehicles.Elektricka;
import vehicles.Trolejbus;
import vehicles.Vozidlo;

public class Cestujuci extends Clovek
{
	protected String druhVozidla = null;
	
	public Cestujuci()
	{
		super();
		Transport.addCestujuci(this);
	}

	/**
	 * K cestujucemu sa priradi druh vozidla - akym najradsej cestuje
	 * @param druhVozidla
	 */
	public void setDruhVozidla(String druhVozidla) {
		this.druhVozidla = druhVozidla;	
	}
	
	/**
	 * Nastupi do vozidla takeho, aka je instancia vozidla
	 * @param v
	 */
	public void nastupDoVozidla(Vozidlo v)
	{
		if(v instanceof Trolejbus)
		{
			ContextNastup ctx = new ContextNastup(new NastupTrolejbus());
			ctx.spustiNastupStrategy(this);
		}
		
		else if(v instanceof Autobus)
		{
			ContextNastup ctx = new ContextNastup(new NastupAutobus());
			ctx.spustiNastupStrategy(this);
		}
		
		else if(v instanceof Elektricka)
		{
			ContextNastup ctx = new ContextNastup(new NastupElektricka());
			ctx.spustiNastupStrategy(this);
		}
	}
}
