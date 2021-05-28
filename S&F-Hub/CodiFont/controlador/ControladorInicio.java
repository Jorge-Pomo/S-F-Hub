package controlador;

import java.net.URL;
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
	@FXML
	private TextField txtBuscarSerie;
	@FXML
	private Button btnSyP;
	@FXML
	private Button btnSyP2;
	@FXML
	private Button btnSyP3;
	@FXML
	private Button btnSyP4;
	@FXML
	private Button btnSyP5;
	@FXML
	private Button btnSyP6;
	@FXML
	private Button btnSyP7;
	@FXML
	private Button btnSyP8;
	@FXML
	private Button btnSyP9;
	@FXML
	private Button btnSyP10;
	@FXML
	private Button btnSyP11;
	@FXML
	private Button btnSyP12;
	@FXML
	private Button btnSyP13;
	@FXML
	private Button btnSyP14;
	@FXML
	private Button btnSyP15;
	@FXML
	private Button btnLista;
	@FXML
	private Button btnAyuda;
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		btnSyP.setOnMouseClicked((event) -> buscarSerie());
		btnSyP2.setOnMouseClicked((event) -> buscarSerie());
		btnSyP3.setOnMouseClicked((event) -> buscarSerie());
		btnSyP4.setOnMouseClicked((event) -> buscarSerie());
		btnSyP5.setOnMouseClicked((event) -> buscarSerie());
		btnSyP6.setOnMouseClicked((event) -> buscarSerie());
		btnSyP7.setOnMouseClicked((event) -> buscarSerie());
		btnSyP8.setOnMouseClicked((event) -> buscarSerie());
		btnSyP9.setOnMouseClicked((event) -> buscarSerie());
		btnSyP10.setOnMouseClicked((event) -> buscarSerie());
		btnSyP11.setOnMouseClicked((event) -> buscarSerie());
		btnSyP12.setOnMouseClicked((event) -> buscarSerie());
		btnSyP13.setOnMouseClicked((event) -> buscarSerie());
		btnSyP14.setOnMouseClicked((event) -> buscarSerie());
		btnSyP15.setOnMouseClicked((event) -> buscarSerie());
		btnLista.setOnMouseClicked((event) -> crearLista());
		btnAyuda.setOnMouseClicked((event) -> soporteTecnico());


	}

	private void buscarSerie() {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/PyS.fxml"));

			Parent root = loader.load();
			Stage stage = (Stage) this.btnSyP.getScene().getWindow();
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

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		private void crearLista() {

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
			private void soporteTecnico() {

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

}
