package controlador;

import java.io.IOException;
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorPyS implements Initializable {

	@FXML private Button btnVolver;
	@FXML private Button AñadirALista;
	@FXML private TextField Recibir;

	@FXML private Label lblTitulo;
	@FXML private Label lblSinposis;
	@FXML private Label lblReparto;
	
	@FXML private ImageView imgPrincipal;
	
	@FXML private Label Titulo;
	@FXML
	public void recibirparametros ( String texto) {
	Titulo.setText(texto);	
		
	}

	private String reparto;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String nombreImg =  "";
		
		switch (ControladorInicio.getId()) {
		case 1:
			nombreImg = "theMandaloria.jpg";
			break;

		case 2:
			nombreImg = "BeavisandButt-Head.jpg";
			break;
		case 3:
			nombreImg = "TheMachinist.jpg";
			break;
		case 9:
			nombreImg = "Shooter.jpg";
			break;
		case 10:
			nombreImg = "TheBlacklist.jpg";
			break;
		case 12:
			nombreImg = "Elseñordelosanillos-comunidaddelanillo.jpg";
			break;
		case 13:
			nombreImg = "Vikingos.jpg";
			break;
		case 14:
			nombreImg = "PeakyBlinders.jpg";
			break;
		case 15:
			nombreImg = "Lacasadepapel.jpg";
			break;
		case 16:
			nombreImg = "Django.jpg";
			break;
		case 19:
			nombreImg = "Lupin.jpg";
			break;
		case 20:
			nombreImg = "TheJoker.jpg";
			break;
		case 21:
			nombreImg = "Narcos.jpg";
			break;
		case 22:
			nombreImg = "Django.jpg";
			break;
		case 31:
			nombreImg = "Bob'sBurguer.jpg";
			break;
		}
		
		Image image1 = new Image(getClass().getResourceAsStream("../vista/img/" + nombreImg));
		imgPrincipal.setImage(image1);
		
		imgPrincipal.setX(30);
		imgPrincipal.setY(30);
		
		btnVolver.setOnMouseClicked((event) -> Atras());
		AñadirALista.setOnMouseClicked((event) -> Añadir());

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://54.235.194.103/bd_s&fhub", "Conectar",
					"12345678");

			Statement s = conexion.createStatement();
			ResultSet rs = s.executeQuery("SELECT Titulo, descripcion, reparto FROM `catalogo` WHERE id_catalogo = " + ControladorInicio.getId());

			while(rs.next()) {
				lblTitulo.setText(rs.getString(1));
				lblSinposis.setText(rs.getString(2));
				reparto = rs.getString(3);
			}
			
			reparto = reparto.replace("-", " ");
			reparto = reparto.replace(":", "\n");
			
			lblReparto.setText(reparto);
			
			System.out.println(ControladorInicio.getId());
			
			while (rs.next()){
				
				System.out.println (rs.getString(1) + " "+rs.getString(2)+ " "
				+rs.getString(3));
				
				}
			
		} catch (Exception e) {
			e.printStackTrace();
	
		}
	}

	public void Atras() {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Inicio2.fxml"));

			Parent root = loader.load();
			Stage stage = (Stage) this.btnVolver.getScene().getWindow();

			stage.setTitle("S&F Hub -- Serie");
			stage.setScene(new Scene(root));
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void Añadir() {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/MiLista.fxml"));

			Parent root = loader.load();
			Stage stage = (Stage) this.AñadirALista.getScene().getWindow();

			stage.setTitle("S&F Hub -- Serie");
			stage.setScene(new Scene(root));
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}