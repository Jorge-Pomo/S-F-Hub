package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

	public void start(Stage primaryStage) {

		
		/*
		 * <h2>Cargamos la ventana Loggin como principal al abrir la app.</h2>
		 * 
		 */
		try {
			String fxml = "vista/GraficosAdministrador.fxml";

			// Cargar la ventana
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(fxml));

			// Cargar la Scene
			Scene scene = new Scene(root);

			// Asignar icono de la aplicación
			primaryStage.getIcons().add(new Image(getClass().getResource("/vista/img/Captura.png").toExternalForm()));

			// Asignar propiedades al Stage
			primaryStage.setTitle("S&Fhub -- Loggin");
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
