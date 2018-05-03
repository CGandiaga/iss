package musica.controladores;

import musica.usuarios.Socio;

import java.util.List;

import musica.cancion.GestorCancion;
import musica.excepciones.UsuarioException;
import musica.usuarios.GestorUsuarios;
import musica.usuarios.Artista;

public class ControladorSesionSocio {
	private GestorUsuarios gu;/** el gestor de usuarios */
	private GestorCancion gca;
	private Socio soc;
	private Artista art;
	
	// Constructor que asigna el gestor de usuarios que recibe como par√°metro	 * 
	 /* @param gesu es el gestor de usuarios 
	 */
	public ControladorSesionSocio(GestorUsuarios gesu,GestorCancion gcan) {
		gu = gesu;
		gca = gcan;
	}
	/**Metodo para identificar a un socio en el sistema, guardando una referencia en el atributo anun
	 * @param login del socio
	 * @param clave del socio
	 * @throws ExcepcionUsuario si las credenciales de usuario no son v·lidas
	 * 			o si las credenciales no son de un socio*/
	public void identificarSocio(String login, String clave) throws UsuarioException {
		if (gu.validarUsuario(login, clave)) {
			// socio v√°lido
			try {
				soc = (Socio) gu.getUsuario(login);
			} catch (ClassCastException e) {
				throw new UsuarioException("Usuario "+login+" no es socio");
			}
		}
		else // socio no v√°lido
			throw new UsuarioException("Credenciales de usuario no validas");
	}
	//Cambia el status de un socio de basico a premium o viceversa
	
	public void setPremium(boolean prem) throws UsuarioException {
		if (soc!= null)
			 soc.setPremium(prem);
		else
			throw new UsuarioException("Autenticacion requerida");
	}

	/*Cierre de sesiÛn*/
	public void cerrarSesion() {
		soc = null;
	}
	/**MÈtodo que permite al anunciante listar canciones de un mismo artista
	 * @param artista
	 * @param orden en el que se listan las canciones
	 * @return lista de canciones
	 * @throws ExcepcionUsuario si las credenciales de usuario no son v·lidas*/
	public List<String> listarCancionesArtista(String artista,int orden) throws UsuarioException {
		if (soc!= null) {
			try {
				art = (Artista) gu.getUsuario(artista);
			} catch (ClassCastException e) {
				throw new UsuarioException("No hay ningun "+artista+" con ese nombre en el sistema");
			}
		
			
			return gca.listarCancionesArtista(art,orden);
			
		}
		else
			throw new UsuarioException("Autenticacion requerida");
	}

}
