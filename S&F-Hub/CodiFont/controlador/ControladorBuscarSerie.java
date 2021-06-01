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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ControladorBuscarSerie implements Initializable {

	// Atributos graficos FXML
	@FXML TableView<ControladorBuscarSerie> tableResuSeries;
	@FXML TableColumn<ControladorBuscarSerie, String> idTitulo;
	@FXML TableColumn<ControladorBuscarSerie, String> idEnlace;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String nombreSerie = ControladorInicio.getbSerie();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://54.235.194.103/bd_s&fhub", "Conectar",
					"12345678");

			Statement s = conexion.createStatement();

			ResultSet rs = s.executeQuery("SELECT Titulo FROM `catalogo` WHERE titulo LIKE '%" + nombreSerie + "%'");
			
			while (rs.next()){
				TableColumn<ControladorBuscarSerie, String> colNombre = new TableColumn<>("Titulo");
				
				tableResuSeries.getColumns().addAll(colNombre);
			}
			// Cerramos Conexion
			conexion.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
