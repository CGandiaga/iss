package musica.arranque;

import java.util.List;
//TODAVIA NO ESTAN IMPLEMENTADAS
/**import musica.anuncios.GestorCampanas;
import musica.canciones.Genero;
import musica.canciones.GestorMusica;
import musica.canciones.Orden;*/
import musica.controladores.ControladorSesionAdministrador;
//TODAVIA NO ESTAN IMPLEMENTADAS
import musica.controladores.*;
import musica.excepciones.UsuarioException;
import musica.campanas.GestorCampana;
import musica.cancion.GestorCancion;
import musica.cancion.Orden;
import musica.cancion.Genero;
import musica.usuarios.GestorUsuarios;

public class PruebasMusicaIter1 {
	
	/*Método main()*/
	public static void main(String[] args) {
	
		//*************************************
		//*******INICIALIZACIÓN GESTORES*******
		//*************************************						
		// Instancio los gestores de usuarios, canciones, campañas
		GestorUsuarios gu = new GestorUsuarios();
		GestorCancion gm = new GestorCancion();
		GestorCampana gc = new GestorCampana();
		
		//*************************************
		//****INICIALIZACION CONTROLADORES*****
		//*************************************				
		// Instanciación controladores de sesión
		ControladorSesionAdministrador csadmin = new ControladorSesionAdministrador(gu);
		ControladorSesionArtista csart = new ControladorSesionArtista(gu, gm);
		ControladorSesionAnunciante csanun = new ControladorSesionAnunciante(gu, gc);
		ControladorSesionSocio cssoc = new ControladorSesionSocio(gu, gm);//NO LE MANDAMOS GESTOR CAMPANA
		
				
		System.out.println("////////////////////////////////////////////////////////");
		System.out.println("// CASOS DE USO PREVIOS/////////////////////////////////");
		System.out.println("////////////////////////////////////////////////////////\n");	
		casosUsoAdmin(csadmin);
		
		
		System.out.println("\n\n////////////////////////////////////////////////////////");
		System.out.println("// CASOS DE USO ITERACIÓN 1/////////////////////////////////");
		System.out.println("////////////////////////////////////////////////////////////\n");
		casosUsoArtistas(csart);
		casosUsoAnunciantes(csanun);
		casosUsoSocios(cssoc);		
	}

	
	/**Método que realiza los casos de uso de los administradores
	 * @param csadmin controlador de sesión para el usuario admin*/
	private static void casosUsoAdmin(ControladorSesionAdministrador csadmin) {
		System.out.println("/// CASOS DE USO ADMINISTRADOR ///\n");
		
		// ------------------------------------
		// -- Usuario admin (ADMINISTRADOR) ---
		// ------------------------------------
		System.out.println("<<inicio sesión admin>>");
		System.out.println("(admin creado por defecto en gestor de usuarios)\n");
		try {
			csadmin.identificarAdministrador("admin","admin");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}		
		
		//*************************************
		//*********CREACION DE USUARIOS********
		//*************************************			
		System.out.println("CREACION DE USUARIOS");		
		try {			
			System.out.println("admin crea tres artistas");
			csadmin.crearUsuario("muse", "clave", "Muse", "Artista");
			csadmin.crearUsuario("judas", "clave", "Judas Priest", "Artista");
			csadmin.crearUsuario("pearl", "clave", "Pearl Jam", "Artista");
			System.out.println("admin crea dos anunciantes");
			csadmin.crearUsuario("donnaipe", "clave", "Don Naipe", "Anunciante");
			csadmin.crearUsuario("megaclothes", "clave", "Megaclothes", "Anunciante");
			System.out.println("admin crea dos socios");
			csadmin.crearUsuario("luisa", "clave", "Luisa Lanas", "Socio");
			csadmin.crearUsuario("mike", "clave", "Michael Johnson", "Socio");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}

		//*************************************
		//************LISTAR USUARIOS**********
		//*************************************	
		System.out.println("\nLISTAR USUARIOS");
		System.out.println("\nlista de artistas:");
		try {
			List<String> descs = csadmin.listarUsuariosTipo("Artista");
			for (String desc :descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" usuarios de tipo \"Artista\"");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}		
		System.out.println("\nlista de socios:");
		try {
			List<String> descs = csadmin.listarUsuariosTipo("Socio");
			for (String desc :descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" usuarios de tipo \"Socio\"");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}	
		System.out.println("\nlista de anunciantes:");
		try {
			List<String> descs = csadmin.listarUsuariosTipo("Anunciante");
			for (String desc : descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" usuarios de tipo \"Anunciante\"");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}		
		System.out.println("\nlista de administradores:");
		try {
			List<String> descs = csadmin.listarUsuariosTipo("Administrador");
			for (String desc : descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" usuarios de tipo \"Administrador\"");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}	
		System.out.println("\nlista de musicos:");
		try {
			List<String> descs = csadmin.listarUsuariosTipo("Musico");
			for (String desc : descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" usuarios de tipo \"Musico\"");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}	
		
		System.out.println("\n<<cierre sesión admin>>");
		csadmin.cerrarSesion();
	}

