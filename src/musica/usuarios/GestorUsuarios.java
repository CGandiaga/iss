package musica.usuarios;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import musica.excepciones.UsuarioException;

public class GestorUsuarios {

	// MAPA DE USUARIOS DEL SISTEMA
	/**Map es una colección de objetos
	 * Map es como una "estrtuctura" que almacena claves/valor de tal manera
	 * que para una clave solo tendremos un valor
	 * STRING	quiere decir que estamos usando variables string como claves de este mapa
	 * USUARIO	el mapa esta formado por clases de tipo usuario**/
	private Map<String,Usuario> mapaUsuarios;

	//Constructor que inicializa el mapa de usuarios y crea un administrador por defecto
	public GestorUsuarios() {
		// inicializo mapa de usuarios
		/**Como Map es una interfaz hay que desarrollar sus metodos, para eso utilizamos aqui la 
		 * palabra reservada HashMap, que viene predeterminada por Java, implementando ella estos métodos*/
		mapaUsuarios = new HashMap<>();

		// creo administrador por defecto
		Administrador a = new Administrador("admin", "admin", "Rootmaster");
		mapaUsuarios.put("admin", a);
	}	

	//Método que crea una nueva instancia del tipo de usuario adecuado y la agrega al mapa, indexada por login
	/**@param login del usuario (ÚNICO)
	 * @param clave del usuario (en claro)
	 * @param nombre del usuario
	 * @param tipo de usuario a generar
	 * @param adm del administrador que solicita la creación del usuario 
	 * @throws ExcepcionUsuario si ya existe un usuario con ese login, 
	 * 			si el tipo de usuario no existe en el sistema,
	 * 			o si hubo un error interno en la creación del usuario**/
	/**Throws sirve para indicar que un método es capaz de lanzar una excepción
	 * Lo que aparece justo después es el tipo de excepción que puede lanzar**/
	public void crearUsuario(String login, String clave, String nombre, String tipoUsuario, Administrador adm) throws UsuarioException {
		if (mapaUsuarios.containsValue(adm)) { // administrador válido
			if (mapaUsuarios.containsKey(login)) // existe el login?
				throw new UsuarioException("Login ya existe");/**Lanzamos una nueva excepción*/
			else {
				// login válido, creo usuario del tipo adecuado mediante reflexión
				try {			
					// preparo constructor
					String nclase = "musica.usuarios."+tipoUsuario;
					//Objetos Class
					/**Las instancias de la clase Class representan clases e interfaces en una aplicación Java en ejecución.
					 * UNA ENUMERACIÓN ES UN TIPO DE CLASE Y UNA ANOTACIÓN ES UN TIPO DE INTERFAZ(SIMILAR A UN MÉTODO ABSTRACTO). Cada matriz también 
					 * pertenece a una clase que se refleja como un objeto Class que comparten todas las matrices con el mismo tipo de elemento y 
					 * número de dimensiones.Los tipos primitivos de Java ( boolean , byte , char , short , int , long , float y double ) y la palabra 
					 * clave void también se representan como objetos de Class .*/
					
					/**Class<?> sirve para modelar clases desconocidas*/
					Class<?>[] tpars = new Class[3];
					/**Devuelve el objeto Class asociado a la clase o interfaz con el nombre de cadena proporcionado. STRING, INT ...*/
					/**Metemos la clase del objeto 3 veces en este vector, tres String porque son las variables que tiene usuario*/
					tpars[0] = Class.forName("java.lang.String");
					tpars[1] = Class.forName("java.lang.String");
					tpars[2] = Class.forName("java.lang.String");
					//De esta forma estamos creamos una clase que haga de constructor
					Constructor<?> co = Class.forName(nclase).getConstructor(tpars);
					
					// relleno parametros y creo la instancia
					/** Class Object es la raíz de la jerarquía de clases. Cada clase tiene Object como una superclase.
					 *  Todos los objetos, incluidas las matrices, implementan los métodos de esta clase*/
					Object[] pars = new Object[3];
					pars[0] = login;
					pars[1] = clave;
					pars[2] = nombre;
					//De esta forma creamos una instancia más del tipo usuario
					Usuario us = (Usuario)co.newInstance(pars);

					// guardo el nuevo usuario en el mapa
					mapaUsuarios.put(login, us);
				} catch (ClassNotFoundException e) {/**Lanza esta nueva excepción si forName no encuentra una de sus clases*/
					throw new UsuarioException("Tipo de usuario \""+tipoUsuario+"\" incorrecto");
				/**Este catch recoge excepciones predeterminadas por Java, Las podemos sacar de la documentación de Java*/
				} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
						| IllegalArgumentException | InvocationTargetException e) {
					throw new UsuarioException("Error interno en la creación del usuario");
				}				
			}
		}
	}
	
	//Método que comprueba las credenciales de un usuario 
	/** @param login del usuario
	 *  @param clave del usuario (en claro)
	 *  @return true si existe un usuario con ese login y su clave coincide con la proporcionada
	 * 			false en cualquier otro caso	*/
	
	public boolean validarUsuario(String login, String clave) {
		Usuario u = mapaUsuarios.get(login);
		if (u == null)
			return false;
		else 
			//equals es un metodo de los objetos string que 
			//devuelve true en caso de que el argumento coincida con el objeto(es decir que clave recibida = clave usuario)
			return clave.equals(u.getClave());
	}

	//Método que devuelve un usuario a partir de su login
	/** @param login del usuario
	 *  @return el usuario del mapa con ese login o null si no existe*/
	public Usuario getUsuario(String login) {
		return mapaUsuarios.get(login);
	}

	//Método que devuelve una lista de descripciones de los usuarios en el sistema por tipo
	/** @param tipo de usuario de interÃ©s
	 *  @return lista con las descripciones de cada usuario del tipo de interés encontrados
	 *  @throws ExcepcionUsuario si el tipo de usuario solicitado no existe	*/
	//List <>
	/**List es una coleccion de strings en este caso*/
	public List<String> listarUsuariosTipo(String tipoUsuario) throws UsuarioException {		
		try {
			// inicializo lista
			/**Al igual que antes, list es una interfaz, por eso pone new ArrayList, porque 
			 * hace falta implementar los metodos de List, Java nos proporciona una serie de 
			 * metodos ya implementados*/
			List<String> descUsuarios = new ArrayList<>();
			// obtengo clase a partir de tipoUsuario
			String nclase = "musica.usuarios."+tipoUsuario;
			Class<?> clase = Class.forName(nclase);
			// preparo lista
			for (Usuario us : mapaUsuarios.values()) {/**Este bucle for recorre la colección de usuarios que devuelve .values*/
				if (clase.isInstance(us))
				/**El método isInstance devuelve verdadero si el argumento Object especificado no es nulo y puede 
				convertirse al tipo de referencia representado por este objeto Class sin generar una ClassCastException. 
				Devuelve falso de lo contrario.*/
				//Es decir, vale 1 si el usuario us es de la misma clase que clase
					descUsuarios.add(us.toString());					
			}
			// y la devuelvo
			return descUsuarios;
		} catch (ClassNotFoundException e) {
			throw new UsuarioException("Tipo de usuario \""+tipoUsuario+"\" incorrecto");
		}		
	}
}
