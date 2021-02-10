package application;

import java.io.IOException;

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
import manager.Autentifikator;
import manager.Transport;
import people.Dispecer;
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
	
	@FXML
	private void btnPrihlasHandler(ActionEvent event) throws IOException
	{
		prihlaseny = Autentifikator.prihlas(Integer.parseInt(pwKod.getText()));
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
		else if( prihlaseny instanceof Dispecer )
			Main.scenaPrihlasenyDispecer();
	}
	
}