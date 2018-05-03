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
	
	 //Método que devuelve el login
	 /** @return el login */
	
	public  String getLogin() {
		return login;
	}

	//Método que devuelve la clave
	 /** @return la clave*/
	
	public  String getClave() {
		return clave;
	}
	
	// Método que fija la clave 
	 /** @param clave nueva*/
	
	public void setClave(String c) {
		clave = c;
	}
	
	// Método que devuelve el nombre
	 /** @return el nombre*/
	
	public String getNombre() {
		return nombre;
	}

	//Método que fija el nombre
	 /** @param nombre nuevo*/
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//Método que devuelve una descripción del usuario
	 /** @return descripción*/
	public String toString() {
		// Compone una cadena con todos los campos y la retorna
		return	"Usuario: "		+	getLogin()	+ 
				"\n Clave: "	+	getClave()	+ 
				"\n Nombre: "	+	getNombre();
	}
}
