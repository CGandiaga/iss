package musica.usuarios;

public class Anunciante extends Usuario {

	/**Constructor que crea una instancia de anunciante
	 * 
	 * @param login del usuario (ÚNICO)
	 * @param clave del usuario (en claro)
	 * @param nombre del usuario*/
	
	public Anunciante(String login, String clave, String nombre) {
		super(login, clave, nombre);
	}	
	
	/**Método que devuelve una descripciÃ³n del anunciante
	 * 
	 * @return descripción */
	public String toString() {
		return super.toString() 
			+ "\n Tipo: anunciante";
	}
}
