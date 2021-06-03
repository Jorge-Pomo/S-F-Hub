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

public class ControladorAdministrador implements Initializable {

	// Atributos graficos FXML
	@FXML
	private TextField txtUsuario;
	@FXML
	private Button btnIniciar;
	@FXML
	private TextField txtContraseña;
	@FXML
	private Label lblError;
	@FXML
	private Button Usuario;
	
	/**
	 * <h2>Configuración de los Botones "Registrarse y "IniciarSesion"</h2>
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
	 * @param contra1    array que contiene la contraseña
	 * @param contraseña passamos contra1 a String i lo guardamos en contraseña
	 * 
	 *                   <p>
	 *                   Nos conectamos a la BBDD
	 *                   </p>
	 * 
	 * @param rs
	 *                   <ul>
	 *                   <li>Error, el usuario o contraseña no son validos</li>
	 *                   <li>Cerramos la conexion y nos vamos a la pestaña de
	 *                   Inicio</li>
	 *                   </ul>
	 */
	// Metodos
	private void iniciarSesion() {

		CharSequence contra1 = txtContraseña.getCharacters();
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
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/GraficosAdministrador.fxml"));

				Parent root = loader.load();
				Stage stage = (Stage) this.btnIniciar.getScene().getWindow();

				stage.setTitle("S&F Hub -- Registrarse");
				stage.setScene(new Scene(root));
				stage.show();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
private void Usuario () {
		
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Loggin.fxml"));

			Parent root = loader.load();
			Stage stage = (Stage) this.Usuario.getScene().getWindow();

			stage.setTitle("S&F Hub -- Registrarse");
			stage.setScene(new Scene(root));
			stage.show();
		
		} catch (Exception e) {
			e.printStackTrace();
		
	}
	}
	

}
