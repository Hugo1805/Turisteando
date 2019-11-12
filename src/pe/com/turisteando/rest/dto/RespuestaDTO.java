package pe.com.turisteando.rest.dto;

import java.io.Serializable;

public class RespuestaDTO implements Serializable {
	
	private int estado; //0:pedido pendiente de pago 1:no hay estock, 2: error
	private String mensaje;
	
	
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public RespuestaDTO(int estado, String mensaje) {
		super();
		this.estado = estado;
		this.mensaje = mensaje;
	}
	public RespuestaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	
	
	

}
