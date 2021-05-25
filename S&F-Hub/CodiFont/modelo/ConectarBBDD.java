package modelo;

public class ConectarBBDD {

	// Atributos

	private String url_BDD;
	private String usuario;
	private String contrase�a;
	private String consulta;

	// Constructores

	public ConectarBBDD(String url_BDD, String usuario, String contrase�a, String consulta) {

		this.url_BDD = url_BDD;
		this.usuario = usuario;
		this.contrase�a = contrase�a;
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

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public String getConsulta() {
		return consulta;
	}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}

	// Metodos

	public void leerConsulta() {

	}

}
