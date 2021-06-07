package controlador;

/**
 * @author Jorge, Diego, Fran
 * 
 * @versión 1.0.0
 * */

public class serie {

	private String titulo = null;
    private String link = null;

    public serie() {
    }

    public serie(String firstName, String lastName) {
        this.titulo = firstName;
        this.link = lastName;
    }

    public String getFirstName() {
        return titulo;
    }

    public void setFirstName(String firstName) {
        this.titulo = firstName;
    }

    public String getLastName() {
        return link;
    }

    public void setLastName(String lastName) {
        this.link = lastName;
    }
	
}
