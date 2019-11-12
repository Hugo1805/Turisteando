package pe.com.turisteando.rest.dto;

public class DepartamentoDTO {
	
	private int codDepartamento;
	private String nombreDepartamento;
	private int Codpais;
	
	public DepartamentoDTO(int codDepartamento, String nombreDepartamento, int codpais) {
		super();
		this.codDepartamento = codDepartamento;
		this.nombreDepartamento = nombreDepartamento;
		Codpais = codpais;
	}
	public DepartamentoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCodDepartamento() {
		return codDepartamento;
	}
	public void setCodDepartamento(int codDepartamento) {
		this.codDepartamento = codDepartamento;
	}
	public String getNombreDepartamento() {
		return nombreDepartamento;
	}
	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}
	public int getCodpais() {
		return Codpais;
	}
	public void setCodpais(int codpais) {
		Codpais = codpais;
	}
		
	
	
	
	
	
	
	

}
