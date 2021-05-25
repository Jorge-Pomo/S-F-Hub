package modelo;

public class Usuario {

	// Atributos

	private String Nombre;
	private String Apellidos;
	private String Email;
	private String Contraseña;
	private int Edad;
	private boolean Politicaprovacidad;
	private boolean Publicidad;

	// Constructores

	public Usuario(String nombre, String apellidos, String email, String contraseña, int edad,
			boolean politicaprovacidad, boolean publicidad) {

		Nombre = nombre;
		Apellidos = apellidos;
		Email = email;
		Contraseña = contraseña;
		Edad = edad;
		Politicaprovacidad = politicaprovacidad;
		Publicidad = publicidad;
	}

	// Getters & Setters

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getContraseña() {
		return Contraseña;
	}

	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}

	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}

	public boolean isPoliticaprovacidad() {
		return Politicaprovacidad;
	}

	public void setPoliticaprovacidad(boolean politicaprovacidad) {
		Politicaprovacidad = politicaprovacidad;
	}

	public boolean isPublicidad() {
		return Publicidad;
	}

	public void setPublicidad(boolean publicidad) {
		Publicidad = publicidad;
	}

	// Metodos

	public void registrar() {

	}

	public void iniciarSesion() {

	}

	public void mostrarContraseña() {

	}

	public void crearAdministrador() {

	}

	public void mostrarDatos() {

	}

	public void ordenarPorGenero() {

	}

}
