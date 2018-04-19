package musica.usuarios;

public class Artista extends Usuario {

	/**
	 * Constructor que crea una instancia de artista
	 * 
	 * @param login del usuario (ÚNICO)
	 * @param clave del usuario (en claro)
	 * @param nombre del usuario
	 */
	public Artista(String login, String clave, String nombre) {
		super(login, clave, nombre);
	}	
	
	/**
	 * Método que devuelve una descripción del artista
	 * 
	 * @return descripción
	 */
	public String toString() {
		return super.toString() 
			+ "\n Tipo: artista";
	}
}
