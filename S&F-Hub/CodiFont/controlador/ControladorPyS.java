package controlador;

import java.awt.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorPyS implements Initializable {

	@FXML private Button btnVolver;
	@FXML private Button AñadirALista;
	@FXML private Label Titulo;

	ControladorPyS ControladorPyS;

	@FXML
	public void recibirparametros(String texto) {
		Titulo.setText(Titulo.getText());

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		btnVolver.setOnMouseClicked((event) -> Atras());
		ControladorPyS = this;
		AñadirALista.setOnMouseClicked((event) -> {
			try {
				Añadir();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

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

	private void Añadir() throws IOException {

		try {

			Stage stage2 = new Stage();

			FXMLLoader loader = new FXMLLoader();

			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("MiLista.fxml"));

			ControladorMiLista ControladorMiListaInstancia = (ControladorMiLista) loader.getController();

			ControladorMiListaInstancia.reciberparametros(ControladorPyS, Titulo.getText());

			Scene scene = new Scene(root);
			stage2.setScene(scene);
			stage2.alwaysOnTopProperty();
			stage2.initModality(Modality.APPLICATION_MODAL);
			stage2.show();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
