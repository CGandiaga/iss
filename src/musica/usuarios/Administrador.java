package musica.usuarios;

public class Administrador extends Usuario {

	/**Constructor que crea una instancia de administrador
	 * 
	 * @param login del usuario (ÚNICO)
	 * @param clave del usuario (en claro)
	 * @param nombre del usuario*/
	public Administrador(String login, String clave, String nombre) {
		super(login, clave, nombre);
	}	
	
	/**Método que devuelve una descripción del administrador
	 * 
	 * @return descripción */
	public String toString() {
		return super.toString() 
			+ "\n Tipo: administrador";
	}
}
