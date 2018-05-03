package musica.usuarios;

public abstract class Usuario {
	
	private String login; /** login unico del usuario en el sistema */
	private String clave; /** clave del usuario */
	private String nombre; /** nombre del usuario */
	
	// Constructor que crea una instancia de esta clase	 * 
	/** @param login del usuario (UNICO)
	 *  @param clave del usuario (en claro)
	 *  @param nombre del usuario	*/
	
	//Constructor Usuario
	public Usuario(String l, String c, String n) {
		login = l;
		clave = c;
		nombre = n;
	}
	
	 //M�todo que devuelve el login
	 /** @return el login */
	
	public  String getLogin() {
		return login;
	}

	//M�todo que devuelve la clave
	 /** @return la clave*/
	
	public  String getClave() {
		return clave;
	}
	
	// M�todo que fija la clave 
	 /** @param clave nueva*/
	
	public void setClave(String c) {
		clave = c;
	}
	
	// M�todo que devuelve el nombre
	 /** @return el nombre*/
	
	public String getNombre() {
		return nombre;
	}

	//M�todo que fija el nombre
	 /** @param nombre nuevo*/
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//M�todo que devuelve una descripci�n del usuario
	 /** @return descripci�n*/
	public String toString() {
		// Compone una cadena con todos los campos y la retorna
		return	"Usuario: "		+	getLogin()	+ 
				"\n Clave: "	+	getClave()	+ 
				"\n Nombre: "	+	getNombre();
	}
}
