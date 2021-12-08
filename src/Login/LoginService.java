package Login;

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
import java.util.HashMap;
import java.util.Map;


public class LoginService extends UnicastRemoteObject implements ILogin {
	private static final long serialVersionUID = 1L;

	public static ArrayList<Usuario> users;
	
	//Attribute for the Singleton pattern
	public static LoginService instance;
	private LoginAppService loginService = new LoginAppService();
	private Map<Long, Usuario> serverState = new HashMap<>();
			
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
			user0.setFecha_ncto(null);
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
	public String combrobarLogin() {
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

	@Override
	public long loginGoogle(String email, String password) throws RemoteException {
		// TODO Auto-generated method stub
		crearUsuarios();
		System.out.println(" * RemoteFacade login(): " + email  + " / " + password);
		
		//Perform login() using LoginAppService
		Usuario user = loginService.login(email, password);
			
		//If login() success user is stored in the Server State
		if (user != null) {
			//If user is not logged in 
			if (!this.serverState.values().contains(user)) {
				Long token = Calendar.getInstance().getTimeInMillis();		
				this.serverState.put(token, user);		
				return(token);
			} else {
				throw new RemoteException("User is already logged in!");
			}
		} else {
			throw new RemoteException("Login fails!");
		}
	}
}