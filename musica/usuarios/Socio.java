package musica.usuarios;

public class Socio extends Usuario {

	/** tipo de socio */
	private boolean premium;

	/**
	 * Constructor que crea una instancia de Socio
	 * 
	 * @param login del usuario (ÚNICO)
	 * @param clave del usuario (en claro)
	 * @param nombre del usuario
	 */
	public Socio(String login, String clave, String nombre) {
		super(login, clave, nombre);
	}	
	
	/**
	 * Método que permite saber si el socio es premium 
	 * 
	 * @return true si es premium
	 * 			false si es básico
	 */
	public boolean esPremium() {
		return premium;
	}
	
	/**
	 * Método que permite ajustar el tipo de socio 
	 * 
	 * @param true si pasa a premium
	 * 			false si pasa a básico
	 */
	public void setPremium(boolean prem) {
		premium = prem;
	}
	
	/**
	 * Método que devuelve una descripción del socio
	 * 
	 * @return descripción
	 */
	public String toString() {
		if (premium) {
			return super.toString() 
					+ "\n Tipo: socio premium";
		}
		else {
			return super.toString() 
					+ "\n Tipo: socio básico";			
		}
	}
}
