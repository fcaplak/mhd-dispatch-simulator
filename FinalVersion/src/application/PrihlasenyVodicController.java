package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import people.Vodic;

public class PrihlasenyVodicController
{
	@FXML Button btnLogout;
	@FXML Text txtCisloLinky;
	@FXML Text txtKonecna;
	@FXML Text txtNextZas;
	@FXML Text txtCurrZas;
	@FXML Text txtVodic;
	@FXML Text txtPeniaze;
	@FXML Text txtPriestupok;
	
	Vodic vodic = ((Vodic)PrihlasenieScenaController.prihlaseny);
	
	protected boolean spachalPriestupok = false;
	
	@FXML
    public void initialize() throws IOException
    {
		txtVodic.setText("V sluûbe "+vodic.getMeno() + ", #" + vodic.getId() + ", " + vodic.getVozidlo().getTyp() + " #"+vodic.getVozidlo().getId());
		txtPeniaze.setText(Double.toString(vodic.getCelkovyZarobok()));
		zobrazTexty();
    }
	
	/**
	 * V pripade nutnej aktualizacie textov na obrazovke sa aktualizuju
	 */
	private void zobrazTexty()
	{
		txtKonecna.setText(vodic.getVozidlo().getKonecnaZastavka().getMeno());
		txtCisloLinky.setText( Integer.toString(vodic.getLinka().getCislo()));
		txtPeniaze.setText(Double.toString(vodic.getCelkovyZarobok()));
		
		if(vodic.getAktivnyPriestupok() == true)
		{
			txtPriestupok.setText("Vykonal si priestupok\nTeraz ùa mÙûe kontroln˝ dispeËer pokutovaù!");
		}
		
		txtCurrZas.setText(vodic.getVozidlo().getAktualnaZastavka().getMeno());
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
