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

	@FXML
	private Button btnVolver2;
	@FXML
	private Button NLista;
	@FXML
	private Button Añadir;
	
	
	@FXML private Label lblNombreLista;
	
	 /**
		 * <h2>Configuración de los Botones "Volver y "NuevaLista"</h2>
		 * <p>
		 * Anidamos cada botón con su método
		 * </p>
		 */

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		btnVolver2.setOnMouseClicked((event) -> Atras2());
		NLista.setOnMouseClicked((event) -> NuevaLista());
		//Añadir.setOnMouseClicked((event) -> AñadirSyP());
		
	}
	
	/**
	 * @param loader         especificamos donde se encuentra la ventana a cargar
	 * 
	 * @param root           cargamos la ventana
	 * 
	 * @param stage          indicamos la funcionalidad del botón, en este caso que
	 *                       abra la ventana Inicio
	 * 
	 * @param stage.setTitle insertamos el título de la página
	 */
	
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
	
	/**
	 * 
	 * @see Creamos una ventana emergente que nos pida un nombre para la nueva lita
	 * 
	 * @param TextInputDialog  	Crea una ventana emergente 
	 * 
	 */
	
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
	

