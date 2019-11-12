package pe.com.turisteando.rest.get;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Past;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mysql.cj.protocol.Message;
import com.mysql.cj.xdevapi.PreparableStatement;

//import com.mysql.jdbc.Connection;

//import com.mysql.jdbc.Pr;
import com.mysql.jdbc.Driver;

import pe.com.turisteando.rest.dto.DepartamentoDTO;
import pe.com.turisteando.rest.dto.PaisDTO;
import pe.com.turisteando.rest.dto.ProductoDTO;
import pe.com.turisteando.rest.dto.TiendaDTO;
import pe.com.turisteando.rest.dto.UsuarioDTO;
import pe.com.turisteando.util.BD.UtilBD;
import pe.com.turisteando.util.BD.UtilBDSQL;



@Path("/tiposgetttt")
public class ServiciosGet {	
	
	//EndPonit
	//http://localhost:8080/turisteando/tiposgetttt/hola
	
	@GET
	@Path("/hola")
	@Produces(MediaType.TEXT_PLAIN)	
	public String holaMundo() 
	{
		System.out.println("entron a holaMundo");
		return "Hola servicios rest";
	}


/*------------------------------------------------------------------------------Tienda------------------------------------------------------------------------------------------------------*/

	
	//EndPonit
		//http://localhost:8080/turisteando/tiposgetttt/listadoTienda

