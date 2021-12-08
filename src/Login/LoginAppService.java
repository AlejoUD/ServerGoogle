package Login;


//TODO: Implement Singleton Pattern
public class LoginAppService {
		
	public Usuario login(String email, String password) {
		//TODO: Get User using DAO and check 		
		Usuario user = new Usuario();		
		user.setEmail("thomas.e2001@gmail.com");
		user.setName("Thomas");			
		user.setContrasenya("$!9PhNz,");
		
		if (user.getEmail().equals(email) && user.comprobarContrasenya(password)) {		
			return user;
		} else {
			return null;
		}
	}
}