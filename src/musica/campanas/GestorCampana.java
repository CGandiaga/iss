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
	//Mapa de campa�as del sistema
	/**Map es una colecci�n de objetos
	 * Map es como una "estrtuctura" que almacena claves/valor de tal manera
	 * que para una clave solo tendremos un valor
	 * STRING	quiere decir que estamos usando variables string como claves de este mapa
	 * USUARIO	el mapa esta formado por clases de tipo usuario*/
	private Map<Integer,Campana> mapaCampanas;
	
	//Constructor GestorCampanas
	public GestorCampana() {
				// inicializo mapa de campa�as
				/**Como Map es una interfaz hay que desarrollar sus metodos, para eso utilizamos aqui la 
				 * palabra reservada HasMap, que viene predeterminada por Java, implementando ella estos m�todos*/
				mapaCampanas = new HashMap<>();
				id=0;//Ponemos a cero en el constructor
	}
	
	/**M�todo para publicar una nueva campa�a en la plataforma
	 * @param empresa que contrata la campa�a
	 * @param producto 
	 * @param nombre de la campa�a
	 * @param N� de reproducciones de la campa�a
	 * @throws 
	 * 		   ,*/
	public void PublicarCampana(String nombre, int Nrepro, String genero, Anunciante anun) throws UsuarioException{
			try {
				id++;//Incrementamos el contador cada vez que publicamos una campana nueva
				
				//Creamos una nueva instancia de Campa�a
				Campana cam = new Campana(nombre, Nrepro, genero, id, anun);
				//A�adimos la nueva instancia al mapa de campa�as
				mapaCampanas.put(id,cam);
			}
			/**Excepciones causadas por usar el metodo put*/
			catch (UnsupportedOperationException | ClassCastException | NullPointerException | IllegalArgumentException e) {
				throw new UsuarioException("Error interno en la creaci�n de la Campa�a");
			}
		}
	
	/**M�todo que permite a un usuario de tipo anunciante listar campanas*/
	public List<String> listarMisCampa�as(Anunciante anun ) throws UsuarioException{
		if(anun != null) {
			try{
				// inicializo lista
				/**Al igual que antes, list es una interfaz, por eso pone new ArrayList, porque 
				 * hace falta implementar los metodos de List, Java nos proporciona una serie de 
				 * metodos ya implementados*/
				List<String> descCampanas = new ArrayList<>();
				for (Campana cam : mapaCampanas.values()) {/**Este bucle for recorre la colecci�n de campa�as que devuelve .values*/
					if(cam.getAnunciante() == anun)
					descCampanas.add(cam.toString());/**A�adimos a la lista informaci�n relativa a cada campa�a
					 									almacenada en mapaCampa�as*/
				}
				//Devolvemos la lista
				return descCampanas;
			}
			/**Excepciones que puede causar el uso de add*/
			catch(NullPointerException | UnsupportedOperationException | ClassCastException  |  IllegalArgumentException e){
				throw new UsuarioException("Error interno en la creaci�n de la lista");
			}
		}
		else 
			throw new UsuarioException("Autenticaci�n requerida");
	}
}
