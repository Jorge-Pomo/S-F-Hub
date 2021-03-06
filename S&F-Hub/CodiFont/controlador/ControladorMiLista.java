package controlador;

/**
 * @author Jorge, Diego, Fran
 * 
 * @versi?n 1.0.0
 * */

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

/**
 * <h2>Ventana Mi Lista</h2>
 * */
public class ControladorMiLista implements Initializable {

	// Atributos graficos FXML
	@FXML private Button btnVolver2;
	@FXML private Button NLista;
	@FXML private Button A?adir;
	
	@FXML private Label lblNombreLista;
	
	 ControladorPyS stage1_controller_enstage2;
	
	 /**
		 * <h2>Configuraci?n de los Botones "Volver y "NuevaLista"</h2>
		 * <p>
		 * Anidamos cada bot?n con su m?todo
		 * </p>
	*/
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		btnVolver2.setOnMouseClicked((event) -> Atras2());
		NLista.setOnMouseClicked((event) -> NuevaLista());
		//A?adir.setOnMouseClicked((event) -> A?adirSyP());
		
	}
	
	/**
	 * @param loader         especificamos donde se encuentra la ventana a cargar
	 * 
	 * @param root           cargamos la ventana
	 * 
	 * @param stage          indicamos la funcionalidad del bot?n, en este caso que
	 *                       abra la ventana Inicio
	 * 
	 * @param stage.setTitle insertamos el t?tulo de la p?gina
	 */
	public void Atras2() {
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Inicio2.fxml"));

			Parent root = loader.load();
			Stage stage = (Stage) this.btnVolver2.getScene().getWindow();
			

			stage.setTitle("S&F Hub -- Peliculas y Series");
			stage.setScene(new Scene(root));
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void reciberparametros (ControladorPyS stage1, String texto ) {
		
		A?adir.setText(texto);
		stage1_controller_enstage2=stage1;
		
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
	

