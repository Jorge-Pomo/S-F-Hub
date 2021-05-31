package controlador;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControladorRegistrarPSAdministrador implements Initializable{

	@FXML private TextField txtTitulo;
	@FXML private ImageView imgSP;
	@FXML private TextArea txtPlataformas;
	@FXML private TextArea txtSinopsis;
	@FXML private TextArea txtReparto;
	@FXML private CheckBox checkSerie;
	@FXML private CheckBox checkPelicula;
	@FXML private Button registrar;
	@FXML private Label lblError;
	@FXML private Slider slivaloracion;
	@FXML private TextField txtGenero;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		registrar.setOnMouseClicked((event) -> resgistrar());
	}

	//Registrar Usuario
	private void resgistrar() {
		
		String titulo = txtTitulo.getText();
		Image img = imgSP.getImage();
		String plataformas = txtPlataformas.getText();
		String sinopsis = txtSinopsis.getText();
		String reparto = txtReparto.getText();
		String esPelicula;
		String esSerie;
		int valoracion = (int) slivaloracion.getValue();
		String genero = txtGenero.getText();
		
		if(checkPelicula.isSelected()) {
			esPelicula = "SI";
			esSerie = "NO";
		}else {
			esPelicula = "NO";
			esSerie = "SI";
		}
		
		if(txtTitulo.getText().equals("") || txtPlataformas.getText().equals("") || txtSinopsis.getText().equals("") || txtReparto.getText().equals("")) {
			lblError.setText("Hay campos vacios");
		}else {
			// Conexion BBDD
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conexion = DriverManager.getConnection("jdbc:mysql://54.235.194.103/bd_s&fhub",
						"Conectar", "12345678");

				Statement s = conexion.createStatement();

				int rs = s.executeUpdate(
						"INSERT INTO `catalogo`(`Imagen`, `Titulo`, `plataformas`, `valoracion`, `descripcion`, `genero`, `reparto`, `esSerie`, `esPelicula`) VALUES ('"+ img + "','" + titulo + "','" + plataformas + "','" + valoracion + "','" + sinopsis + "','" + genero + "','" + reparto + "','" + esSerie + "','" + esPelicula + "')");

				// Cerramos Conexion
				conexion.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	
}
