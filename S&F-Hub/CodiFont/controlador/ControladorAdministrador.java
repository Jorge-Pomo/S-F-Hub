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

/**
 * <h2>Pesta�a de login Administrador</h2>
 * */
public class ControladorAdministrador implements Initializable {

	// Atributos graficos FXML
	@FXML private TextField txtUsuario;
	@FXML private Button btnIniciar;
	@FXML private TextField txtContrase�a;
	@FXML private Label lblError;
	@FXML private Button Usuario;

	/**
	 * <h2>Configuraci�n de los Botones "Registrarse y "IniciarSesion"</h2>
	 * <p>
	 * Anidamos cada boton con su metodo
	 * </p>
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		this.btnIniciar.setOnMouseClicked((event) -> iniciarSesion());
		this.Usuario.setOnMouseClicked((event) -> Usuario());
	}

	/**
	 * <h2>Boton de iniciarSesion</h2>
	 * 
	 * @param contra1    array que contiene la contrase�a
	 * @param contrase�a passamos contra1 a String i lo guardamos en contrase�a
	 * 
	 *                   <p>
	 *                   Nos conectamos a la BBDD
	 *                   </p>
	 * 
	 * @param rs
	 *                   <ul>
	 *                   <li>Error, el usuario o contrase�a no son validos</li>
	 *                   <li>Cerramos la conexion y nos vamos a la pesta�a de
	 *                   Inicio</li>
	 *                   </ul>
	 */
	// Metodos
	private void iniciarSesion() {

		CharSequence contra1 = txtContrase�a.getCharacters();
		String contrase�a = contra1.toString();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://54.235.194.103/bd_s&fhub", "Conectar",
					"12345678");

			Statement s = conexion.createStatement();

			ResultSet rs = s.executeQuery("SELECT nombre, contrase�a FROM `usuario` WHERE nombre = '"
					+ txtUsuario.getText() + "' AND contrase�a = '" + contrase�a + "'");

			// Si no hay datos guardados en rs, no se habra podido hacer la consulta
			if (!rs.isBeforeFirst()) {
				lblError.setText("El usuario o la contrase�a no son validos");

			} else {
				String user = "";
				String passwd = "";
				while (rs.next()) {
					user = rs.getString(1);
					passwd = rs.getString(2);
				}

				if (user.equals("admin") && passwd.equals("admin")) {
					// Cerramos Conexion
					conexion.close();

					// Ir ventana PyS
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/GraficosAdministrador.fxml"));

					Parent root = loader.load();
					Stage stage = (Stage) this.btnIniciar.getScene().getWindow();

					stage.setTitle("S&F Hub -- Administrador");
					stage.setScene(new Scene(root));
					stage.show();
				} else {
					lblError.setText("El usuario o la contrase�a no son validos");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param loader         especificamos donde se encuentra la ventana a cargar
	 * 
	 * @param root           cargamos la ventana
	 * 
	 * @param stage          indicamos la funcionalidad del bot�n, en este caso que
	 *                       abra la ventana Login
	 * 
	 * @param stage.setTitle insertamos el t�tulo de la p�gina
	 */
	private void Usuario() {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Login.fxml"));

			Parent root = loader.load();
			Stage stage = (Stage) this.Usuario.getScene().getWindow();

			stage.setTitle("S&F Hub -- Login");
			stage.setScene(new Scene(root));
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
