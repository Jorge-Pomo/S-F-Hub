package controlador;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

public class ControladorGraficosAdministrador implements Initializable {

	// Atributos graficos FXML
	@FXML
	private LineChart grfNuevosUsuarios;

	@FXML
	private BarChart grfSeriesBuscadas;
	@FXML
	private CategoryAxis xAxis;

	@FXML
	private Label lblError;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();

		xAxis.setLabel("Series más vistas");
		yAxis.setLabel("Numero de usuarios");

		grfSeriesBuscadas.setTitle("Series más buscadas");

		XYChart.Series series1 = new XYChart.Series();
		series1.setName("nombre Serie");
		series1.getData().add(new XYChart.Data("1800", 107));
		series1.getData().add(new XYChart.Data("1900", 133));
		series1.getData().add(new XYChart.Data("2008", 973));
		XYChart.Series series2 = new XYChart.Series();
		series2.setName("America");
		series2.getData().add(new XYChart.Data("1800", 31));
		series2.getData().add(new XYChart.Data("1900", 156));
		series2.getData().add(new XYChart.Data("2008", 914));
		XYChart.Series series3 = new XYChart.Series();
		series3.setName("Asia");
		series3.getData().add(new XYChart.Data("1800", 635));
		series3.getData().add(new XYChart.Data("1900", 947));
		series3.getData().add(new XYChart.Data("2008", 4054));
		XYChart.Series series4 = new XYChart.Series();
		series4.setName("Europe");
		series4.getData().add(new XYChart.Data("1800", 203));
		series4.getData().add(new XYChart.Data("1900", 408));
		series4.getData().add(new XYChart.Data("2008", 732));
		XYChart.Series series5 = new XYChart.Series();
		series5.setName("Oceania");
		series5.getData().add(new XYChart.Data("1800", 2));
		series5.getData().add(new XYChart.Data("1900", 6));
		series5.getData().add(new XYChart.Data("2008", 34));
		
		grfSeriesBuscadas.getData().addAll(series1, series2, series3, series4, series5);
	}

}
