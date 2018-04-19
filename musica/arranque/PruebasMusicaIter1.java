package musica.arranque;

import java.util.List;

import musica.anuncios.GestorCampanas;
import musica.canciones.Genero;
import musica.canciones.GestorMusica;
import musica.canciones.Orden;
import musica.controladores.ControladorSesionAdministrador;
import musica.controladores.ControladorSesionAnunciante;
import musica.controladores.ControladorSesionArtista;
import musica.controladores.ControladorSesionSocio;
import musica.excepciones.ArtistaException;
import musica.excepciones.UsuarioException;
import musica.usuarios.GestorUsuarios;

public class PruebasMusicaIter1 {
	
	/**
	 * Método main(). No se esperan parámetros.
	 * @param args parámetros por línea de comandos que no se tratan.
	 */
	public static void main(String[] args) {
	
		//*************************************
		//*******INICIALIZACION GESTORES*******
		//*************************************						
		// Instancio los gestores de usuarios, canciones, campañas
		GestorUsuarios gu = new GestorUsuarios();
		GestorMusica gm = new GestorMusica();
		GestorCampanas gc = new GestorCampanas();
		
		//*************************************
		//****INICIALIZACION CONTROLADORES*****
		//*************************************				
		// Instancio controladores de sesión
		ControladorSesionAdministrador csadmin = new ControladorSesionAdministrador(gu);
		ControladorSesionArtista csart = new ControladorSesionArtista(gu, gm);
		ControladorSesionAnunciante csanun = new ControladorSesionAnunciante(gu, gc);
		ControladorSesionSocio cssoc = new ControladorSesionSocio(gu, gm, gc);
		
				
		System.out.println("////////////////////////////////////////////////////////");
		System.out.println("// CASOS DE USO PREVIOS");
		System.out.println("////////////////////////////////////////////////////////\n");	
		casosUsoAdmin(csadmin);
		
		
		System.out.println("\n\n////////////////////////////////////////////////////////");
		System.out.println("// CASOS DE USO ITERACIÓN 1");
		System.out.println("////////////////////////////////////////////////////////\n");
		casosUsoArtistas(csart);
		casosUsoAnunciantes(csanun);
		casosUsoSocios(cssoc);		
	}

	
	/**
	 * Método que realiza los casos de uso de los administradores
	 * @param csadmin controlador de sesión para el usuario admin
	 */
	private static void casosUsoAdmin(ControladorSesionAdministrador csadmin) {
		System.out.println("/// CASOS DE USO ADMINISTRADOR ///\n");
		
		// ------------------------------------
		// -- Usuario admin (ADMINISTRADOR) --
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

	/**
	 * Método que realiza los casos de uso de los artistas
	 * @param csart controlador de sesión para el usuario artista
	 */
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
			csart.publicarCancion("Hysteria", Genero.ROCK);
			csart.publicarCancion("Madness", Genero.ELECTRONICA);
			csart.publicarCancion("Starlight", Genero.ROCK);
			csart.publicarCancion("Resistance", Genero.ROCK);
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
		//*******PUBLICACIÓN DE CANCIONES******
		//*************************************	
		System.out.println("PUBLICACIÓN DE CANCIONES");
		System.out.println("judas crea tres canciones");
		try {			
			csart.publicarCancion("Victim of changes", Genero.ROCK);
			csart.publicarCancion("Breaking the law", Genero.ROCK);
			csart.publicarCancion("Painkiller", Genero.ROCK);
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}	

		System.out.println("\n<<cierre sesión judas priest>>");
		csart.cerrarSesion();
	}

	/**
	 * Método que realiza los casos de uso de los anunciantes
	 * @param csanun controlador de sesión para el usuario anunciante
	 */
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
			csanun.publicarCampana("Tute a Cuatro", Genero.ROCK, 10);
			csanun.publicarCampana("Europoly", Genero.ROCK, 8);
			csanun.publicarCampana("Dominó en Parejas", Genero.POP, 5);
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}	

		//*************************************
		//*****LISTAR CAMPAÑAS ANUNCIANTE******
		//*************************************	
		System.out.println("\nLISTAR CAMPAÑAS");
		System.out.println("lista de campañas:");
		try {
			List<String> descs = csanun.listarMisCampanas();
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
			csanun.publicarCampana("Calcetines invierno", Genero.ROCK, 50);
			csanun.publicarCampana("Bufandas de lana", Genero.POP, 20);
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}	

		//*************************************
		//*****LISTAR CAMPAÑAS ANUNCIANTE******
		//*************************************	
		System.out.println("\nLISTAR CAMPAÑAS");
		System.out.println("lista de campañas:");
		try {
			List<String> descs = csanun.listarMisCampanas();
			for (String desc : descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" campañas");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n<<cierre sesión megaclothes>>");
		csanun.cerrarSesion();
	}

	/**
	 * Método que realiza los casos de uso de los socios
	 * @param cssoc controlador de sesión para el usuario socio
	 */
	private static void casosUsoSocios(ControladorSesionSocio cssoc) {
		System.out.println("\n\n/// CASOS DE USO SOCIOS ///\n");
		
		// ---------------------------
		// -- Usuario luisa (SOCIO) --
		// ---------------------------
		System.out.println("<<inicio sesión luisa>>\n");	
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
			cssoc.activarPremium(true);
			System.out.println("Luisa pasa a ser socio premium");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}

		//*************************************
		//*****LISTAR CANCIONES POR ARTISTA****
		//*************************************	
		System.out.println("\nLISTAR CANCIONES POR ARTISTA");
		System.out.println("\nlista de canciones de Muse ordenadas alfabéticamente:");
		try {
			List<String> descs = cssoc.listarCancionesArtista("muse", Orden.ALFA);
			for (String desc : descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" canciones de Muse");
		} catch (UsuarioException | ArtistaException e) {
			System.out.println(e.getMessage());
		} 
		System.out.println("\nlista de canciones de Judas Priest ordenadas alfabéticamente (inversa):");
		try {
			List<String> descs = cssoc.listarCancionesArtista("judas", Orden.ALFA_INV);
			for (String desc : descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" canciones de Judas Priest");
		} catch (UsuarioException | ArtistaException e) {
			System.out.println(e.getMessage());
		} 
		System.out.println("\nlista de canciones de Pearl Jam ordenadas alfabéticamente:");
		try {
			List<String> descs = cssoc.listarCancionesArtista("pearl", Orden.ALFA);
			for (String desc : descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" canciones de Pearl Jam");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		} catch (ArtistaException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\nlista de canciones de admin ordenadas alfabéticamente:");
		try {
			List<String> descs = cssoc.listarCancionesArtista("admin", Orden.ALFA);
			for (String desc : descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" canciones de admin");
		} catch (UsuarioException | ArtistaException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n<<cierre sesión luisa>>");
		cssoc.cerrarSesion();
	}
}
