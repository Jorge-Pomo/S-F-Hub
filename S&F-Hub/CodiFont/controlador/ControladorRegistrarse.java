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
	@FXML private Label lblError;
	
	/**
	 * <h2>Configuración del Boton "Registrarse"</h2> anidamos el boton al metodo
	 * registrarse
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		btnRegistrarse.setOnMouseClicked((event) -> registrar());

	}

	/**
	 * <h2>Comprobamos el campo del E-amil</h2>
	 * 
	 * @param resu  resultado que devolverá el metodo
	 * @param email variable donde se guardara el e-mail
	 * 
	 *              Si el email contiene un "@" y un "." sera correcto.
	 * 
	 * @see Email
	 * 
	 * @return
	 *         <ul>
	 *         <li>El email es correcto</li>
	 *         <li>El email es incorrecto</li>
	 *         </ul>
	 */
	private boolean comprobarEmail() {

		boolean resu = false;

		String email = txtEmail.getText();

		if (email.contains("@") && email.contains(".")) {
			resu = true;
		}

		return resu;
	}

	/**
	 * <h2>Comprobamos el campo Contraseña</h2>
	 * 
	 * @param resu      resultado que devolverá el metodo
	 * @param contra1   campo "contraseña"
	 * @param contraRep campo "Repetri Contraseña"
	 * 
	 * @see CharSequence creamos un array de caracteres con la contraseña
	 * 
	 * @see .toString convertimos la cadena de caracteres a String para poder
	 *      comparar los 2 campos
	 * 
	 * @return
	 *         <ul>
	 *         <li>Son iguales</li>
	 *         <li>No son iguales</li>
	 *         </ul>
	 */
	private boolean comprobarContraseña() {
		boolean resu = false;

		CharSequence contra1 = txtContra.getCharacters();
		CharSequence contraRep = txtRepetirContra.getCharacters();

		if (contra1.toString().equals(contraRep.toString())) {
			resu = true;
		}

		return resu;
	}

	public boolean comprobarRegistro() {
		boolean resu = false;
		
		
		
		return resu;
	}
	
	/**
	 * <h2>Registramos al usuario en la BBDD</h2>
	 * 
	 * @param Connection Iniciamos la conexion con la BBDD, indicando el tipo, la URL, usuario y contraseña
	 * @param Statment Iniciamos Conexion
	 * @param contraseña Guardamos la contraseña en tipo String
	 * @param rs Insertamos datos de registro
	 * 
	 * Volvemos a la ventana de Login para poder iniciar sesion con el usuario ya creado y almacenado en la BBDD
	 * */
	public void registrar() {

		if(comprobarRegistro() && comprobarEmail() && comprobarContraseña()) {
			//Conexion BBDD
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conexion = DriverManager.getConnection("jdbc:mysql://54.235.194.103/bd_s&fhub", "Conectar", "12345678");

				Statement s = conexion.createStatement();

				CharSequence contra1 = txtContra.getCharacters();
				String contraseña = contra1.toString();

				int rs = s.executeUpdate("INSERT INTO usuario (`nombre`, `contraseña`, `publicidad`, `privacidad`, `telf`, `e-mail`) VALUES ('" + txtUser.getText() + "','" + contraseña + "','" + checkPublicidad.isSelected() + "','" + checkPrivacidad.isSelected() + "','" + txtTelef.getText() + "','" + txtEmail.getText() + "')" );
				
				//Cerramos Conexion
				conexion.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			//Volver ventana Loggin
			try {

				FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Loggin.fxml"));

				Parent root = loader.load();
				Stage stage = (Stage) this.btnRegistrarse.getScene().getWindow();

				stage.setTitle("S&F Hub -- Loggin");
				stage.setScene(new Scene(root));
				stage.show();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			if(comprobarRegistro() == false) {
				
			}
			if(comprobarEmail() == false) {
				
			}
			if(comprobarContraseña() == false) {
				
			}
		}

		
		
	}

}
