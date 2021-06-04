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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Usuario;

public class ControladorSoporteTc implements Initializable {

	@FXML
	private Button btnVolver3;
	@FXML
	private Button subirError;
	@FXML
	private TextArea Texto;
	@FXML
	private TextField Email;
	public Usuario user;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		btnVolver3.setOnMouseClicked((event) -> Atras3());
		subirError.setOnMouseClicked((event) -> Error());

	}

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

	public void Error() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://54.235.194.103/bd_s&fhub", "Conectar",
					"12345678");

			Statement s = conexion.createStatement();

			int admin = (int) Math.random() * 2 + 1;

			ResultSet rs2 = s.executeQuery(
					"SELECT id_usuario FROM usuario where nombre = '" + ControladorLoggin.nombreUsu + "';");

			rs2.next();

			int idUsu = rs2.getInt(1);

			int rs = s.executeUpdate("INSERT INTO `error`(`Email`, `descripcion`, `id_basico`, `id_admin`) VALUES ('"
					+ Email.getText() + "','" + Texto.getText() + "'," + idUsu + ",'" + admin + "' )");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
