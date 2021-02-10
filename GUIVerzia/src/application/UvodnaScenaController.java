package application;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import manager.Podnik;
import manager.Transport;
import ui.Vypis;

public class UvodnaScenaController
{
	@FXML Text txtUvodPocet;
	@FXML Button btnExitB;
	@FXML Button btnStartB;
	
	@FXML TextField inVodici;
	int numVodici;
	
	@FXML TextField inSkusVodici;
	int numSkusVodici;
	
	@FXML TextField inProfVodici;
	int numProfVodici;
	
	@FXML TextField inDispeceri;
	int numDispeceri;
	
	@FXML TextField inKonDispeceri;
	int numKonDispeceri;
	
	@FXML TextField inAutobusy;
	int numAutobusy;
	
	@FXML TextField inTrolej;
	int numTrolejbusy;
	
	@FXML TextField inElektricky;
	int numElektricky;
	
	@FXML Text invalidInputs;
	
	@FXML
    public void initialize() throws IOException // zaciatok programu
	{
		//Transport.vytvorZastavky(); // vytvori instancie s menami zastavok z pola a vlozi do hashmapy
		
		//txtUvodPocet.setText("PoËet zamestnancov:\nVodiËi: " + Transport.getVodici().size() + "\nDispeËeri:"+ Transport.getDispeceri().size());
    }

	
	@FXML
	private void btnStart(ActionEvent event) throws IOException
	{
		try
		{
			numVodici = Integer.parseInt(inVodici.getText());
			numSkusVodici = Integer.parseInt(inSkusVodici.getText());
			numProfVodici = Integer.parseInt(inProfVodici.getText());
			numDispeceri = Integer.parseInt(inDispeceri.getText());
			numKonDispeceri = Integer.parseInt(inKonDispeceri.getText());
			numAutobusy = Integer.parseInt(inAutobusy.getText());
			numTrolejbusy = Integer.parseInt(inTrolej.getText());
			numElektricky = Integer.parseInt(inElektricky.getText()); 
			
			Podnik.zamestnajVodicov(numSkusVodici, numVodici, numProfVodici);
			Podnik.zamestnajDispecerov(numDispeceri, numKonDispeceri);
			Podnik.pripravVozidla(numAutobusy,  numTrolejbusy, numElektricky);
			Transport.vytvorZastavky();
			Podnik.vytvorLinky();
			
			Main.scenaPrihlasenie();
		}
		catch (NumberFormatException e)
		{
			invalidInputs.setText("Polia musia obsahovaù iba celÈ ËÌsla!");
		}
	}
	
	@FXML
	private void btnExit(ActionEvent event) throws IOException
	{
		Platform.exit();
		System.exit(0);
	}
}
