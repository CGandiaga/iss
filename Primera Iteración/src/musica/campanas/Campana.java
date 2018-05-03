package musica.campanas;

import musica.usuarios.Anunciante;;

public class Campana {
	//Atributos de la campa�a
	private String nombre;
	private int Nrepro;
	private String genero;
	private int id;
	private Anunciante anunciante;
	
	// Constructor que crea una instancia de esta clase	 * 
	/** @param nombre del producto de la campa�a 
	 *  @param numero de reproducciones de la campa�a
	 *  @param genero asociado a la campa�a	
	 *  @param identificador unico asociado a la campa�a dentro del sistema	
	 *  @param anunciate asociado a la campa�a	*/
	
	//Constructor de Campana
	public Campana(String nombre, int Nrepro, String genero, int id, Anunciante anunciante) {
		this.nombre = nombre;
		this.Nrepro = Nrepro;
		this.genero = genero;
		this.id = id; 
		this.anunciante = anunciante;
	
	}
	//Metodo put para cambiar los atributos de una campa�a
	public void put(String nombre, int Nrepro, String genero, Anunciante anunciante) {
		this.nombre = nombre;
		this.Nrepro = Nrepro;
		this.genero = genero;
		this.anunciante = anunciante;
	}
	
	//Metodos get para poder conocer los atributos de la campa�a
	public Anunciante getAnunciante() {
		return anunciante;
	}
	//M�todo que devuelve el nombre
		 /** @return nombre*/
	public String getNombre() {
		return nombre;
	}
	
	//M�todo que devuelve el genero
	 /** @return genero*/
	public String getGenero() {
		return genero;
	}
	
	//M�todo que devuelve el numero de reproducciones
	 /** @return Nrepros*/
	public int getRepro() {
		return Nrepro;
	}
	
	//M�todo que devuelve el identificador del sistema
		 /** @return id*/
	public int getId() {
		return id;
	}
	
	
	//M�todo que devuelve una descripci�n del usuario
		 /** @return descripci�n*/
	public String toString() {
		// Compone una cadena con todos los campos y la retorna
		return	"Campana : "       +getId()+
				"\n Descripcion: "		+	getNombre()	+ 
				"\n Anunciante: "	+	getAnunciante().getNombre()+ 
				"\n Genero: "	+	getGenero()	+
				"\n Reproducciones: "	+	getRepro();
}
	
}