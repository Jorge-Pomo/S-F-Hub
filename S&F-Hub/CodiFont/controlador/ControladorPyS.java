package controlador;

/**
 * @author Jorge, Diego, Fran
 * 
 * @versión 1.0.0
 * */

import java.io.IOException;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * <h2>Ventana info Peliculas y Serires</h2>
 * <p>Ventana con toda la informacion de las Peliculas y lasa Serties</p>
 * */
public class ControladorPyS implements Initializable {

	// Atributos graficos FXML
		@FXML private Button btnVolver;
		@FXML private Button AñadirALista;
		@FXML private TextField Recibir;

		@FXML private Label lblTitulo;
		@FXML private Label lblSinposis;
		@FXML private Label lblReparto;
			
		@FXML private ImageView imgPrincipal;
		@FXML private ImageView img0;
		@FXML private ImageView img1;
		@FXML private ImageView img2;
		@FXML private ImageView img3;
		@FXML private ImageView img4;
		@FXML private ImageView img5;
		@FXML private ImageView img6;
			
		@FXML private Label Titulo;
		@FXML
		public void recibirparametros ( String texto) {
		Titulo.setText(texto);	
			
		}

	private String reparto;
	private String plataformas;

	/**
	 * @see switch Inicializamos las img segun la serie/Pelicula elegida
	 * 
	 * @param image 1 creamos objeto d etipo Image con la img que tiene que cargar.
	 * 
	 * @see try hacemos una consulta, pidiendo: titulo, descripcion, reparto y las
	 *      plataformas, y lo guardamos en diferentes atributos para utilizarlos más
	 *      tarde
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String nombreImg = "";

		switch (ControladorInicio.getId()) {
		case 1:
			nombreImg = "theMandaloria.jpg";
			break;

		case 2:
			nombreImg = "BeavisandButt-Head.jpg";
			break;
		case 3:
			nombreImg = "TheMachinist.jpg";
			break;
		case 9:
			nombreImg = "Shooter.jpg";
			break;
		case 10:
			nombreImg = "TheBlacklist.jpg";
			break;
		case 12:
			nombreImg = "Elseñordelosanillos-comunidaddelanillo.jpg";
			break;
		case 13:
			nombreImg = "Vikingos.jpg";
			break;
		case 14:
			nombreImg = "PeakyBlinders.jpg";
			break;
		case 15:
			nombreImg = "Lacasadepapel.jpg";
			break;
		case 16:
			nombreImg = "Django.jpg";
			break;
		case 19:
			nombreImg = "Lupin.jpg";
			break;
		case 20:
			nombreImg = "TheJoker.jpg";
			break;
		case 21:
			nombreImg = "Narcos.jpg";
			break;
		case 22:
			nombreImg = "Django.jpg";
			break;
		case 31:
			nombreImg = "Bob'sBurguer.jpg";
			break;
		}

		Image image1 = new Image(getClass().getResourceAsStream("../vista/img/" + nombreImg));
		imgPrincipal.setImage(image1);

		// Tamaño de la img principal
		imgPrincipal.setX(30);
		imgPrincipal.setY(30);

		btnVolver.setOnMouseClicked((event) -> Atras());
		AñadirALista.setOnMouseClicked((event) -> Añadir());

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://54.235.194.103/bd_s&fhub", "Conectar",
					"12345678");

			Statement s = conexion.createStatement();
			ResultSet rs = s.executeQuery(
					"SELECT Titulo, descripcion, reparto, plataformas FROM `catalogo` WHERE id_catalogo = "
							+ ControladorInicio.getId());

			// Cargamos los resultados de la consulta
			while (rs.next()) {
				lblTitulo.setText(rs.getString(1));
				lblSinposis.setText(rs.getString(2));
				reparto = rs.getString(3);
				plataformas = rs.getString(4);
			}

			// Formato texto -- Label Reparto
			reparto = reparto.replace("-", " ");
			reparto = reparto.replace(":", ", ");

			lblReparto.setText(reparto);

			// Img Plataformas
			String[] plataforma = plataformas.split(":");

			for (int i = 0; i < plataforma.length; i++) {
				plataforma[i] = plataforma[i].toLowerCase();
				imgPlataforma(plataforma[i], i);
			}

			// System.out.println(ControladorInicio.getId());
			//
			// while (rs.next()) {
			// System.out.println(rs.getString(1) + " " + rs.getString(2) + " " +
			// rs.getString(3));
			// }

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
	 *                       abra la ventana Inicio
	 * 
	 * @param stage.setTitle insertamos el título de la página
	 */
	public void Atras() {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Inicio2.fxml"));

			Parent root = loader.load();
			Stage stage = (Stage) this.btnVolver.getScene().getWindow();

			stage.setTitle("S&F Hub -- Peliculas y Series");
			stage.setScene(new Scene(root));
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <p>
	 * Funcionalidad Boton añadir, añadimos serie a mi lista
	 * </p>
	 * 
	 * @param loader         especificamos donde se encuentra la ventana a cargar
	 * 
	 * @param root           cargamos la ventana
	 * 
	 * @param stage          indicamos la funcionalidad del botón, en este caso que
	 *                       abra la ventana Inicio
	 * 
	 * @param stage.setTitle insertamos el título de la página
	 */
	private void Añadir() {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/MiLista.fxml"));

			Parent root = loader.load();
			Stage stage = (Stage) this.AñadirALista.getScene().getWindow();

			stage.setTitle("S&F Hub -- mi Lista");
			stage.setScene(new Scene(root));
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * <p>
	 * Cargamos las img de las plataformas en las que se puede reproducir la serie
	 * </p>
	 * 
	 * @param nombrePlataforma guardamos el nombre de la plataforma
	 * @param img              guardamos el numero de la casilla en la que se
	 *                         mostrara la imagen
	 * 
	 * @param imag1            creamos un objeto de tipo Image, con la imagen de la
	 *                         plataforma
	 * 
	 * @see switch Gracias al switch cargamos solo los espacios de imagen que hacenb
	 *      falta para esa serie
	 */
	private void imgPlataforma(String nombrePlataforma, int img) {
		Image image1 = new Image(
				getClass().getResourceAsStream("../vista/img/plataformas/" + nombrePlataforma + ".png"));

		switch (img) {
		case 0:
			img0.setImage(image1);
			break;
		case 1:
			img1.setImage(image1);
			break;
		case 2:
			img2.setImage(image1);
			break;
		case 3:
			img3.setImage(image1);
			break;
		case 4:
			img4.setImage(image1);
			break;
		case 5:
			img5.setImage(image1);
			break;
		case 6:
			img6.setImage(image1);
			break;
		}

	}

}