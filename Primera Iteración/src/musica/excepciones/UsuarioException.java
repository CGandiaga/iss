package musica.excepciones;

/**Al declarar esta clase como extends Exception, estamos haciento que 
Usuarioexception herede de la clase predefinida por Java Exception**/
public class UsuarioException extends Exception {

	//Esta l�nea es necesaria para evitar errores t�picos(CREO)
	private static final long serialVersionUID = 1L;
	
	//Constructor para crear una excepci�n relativa a usuarios
	/**Este metodo tiene como argumento un texto que describe la causa de la excepci�n **/
	public UsuarioException(String causa) {
		super(causa);/**Estamos creando una nueva excepci�n con este nombre*/
		
	}
}
