package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage; 

public class Main extends Application { 
  
	private static Stage stage;
	private static AnchorPane mainLayout;
	
	 public void start(Stage stage) throws Exception
	 {
	        Main.stage = stage;
	        stage.setTitle("Dispeèing MHD simulátor");
	        
	        scenaUvodna();
	 }
  
	public static void scenaUvodna() throws IOException
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/UvodnaScena.fxml"));
		mainLayout = loader.load();
		Scene scena = new Scene(mainLayout);
		stage.setScene(scena);
		stage.show();
	}
		
	public static void scenaPrihlasenie() throws IOException
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/PrihlasenieScena.fxml"));
		mainLayout = loader.load();
		Scene scena = new Scene(mainLayout);
		stage.setScene(scena);
		stage.show();
	}
	
	public static void scenaPrihlasenyVodic() throws IOException
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/PrihlasenyVodic.fxml"));
		mainLayout = loader.load();
		Scene scena = new Scene(mainLayout);
		stage.setScene(scena);
		stage.show();
	}
	
	public static void scenaPrihlasenyDispecer() throws IOException
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/PrihlasenyDispecer.fxml"));
		mainLayout = loader.load();
		Scene scena = new Scene(mainLayout);
		stage.setScene(scena);
		stage.show();
	}
	
    public static void main(String args[]) 
    { 
        launch(args); 
    } 
}