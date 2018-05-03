package musica.usuarios;

public class Anunciante extends Usuario {

	/**Constructor que crea una instancia de anunciante
	 * 
	 * @param login del usuario (�NICO)
	 * @param clave del usuario (en claro)
	 * @param nombre del usuario*/
	
	public Anunciante(String login, String clave, String nombre) {
		super(login, clave, nombre);
	}	
	
	/**M�todo que devuelve una descripción del anunciante
	 * 
	 * @return descripci�n */
	public String toString() {
		return super.toString() 
			+ "\n Tipo: anunciante";
	}
}
