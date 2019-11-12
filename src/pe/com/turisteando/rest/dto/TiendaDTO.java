package pe.com.turisteando.rest.dto;

import java.sql.Array;
import java.util.List;

public class TiendaDTO {
	
	private int codTienda;
	private String foto;
	private String nombreTienda;
	private String descripcion;
	private String direccion;
	private String telefono;
	private String diaAperTura;
	private String diaCierre;
	private String horaApertura;
	private String horaCierre;
	private int codUsuario;
	private int codPais;
	private int codDepa;
	private int codTipoTienda;
	
	public TiendaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TiendaDTO(int codTienda, String foto, String nombreTienda, String descripcion, String direccion,
			String telefono, String diaAperTura, String diaCierre, String horaApertura, String horaCierre,
			int codUsuario, int codPais, int codDepa, int codTipoTienda) {
		super();
		this.codTienda = codTienda;
		this.foto = foto;
		this.nombreTienda = nombreTienda;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.telefono = telefono;
		this.diaAperTura = diaAperTura;
		this.diaCierre = diaCierre;
		this.horaApertura = horaApertura;
		this.horaCierre = horaCierre;
		this.codUsuario = codUsuario;
		this.codPais = codPais;
		this.codDepa = codDepa;
		this.codTipoTienda = codTipoTienda;
	}
	public int getCodTienda() {
		return codTienda;
	}
	public void setCodTienda(int codTienda) {
		this.codTienda = codTienda;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getNombreTienda() {
		return nombreTienda;
	}
	public void setNombreTienda(String nombreTienda) {
		this.nombreTienda = nombreTienda;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDiaAperTura() {
		return diaAperTura;
	}
	public void setDiaAperTura(String diaAperTura) {
		this.diaAperTura = diaAperTura;
	}
	public String getDiaCierre() {
		return diaCierre;
	}
	public void setDiaCierre(String diaCierre) {
		this.diaCierre = diaCierre;
	}
	public String getHoraApertura() {
		return horaApertura;
	}
	public void setHoraApertura(String horaApertura) {
		this.horaApertura = horaApertura;
	}
	public String getHoraCierre() {
		return horaCierre;
	}
	public void setHoraCierre(String horaCierre) {
		this.horaCierre = horaCierre;
	}
	public int getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
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
	public int getCodTipoTienda() {
		return codTipoTienda;
	}
	public void setCodTipoTienda(int codTipoTienda) {
		this.codTipoTienda = codTipoTienda;
	}
	

	
	
	
	
	
	
	
	
	
	

}
