package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import manager.Priestupok;
import manager.Transport;
import people.KontrolnyDispecer;
import people.Vodic;

public class PrihlasenyKontrolnyDispecerController
{
	@FXML Button btnLogout;
	
	@FXML Button btnPrirad;
	
	@FXML Text dispecerText;
	@FXML Text invalid;
	
	@FXML TextField fieldLinka;
	@FXML TextField fieldIdVodica;
	@FXML TextField fieldIdVozidla;
	
	@FXML TableView <Vodic> tabVodici;
	@FXML private TableColumn <Vodic, String> tabVodIdCol;
	@FXML private TableColumn <Vodic, String> tabVodMenoCol;
	@FXML private TableColumn <Vodic, String> tabVodVekCol;
	@FXML private TableColumn <Vodic, String> tabVodTypCol;
	@FXML private TableColumn <Vodic, String> tabVodVozCol;
	@FXML private TableColumn <Vodic, String> tabVodLinkaCol;
	
	@FXML TableView <Priestupok> tabPriestupky;
	@FXML private TableColumn <Priestupok, String> tabPriestupkyVodic;
	@FXML private TableColumn <Priestupok, String> tabPriestupkyDruh;
	@FXML private TableColumn <Priestupok, String> tabPriestupkyVyska;
        
	static ObservableList <Vodic> vodiciList = FXCollections.observableArrayList();
	static ObservableList <Priestupok> priestupkyList = FXCollections.observableArrayList();
	
	KontrolnyDispecer kontrolnyDispecer = ((KontrolnyDispecer)PrihlasenieScenaController.prihlaseny);
	
	public static ObservableList <Vodic> getVodici()
	{
		vodiciList.clear();
		
		for(Vodic v: Transport.getVodici().values())
				vodiciList.add(v);
		
		return vodiciList;
	}
	
	
	public static ObservableList<Priestupok> getPriestupky()
	{
		priestupkyList.clear();
			
		for(Priestupok p: Transport.getPriestupky().values())
				priestupkyList.add(p);
		
		return priestupkyList;
	}
	
	public void initialize()
	{
		dispecerText.setText("Prihlásený kontrolný dispeèer " + kontrolnyDispecer.getMeno() + ", #" + kontrolnyDispecer.getId());
		
		tabVodIdCol.setCellValueFactory(new PropertyValueFactory <Vodic, String> ("id"));
		tabVodMenoCol.setCellValueFactory(new PropertyValueFactory <Vodic, String> ("meno"));
		tabVodVekCol.setCellValueFactory(new PropertyValueFactory <Vodic, String> ("vek"));
		tabVodTypCol.setCellValueFactory(new PropertyValueFactory <Vodic, String> ("typ"));
		tabVodVozCol.setCellValueFactory(new PropertyValueFactory <Vodic, String> ("vozidloTab"));
		tabVodLinkaCol.setCellValueFactory(new PropertyValueFactory <Vodic, String> ("linkaNum"));
		
		tabVodici.setItems(getVodici());
		
		
		tabPriestupkyVodic.setCellValueFactory(new PropertyValueFactory <Priestupok, String> ("idVodica"));
		tabPriestupkyDruh.setCellValueFactory(new PropertyValueFactory <Priestupok, String> ("druh"));
		tabPriestupkyVyska.setCellValueFactory(new PropertyValueFactory <Priestupok, String> ("vyska"));
		
		tabPriestupky.setItems(getPriestupky());
		
	}
	
	/**
	 * Handler na tlacitko k udeleniu pokuty
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void handleBtnUdel(ActionEvent event) throws IOException
	{
		try 
		{
			kontrolnyDispecer.pokuta(Integer.parseInt(fieldIdVodica.getText()));
			tabPriestupky.setItems(getPriestupky());
		}
		catch (Exception e)
		{
			invalid.setText("Zadal si neplatné ID!");
		}
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
