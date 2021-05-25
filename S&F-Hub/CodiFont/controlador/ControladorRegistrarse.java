package controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControladorRegistrarse  implements Initializable{

	//Atributos graficos FXML
		@FXML
		private Label lblNuwvoUsuario;
		@FXML
		private Label lblContraseña;
		@FXML
		private TextField txtUser;
		@FXML
		private TextField txtEmail;
		@FXML
		private TextField txtTelef;
		@FXML
		private PasswordField txtContra;
		@FXML
		private PasswordField txtRepetirContra;
		@FXML
		private CheckBox checkPublicidad;
		@FXML
		private CheckBox checkPrivacidad;
		@FXML
		private Button btnRegistrarse;
		
		
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
