package Login;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;
import java.time.LocalDate;


public class Usuario{

	private String email;
	private String name;
	private Date fecha_ncto;
	private double peso;
	private String contrasenya;
	private String frecuencia;
	
	public String getEmail() {
		return email;
	}
	
	
	public String getContrasenya() {
		return contrasenya;
	}
	public boolean comprobarContrasenya(String password) {
		return this.contrasenya.equals(password);
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Date getFecha_ncto() {
		return fecha_ncto;
	}


	public void setFecha_ncto(Date fecha_ncto) {
		this.fecha_ncto = fecha_ncto;
	}


	public double getPeso() {
		return peso;
	}


	public void setPeso(double peso) {
		this.peso = peso;
	}


	public String getFrecuencia() {
		return frecuencia;
	}
	
	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}
		
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		
		result.append(this.email);
		result.append(" - (");
		result.append(this.name);
		result.append(" - ");
		result.append(this.contrasenya);
		result.append(" - ");
		result.append(this.fecha_ncto);
		result.append(" - (");
		result.append(this.peso);
		result.append(" - (");
		result.append(this.frecuencia);
		result.append(" - (");
		
		return result.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this.getClass().getName().equals(obj.getClass().getName())) {
			return this.email.equals(((Usuario)obj).email);
		}
		
		return false;
	}
}