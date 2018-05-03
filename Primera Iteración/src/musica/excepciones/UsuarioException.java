package musica.excepciones;

/**Al declarar esta clase como extends Exception, estamos haciento que 
Usuarioexception herede de la clase predefinida por Java Exception**/
public class UsuarioException extends Exception {

	//Esta línea es necesaria para evitar errores típicos(CREO)
	private static final long serialVersionUID = 1L;
	
	//Constructor para crear una excepción relativa a usuarios
	/**Este metodo tiene como argumento un texto que describe la causa de la excepción **/
	public UsuarioException(String causa) {
		super(causa);/**Estamos creando una nueva excepción con este nombre*/
		
	}
}
