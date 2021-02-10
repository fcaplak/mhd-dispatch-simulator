package application;

import java.io.IOException;

import connections.Linka;
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
import manager.Autentifikator;
import manager.Transport;
import people.Dispecer;
import people.Vodic;
import people.Zamestnanec;
import vehicles.Vozidlo;

public class PrihlasenyDispecerController
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
	
	@FXML TableView <Linka> tabLinky;
	@FXML private TableColumn <Linka, String> tabLinIdCol;
	@FXML private TableColumn <Linka, String> tabLinTypCol;
	@FXML private TableColumn <Linka, String> tabLinZasCol;
	
	@FXML TableView <Vozidlo> tabVozidla;
	@FXML private TableColumn <Vozidlo, String> tabVozIdCol;
	@FXML private TableColumn <Vozidlo, String> tabVozDruhCol;
	@FXML private TableColumn <Vozidlo, String> tabVozLocCol;
        
	static ObservableList <Vodic> vodiciList = FXCollections.observableArrayList();
	static ObservableList <Linka> linkyList = FXCollections.observableArrayList();
	static ObservableList <Vozidlo> vozidlaList = FXCollections.observableArrayList();
	
	Dispecer dispecer = ((Dispecer)PrihlasenieScenaController.prihlaseny);
	
	public static ObservableList <Vodic> getVodici()
	{
		vodiciList.clear();
		
		for(Vodic v: Transport.getVodici().values())
				vodiciList.add(v);
		
		return vodiciList;
	}
	
	public static ObservableList <Linka> getLinky()
	{
		linkyList.clear();
		
		for(Linka l: Transport.getLinky().values())
				linkyList.add(l);
		
		return linkyList;
	}
	
	public static ObservableList<Vozidlo> getVozidla()
	{
		vozidlaList.clear();
			
		for(Vozidlo v: Transport.getVozidla().values())
				vozidlaList.add(v);
		
		return vozidlaList;
	}
	
	public void initialize()
	{
		dispecerText.setText("Prihlásený dispeèer " + dispecer.getMeno() + ", #" + dispecer.getId());
		
		tabVodIdCol.setCellValueFactory(new PropertyValueFactory <Vodic, String> ("id"));
		tabVodMenoCol.setCellValueFactory(new PropertyValueFactory <Vodic, String> ("meno"));
		tabVodVekCol.setCellValueFactory(new PropertyValueFactory <Vodic, String> ("vek"));
		tabVodTypCol.setCellValueFactory(new PropertyValueFactory <Vodic, String> ("typ"));
		tabVodVozCol.setCellValueFactory(new PropertyValueFactory <Vodic, String> ("vozidloTab"));
		tabVodLinkaCol.setCellValueFactory(new PropertyValueFactory <Vodic, String> ("linkaNum"));
		
		tabVodici.setItems(getVodici());
		
		
		tabLinIdCol.setCellValueFactory(new PropertyValueFactory <Linka, String> ("cislo"));
		tabLinTypCol.setCellValueFactory(new PropertyValueFactory <Linka, String> ("typ"));
		tabLinZasCol.setCellValueFactory(new PropertyValueFactory <Linka, String> ("zasZac"));
		
		tabLinky.setItems(getLinky());
		
		
		tabVozIdCol.setCellValueFactory(new PropertyValueFactory <Vozidlo, String> ("id"));
		tabVozDruhCol.setCellValueFactory(new PropertyValueFactory <Vozidlo, String> ("typ"));
		tabVozLocCol.setCellValueFactory(new PropertyValueFactory <Vozidlo, String> ("loc"));
		
		tabVozidla.setItems(getVozidla());
	}
	
	@FXML
	private void handleBtnPrirad(ActionEvent event) throws IOException
	{
		invalid.setText(" ");
		try 
		{
			dispecer.presun(Integer.parseInt(fieldIdVodica.getText()), Integer.parseInt(fieldIdVozidla.getText()), Integer.parseInt(fieldLinka.getText()));
			tabVodici.setItems(getVodici());
			tabVozidla.setItems(getVozidla());
		}
		catch (Exception e)
		{
			invalid.setText("Zadal si neplatné hodnoty!");
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
