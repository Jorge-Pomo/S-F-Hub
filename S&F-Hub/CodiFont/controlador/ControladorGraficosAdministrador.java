package controlador;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ControladorGraficosAdministrador implements Initializable {

	// Atributos graficos FXML
	
	@FXML private LineChart grfNuevosUsuarios;
	@FXML private BarChart grfSeresBuscadas;

	@FXML private Label lblError;
	@FXML private Button btnRegistrarSP;
	@FXML private Button Salir;
	
	@FXML private ListView lvError;
	
	
	/**
	 * @param dia[] array vacío para almacenar los usuarios registrados diariamente en un rango de 7 días
	 * */
	int dia[] = { 0, 0, 0, 0, 0, 0, 0 };

	/**
	 * <h2>Inicializamos el botón btnRegistrarSP y lo juntamos con su método "ventanaRegistrarSP"</h2>
	 * 
	 * <h2>Nos conectamos a la BBDD</h2>
	 * <p>Consultamos los usuarios añadidos en los ultimos 7 días</p>
	 * <p>Guardamos la consulta en el array día</p>
	 * */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		btnRegistrarSP.setOnMouseClicked((event) -> ventanaRegistrarSP());
		Salir.setOnMouseClicked((event) -> salir());
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://54.235.194.103/bd_s&fhub", "Conectar",
					"12345678");

			Statement s = conexion.createStatement();
			ResultSet rs = s
					.executeQuery("SELECT Fecha, COUNT(Fecha) FROM usuario GROUP BY Fecha ORDER BY Fecha ASC LIMIT 7");

			int i = 0;

			while (rs.next()){
				dia[i] = Integer.parseInt(rs.getString(2));
				i++;
			}
			
			//Consulta Error
			ResultSet conErro = s.executeQuery("SELECT descripcion, id_basico FROM `error`"); 			
			
			while (conErro.next()){
				
				System.out.println(conErro.getString(1));
				lvError.getItems().add(conErro.getInt("id_basico") + ": " + conErro.getString("descripcion"));
			}

		} catch (Exception e) {

		}

		
		//LineChart
		/**
		 * @param grfNuevosUsuarios.setTitle() le ponemos título a la gráfica de líneas
		 * 
		 * <p>Creamos un array con el nombre de cada campo "Día 1..." y la posición del array día que contiene los usuarios registrados por día</p>
		 * 
		 * <p> Añadimos los días a la gráfica </p>
		 * */
		grfNuevosUsuarios.setTitle("Nuevos usuarios diarios");

		//Datos Dias
		XYChart.Series<String, Number> dias = new XYChart.Series<>();
		dias.setName("Nombre Serie");
		dias.getData().addAll(
				new XYChart.Data<>("Dia 1", dia[0]),
				new XYChart.Data<>("Dia 2", dia[1]),
				new XYChart.Data<>("Dia 3", dia[2]),
				new XYChart.Data<>("Dia 4", dia[3]),
				new XYChart.Data<>("Dia 5", dia[4]),
				new XYChart.Data<>("Dia 6", dia[5]),
				new XYChart.Data<>("Dia 7", dia[6]));

		grfNuevosUsuarios.getData().addAll(dias);
		ObservableList<XYChart.Series<String, Number>> data2 = FXCollections.observableArrayList();
		data2.addAll(dias);


		//Barchart
		grfSeresBuscadas.setTitle("Series más buscadas");

		//Datos Semanas
		XYChart.Series<String, Number> series1 = new XYChart.Series<>();
		series1.setName("nombre Serie");
		series1.getData().addAll(
				new XYChart.Data<>("Semana 1", 10),
				new XYChart.Data<>("Semana 2", 13),
				new XYChart.Data<>("Semana 3", 97));

		XYChart.Series<String, Number> series2 = new XYChart.Series();
		series2.setName("America");
		series2.getData().addAll(
				new XYChart.Data("Semana 1", 31),
				new XYChart.Data("Semana 2", 15),
				new XYChart.Data("Semana 3", 91));

		XYChart.Series<String, Number> series3 = new XYChart.Series();
		series3.setName("Asia");
		series3.getData().addAll(
				new XYChart.Data("Semana 1", 63),
				new XYChart.Data("Semana 2", 94),
				new XYChart.Data("Semana 3", 40));

		XYChart.Series<String, Number> series4 = new XYChart.Series();
		series4.setName("Europe");
		series4.getData().addAll(
				new XYChart.Data("Semana 1", 20),
				new XYChart.Data("Semana 2", 40),
				new XYChart.Data("Semana 3", 73));

		XYChart.Series<String, Number> series5 = new XYChart.Series();
		series5.setName("Oceania");
		series5.getData().addAll(
				new XYChart.Data("Semana 1", 2),
				new XYChart.Data("Semana 2", 6),
				new XYChart.Data("Semana 3", 34));

		//Guardamos los datos los datos
		grfSeresBuscadas.getData().addAll(series1, series2, series3, series4, series5);

		ObservableList<XYChart.Series<String, Number>> data = FXCollections.observableArrayList();
		data.addAll(series1, series2, series3, series4, series5);
	}
	
	/**
	 * <h2>Funcionalidad del botón "btnRegistrarSP"</h2>
	 * 
	 * */
	public void ventanaRegistrarSP() {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/RegistrarPSAdministrador.fxml"));

			Parent root = loader.load();
			Stage stage = (Stage) this.btnRegistrarSP.getScene().getWindow();

			stage.setTitle("S&F Hub -- Loggin");
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
	 *                       abra la ventana administrador
	 * 
	 * @param stage.setTitle insertamos el título de la página
	 */
	
	
	public void salir() {
		
		try {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Administrador.fxml"));

		Parent root = loader.load();
		Stage stage = (Stage) this.Salir.getScene().getWindow();
		

		stage.setTitle("S&F Hub -- Serie");
		stage.setScene(new Scene(root));
		stage.show();

	} catch (Exception e) {
		e.printStackTrace();
	}
	}
}