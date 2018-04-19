package musica.usuarios;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import musica.excepciones.UsuarioException;

public class GestorUsuarios {

	/**
	 * Mapa de usuarios del sistema
	 */
	private Map<String,Usuario> mapaUsuarios;

	/**
	 * Constructor que inicializa el mapa de usuarios y crea un administrador por defecto
	 */
	public GestorUsuarios() {
		// inicializo mapa de usuarios
		mapaUsuarios = new HashMap<>();

		// creo administrador por defecto
		Administrador a = new Administrador("admin", "admin", "Rootmaster");
		mapaUsuarios.put("admin", a);
	}	

	/**
	 * Método que crea una nueva instancia del tipo de usuario adecuado y la agrega al mapa, indexada por login
	 * 
	 * @param login del usuario (ÚNICO)
	 * @param clave del usuario (en claro)
	 * @param nombre del usuario
	 * @param tipo de usuario a generar
	 * @param adm del administrador que solicita la creación del usuario 
	 * @throws ExcepcionUsuario si ya existe un usuario con ese login, 
	 * 			si el tipo de usuario no existe en el sistema,
	 * 			o si hubo un error interno en la creación del usuario
	 */
	public void crearUsuario(String login, String clave, String nombre, String tipoUsuario, Administrador adm) 
			throws UsuarioException {
		if (mapaUsuarios.containsValue(adm)) { // administrador válido
			if (mapaUsuarios.containsKey(login)) // existe el login?
				throw new UsuarioException("Login ya existe");
			else {
				// login válido, creo usuario del tipo adecuado mediante reflexión
				try {			
					// preparo constructor
					String nclase = "musica.usuarios."+tipoUsuario;
					Class<?>[] tpars = new Class[3];
					tpars[0] = Class.forName("java.lang.String");
					tpars[1] = Class.forName("java.lang.String");
					tpars[2] = Class.forName("java.lang.String");
					Constructor<?> co = Class.forName(nclase).getConstructor(tpars);
					
					// relleno parámetros y creo la instancia
					Object[] pars = new Object[3];
					pars[0] = login;
					pars[1] = clave;
					pars[2] = nombre;
					Usuario us = (Usuario)co.newInstance(pars);

					// guardo usuario en el mapa
					mapaUsuarios.put(login, us);
				} catch (ClassNotFoundException e) {
					throw new UsuarioException("Tipo de usuario \""+tipoUsuario+"\" incorrecto");
				} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
						| IllegalArgumentException | InvocationTargetException e) {
					throw new UsuarioException("Error interno en la creación del usuario");
				}				
			}
		}
	}
	
	/**
	 * Método que comprueba las credenciales de un usuario
	 * 
	 * @param login del usuario
	 * @param clave del usuario (en claro)
	 * @return true si existe un usuario con ese login y su clave coincide con la proporcionada
	 * 			false en cualquier otro caso 
	 */
	public boolean validarUsuario(String login, String clave) {
		Usuario u = mapaUsuarios.get(login);
		if (u == null)
			return false;
		else 
			return clave.equals(u.getClave());
	}

	/**
	 * Método que devuelve un usuario a partir de su login
	 * 
	 * @param login del usuario
	 * @return el usuario del mapa con ese login o null si no existe
	 */
	public Usuario getUsuario(String login) {
		return mapaUsuarios.get(login);
	}

	/**
	 * Método que devuelve una lista de descripciones de los usuarios en el sistema por tipo
	 * 
	 * @param tipo de usuario de interés
	 * @return lista con las descripciones de cada usuario del tipo de interés encontrados
	 * @throws ExcepcionUsuario si el tipo de usuario solicitado no existe	 
	 */
	public List<String> listarUsuariosTipo(String tipoUsuario) throws UsuarioException {		
		try {
			// inicializo lista
			List<String> descUsuarios = new ArrayList<>();
			// obtengo clase a partir de tipoUsuario
			String nclase = "musica.usuarios."+tipoUsuario;
			Class<?> clase = Class.forName(nclase);
			// preparo lista
			for (Usuario us : mapaUsuarios.values()) {
				if (clase.isInstance(us))
					descUsuarios.add(us.toString());					
			}
			// y la devuelvo
			return descUsuarios;
		} catch (ClassNotFoundException e) {
			throw new UsuarioException("Tipo de usuario \""+tipoUsuario+"\" incorrecto");
		}		
	}
}
