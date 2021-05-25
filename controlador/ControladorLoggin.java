package controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorLoggin implements Initializable{

	//Atributos graficos FXML
	@FXML
	private Label lblUsuario;
	@FXML
	private TextField txtUsuario;
	@FXML
	private Label lblContraseña;
	@FXML
	private PasswordField passwordContraseña;
	
	@FXML
	private Button btnIniciarSesion;
	@FXML
	private Button btnRegistrarse;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//Evento botones
//		btnRegistrarse.setOnAction((event) -> registrarse(event));
		btnRegistrarse.setOnMouseClicked((event) -> registrarse(event));
	
	}
	
	//Metodos
	private void registrarse(MouseEvent event){
		try {
			String fxml = "vista/Registrarse.fxml";
			
	        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
	       
	        Parent root = loader.load();
	        
	        ControladorRegistrarse controlador = loader.getController();
	        
	        Scene scene = new Scene(root); 
	        Stage stage = new Stage(); 
	        
	        stage.initModality(Modality.APPLICATION_MODAL);
	        stage.setScene(scene);
	        
	        stage.show();
	        
	        stage.showAndWait();
	        
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	

}
