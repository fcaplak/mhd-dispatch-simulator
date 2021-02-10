package manager;

import java.util.Random;

public final class RandomUtil
{
	/**
	 * Vrati nahodne cislo z intervali a,b
	 * @param a
	 * @param b
	 * @return
	 */
	public static int getRandomInterval(int a, int b)
	{
		Random rand = new Random(); 
		
		return (rand.nextInt(( b - a ) + 1) + a);
	}
	
	/**
	 * Vrati nahodne meno spojene s medzerou a priezivskom z pola triedy Transport
	 * @return
	 */
	public static String getRandomName()
	{
		String meno = Transport.getMena()[new Random().nextInt(50)];
		String priezvisko = Transport.getPriezviska()[new Random().nextInt(50)];
		
		return meno + " " + priezvisko;
	}
}