	/** Método que realiza los casos de uso de los artistas
	 * @param csart controlador de sesión para el usuario artista*/
	private static void casosUsoArtistas(ControladorSesionArtista csart) {
		System.out.println("\n\n/// CASOS DE USO ARTISTAS ///\n");
		
		// ------------------------------------
		// -- Usuario muse (ARTISTA) --
		// ------------------------------------
		System.out.println("<<inicio sesión muse>>\n");	
		try {
			csart.identificarArtista("muse","clave");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}
		
		//*************************************
		//*******PUBLICACIÓN DE CANCIONES******
		//*************************************	
		System.out.println("PUBLICACIÓN DE CANCIONES");
		System.out.println("muse crea cuatro canciones");
		try {			
			csart.publicarCancion("Hysteria",Genero.ROCK);
			csart.publicarCancion("Madness", Genero.ELECTRONICA);
			csart.publicarCancion("Starlight",Genero.ROCK);
			csart.publicarCancion("Resistance",Genero.ROCK);
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}	

		System.out.println("\n<<cierre sesión muse>>");
		csart.cerrarSesion();
		
		
		// ------------------------------------
		// -- Usuario judas priest (ARTISTA) --
		// ------------------------------------
		System.out.println("\n<<inicio sesión judas priest>>\n");	
		try {
			csart.identificarArtista("judas","clave");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}
		
		//*************************************
		//*******PUBLICACIÃ“N DE CANCIONES******
		//*************************************	
		System.out.println("PUBLICACIÓN DE CANCIONES");
		System.out.println("judas crea tres canciones");
		try {			
			csart.publicarCancion("Victim of changes",Genero.ROCK);
			csart.publicarCancion("Breaking the law",Genero.ROCK);
			csart.publicarCancion("Painkiller",Genero.ROCK);
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}	

		System.out.println("\n<<cierre sesión judas priest>>");
		csart.cerrarSesion();
	}

