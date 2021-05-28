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

public class ControladorMiLista implements Initializable{

	@FXML
	private Button btnVolver2;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		btnVolver2.setOnMouseClicked((event) -> Atras2());
		
	}
	
	public void Atras2() {
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Inicio2.fxml"));

			Parent root = loader.load();
			Stage stage = (Stage) this.btnVolver2.getScene().getWindow();
			

			stage.setTitle("S&F Hub -- MiLista");
			stage.setScene(new Scene(root));
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
	

