package controlador;


import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ControladorMiLista implements Initializable {

	// Atributos graficos FXML
	@FXML private Button btnVolver2;
	@FXML private Button NLista;
	@FXML private Button Añadir;
	
	@FXML private Label lblNombreLista;
	
	 ControladorPyS stage1_controller_enstage2;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		btnVolver2.setOnMouseClicked((event) -> Atras2());
		NLista.setOnMouseClicked((event) -> NuevaLista());
		//Añadir.setOnMouseClicked((event) -> AñadirSyP());
		
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
	
	public void reciberparametros (ControladorPyS stage1, String texto ) {
		
		Añadir.setText(texto);
		stage1_controller_enstage2=stage1;
		
	}
	
	private void NuevaLista() {
		
		TextInputDialog tid = new TextInputDialog();
		tid.setHeaderText(null);
		tid.setTitle("Insertar");
		tid.setContentText("Nombre de la Lista");
		Optional<String> texto = tid.showAndWait();
		
		String NombreNuevaLista = texto.get();
		
		lblNombreLista.setText(NombreNuevaLista);
		
	}

}
	

