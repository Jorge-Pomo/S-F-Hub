package modelo;

public class Usuario {

	// Atributos

	private String nombre;
	private String apellidos;
	private String email;
	private String contrase�a;
	private int edad;
	private boolean politicaprovacidad;
	private boolean publicidad;

	// Constructores

	public Usuario(String nombre, String apellidos, String email, String contrase�a, int edad,
			boolean politicaprovacidad, boolean publicidad) {

		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.contrase�a = contrase�a;
		this.edad = edad;
		this.politicaprovacidad = politicaprovacidad;
		this.publicidad = publicidad;
	}

	// Getters & Setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean isPoliticaprovacidad() {
		return politicaprovacidad;
	}

	public void setPoliticaprovacidad(boolean politicaprovacidad) {
		this.politicaprovacidad = politicaprovacidad;
	}

	public boolean isPublicidad() {
		return publicidad;
	}

	public void setPublicidad(boolean publicidad) {
		this.publicidad = publicidad;
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
