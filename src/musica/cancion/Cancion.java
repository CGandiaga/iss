package musica.cancion;

import musica.usuarios.Artista;

public class Cancion {
	//Atributos de la cancion
			private int identificador;
			private int Nrepro;
			private String titulo;
			private Artista artista;
			private String genero;
			
			
		// Constructor que crea una instancia de esta clase	 * 
		/** @param  identificador unico asociado a la cancion 
		 *  @param numero de reproducciones de la cancion
		 *  @param titulo asociado a la canción	
		 *  @param artista asociado a la canción	
		 *  @param genero asociado a la canción	*/	
			
		//Constructor Cancion
		public Cancion(int identificador, int Nrepro, String titulo,Artista artista, String genero) {
			this.identificador = identificador;
			this.Nrepro = Nrepro;
			this.titulo = titulo;
			this.artista = artista;
			this.genero = genero;
			}
		//Método que devuelve el artista de la canción
		 /** @return artista*/
		public Artista getArtista() {
			return artista;
		}
		//Método que devuelve el titulo
		 /** @return titulo*/
		public String getTitulo() {
			return titulo;
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
		//Método que devuelve el identificador
		 /** @return identificador*/
		public int getId() {
			return identificador;
		}
		//Método que devuelve una descripción del usuario
		 /** @return descripción*/
		public String toString() {
			// Compone una cadena con todos los campos y la retorna
			return	"Cancion: " + getId() +
					"\nTitulo: "		+	getTitulo()	+ 
					"\n Artista: "	+	getArtista().getNombre()	+ 
					"\n Reproducciones: "	+	getRepro();
}
}

