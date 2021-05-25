package modelo;

public abstract class Contenido {

	// Atributos

	private String Nombre;
	private String Genero;

	// Constructores

	public Contenido(String Nombre, String Genero) {

		this.Nombre = Nombre;
		this.Genero = Genero;

	}

	// Getters & setters

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getGenero() {
		return Genero;
	}

	public void setGenero(String genero) {
		Genero = genero;
	}
	
	//Metodos
	
	public void añadirContenido() {
		
	}
	
	public void DescargarContenido() {
		
	}

	public void buscarSeriePelicula() {
	
	}
	

}
