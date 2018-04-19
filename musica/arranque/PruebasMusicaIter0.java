package musica.arranque;

import java.util.List;

import musica.controladores.ControladorSesionAdministrador;
import musica.excepciones.UsuarioException;
import musica.usuarios.GestorUsuarios;

public class PruebasMusicaIter0 {
	
	/**
	 * Método main(). No se esperan parámetros.
	 * @param args parámetros por línea de comandos que no se tratan.
	 */
	public static void main(String[] args) {
	
		//*************************************
		//*******INICIALIZACION GESTORES*******
		//*************************************						
		// Instancio los gestores de usuarios
		GestorUsuarios gu = new GestorUsuarios();
		
		//*************************************
		//****INICIALIZACION CONTROLADORES*****
		//*************************************				
		// Instancio controladores de sesión
		ControladorSesionAdministrador csadmin = new ControladorSesionAdministrador(gu);
		
				
		System.out.println("////////////////////////////////////////////////////////");
		System.out.println("// CASOS DE USO ITERACIÓN 0");
		System.out.println("////////////////////////////////////////////////////////\n");	
		casosUsoAdmin(csadmin);	
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
}
