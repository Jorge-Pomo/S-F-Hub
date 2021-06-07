package controlador;

/**
 * @author Jorge, Diego, Fran
 * 
 * @versi�n 1.0.0
 * */

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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

/**
 * <h2>Ventana Registrarse</h2>
 * <p>Ventana para registrarse en la app y en la BBDD</p>
 * */
public class ControladorRegistrarse implements Initializable {

	// Atributos graficos FXML
	@FXML private Label lblNuwvoUsuario;
	@FXML private Label lblContrase�a;
	@FXML private TextField txtUser;
	@FXML private TextField txtEmail;
	@FXML private TextField txtTelef;
	@FXML private PasswordField txtContra;
	@FXML private PasswordField txtRepetirContra;
	@FXML private CheckBox checkPublicidad;
	@FXML private CheckBox checkPrivacidad;
	@FXML private Button btnRegistrarse;
	@FXML private Label lblError;
	private Date fechaSQL;

	/**
	 * <h2>Configuraci�n del Boton "Registrarse"</h2> anidamos el boton al metodo
	 * registrarse
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		btnRegistrarse.setOnMouseClicked((event) -> registrar());

	}

	/**
	 * <h2>Comprobamos el campo del E-amil</h2>
	 * 
	 * @param resu  resultado que devolver� el metodo
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
	public boolean comprobarEmail(String comrpobarEmail) {

		boolean resu = false;

		String email = comrpobarEmail;

		if (email.contains("@") && email.contains(".")) {
			resu = true;
		}

		return resu;
	}

	/**
	 * <h2>Comprobamos el campo Contrase�a</h2>
	 * 
	 * @param resu      resultado que devolver� el metodo
	 * @param contra1   campo "contrase�a"
	 * @param contraRep campo "Repetri Contrase�a"
	 * 
	 * @see CharSequence creamos un array de caracteres con la contrase�a
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
	private boolean comprobarContrase�a() {
		boolean resu = false;

		CharSequence contra1 = txtContra.getCharacters();
		CharSequence contraRep = txtRepetirContra.getCharacters();

		if (contra1.toString().equals("")) {
			resu = false;
		} else {
			if (contra1.toString().equals(contraRep.toString())) {
				resu = true;
			}
		}

		return resu;
	}

	// REGISTRO

	/**
	 * <h2>Comprobamos que el usuario ya esta registrado</h2>
	 * 
	 * @param Connection Iniciamos la conexion con la BBDD
	 * @param Statment   Iniciamos Conexion
	 * 
	 * @param rs         Insertamos datos de registro
	 * 
	 *                   Comprobamos que el usuario ya se encuentra en la Base de
	 *                   Datos
	 * 
	 */

	public boolean comprobarRegistro() {

		boolean resu = true;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://54.235.194.103/bd_s&fhub", "Conectar",
					"12345678");

			Statement s = conexion.createStatement();
			ResultSet rs = s.executeQuery("SELECT Email FROM usuario WHERE Email = '" + txtEmail.getText() + "'");

			if (rs.next()) {
				resu = false;
			}

		} catch (Exception e) {

		}

		return resu;
	}

	/**
	 * <h2>Registramos al usuario en la BBDD</h2>
	 * 
	 * @param Connection Iniciamos la conexion con la BBDD, indicando el tipo, la
	 *                   URL, usuario y contrase�a
	 * @param Statment   Iniciamos Conexion
	 * @param contrase�a Guardamos la contrase�a en tipo String
	 * @param rs         Insertamos datos de registro
	 * 
	 *                  <p> Volvemos a la ventana de Login para poder iniciar sesion
	 *                   con el usuario ya creado y almacenado en la BBDD</p>
	 */
	public void registrar() {

		if (txtUser.getText().equals("") || txtEmail.getText().equals("") || txtTelef.getText().equals("")
				|| txtContra.getText().equals("") || txtRepetirContra.getText().equals("")) {

			lblError.setText("Hay campos vacios");
		} else {
			if (comprobarRegistro() == false) {
				lblError.setText("El usuario ya existe");
			} else {
				if (comprobarEmail(txtEmail.getText()) == false) {
					lblError.setText("El Email no es correcto");
				} else {
					if (comprobarContrase�a() == false) {
						lblError.setText("La contrase�a no coincide");
					} else {
						// Conexion BBDD
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection conexion = DriverManager.getConnection("jdbc:mysql://54.235.194.103/bd_s&fhub",
									"Conectar", "12345678");

							Statement s = conexion.createStatement();

							CharSequence contra1 = txtContra.getCharacters();
							String contrase�a = contra1.toString();
							
							Date date = new Date();
							DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
							
							int rs = s.executeUpdate(
									"INSERT INTO usuario (`nombre`, `contrase�a`, `publicidad`, `privacidad`, `telf`, `Email`, `Fecha`) VALUES ('"
											+ txtUser.getText() + "','" + contrase�a + "','"
											+ checkPublicidad.isSelected() + "','" + checkPrivacidad.isSelected()
											+ "','" + txtTelef.getText() + "','" + txtEmail.getText() + "','" + dateFormat.format(date) + "')");

							// Cerramos Conexion
							conexion.close();

						} catch (Exception e) {
							e.printStackTrace();
						}

						// Volver ventana Loggin
						try {

							FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Login.fxml"));

							Parent root = loader.load();
							Stage stage = (Stage) this.btnRegistrarse.getScene().getWindow();

							stage.setTitle("S&F Hub -- Login");
							stage.setScene(new Scene(root));
							stage.show();

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}

	}

}
