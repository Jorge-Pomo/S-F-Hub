package controlador;

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

public class ControladorLoggin implements Initializable {

	// Atributos graficos FXML
	@FXML private Label lblUsuario;
	@FXML private TextField txtUsuario;
	@FXML private Label lblContraseña;
	@FXML private PasswordField passwordContraseña;
	@FXML private Button btnIniciarSesion;
	@FXML private Button btnRegistrarse;
	@FXML private Label lblError;
	@FXML private Button EntrarAdmin;

	/**
	 * <h2>Configuración de los Botones "Registrarse y "IniciarSesion"</h2> 
	 * <p>Anidamos cada boton con su metodo</p>
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		this.btnRegistrarse.setOnMouseClicked((event) -> registrarse());
		this.btnIniciarSesion.setOnMouseClicked((event) -> iniciarSesion());
		this.EntrarAdmin.setOnMouseClicked((event) -> iniciarAdmin());
	}

	/**
	 * <h2>Boton de iniciarSesion</h2>
	 * 
	 * @param contra1 array que contiene la contraseña
	 * @param contraseña passamos contra1 a String i lo guardamos en contraseña
	 * 
	 * <p>Nos conectamos a la BBDD</p>
	 * 
	 * @param rs
	 * <ul>
	 * 	<li>Error, el usuario o contraseña no son validos</li>
	 *	<li>Cerramos la conexion y nos vamos a la pestaña de Inicio</li>
	 * </ul>
	 * */
	// Metodos
	private void iniciarSesion() {

		CharSequence contra1 = passwordContraseña.getCharacters();
		String contraseña = contra1.toString();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://54.235.194.103/bd_s&fhub", "Conectar",
					"12345678");

			Statement s = conexion.createStatement();

			ResultSet rs = s.executeQuery("SELECT nombre, contraseña FROM `usuario` WHERE nombre = '"
					+ txtUsuario.getText() + "' AND contraseña = '" + contraseña + "'");

			// Si no hay datos guardados en rs, no se habra podido hacer la consulta
			if (!rs.isBeforeFirst()) {
				lblError.setText("El usuario o la contraseña no son validos");

			} else {
				// Cerramos Conexion
				conexion.close();

				// Ir ventana PyS
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Inicio2.fxml"));

				Parent root = loader.load();
				Stage stage = (Stage) this.btnIniciarSesion.getScene().getWindow();

				stage.setTitle("S&F Hub -- Registrarse");
				stage.setScene(new Scene(root));
				stage.show();
			}
		} catch (Exception e) {
			e.printStackTrace();
	
		}

		
	}

	/**
	 * @param loader        especificamos done se encuentra la ventana a cargar
	 * @param root          cargamos la ventana
	 * @param stage         indicamos la funcionalidad del boton, en este caso que
	 *                      no abra otr ventana
	 * @param stage.stTitle insertamos el titulo de la pagina
	 */
	private void registrarse() {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Registrarse.fxml"));

			Parent root = loader.load();
			Stage stage = (Stage) this.btnRegistrarse.getScene().getWindow();

			stage.setTitle("S&F Hub -- Registrarse");
			stage.setScene(new Scene(root));
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	private void iniciarAdmin () {
		
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Administrador.fxml"));

			Parent root = loader.load();
			Stage stage = (Stage) this.btnRegistrarse.getScene().getWindow();

			stage.setTitle("S&F Hub -- Registrarse");
			stage.setScene(new Scene(root));
			stage.show();
		
		} catch (Exception e) {
			e.printStackTrace();
		
		}
	}
}


