package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorLoggin implements Initializable {

	// Atributos graficos FXML
	@FXML private Label lblUsuario;
	@FXML private TextField txtUsuario;
	@FXML private Label lblContraseña;
	@FXML private PasswordField passwordContraseña;
	@FXML private Button btnIniciarSesion;
	@FXML private Button btnRegistrarse;

	/**
	 * <h2>Configuración de los Botones "Registrarse y "IniciarSesion"</h2>
	 * Anidamos cada boton con su metodo
	 * */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		this.btnRegistrarse.setOnMouseClicked((event) -> registrarse());
		this.btnIniciarSesion.setOnMouseClicked((event) -> iniciarSesion());

	}

	// Metodos
	private void iniciarSesion() {

	}

	/**
	 * @param loader especificamos done se encuentra la ventana a cargar
	 * @param root cargamos la ventana
	 * @param stage indicamos la funcionalidad del boton, en este caso que no abra otr ventana
	 * @param stage.stTitle insertamos el titulo de la pagina
	 * */
	private void registrarse() {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Registrarse.fxml"));

			Parent root = loader.load();
			Stage stage = (Stage) this.btnIniciarSesion.getScene().getWindow();

			stage.setTitle("S&F Hub -- Registrarse");
			stage.setScene(new Scene(root));
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
