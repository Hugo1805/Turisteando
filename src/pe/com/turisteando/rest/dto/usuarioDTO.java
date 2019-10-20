package pe.com.turisteando.rest.dto;

import java.io.Serializable;

public class usuarioDTO implements Serializable {
	
	private String usuario;
	private String clave ;

	public usuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public usuarioDTO(String usuario, String clave) {
		super();
		this.usuario = usuario;
		this.clave = clave;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}

	
	
}
