package pe.com.turisteando.rest.dto;

public class TipoProductoDTO {
	
	private int codTipoProducto;
	private String descripcionTipoProducto;
	
	public TipoProductoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TipoProductoDTO(int codTipoProducto, String descripcionTipoProducto) {
		super();
		this.codTipoProducto = codTipoProducto;
		this.descripcionTipoProducto = descripcionTipoProducto;
	}
	public int getCodTipoProducto() {
		return codTipoProducto;
	}
	public void setCodTipoProducto(int codTipoProducto) {
		this.codTipoProducto = codTipoProducto;
	}
	public String getDescripcionTipoProducto() {
		return descripcionTipoProducto;
	}
	public void setDescripcionTipoProducto(String descripcionTipoProducto) {
		this.descripcionTipoProducto = descripcionTipoProducto;
	}
	
	

}
