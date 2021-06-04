package controlador;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Base64;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;
import com.sun.javafx.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class ControladorRegistrarPSAdministrador implements Initializable {

	@FXML private TextField txtTitulo;
	@FXML private ImageView imgSP;
	@FXML private Button btnImg;
	@FXML private TextArea txtPlataformas;
	@FXML private TextArea txtSinopsis;
	@FXML private TextArea txtReparto;
	@FXML private CheckBox checkSerie;
	@FXML private CheckBox checkPelicula;
	@FXML private Button registrar;
	@FXML private Label lblError;
	@FXML private Slider slivaloracion;
	@FXML private TextField txtGenero;
	@FXML private ListView listImg;
	@FXML private Button Volver;
	@FXML private Label lblRegistro;

	private String rutaImg;
	private String nombreImg;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		registrar.setOnMouseClicked((event) -> resgistrar());
		btnImg.setOnMouseClicked((event) -> imagen());
		Volver.setOnMouseClicked((event) -> volver());
	}

	// Registrar Usuario
	private void resgistrar() {

		String titulo = txtTitulo.getText();
		Image img = imgSP.getImage();
		String plataformas = txtPlataformas.getText();
		String sinopsis = txtSinopsis.getText();
		String reparto = txtReparto.getText();
		String esPelicula;
		String esSerie;
		int valoracion = (int) slivaloracion.getValue();
		String genero = txtGenero.getText();

		if (checkPelicula.isSelected()) {
			esPelicula = "SI";
			esSerie = "NO";
		} else {
			esPelicula = "NO";
			esSerie = "SI";
		}

		if (txtTitulo.getText().equals("") || txtPlataformas.getText().equals("") || txtSinopsis.getText().equals("")
				|| txtReparto.getText().equals("")) {
			lblError.setText("Hay campos vacios");
		} else {
			// Conexion BBDD
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conexion = DriverManager.getConnection("jdbc:mysql://54.235.194.103/bd_s&fhub", "Conectar",
						"12345678");

				Statement s = conexion.createStatement();

				String cnsulta = "INSERT INTO `catalogo`(`Imagen`, `Titulo`, `plataformas`, `valoracion`, `descripcion`, `genero`, `reparto`, `esSerie`, `esPelicula`, `imgB`) VALUES ('"
						+ this.rutaImg + "','" + titulo + "','" + plataformas + "','" + valoracion + "','" + sinopsis
						+ "','" + genero + "','" + reparto + "','" + esSerie + "','" + esPelicula + "','NULL')";
				System.out.println(cnsulta);
				int rs = s.executeUpdate(cnsulta);

				// IMG
				FileInputStream is = new FileInputStream(this.nombreImg);

				PreparedStatement st = conexion
						.prepareStatement("update catalogo set imgB  = ? WHERE Titulo = '" + titulo + "'");

				st.setBlob(1, is);

				st.execute();
				is.close();
				st.close();

				// Cerramos Conexion
				conexion.close();

				lblRegistro.setOpacity(1);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public void imagen() {
		FileChooser fc = new FileChooser();
		fc.setInitialDirectory(new File("C:\\Users\\DAM\\Pictures"));
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images", "*.*"),
				new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"));
		File selectedFile = fc.showOpenDialog(null);

		if (selectedFile != null) {
			listImg.getItems().add(selectedFile.getName());
		} else {
			lblError.setText("L'arxiu no es valid");
		}

		this.rutaImg = selectedFile.getName();

		Image image = new Image("file:" + selectedFile.getAbsolutePath());

		imgSP.setImage(image);
		this.nombreImg = selectedFile.getAbsolutePath();
	}

	// private void convertImage() throws IOException{
	// String dirName="C:\\";
	// ByteArrayOutputStream baos=new ByteArrayOutputStream(1000);
	// BufferedImage img=ImageIO.read(new File(dirName,"rose.jpg"));
	// ImageIO.write(img, "jpg", baos);
	// baos.flush();
	//
	// String base64String=Base64.encode(baos.toByteArray());
	// baos.close();
	//
	// byte[] bytearray = Base64.decode(base64String);
	//
	// BufferedImage imag=ImageIO.read(new ByteArrayInputStream(bytearray));
	// ImageIO.write(imag, "jpg", new File(dirName,"snap.jpg"));
	// }

	public void volver() {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/GraficosAdministrador.fxml"));

			Parent root = loader.load();
			Stage stage = (Stage) this.Volver.getScene().getWindow();

			stage.setTitle("S&F Hub -- Serie");
			stage.setScene(new Scene(root));
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