	/**Método que realiza los casos de uso de los anunciantes
	 * @param csanun controlador de sesiÃ³n para el usuario anunciante*/
	private static void casosUsoAnunciantes(ControladorSesionAnunciante csanun) {
		System.out.println("\n\n/// CASOS DE USO ANUNCIANTES ///\n");
		
		// ------------------------------------
		// -- Usuario donnaipe (ANUNCIANTE) --
		// ------------------------------------
		System.out.println("<<inicio sesión donnaipe>>\n");	
		try {
			csanun.identificarAnunciante("donnaipe","clave");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}
				
		//*************************************
		//*******PUBLICACIÓN DE CAMPAÑAS*******
		//*************************************	
		System.out.println("\nPUBLICACIÓN DE CAMPAÑAS");
		System.out.println("donnaipe crea tres campañas");
		try {
			csanun.PublicarCampana("Tute a Cuatro", 10,Genero.ROCK);
			csanun.PublicarCampana("Europoly", 8,Genero.ROCK);
			csanun.PublicarCampana("Dominó en Parejas", 5,Genero.POP);
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}	

		//*************************************
		//*****LISTAR CAMPAÑAS ANUNCIANTE******
		//*************************************	
		System.out.println("\nLISTAR CAMPAÑAS");
		System.out.println("lista de campañas:");
		try {
			List<String> descs = csanun.listarMisCampañas();
			for (String desc : descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" campañas");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n<<cierre sesión donnaipe>>");
		csanun.cerrarSesion();	
		
		// ------------------------------------
		// -- Usuario megaclothes (ANUNCIANTE) --
		// ------------------------------------
		System.out.println("\n<<inicio sesión megaclothes>>\n");	
		try {
			csanun.identificarAnunciante("megaclothes","clave");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}
				
		//*************************************
		//*******PUBLICACIÓN DE CAMPAÑAS*******
		//*************************************	
		System.out.println("\nPUBLICACIÓN DE CAMPAÑAS");
		System.out.println("megaclothes crea dos campañas");
		try {
			csanun.PublicarCampana("Calcetines invierno", 50,Genero.ROCK);
			csanun.PublicarCampana("Bufandas de lana",20 ,Genero.POP);
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}	

		//*************************************
		//*****LISTAR CAMPAÑAS ANUNCIANTE******
		//*************************************	
		System.out.println("\nLISTAR CAMPAÑAS");
		System.out.println("lista de campañas:");
		try {
			List<String> descs = csanun.listarMisCampañas();
			for (String desc : descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" campañas");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n<<cierre sesión megaclothes>>");
		csanun.cerrarSesion();
	}

	/**Método que realiza los casos de uso de los socios
	 * @param cssoc controlador de sesiÃ³n para el usuario socio*/
	private static void casosUsoSocios(ControladorSesionSocio cssoc) {
		System.out.println("\n\n/// CASOS DE USO SOCIOS ///\n");
		
		// ---------------------------
		// -- Usuario luisa (SOCIO) --
		// ---------------------------
		System.out.println("<<inicio sesiÃ³n luisa>>\n");	
		try {
			cssoc.identificarSocio("luisa","clave");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}
				
		//*************************************
		//********PASAR A SOCIO PREMIUM********
		//*************************************
		System.out.println("\nPASAR A SOCIO PREMIUM");
		try {
			cssoc.setPremium(true);;
			System.out.println("Luisa pasa a ser socio premium");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}

		//*************************************
		//*****LISTAR CANCIONES POR ARTISTA****
		//*************************************	
		System.out.println("\nLISTAR CANCIONES POR ARTISTA");
		System.out.println("\nlista de canciones de Muse ordenadas alfabÃ©ticamente:");
		try {
			List<String> descs = cssoc.listarCancionesArtista("muse", Orden.ALF);
			for (String desc : descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" canciones de Muse");
		} catch (UsuarioException  e) {
			System.out.println(e.getMessage());
		} 
		System.out.println("\nlista de canciones de Judas Priest ordenadas alfabÃ©ticamente (inversa):");
		try {
			List<String> descs = cssoc.listarCancionesArtista("judas", Orden.ALF_INV);
			for (String desc : descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" canciones de Judas Priest");
		} catch (UsuarioException  e) {
			System.out.println(e.getMessage());
		} 
		System.out.println("\nlista de canciones de Pearl Jam ordenadas alfabéticamente:");
		try {
			List<String> descs = cssoc.listarCancionesArtista("pearl", Orden.ALF);
			for (String desc : descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" canciones de Pearl Jam");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		} 
		System.out.println("\nlista de canciones de admin ordenadas alfabéticamente:");
		try {
			List<String> descs = cssoc.listarCancionesArtista("admin", Orden.ALF);
			for (String desc : descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" canciones de admin");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n<<cierre sesiÃ³n luisa>>");
		cssoc.cerrarSesion();
	}
}
