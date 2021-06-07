package controlador;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import modelo.Usuario;

public class ControladorSoporteTc implements Initializable {

	// Atributos graficos FXML
	
	@FXML private Button btnVolver3;
	@FXML private Button subirError;
	@FXML private TextArea Texto;
	@FXML private TextField Email;
	
	public Usuario user;

	/**
	 * <h2>Configuración de los Botones "Volver y "EnviarError"</h2>
	 * <p>
	 * Anidamos cada botón con su método
	 * </p>
	 */

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		btnVolver3.setOnMouseClicked((event) -> Atras3());
		subirError.setOnMouseClicked((event) -> Error());

	}

	/**
	 * @param loader         especificamos donde se encuentra la ventana a cargar
	 * 
	 * @param root           cargamos la ventana
	 * 
	 * @param stage          indicamos la funcionalidad del botón, en este caso que
	 *                       abra la ventana Inicio
	 * 
	 * @param stage.setTitle insertamos el título de la página
	 */
	
	
	public void Atras3() {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Inicio2.fxml"));

			Parent root = loader.load();
			Stage stage = (Stage) this.btnVolver3.getScene().getWindow();

			stage.setTitle("S&F Hub -- Soporte");
			stage.setScene(new Scene(root));
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <h2>Registramos el error en la BBDD</h2>
	 * 
	 * 
	 * @see Comprobamos que los campos Email y descripción no estan vacios, en ese caso saldrá 
	 * una ventana emergente que lo indique 
	 * 
	 * 
	 * 
	 * @param Connection Iniciamos la conexion con la BBDD, indicando el Email y la descripcion del error
	 *                   
	 * @param Statment   Iniciamos Conexion
	 * 
	 * @param contraseña Guardamos la contraseña en tipo String
	 * 
	 * @param rs         Insertamos datos de registro
	 * 
	 *                  <p> Volvemos a la ventana de Login para poder iniciar sesion
	 *                   con el usuario ya creado y almacenado en la BBDD</p>
	 *                   
	 *@param alert      Ventana emergente
	 *                   
	 */
	
	
	
	public void Error() {

		
		if (Email.getText().equals("") || Texto.getText().equals("")) {
			
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Los campos Email y descripcion no pueden estar vacios");
			alert.showAndWait();

			
		}else {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://54.235.194.103/bd_s&fhub", "Conectar",
					"12345678");

			Statement s = conexion.createStatement();

			int admin = (int) Math.random() * 2 + 1;

			ResultSet rs2 = s.executeQuery(
					"SELECT id_usuario FROM usuario where nombre = '" + ControladorLogin.nombreUsu + "';");

			rs2.next();

			int idUsu = rs2.getInt(1);

			int rs = s.executeUpdate("INSERT INTO `error`(`Email`, `descripcion`, `id_basico`, `id_admin`) VALUES ('"
					+ Email.getText() + "','" + Texto.getText() + "'," + idUsu + ",'" + admin + "' )");

			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setHeaderText(null);
			alert.setTitle("Confirmacion");
			alert.setContentText("El error ha sido enviado correctamente");
			alert.showAndWait();
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
}



