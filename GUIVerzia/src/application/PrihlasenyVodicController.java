package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import manager.Autentifikator;
import people.Vodic;

public class PrihlasenyVodicController
{
	@FXML Button btnLogout;
	@FXML Text txtCisloLinky;
	@FXML Text txtKonecna;
	@FXML Text txtNextZas;
	@FXML Text txtCurrZas;
	@FXML Text txtVodic;
	
	Vodic vodic = ((Vodic)PrihlasenieScenaController.prihlaseny);
	
	@FXML
    public void initialize() throws IOException
    {
		txtVodic.setText("V službe "+vodic.getMeno() + ", #" + vodic.getId() + ", " + vodic.getVozidlo().getTyp() + " #"+vodic.getVozidlo().getId());
		zobrazTexty();
    }
	
	private void zobrazTexty()
	{
		txtKonecna.setText(vodic.getVozidlo().getKonecnaZastavka().getMeno());
		txtCurrZas.setText(vodic.getVozidlo().getAktualnaZastavka().getMeno());
		txtCisloLinky.setText( Integer.toString(vodic.getLinka().getCislo()));
		
		String zastavky = "";
		
		txtNextZas.setText("");
		for(int i = 1; i <= 5; i++)
		{
			try {
				zastavky += vodic.getVozidlo().getZastavky().get(vodic.getVozidlo().getZastavky().indexOf(vodic.getVozidlo().getAktualnaZastavka())+i).getMeno()+"\n";
			}
			catch (Exception e) {}
		}
			
		txtNextZas.setText(zastavky);
	}
	
	@FXML
	private void handleBtnPrejdi(ActionEvent event) throws IOException
	{
		vodic.posun();

		zobrazTexty();
	}
	
	@FXML
	private void handleBtnLogout(ActionEvent event) throws IOException
	{
		if(PrihlasenieScenaController.prihlaseny != null)
		{
			PrihlasenieScenaController.prihlaseny = null;
			Main.scenaPrihlasenie();
		}
	}
	
}
