package Singleton;

public class LoginGoogleSingletonSpooler extends LoginSpooler{

	private static LoginGoogleSingletonSpooler INSTANCE = new LoginGoogleSingletonSpooler();
	
	private LoginGoogleSingletonSpooler() {
		super.login(null, null);
		System.out.println("  # EAGER: Execute the constructor.");
	}
	
	public static LoginGoogleSingletonSpooler getInstance() {
		System.out.println("  Devolviendo la instancia.");
		
		return INSTANCE;
	}
}
