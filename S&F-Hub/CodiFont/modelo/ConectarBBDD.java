package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConectarBBDD {

	// Atributos
	private String url_BDD;
	private String usuario;
	private String contraseña;
	private String consulta;

	// Constructores
	public ConectarBBDD() {
		
	}
	
	public ConectarBBDD(String url_BDD, String usuario, String contraseña, String consulta) {
		this.url_BDD = url_BDD;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.consulta = consulta;
	}

	// Getters & Setters
	public String getUrl_BDD() {
		return url_BDD;
	}

	public void setUrl_BDD(String url_BDD) {
		this.url_BDD = url_BDD;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getConsulta() {
		return consulta;
	}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}

	// Metodos
	public void connectar() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://54.235.194.103:80/bd_s&fhub","root","12345678");
		
			Statement  s = conexion.createStatement();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
