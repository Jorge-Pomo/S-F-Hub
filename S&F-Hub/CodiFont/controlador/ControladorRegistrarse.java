package controlador;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utilidades.ConectarBBDD;

public class ControladorRegistrarse implements Initializable {

	// Atributos graficos FXML
	@FXML private Label lblNuwvoUsuario;
	@FXML private Label lblContraseña;
	@FXML private TextField txtUser;
	@FXML private TextField txtEmail;
	@FXML private TextField txtTelef;
	@FXML private PasswordField txtContra;
	@FXML private PasswordField txtRepetirContra;
	@FXML private CheckBox checkPublicidad;
	@FXML private CheckBox checkPrivacidad;
	@FXML private Button btnRegistrarse;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		btnRegistrarse.setOnMouseClicked((event) -> registrar());

	}

	private boolean comprobarEmail() {

		boolean resu = false;

		String email = txtEmail.getText();

		if (email.contains("@") && email.contains(".")) {
			resu = true;
		}

		return resu;
	}

	private boolean comprobarContraseña() {
		boolean resu = false;
		
		CharSequence contra1 = txtContra.getCharacters();
		CharSequence contraRep = txtRepetirContra.getCharacters();
		
		if(contra1.toString().equals(contraRep.toString())) {
			resu = true;
		}
		
		return resu;
	}
	
	public void registrar() {
		
		System.out.println(comprobarEmail() + " " + comprobarContraseña());
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://54.235.194.103:80/bd_s&fhub","root","12345678");
		
			Statement  s = conexion.createStatement();
			
			//ResultSet rs = s.executeQuery ("INSERT INTO usuario VALUES (DEFAULT, "+ txtUser + ", "+ txtContra + ", "+ checkPublicidad + ", "+ checkPrivacidad + ", " + txtTelef + ", " + txtEmail +")");
			
			ResultSet rs = s.executeQuery ("SELECT * FROM usuario");
			
			while (rs.next()){
				
				System.out.println (rs.getString(1));
				
				}
			
			conexion.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Loggin.fxml"));

			Parent root = loader.load();
			Stage stage = (Stage) this.btnRegistrarse.getScene().getWindow(); 

			stage.setTitle("S&F Hub -- Loggin");
			stage.setScene(new Scene(root));
			stage.show();


		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
