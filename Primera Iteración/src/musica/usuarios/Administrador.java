package musica.usuarios;

public class Administrador extends Usuario {

	/**Constructor que crea una instancia de administrador
	 * 
	 * @param login del usuario (�NICO)
	 * @param clave del usuario (en claro)
	 * @param nombre del usuario*/
	public Administrador(String login, String clave, String nombre) {
		super(login, clave, nombre);
	}	
	
	/**M�todo que devuelve una descripci�n del administrador
	 * 
	 * @return descripci�n */
	public String toString() {
		return super.toString() 
			+ "\n Tipo: administrador";
	}
}