	@GET
	@Path("/listadoTienda")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TiendaDTO>listadoTienda(){
		System.out.println("entro a listado Tienda");
		
		List<TiendaDTO>listadoTienda = new ArrayList<>();		
		try {
			//conxion sql a SQLServer
			Connection cn = new UtilBDSQL().getConnectionSQL();
			//llamar a procedure ListarTienda
			String procedimientoAlmacenado="{call ListarTienda}";
			CallableStatement call =cn.prepareCall(procedimientoAlmacenado);
			
			//con esta linea llamas a parametros
			//call.setString(parameterIndex, x);
			
			ResultSet rs = call.executeQuery();
			
			//Statement stmt = UtilBDSQL.getConnectionSQL().createStatement();			
			//ResultSet rs = stmt.executeQuery("select * from usuario;");
			
			TiendaDTO tienda = new TiendaDTO();
			
			
			while (rs.next()) {
				tienda = new TiendaDTO();				
				tienda.setCodTienda(rs.getInt("codTienda"));
				tienda.setFoto(rs.getString("foto"));
				tienda.setNombreTienda(rs.getString("nombreTienda"));
				tienda.setDescripcion(rs.getString("descripcion"));
				tienda.setDireccion(rs.getString("direccion"));
				tienda.setTelefono(rs.getString("telefono"));
				tienda.setDiaAperTura(rs.getString("diaAperTura"));
				tienda.setDiaCierre(rs.getString("diaCierre"));
				tienda.setHoraApertura(rs.getString("horaApertura"));
				tienda.setHoraCierre(rs.getString("horaCierre"));				
				tienda.setCodUsuario(rs.getInt("codUsuario"));
				tienda.setCodPais(rs.getInt("codpais"));
				tienda.setCodDepa(rs.getInt("codDepartamento"));
				tienda.setCodTipoTienda(rs.getInt("codTipo"));
				listadoTienda.add(tienda);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listadoTienda;
	}

	//EndPonit
			//http://localhost:8080/turisteando/tiposgetttt/listadoTiendaPais
	
	@GET
	@Path("/listadoTiendaPais")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<TiendaDTO> listadoTiendaPais(TiendaDTO Tien){
		System.out.println("entro a listado Tienda Pais");
		
		List<TiendaDTO>listadoTiendaPais = new ArrayList<>();		
		try {
			
			//conxion sql a SQLServer
			Connection cn = new UtilBDSQL().getConnectionSQL();
			
			//llamar a procedure ListarTienda
			String procedimientoAlmacenado="{call ListarTiendaPais(?)}";
			CallableStatement call =cn.prepareCall(procedimientoAlmacenado);
			
			//con esta linea llamas a parametros
			call.setInt("CodPais", Tien.getCodPais());
			
			ResultSet rs = call.executeQuery();
			
			TiendaDTO tienda = new TiendaDTO();
			
			
			while (rs.next()) {
				tienda = new TiendaDTO();				
				tienda.setCodTienda(rs.getInt("codTienda"));
				tienda.setFoto(rs.getString("foto"));
				tienda.setNombreTienda(rs.getString("nombreTienda"));
				tienda.setDescripcion(rs.getString("descripcion"));
				tienda.setDireccion(rs.getString("direccion"));
				tienda.setTelefono(rs.getString("telefono"));
				tienda.setDiaAperTura(rs.getString("diaAperTura"));
				tienda.setDiaCierre(rs.getString("diaCierre"));
				tienda.setHoraApertura(rs.getString("horaApertura"));
				tienda.setHoraCierre(rs.getString("horaCierre"));
				tienda.setCodPais(rs.getInt("codpais"));			
				listadoTiendaPais.add(tienda);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Listo ?");
		return listadoTiendaPais;
	}
	

	//EndPonit
	//http://localhost:8080/turisteando/tiposgetttt/listadoTiendaPaisDepa
	
	@GET
	@Path("/listadoTiendaPaisDepa")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<TiendaDTO> listadoTiendaDepa(TiendaDTO Tien){
		System.out.println("entro a listado Tienda Pais Depa");
		
		List<TiendaDTO>listadoTiendaPais = new ArrayList<>();		
		try {
			
			//conxion sql a SQLServer
			Connection cn = new UtilBDSQL().getConnectionSQL();
			
			//llamar a procedure ListarTienda
			String procedimientoAlmacenado="{call ListarTiendaPaisDepartamento(?,?)}";
			CallableStatement call =cn.prepareCall(procedimientoAlmacenado);
			
			//con esta linea llamas a parametros
			call.setInt("CodPais", Tien.getCodPais());
			call.setInt("codDepa", Tien.getCodDepa());
			
			ResultSet rs = call.executeQuery();
			
			TiendaDTO tienda = new TiendaDTO();
			
			
			while (rs.next()) {
				tienda = new TiendaDTO();				
				tienda.setCodTienda(rs.getInt("codTienda"));
				tienda.setFoto(rs.getString("foto"));
				tienda.setNombreTienda(rs.getString("nombreTienda"));
				tienda.setDescripcion(rs.getString("descripcion"));
				tienda.setDireccion(rs.getString("direccion"));
				tienda.setTelefono(rs.getString("telefono"));
				tienda.setDiaAperTura(rs.getString("diaAperTura"));
				tienda.setDiaCierre(rs.getString("diaCierre"));
				tienda.setHoraApertura(rs.getString("horaApertura"));
				tienda.setHoraCierre(rs.getString("horaCierre"));
				tienda.setCodPais(rs.getInt("codpais"));			
				listadoTiendaPais.add(tienda);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Listo ?");
		return listadoTiendaPais;
	}
	

/*------------------------------------------------------------------------------Pais------------------------------------------------------------------------------------------------------*/
	
	//EndPonit
		//http://localhost:8080/turisteando/tiposgetttt/listadoPais
	
	@GET
	@Path("/listadoPais")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PaisDTO>listadoPais(){
		System.out.println("entro a listado Pais");
		
		List<PaisDTO>listadoPais = new ArrayList<>();		
		try {
			//conxion sql a SQLServer
			Connection cn = new UtilBDSQL().getConnectionSQL();
			//llamar a procedure ListarTienda
			String procedimientoAlmacenado="{call ListarPais}";
			CallableStatement call =cn.prepareCall(procedimientoAlmacenado);
			
			//con esta linea llamas a parametros
			//call.setInt(parameterIndex, x);
			
			ResultSet rs = call.executeQuery();
			
			//Statement stmt = UtilBDSQL.getConnectionSQL().createStatement();			
			//ResultSet rs = stmt.executeQuery("select * from usuario;");
			
			PaisDTO pais = new PaisDTO();
			
			
			while (rs.next()) {
				pais = new PaisDTO();				
				pais.setCodpais(rs.getInt("codpais"));
				pais.setNombrePais(rs.getString("nombrePais"));				
				listadoPais.add(pais);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listadoPais;
	}

/*------------------------------------------------------------------------------Departamento------------------------------------------------------------------------------------------------------*/
	
	//EndPonit
	//http://localhost:8080/turisteando/tiposgetttt/listadoDepa

	@GET
	@Path("/listadoDepa")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DepartamentoDTO>listadoDepa(){
		System.out.println("entro a listado Depa");
		
		List<DepartamentoDTO>listadoDepa = new ArrayList<>();		
		try {
			//conxion sql a SQLServer
			Connection cn = new UtilBDSQL().getConnectionSQL();
			//llamar a procedure ListarTienda
			String procedimientoAlmacenado="{call ListarDepartamento}";
			CallableStatement call =cn.prepareCall(procedimientoAlmacenado);
			
			//con esta linea llamas a parametros
			//call.setInt(parameterIndex, x);
			
			ResultSet rs = call.executeQuery();
			
			//Statement stmt = UtilBDSQL.getConnectionSQL().createStatement();			
			//ResultSet rs = stmt.executeQuery("select * from usuario;");
			
			DepartamentoDTO depa = new DepartamentoDTO();
			
			
			while (rs.next()) {
				depa = new DepartamentoDTO();				
				depa.setCodDepartamento(rs.getInt("codDepartamento"));
				depa.setNombreDepartamento(rs.getString("nombreDepartamento"));
				depa.setCodpais(rs.getInt("codPais"));
				listadoDepa.add(depa);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listadoDepa;
	}
	
/*------------------------------------------------------------------------------Producto------------------------------------------------------------------------------------------------------*/
	
	
	//EndPonit
	//http://localhost:8080/turisteando/tiposgetttt/listadoProductoTienda

	@GET
	@Path("/listadoProductoTienda")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductoDTO> listadoProductoTienda(ProductoDTO produc){
	System.out.println("entro a listado Producto Tienda");
	
	List<ProductoDTO>listadoProductoTienda = new ArrayList<>();		
	try {
		
		//conxion sql a SQLServer
		Connection cn = new UtilBDSQL().getConnectionSQL();
		
		//llamar a procedure ListarTienda
		String procedimientoAlmacenado="{call ListarProductosDeTienda(?)}";
		CallableStatement call =cn.prepareCall(procedimientoAlmacenado);
		
		//con esta linea llamas a parametros
		call.setInt("CodTienda", produc.getCodTienda());
		
		ResultSet rs = call.executeQuery();
		
		ProductoDTO producto = new ProductoDTO();
		
		
		while (rs.next()) {
			producto = new ProductoDTO();				
			producto.setCodProducto(rs.getInt("codProducto"));
			producto.setFotoProducto(rs.getString("fotoProducto"));
			producto.setNombreProducto(rs.getString("nombreProducto"));
			producto.setPrecio(rs.getDouble("precio"));
			producto.setDescripcion(rs.getString("descripcion"));
			producto.setStock(rs.getInt("stock"));
			producto.setCodTipoProducto(rs.getInt("codTipoProducto"));
			producto.setCodTienda(rs.getInt("codTienda"));			
			
			listadoProductoTienda.add(producto);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return listadoProductoTienda;
	}		
			
		
	
	
	
	
	
	
	
	
	
	
	
	
	

}
