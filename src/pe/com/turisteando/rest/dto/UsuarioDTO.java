package pe.com.turisteando.rest.dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {
		
	private int codUsuario;
	private String usuario;
	private String nombre;
	private String apellido;
	private String email;
	private String clave;
	private int codPais;
	private int codDepa;
	
	public UsuarioDTO(int codUsuario, String usuario, String nombre, String apellido, String email, String clave,
			int codPais, int codDepa) {
		super();
		this.codUsuario = codUsuario;
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.clave = clave;
		this.codPais = codPais;
		this.codDepa = codDepa;
	}
	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public int getCodPais() {
		return codPais;
	}
	public void setCodPais(int codPais) {
		this.codPais = codPais;
	}
	public int getCodDepa() {
		return codDepa;
	}
	public void setCodDepa(int codDepa) {
		this.codDepa = codDepa;
	}
	
	
	
	

}
