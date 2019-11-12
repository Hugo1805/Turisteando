package pe.com.turisteando.rest.dto;

public class ReservaDTO {

	private int codReservar;
	private String descripcionDetalleReserva;
	private int CodUsuario;
	private int CodTienda;
		
	public ReservaDTO(int codReservar, String descripcionDetalleReserva, int codUsuario, int codTienda) {
		super();
		this.codReservar = codReservar;
		this.descripcionDetalleReserva = descripcionDetalleReserva;
		CodUsuario = codUsuario;
		CodTienda = codTienda;
	}
	public ReservaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCodReservar() {
		return codReservar;
	}
	public void setCodReservar(int codReservar) {
		this.codReservar = codReservar;
	}
	public String getDescripcionDetalleReserva() {
		return descripcionDetalleReserva;
	}
	public void setDescripcionDetalleReserva(String descripcionDetalleReserva) {
		this.descripcionDetalleReserva = descripcionDetalleReserva;
	}
	public int getCodUsuario() {
		return CodUsuario;
	}
	public void setCodUsuario(int codUsuario) {
		CodUsuario = codUsuario;
	}
	public int getCodTienda() {
		return CodTienda;
	}
	public void setCodTienda(int codTienda) {
		CodTienda = codTienda;
	}
	
	
	
	
	
}
