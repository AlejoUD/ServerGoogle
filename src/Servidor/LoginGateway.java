package Servidor;

import java.rmi.Naming;

import ParteLogin.ILogin;


public class LoginGateway {

	private static LoginGateway instance;
	private ILogin currencyConvService;
	
	private LoginGateway() {
		try {		
			String URL = "//127.0.0.1:1099/CurrencyExchange";
			this.currencyConvService = (ILogin) Naming.lookup(URL);
		} catch (Exception ex) {
			System.err.println("# Error locating remote fa�ade: " + ex);
		}
	}
	
	public static LoginGateway getInstance() {
		if(instance == null) {
			instance = new LoginGateway();
		}
		
		return instance;
	}
	
	public String comprobar() {
		System.out.println("   - Combrobando...");
		
		try {
			return this.currencyConvService.combrobarLogin();
		} catch (Exception ex) {
			System.out.println("   $ Error : " + ex.getMessage());
			return "";
		}		
	}

}