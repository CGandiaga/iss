 package musica.controladores;

import java.util.List;

import musica.excepciones.UsuarioException;
import musica.usuarios.Anunciante;
import musica.usuarios.GestorUsuarios;
import musica.campanas.GestorCampana;

public class ControladorSesionAnunciante {
	
	private GestorUsuarios gu; /** el gestor de usuarios*/
	private	Anunciante	anun;/**el anunciante de la sesi�n*/
	private GestorCampana gc;/**gestor campa�a de la sesion*/
	
	/**Constructor que asigna el gestor de usuarios que recibe como par�metro	
	 * @param gesu es el gestor de usuarios 
	 * @param gc es el gestor de campa�a */
	public	ControladorSesionAnunciante (GestorUsuarios gesu, GestorCampana gcam) {
		gu = gesu;
		gc = gcam;
	}
	
	/**Metodo para identificar a un anunciante en el sistema, guardando una referencia en el atributo anun
	 * @param login del anunciante
	 * @param clave del anunciante
	 * @throws ExcepcionUsuario si las credenciales de usuario no son v�lidas
	 * 			o si las credenciales no son de un anunciante*/
	public void identificarAnunciante(String login, String clave) throws UsuarioException {
		if (gu.validarUsuario(login, clave)) {
			// anun v�lido
			try {
				anun = (Anunciante) gu.getUsuario(login);
			} catch (ClassCastException e) {/**Excepci�n, si getUsuario nos devuelve algo diferente de un anunciante*/
				throw new UsuarioException("Usuario "+login+" no es anunciante");
			}
		}
		else // anun no v�lido
			throw new UsuarioException("Credenciales de usuario no v�lidas");
	}
	
	/**M�todo que permite al anunciante publicar una campa�a
	 * @param producto
	 * @param n� de reproducciones 
	 * @param g�nero en el que se quiere la campa�a
	 * @throws excepcionalmente si el anunciante no se haya registrado*/
	
	public void PublicarCampana( String nombre, int Nrepro, String genero ) throws UsuarioException{
		if(anun != null) { 
				//anun v�lido 
				gc.PublicarCampana(nombre, Nrepro, genero, anun);
			}
		//anun no valido
		else {
			throw new UsuarioException("Autenticaci�n requerida");
		}
	}
	
	/**M�todo que permite al anunciante listar una campa�a
	 * @param producto
	 * @param n� de reproducciones 
	 * @param g�nero en el que se quiere la campa�a
	 * @return lista de campa�as*/
	public List<String> listarMisCampa�as() throws UsuarioException {
		return gc.listarMisCampa�as( anun);
	}
	/**Metodo para cerrar sesi�n que elimina la referencia a anun*/
	public void cerrarSesion() {
		anun = null;
	}

}
