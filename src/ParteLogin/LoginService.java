package ParteLogin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class LoginService extends UnicastRemoteObject implements ILogin {
	private static final long serialVersionUID = 1L;

	public static ArrayList<Usuario> users;
	
	//Attribute for the Singleton pattern
	public static LoginService instance;
			
	private LoginService() throws RemoteException {
		super();
		crearUsuarios();
	}
	
	public static LoginService getInstance() {
		if (instance == null) {
			try {
				instance = new LoginService();
			} catch(Exception ex) {
				System.err.println("  # Error initializing service(): " + ex.getMessage());
			}
		}
		
		return instance;
	}

	private static final void crearUsuarios() {
		try {
			Usuario user0= new Usuario();
			Usuario user1= new Usuario();
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			user0.setContrasenya("$!9PhNz,");
			user0.setEmail("thomas.e2001@gmail.com");
			user0.setFecha_ncto(new Date(2001,11,12));
			user0.setFrecuencia("100");
			user0.setName("Thomas");
			user0.setPeso((float) 100.0);
			usuarios.add(user0);
			users = usuarios;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("  # Error " + e.getMessage());
		}
		System.out.println("Usuarios: "+ users);
	}

	@Override
	public String comprobarLogin() {
		// TODO Auto-generated method stub
		crearUsuarios();
		String resultado;
		if(users.contains("thomas.e2001@gmail.com")) {
			System.out.println("El usuario con el email thomas.e2001@gmail.com si esta registrado.");
			resultado = "El usuario con el email thomas.e2001@gmail.com si esta registrado.";
		}else {
			System.out.println("No esta registrado");
			resultado = "No esta registrado";
		}
		return resultado;
	}
}