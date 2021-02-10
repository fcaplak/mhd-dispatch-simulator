package manager;

import java.util.Random;

public final class Util
{
	public static int getRandomInterval(int a, int b)
	{
		Random rand = new Random(); 
		
		return (rand.nextInt(( b - a ) + 1) + a);
	}
	
	public static String getRandomName()
	{
		String meno = Transport.getMena()[new Random().nextInt(50)];
		String priezvisko = Transport.getPriezviska()[new Random().nextInt(50)];
		
		return meno + " " + priezvisko;
	}
}
