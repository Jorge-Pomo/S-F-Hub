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

public class ControladorSoporteTc implements Initializable{

	@FXML
	private Button btnVolver3;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		btnVolver3.setOnMouseClicked((event) -> Atras3());
		
	}
	
	public void Atras3() {
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Inicio2.fxml"));

			Parent root = loader.load();
			Stage stage = (Stage) this.btnVolver3.getScene().getWindow();
			

			stage.setTitle("S&F Hub -- Soporte");
			stage.setScene(new Scene(root));
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
