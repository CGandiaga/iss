package musica.controladores;

import musica.excepciones.UsuarioException;
import musica.usuarios.GestorUsuarios;
import musica.usuarios.Artista;
import musica.cancion.GestorCancion;

public class ControladorSesionArtista {
	private GestorUsuarios gu; /** el gestor de usuarios */
	private GestorCancion gca; 
	private Artista art;
	
	// Constructor que asigna el gestor de usuarios que recibe como par�metro	 * 
	 /* @param gesu es el gestor de usuarios  */
	public ControladorSesionArtista(GestorUsuarios gesu,GestorCancion gcan) {
		gu = gesu;
		gca= gcan;
	}
	/**Metodo para identificar a un artista en el sistema, guardando una referencia en el atributo art
	 * @param login del artista
	 * @param clave del artista
	 * @throws ExcepcionUsuario si las credenciales de usuario no son v�lidas
	 * 			o si las credenciales no son de un artista*/
	public void identificarArtista(String login, String clave) throws UsuarioException {
		if (gu.validarUsuario(login, clave)) {
			// artista valido
			try {
				art = (Artista) gu.getUsuario(login);
			} catch (ClassCastException e) {
				throw new UsuarioException("Usuario "+login+" no es artista");
			}
		}
		else // admin no válido
			throw new UsuarioException("Credenciales de usuario no validas");
	}
	
	/**M�todo que permite al artista publicar una cancion
	 * @param titulo
	 * @param genero de la cancion 
	 * @throws excepcionalmente si el artista no se haya registrado*/
	
	public void publicarCancion(String titulo, String genero) throws UsuarioException {
		if (art!= null) 
			gca.publicarCancion(titulo, art, genero);
		else
			throw new UsuarioException("Autenticación requerida");
}
	
	/*Cierre de sesi�n*/
	/**Metodo para cerrar sesi�n que elimina la referencia a art*/
	public void cerrarSesion() {
		art = null;
	}
		
}	