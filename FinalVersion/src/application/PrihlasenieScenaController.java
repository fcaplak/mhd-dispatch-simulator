package application;

import java.io.IOException;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import manager.Podnik;
import manager.Transport;
import people.Dispecer;
import people.KontrolnyDispecer;
import people.Vodic;
import people.Zamestnanec;


public class PrihlasenieScenaController
{
	@FXML Button btnPrihlas;
	@FXML PasswordField pwKod;
	@FXML Text invalid;
	
	@FXML TableView <Zamestnanec> tabView;
	@FXML private TableColumn <Zamestnanec, String> idColumn;
	@FXML private TableColumn <Zamestnanec, String> zamColumn;
	@FXML private TableColumn <Zamestnanec, String> kodColumn;
	
	static ObservableList <Zamestnanec> zamList = FXCollections.observableArrayList();
	
	public static ObservableList <Zamestnanec> getZam()
	{
		if(zamList.isEmpty())
		{
			for(Vodic v: Transport.getVodici().values())
				zamList.add(v);
			
			for(Dispecer v: Transport.getDispeceri())
				zamList.add(v);
		}
		return zamList;
	}
	
	public void initialize()
	{
		idColumn.setCellValueFactory(new PropertyValueFactory <Zamestnanec, String> ("id"));
		zamColumn.setCellValueFactory(new PropertyValueFactory <Zamestnanec, String> ("typ"));
		kodColumn.setCellValueFactory(new PropertyValueFactory <Zamestnanec, String> ("kod"));
		
		tabView.setItems(getZam());
	}
	
	static Zamestnanec prihlaseny = null;
	
	/**
	 * Zistujeme ci je kod zlozeny iba z cisel
	 * @throws VynimkaException
	 */
	public void checkOnlyNumbers() throws VynimkaException
	{
		String regex = ".*[a-zA-Z]+.*";
		Pattern pattern = Pattern.compile(regex);
		
		if(pattern.matcher(pwKod.getText()).matches())
			throw new VynimkaException("Kod moze obsahovat len cisla!");
	}
	
	/**
	 * Handler na prihlasovacie tlacitko, tuto overujeme kod
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void btnPrihlasHandler(ActionEvent event) throws IOException
	{
		// kontrolujeme ci sa v hesle nachadzaju iba cisla
		try {
			checkOnlyNumbers();
		} catch (VynimkaException e)
		{	
			e.callMethod();
			return;
		}
		
		prihlaseny = Podnik.Autentifikator.prihlas(Integer.parseInt(pwKod.getText()));
		if( prihlaseny instanceof Vodic )
		{
			try
			{
				Main.scenaPrihlasenyVodic();
			}
			catch (Exception e)
			{
				invalid.setText("Vodièovi nebolo priradené vozidlo!");
			}
			
		}
		else if( prihlaseny instanceof KontrolnyDispecer )
			Main.scenaPrihlasenyKontrolnyDispecer();
		else if( prihlaseny instanceof Dispecer )
			Main.scenaPrihlasenyDispecer();
	}
	
}