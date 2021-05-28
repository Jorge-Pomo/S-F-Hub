package controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladorPyS implements Initializable {

	
	@FXML
	private Button Volver;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Volver.setOnMouseClicked((event) -> Atras());
		
	}
	
	public void Atras() {
		
		try {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Inicio.fxml"));

		Parent root = loader.load();
		Stage stage = (Stage) this.Volver.getScene().getWindow();
		

		stage.setTitle("S&F Hub -- Serie");
		stage.setScene(new Scene(root));
		stage.show();

	} catch (Exception e) {
		e.printStackTrace();
	}
	}
}
	

