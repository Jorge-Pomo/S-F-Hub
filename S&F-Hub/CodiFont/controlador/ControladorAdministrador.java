package controlador;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladorAdministrador {

	// Atributos graficos FXML
	@FXML TextField txtUsuario;
	@FXML PasswordField txtContraseña;
	@FXML Button btnIniciar;
	@FXML Label lblError;

	public void initialize(URL arg0, ResourceBundle arg1) {

		this.btnIniciar.setOnMouseClicked((event) -> iniciarSesion());
	}

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
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/PyS.fxml"));

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

}
