package musica.campanas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import musica.excepciones.UsuarioException;
import musica.usuarios.Anunciante;
import musica.campanas.Campana;;

public class GestorCampana {
	private int id;
	//Mapa de campañas del sistema
	/**Map es una colección de objetos
	 * Map es como una "estrtuctura" que almacena claves/valor de tal manera
	 * que para una clave solo tendremos un valor
	 * STRING	quiere decir que estamos usando variables string como claves de este mapa
	 * USUARIO	el mapa esta formado por clases de tipo usuario*/
	private Map<Integer,Campana> mapaCampanas;
	
	//Constructor GestorCampanas
	public GestorCampana() {
				// inicializo mapa de campañas
				/**Como Map es una interfaz hay que desarrollar sus metodos, para eso utilizamos aqui la 
				 * palabra reservada HasMap, que viene predeterminada por Java, implementando ella estos métodos*/
				mapaCampanas = new HashMap<>();
				id=0;//Ponemos a cero en el constructor
	}
	
	/**Método para publicar una nueva campaña en la plataforma
	 * @param empresa que contrata la campaña
	 * @param producto 
	 * @param nombre de la campaña
	 * @param Nº de reproducciones de la campaña
	 * @throws 
	 * 		   ,*/
	public void PublicarCampana(String nombre, int Nrepro, String genero, Anunciante anun) throws UsuarioException{
			try {
				id++;//Incrementamos el contador cada vez que publicamos una campana nueva
				
				//Creamos una nueva instancia de Campaña
				Campana cam = new Campana(nombre, Nrepro, genero, id, anun);
				//Añadimos la nueva instancia al mapa de campañas
				mapaCampanas.put(id,cam);
			}
			/**Excepciones causadas por usar el metodo put*/
			catch (UnsupportedOperationException | ClassCastException | NullPointerException | IllegalArgumentException e) {
				throw new UsuarioException("Error interno en la creación de la Campaña");
			}
		}
	
	/**Método que permite a un usuario de tipo anunciante listar campanas*/
	public List<String> listarMisCampañas(Anunciante anun ) throws UsuarioException{
		if(anun != null) {
			try{
				// inicializo lista
				/**Al igual que antes, list es una interfaz, por eso pone new ArrayList, porque 
				 * hace falta implementar los metodos de List, Java nos proporciona una serie de 
				 * metodos ya implementados*/
				List<String> descCampanas = new ArrayList<>();
				for (Campana cam : mapaCampanas.values()) {/**Este bucle for recorre la colección de campañas que devuelve .values*/
					if(cam.getAnunciante() == anun)
					descCampanas.add(cam.toString());/**Añadimos a la lista información relativa a cada campaña
					 									almacenada en mapaCampañas*/
				}
				//Devolvemos la lista
				return descCampanas;
			}
			/**Excepciones que puede causar el uso de add*/
			catch(NullPointerException | UnsupportedOperationException | ClassCastException  |  IllegalArgumentException e){
				throw new UsuarioException("Error interno en la creación de la lista");
			}
		}
		else 
			throw new UsuarioException("Autenticación requerida");
	}
}
