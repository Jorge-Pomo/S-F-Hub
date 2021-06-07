package controlador;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladorInicio implements Initializable {

	// Atributos graficos FXML
	
	@FXML private TextField txtBuscarSerie;
	@FXML private Button btnBuscarSerie;
	@FXML private Button btnBobs;
	@FXML private Button btnSyP2;
	@FXML private Button btnSyP3;
	@FXML private Button btnSyP4;
	@FXML private Button btnSyP5;
	@FXML private Button btnSyP6;
	@FXML private Button btnSyP7;
	@FXML private Button btnSyP8;
	@FXML private Button btnSyP9;
	@FXML private Button btnSyP10; 
	@FXML private Button btnSyP11;
	@FXML private Button btnSyP12;
	@FXML private Button btnSyP13;
	@FXML private Button btnSyP14;
	@FXML private Button btnSyP15;
	@FXML private Button btnLista;
	@FXML private Button btnAyuda;
	@FXML private Button Salir;

	public static String bSerie;
	public static int id;
	
	//Getters && Setters
	public static String getbSerie() {
		return bSerie;
	}

	public void setbSerie(String bSerie) {
		this.bSerie = bSerie;
	}
	
	public static int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * <h2>Configuración de los Botones "EntrarPyS , Lista, Soporte, BuscarSerie y Volver"</h2> 
	 * 
	 * anidamos el botón al método
	 * 
	 */

	// Metodos
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		btnBobs.setOnMouseClicked((event) -> entrarSerie(31));
		btnSyP2.setOnMouseClicked((event) -> entrarSerie(1));
		btnSyP3.setOnMouseClicked((event) -> entrarSerie(2));
		btnSyP4.setOnMouseClicked((event) -> entrarSerie(3));
		btnSyP5.setOnMouseClicked((event) -> entrarSerie(9));
		btnSyP6.setOnMouseClicked((event) -> entrarSerie(10));
		btnSyP7.setOnMouseClicked((event) -> entrarSerie(12));
		btnSyP8.setOnMouseClicked((event) -> entrarSerie(13));
		btnSyP9.setOnMouseClicked((event) -> entrarSerie(14));
		btnSyP10.setOnMouseClicked((event) -> entrarSerie(15));
		btnSyP11.setOnMouseClicked((event) -> entrarSerie(16));
		btnSyP12.setOnMouseClicked((event) -> entrarSerie(19));
		btnSyP13.setOnMouseClicked((event) -> entrarSerie(20));
		btnSyP14.setOnMouseClicked((event) -> entrarSerie(21));
		btnSyP15.setOnMouseClicked((event) -> entrarSerie(22));

		btnLista.setOnMouseClicked((event) -> crearLista());
		btnAyuda.setOnMouseClicked((event) -> soporteTecnico());

		btnBuscarSerie.setOnMouseClicked((event) -> buscarSerie());
		Salir.setOnMouseClicked((event) -> Salir());
		
	}

		/**
		 * 
		 * @param num 	     Recoge el id de cada pelicula
		 * 
		 * @param stage      Cada uno de los botones para entrar en las serues y las peliculas
		 * 
		 */
	
	
	public void entrarSerie(int num) {
		try {
			id = num;
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/PyS.fxml"));

			Parent root = loader.load();
			Stage stage = (Stage) this.btnBobs.getScene().getWindow();
			Stage stage2 = (Stage) this.btnSyP2.getScene().getWindow();
			Stage stage3 = (Stage) this.btnSyP3.getScene().getWindow();
			Stage stage4 = (Stage) this.btnSyP4.getScene().getWindow();
			Stage stage5 = (Stage) this.btnSyP5.getScene().getWindow();
			Stage stage6 = (Stage) this.btnSyP6.getScene().getWindow();
			Stage stage7 = (Stage) this.btnSyP7.getScene().getWindow();
			Stage stage8 = (Stage) this.btnSyP8.getScene().getWindow();
			Stage stage9 = (Stage) this.btnSyP9.getScene().getWindow();
			Stage stage10 = (Stage) this.btnSyP10.getScene().getWindow();
			Stage stage11 = (Stage) this.btnSyP11.getScene().getWindow();
			Stage stage12 = (Stage) this.btnSyP12.getScene().getWindow();
			Stage stage13 = (Stage) this.btnSyP13.getScene().getWindow();
			Stage stage14 = (Stage) this.btnSyP14.getScene().getWindow();
			Stage stage15 = (Stage) this.btnSyP15.getScene().getWindow();

			stage.setTitle("S&F Hub -- Serie");
			stage.setScene(new Scene(root));
			stage.show();

			System.out.println(num);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @param loader         especificamos donde se encuentra la ventana a cargar
	 * 
	 * @param root           cargamos la ventana
	 * 
	 * @param stage          indicamos la funcionalidad del botón, en este caso que
	 *                       abra la ventana MiLista
	 * 
	 * @param stage.setTitle insertamos el título de la página
	 */
	
	public void crearLista() {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/MiLista.fxml"));

			Parent root = loader.load();
			Stage stage = (Stage) this.btnLista.getScene().getWindow();

			stage.setTitle("S&F Hub -- Lista");
			stage.setScene(new Scene(root));
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param loader         especificamos donde se encuentra la ventana a cargar
	 * 
	 * @param root           cargamos la ventana
	 * 
	 * @param stage          indicamos la funcionalidad del botón, en este caso que
	 *                       abra la ventana Soporte
	 * 
	 * @param stage.setTitle insertamos el título de la página
	 */
	
	public void soporteTecnico() {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/SoporteTc.fxml"));

			Parent root = loader.load();
			Stage stage = (Stage) this.btnAyuda.getScene().getWindow();

			stage.setTitle("S&F Hub -- Ayuda");
			stage.setScene(new Scene(root));
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void buscarSerie() {
		
		setbSerie(txtBuscarSerie.getText());
		bSerie = txtBuscarSerie.getText();
		System.out.println(getbSerie());
		System.out.println();
		try {			
			//Abrimos pestaña
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/buscadorSerie.fxml"));

			Parent root = (Parent)loader.load();
			Stage stage =new Stage();

			stage.setTitle("S&F Hub -- Ayuda");
			stage.setScene(new Scene(root));
			stage.show();
			
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	
	/**
	 * @param loader         especificamos donde se encuentra la ventana a cargar
	 * 
	 * @param root           cargamos la ventana
	 * 
	 * @param stage          indicamos la funcionalidad del botón, en este caso que
	 *                       abra la ventana Login
	 * 
	 * @param stage.setTitle insertamos el título de la página
	 */
	
	public void Salir() {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Login.fxml"));

			Parent root = loader.load();
			Stage stage = (Stage) this.Salir.getScene().getWindow();

			stage.setTitle("S&F Hub -- Ayuda");
			stage.setScene(new Scene(root));
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
