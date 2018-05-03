package musica.cancion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import musica.excepciones.UsuarioException;
import musica.usuarios.Artista;


public class GestorCancion {
	private int id;// Nos servir� para identificar cada cancion en el sistema
	
	/** Mapa de canciones del sistema*/
	
		/**Map es una colecci�n de objetos
		 * Map es como una "estrtuctura" que almacena claves/valor de tal manera
		 * que para una clave solo tendremos un valor
		 * Integer	quiere decir que estamos usando variables int como claves de este mapa
		 * Canci�n	el mapa esta formado por clases de tipo canci�n**/
		private Map<Integer,Cancion> mapaCanciones;

		/* Creamos dos comparadores uno para ordenar alfabeticamente y otro para el orden alfabetico inverso*/
		/*No les creamos dentro del metodo listar pues podr�a provocarse duplicidad*/
		/*Nos hemos basado en el tutorial proporcionado para realizar la ordenaci�n*/
static final Comparator<Cancion> ALFA =
		new Comparator<Cancion>() {
	public int compare(Cancion v1,Cancion v2) {
		return v1.getTitulo().compareTo(v2.getTitulo());
	}
};

static final Comparator<Cancion> ALFA_INV =
		new Comparator<Cancion>() {
	public int compare(Cancion v1,Cancion v2) {
		return -v1.getTitulo().compareTo(v2.getTitulo());/*Al no haber ning�n entero negativo se puede realizar as� sin ning�n problema*/
	}													/*Otra forma seria quitando el menos y cambiando v1 por v2*/
};

	/**Constructor que inicializa el mapa de canciones  */
	public GestorCancion() {
		// inicializo mapa de usuarios
		mapaCanciones = new HashMap<>();
		id=0;//Ponemos a cero en el constructor
}
	/**M�todo para publicar una nueva cancion en la plataforma
	 * @param etitulo de la cancion
	 * @param artsta 
	 * @param genero de la canci�n
	 * @throws 
	 * 		   ,*/
	public void publicarCancion(String titulo,Artista artista, String genero) throws UsuarioException{
	
		try {
			id++;//Incrementamos el contador cada vez que publicamos una cancion nueva
			//Creamos una nueva instancia de Cancion
			Cancion  can = new Cancion(id,0, titulo, artista, genero);
			//A�adimos la nueva instancia al mapa de canciones
			mapaCanciones.put(id, can);
		}
		/**Excepciones causadas por usar el metodo put*/
		catch (UnsupportedOperationException | ClassCastException | NullPointerException | IllegalArgumentException e) {
			throw new UsuarioException("Error interno en la creaci�n de la Cancion");
		}
	}
	
	/**M�todo que permite a un usuario de tipo anunciante listar campanas*/
	public List<String> listarCancionesArtista(Artista artista, int orden ) throws UsuarioException {		
			try{	
		// inicializo lista
			List<Cancion> listaorden = new ArrayList<>();
			// preparo lista
			for (Cancion can : mapaCanciones.values()) {
				if (artista == can.getArtista())
					listaorden.add(can);					
			}
			/*Elegimos el orden de listado*/
			switch (orden) {
			
			case Orden.ALF :
				Collections.sort(listaorden,ALFA);
				break;
			case Orden.ALF_INV:
				Collections.sort(listaorden,ALFA_INV);
				break;	
			
			}
			/*Convertimos la lista de canciones en string*/
			List<String> listafinal = new ArrayList<>();
			// preparo lista
			for (Cancion can : listaorden) {
					listafinal.add(can.toString());					
			}
			
			// y la devuelvo
			
			return listafinal;
			}
			/**Excepciones que puede causar el uso de add*/
			catch(NullPointerException | UnsupportedOperationException | ClassCastException  |  IllegalArgumentException e){
				throw new UsuarioException("Error interno en la creaci�n de la lista");
			}
		}
		
	}
	

	
	
	
	
