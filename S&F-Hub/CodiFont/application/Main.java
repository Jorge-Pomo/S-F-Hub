package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {

	public void start(Stage primaryStage) {

		try {
			String fxml = "vista/SFHub.fxml";

			// Cargar la ventana
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(fxml));

			// Cargar la Scene
			Scene scene = new Scene(root);

			// Asignar icono de la aplicación
			primaryStage.getIcons().add(new Image(getClass().getResource("/vista/img/Captura.png").toExternalForm()));

			// Asignar propiedades al Stage
			primaryStage.setTitle("S&Fhub");
			primaryStage.setResizable(false);

			// Asignar la scene y mostrar
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
