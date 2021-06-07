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
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import prue.Person;

public class ControladorBuscarSerie implements Initializable{

	// Atributos graficos FXML
	@FXML private ListView lvSeriesB;
	
	/**
	 * <h2> Tabla con el resultado de la búsqueda sql "Buscar Series"</h2>
	 * @param nombreSerie texto del campo de texto de la ventana Inicio2, contiene el nombre a buscar
	 * 
	 * @see Nos conectamos a la BBDD y mostramos los errores
	 * 
	 * 
	 * */

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		 String nombreSerie = ControladorInicio.getbSerie();
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conexion = DriverManager.getConnection("jdbc:mysql://54.235.194.103/bd_s&fhub", "Conectar",
						"12345678");

				Statement s = conexion.createStatement();

				ResultSet rs = s.executeQuery("SELECT Titulo FROM `catalogo` WHERE titulo LIKE '%" + nombreSerie + "%'");
				
				while (rs.next()){
					
					System.out.println(rs.getString(1));
					lvSeriesB.getItems().add(rs.getString(1));
				}
				
				// Cerramos Conexion
				conexion.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		
	}
	

	
}
