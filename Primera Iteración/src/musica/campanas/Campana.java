package musica.campanas;

import musica.usuarios.Anunciante;;

public class Campana {
	//Atributos de la campaña
	private String nombre;
	private int Nrepro;
	private String genero;
	private int id;
	private Anunciante anunciante;
	
	// Constructor que crea una instancia de esta clase	 * 
	/** @param nombre del producto de la campaña 
	 *  @param numero de reproducciones de la campaña
	 *  @param genero asociado a la campaña	
	 *  @param identificador unico asociado a la campaña dentro del sistema	
	 *  @param anunciate asociado a la campaña	*/
	
	//Constructor de Campana
	public Campana(String nombre, int Nrepro, String genero, int id, Anunciante anunciante) {
		this.nombre = nombre;
		this.Nrepro = Nrepro;
		this.genero = genero;
		this.id = id; 
		this.anunciante = anunciante;
	
	}
	//Metodo put para cambiar los atributos de una campaña
	public void put(String nombre, int Nrepro, String genero, Anunciante anunciante) {
		this.nombre = nombre;
		this.Nrepro = Nrepro;
		this.genero = genero;
		this.anunciante = anunciante;
	}
	
	//Metodos get para poder conocer los atributos de la campaña
	public Anunciante getAnunciante() {
		return anunciante;
	}
	//Método que devuelve el nombre
		 /** @return nombre*/
	public String getNombre() {
		return nombre;
	}
	
	//Método que devuelve el genero
	 /** @return genero*/
	public String getGenero() {
		return genero;
	}
	
	//Método que devuelve el numero de reproducciones
	 /** @return Nrepros*/
	public int getRepro() {
		return Nrepro;
	}
	
	//Método que devuelve el identificador del sistema
		 /** @return id*/
	public int getId() {
		return id;
	}
	
	
	//Método que devuelve una descripción del usuario
		 /** @return descripción*/
	public String toString() {
		// Compone una cadena con todos los campos y la retorna
		return	"Campana : "       +getId()+
				"\n Descripcion: "		+	getNombre()	+ 
				"\n Anunciante: "	+	getAnunciante().getNombre()+ 
				"\n Genero: "	+	getGenero()	+
				"\n Reproducciones: "	+	getRepro();
}
	
}