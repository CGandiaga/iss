package musica.cancion;

import musica.usuarios.Artista;

public class Cancion {
	//Atributos de la cancion
			private int identificador;
			private int repro;
			private String titulo;
			private Artista artista;
			private String genero;
			
			
		// Constructor que crea una instancia de esta clase	 * 
		/** @param  identificador unico asociado a la cancion 
		 *  @param numero de reproducciones de la cancion
		 *  @param titulo asociado a la canci�n	
		 *  @param artista asociado a la canci�n	
		 *  @param genero asociado a la canci�n	*/	
			
		//Constructor Cancion
		public Cancion(int identificador, int repro, String titulo,Artista artista, String genero) {
			this.identificador = identificador;
			this.repro = repro;
			this.titulo = titulo;
			this.artista = artista;
			this.genero = genero;
			}
		//M�todo que devuelve el artista de la canci�n
		 /** @return artista*/
		public Artista getArtista() {
			return artista;
		}
		//M�todo que devuelve el titulo
		 /** @return titulo*/
		public String getTitulo() {
			return titulo;
		}
		//M�todo que devuelve el genero
		 /** @return genero*/
		public String getGenero() {
			return genero;
		}
		//M�todo que devuelve el numero de reproducciones
		 /** @return Nrepros*/
		public int getRepro() {
			return repro;
		}
		//M�todo que devuelve el identificador
		 /** @return identificador*/
		public int getId() {
			return identificador;
		}
		//M�todo que devuelve una descripci�n del usuario
		 /** @return descripci�n*/
		public String toString() {
			// Compone una cadena con todos los campos y la retorna
			return	"Cancion: " + getId() +
					"\nTitulo: "		+	getTitulo()	+ 
					"\n Artista: "	+	getArtista().getNombre()	+ 
					"\n Reproducciones: "	+	getRepro();
		}
		//Funci�n para 
		public int ingresos() {
			int ingresos = 0;
		    /**linea que calcula el ingreso seg�n el n� de reproducciones*/	
			return ingresos;
		}
}

