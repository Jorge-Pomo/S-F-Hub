package controlador;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;



import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import prue.Person;

public class ControladorBuscarSerie implements Initializable{

	// Atributos graficos FXML
	@FXML private TableView tableResuSeries;
	@FXML private TableColumn idTitulo;
	@FXML private TableColumn idEnlace;
	
	@FXML private Button btnBuscar;
	
	/**
	 * <h2> Tabla con el resultado de la busqueda sql "Buscar Series"</h2>
	 * @param nombreSerie texto del campo de texto de la ventana Inicio2, contiene el nombre a buscar
	 * 
	 * <p>Nos conectamos a la BBDD</p>
	 * <p>Mostramos contenido </p>
	 * */

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Stage primaryStage = (Stage) this.btnBuscar.getScene().getWindow();
		btnBuscar.setOnMouseClicked((event) -> start(primaryStage));
	}
	
	 public void start(Stage primaryStage) {

		 String nombreSerie = ControladorInicio.getbSerie();
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conexion = DriverManager.getConnection("jdbc:mysql://54.235.194.103/bd_s&fhub", "Conectar",
						"12345678");

				Statement s = conexion.createStatement();

				ResultSet rs = s.executeQuery("SELECT Titulo FROM `catalogo` WHERE titulo LIKE '%" + nombreSerie + "%'");
				
				Object [] fila = new Object[2];
				
				while (rs.next()){
					TableColumn<serie, String> idTitulo = new TableColumn<>("Titulo");
					idTitulo.setCellValueFactory(new PropertyValueFactory<>("Titulo"));
					
					TableColumn<Person, String> idEnlace = new TableColumn<>("Enlace");
					idEnlace.setCellValueFactory(new PropertyValueFactory<>("enlace"));
					
					tableResuSeries.getColumns().add(idTitulo);
					tableResuSeries.getColumns().add(idEnlace);
					
					tableResuSeries.getItems().add(new serie(rs.getString(1), "jg")); 
					
					System.out.println(rs.getString(1));
					
					VBox vbox = new VBox(tableResuSeries);

				    Scene scene = new Scene(vbox);

				    primaryStage.setScene(scene);

				    primaryStage.show();
				}
				
				// Cerramos Conexion
				conexion.close();
			}catch(Exception e){
				e.printStackTrace();
			}
	  }
	
}
