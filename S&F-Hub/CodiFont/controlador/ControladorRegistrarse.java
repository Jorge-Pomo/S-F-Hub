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
	 *                   URL, usuario y contraseña
	 * @param Statment   Iniciamos Conexion
	 * @param contraseña Guardamos la contraseña en tipo String
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
				if (comprobarEmail() == false) {
					lblError.setText("El Email no es correcto");
				} else {
					if (comprobarContraseña() == false) {
						lblError.setText("La contraseña no coincide");
					} else {
						// Conexion BBDD
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection conexion = DriverManager.getConnection("jdbc:mysql://54.235.194.103/bd_s&fhub",
									"Conectar", "12345678");

							Statement s = conexion.createStatement();

							CharSequence contra1 = txtContra.getCharacters();
							String contraseña = contra1.toString();

							int rs = s.executeUpdate(
									"INSERT INTO usuario (`nombre`, `contraseña`, `publicidad`, `privacidad`, `telf`, `Email`) VALUES ('"
											+ txtUser.getText() + "','" + contraseña + "','"
											+ checkPublicidad.isSelected() + "','" + checkPrivacidad.isSelected()
											+ "','" + txtTelef.getText() + "','" + txtEmail.getText() + "')");

							// Cerramos Conexion
							conexion.close();

						} catch (Exception e) {
							e.printStackTrace();
						}

						// Volver ventana Loggin
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
					}
				}
			}
		}

	}

}
