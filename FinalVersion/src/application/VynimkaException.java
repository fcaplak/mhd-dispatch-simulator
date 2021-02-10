package application;

public class VynimkaException extends Exception
{
	public VynimkaException(String msg)
	{
		super(msg);
	}
	public void callMethod()
	{
		System.out.println(super.getMessage());
	}
}
