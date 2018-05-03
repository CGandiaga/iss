package musica.usuarios;

public class Artista extends Usuario {

	/**Constructor que crea una instancia de artista
	 * 
	 * @param login del usuario (�NICO)
	 * @param clave del usuario (en claro)
	 * @param nombre del usuario*/
	public Artista(String login, String clave, String nombre) {
		super(login, clave, nombre);
	}	
	
	/** M�todo que devuelve una descripci�n del artista
	 * 
	 * @return descripci�n */
	public String toString() {
		return super.toString() 
			+ "\n Tipo: artista";
	}
}
