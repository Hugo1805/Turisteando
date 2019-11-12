package pe.com.turisteando.rest.dto;

public class TipoTiendaDTO {
	
	
	private int codTipo;
	private String descripcionTipo;
	
	public TipoTiendaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TipoTiendaDTO(int codTipo, String descripcionTipo) {
		super();
		this.codTipo = codTipo;
		this.descripcionTipo = descripcionTipo;
	}
	public int getCodTipo() {
		return codTipo;
	}
	public void setCodTipo(int codTipo) {
		this.codTipo = codTipo;
	}
	public String getDescripcionTipo() {
		return descripcionTipo;
	}
	public void setDescripcionTipo(String descripcionTipo) {
		this.descripcionTipo = descripcionTipo;
	}
	
	

}
