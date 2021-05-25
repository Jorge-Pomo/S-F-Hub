package modelo;

public class Usuario {

	// Atributos

	private String Nombre;
	private String Apellidos;
	private String Email;
	private String Contrase�a;
	private int Edad;
	private boolean Politicaprovacidad;
	private boolean Publicidad;

	// Constructores

	public Usuario(String nombre, String apellidos, String email, String contrase�a, int edad,
			boolean politicaprovacidad, boolean publicidad) {

		Nombre = nombre;
		Apellidos = apellidos;
		Email = email;
		Contrase�a = contrase�a;
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

	public String getContrase�a() {
		return Contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		Contrase�a = contrase�a;
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

	public void mostrarContrase�a() {

	}

	public void crearAdministrador() {

	}

	public void mostrarDatos() {

	}

	public void ordenarPorGenero() {

	}

}
