package musica.controladores;

import java.util.List;

import musica.excepciones.UsuarioException;
import musica.usuarios.Administrador;
import musica.usuarios.GestorUsuarios;

public class ControladorSesionAdministrador {
	
	private GestorUsuarios gu; /** el gestor de usuarios*/
	private Administrador admin; /** el administrador de la sesi�n*/

	/**Constructor que asigna el gestor de usuarios que recibe como par�metro	 * 
	 * @param gesu es el gestor de usuarios */
	public ControladorSesionAdministrador(GestorUsuarios gesu) {
		gu = gesu;		
	}

	/**Metodo para identificar a un administrador en el sistema, guardando una referencia en el atributo admin
	 * @param login del administrador
	 * @param clave del administrador
	 * @throws ExcepcionUsuario si las credenciales de usuario no son v�lidas
	 * 			o si las credenciales no son de un administrador*/
	public void identificarAdministrador(String login, String clave) throws UsuarioException {
		if (gu.validarUsuario(login, clave)) {
			// admin v�lido
			try {
				admin = (Administrador) gu.getUsuario(login);
			} catch (ClassCastException e) {/**Excepci�n si getUsuario nos devuelve algo diferente de un administrador*/
				throw new UsuarioException("Usuario "+login+" no es administrador");
			}
		}
		else // admin no v�lido
			throw new UsuarioException("Credenciales de usuario no v�lidas");
	}

	/**Metodo para crear un usuario de un tipo concreto
	 * @param login del usuario a crear (�NICO)
	 * @param clave del usuario a crear
	 * @param nombre del usuario a crear
	 * @param tipo del usuario a crear
	 * @throws ExcepcionUsuario si el administrador no se ha identificado en el sistema,
	 *  		si ya existe un usuario con ese login, 
	 * 			si el tipo de usuario no existe en el sistema,
	 * 			o si hubo un error interno en la creación del usuario*/
	public void crearUsuario(String login, String clave, String nombre, String tipo) throws UsuarioException {
		if (admin != null) 
			gu.crearUsuario(login, clave, nombre, tipo, admin);
		else
			throw new UsuarioException("Autenticaci�n requerida");
	}
	
	/**Metodo para recuperar una lista de descripciones de usuario de cierto tipo
	 * @param tipo de usuario de inter�s
	 * @return lista de descripciones de usuarios del tipo de inter�s
	 * @throws ExcepcionUsuario si el administrador no se ha identificado en el sistema,  		
	 * 			o si el tipo de usuario solicitado no existe*/
	public List<String> listarUsuariosTipo(String tipo) throws UsuarioException {
		if (admin!= null)		
			return gu.listarUsuariosTipo(tipo);
		else
			throw new UsuarioException("Autenticaci�n requerida");
	}

	/*** Metodo para cerrar sesi�n que elimina la referencia a admin*/
	public void cerrarSesion() {
		admin = null;
	}
}
