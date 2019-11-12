package pe.com.turisteando.rest.dto;

public class PaisDTO {
	
	private int codpais;
	private String nombrePais;
	
	
	public PaisDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaisDTO(int codpais, String nombrePais) {
		super();
		this.codpais = codpais;
		this.nombrePais = nombrePais;
	}
	public int getCodpais() {
		return codpais;
	}
	public void setCodpais(int codpais) {
		this.codpais = codpais;
	}
	public String getNombrePais() {
		return nombrePais;
	}
	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}
	
	
	

}
