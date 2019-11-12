package pe.com.turisteando.rest.dto;

public class ProductoDTO {
	
	private int codProducto;
	private String fotoProducto;
	private String nombreProducto;
	private double precio;
	private String descripcion;
	private int stock;
	private int codTipoProducto;
	private int codTienda;

	public ProductoDTO(int codProducto, String fotoProducto, String nombreProducto, double precio, String descripcion,
			int stock, int codTipoProducto, int codTienda) {
		super();
		this.codProducto = codProducto;
		this.fotoProducto = fotoProducto;
		this.nombreProducto = nombreProducto;
		this.precio = precio;
		this.descripcion = descripcion;
		this.stock = stock;
		this.codTipoProducto = codTipoProducto;
		this.codTienda = codTienda;
	}
	public ProductoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCodProducto() {
		return codProducto;
	}
	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}
	public String getFotoProducto() {
		return fotoProducto;
	}
	public void setFotoProducto(String fotoProducto) {
		this.fotoProducto = fotoProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getCodTipoProducto() {
		return codTipoProducto;
	}
	public void setCodTipoProducto(int codTipoProducto) {
		this.codTipoProducto = codTipoProducto;
	}
	public int getCodTienda() {
		return codTienda;
	}
	public void setCodTienda(int codTienda) {
		this.codTienda = codTienda;
	}
	
	
	
	

}
