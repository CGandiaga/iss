 package musica.controladores;

import java.util.List;

import musica.excepciones.UsuarioException;
import musica.usuarios.Anunciante;
import musica.usuarios.GestorUsuarios;
import musica.campanas.GestorCampana;

public class ControladorSesionAnunciante {
	
	private GestorUsuarios gu; /** el gestor de usuarios*/
	private	Anunciante	anun;/**el anunciante de la sesión*/
	private GestorCampana gc;/**gestor campaña de la sesion*/
	
	/**Constructor que asigna el gestor de usuarios que recibe como parámetro	
	 * @param gesu es el gestor de usuarios 
	 * @param gc es el gestor de campaña */
	public	ControladorSesionAnunciante (GestorUsuarios gesu, GestorCampana gcam) {
		gu = gesu;
		gc = gcam;
	}
	
	/**Metodo para identificar a un anunciante en el sistema, guardando una referencia en el atributo anun
	 * @param login del anunciante
	 * @param clave del anunciante
	 * @throws ExcepcionUsuario si las credenciales de usuario no son válidas
	 * 			o si las credenciales no son de un anunciante*/
	public void identificarAnunciante(String login, String clave) throws UsuarioException {
		if (gu.validarUsuario(login, clave)) {
			// anun válido
			try {
				anun = (Anunciante) gu.getUsuario(login);
			} catch (ClassCastException e) {/**Excepción, si getUsuario nos devuelve algo diferente de un anunciante*/
				throw new UsuarioException("Usuario "+login+" no es anunciante");
			}
		}
		else // anun no válido
			throw new UsuarioException("Credenciales de usuario no válidas");
	}
	
	/**Método que permite al anunciante publicar una campaña
	 * @param producto
	 * @param nº de reproducciones 
	 * @param género en el que se quiere la campaña
	 * @throws excepcionalmente si el anunciante no se haya registrado*/
	
	public void PublicarCampana( String nombre, int Nrepro, String genero ) throws UsuarioException{
		if(anun != null) { 
				//anun válido 
				gc.PublicarCampana(nombre, Nrepro, genero, anun);
			}
		//anun no valido
		else {
			throw new UsuarioException("Autenticación requerida");
		}
	}
	
	/**Método que permite al anunciante listar una campaña
	 * @param producto
	 * @param nº de reproducciones 
	 * @param género en el que se quiere la campaña
	 * @return lista de campañas*/
	public List<String> listarMisCampañas() throws UsuarioException {
		return gc.listarMisCampañas( anun);
	}
	/**Metodo para cerrar sesión que elimina la referencia a anun*/
	public void cerrarSesion() {
		anun = null;
	}

}
