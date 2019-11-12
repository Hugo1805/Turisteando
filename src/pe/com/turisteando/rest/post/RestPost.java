package pe.com.turisteando.rest.post;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pe.com.turisteando.rest.dto.DepartamentoDTO;
import pe.com.turisteando.rest.dto.PaisDTO;
import pe.com.turisteando.rest.dto.ProductoDTO;
import pe.com.turisteando.rest.dto.RespuestaDTO;
import pe.com.turisteando.rest.dto.TiendaDTO;
import pe.com.turisteando.rest.dto.UsuarioDTO;
import pe.com.turisteando.util.BD.UtilBD;
import pe.com.turisteando.util.BD.UtilBDSQL;

@Path("/tipopostt")
public class RestPost {

/*-----------------------------------------------------------------------------Usuarios-----------------------------------------------------------------------------------------------------*/

	// EndPonit
	// http://localhost:8080/turisteando/tipopostt/inUsu

	@POST
	@Path("/inUsu")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO inUsu(UsuarioDTO usuIn) {

		System.out.println("Entro a inUsu");

		RespuestaDTO respuesta = new RespuestaDTO();

		System.out.println("Usuario: " + usuIn.getUsuario());
		System.out.println("Clave: " + usuIn.getClave());

		try {
			Connection cn = UtilBDSQL.getConnectionSQL();
			// PreparedStatement pst = cn.prepareStatement("INSERT INTO usuario VALUES
			// (?,?)");
			String procedimientoAlmacenado = "{call CrearUsers(?,?,?,?,?,?,?)}";
			CallableStatement call = cn.prepareCall(procedimientoAlmacenado);

			call.setString(1, usuIn.getUsuario());
			call.setString(2, usuIn.getNombre());
			call.setString(3, usuIn.getApellido());
			call.setString(4, usuIn.getEmail());
			call.setString(5, usuIn.getClave());
			call.setInt(6, usuIn.getCodPais());
			call.setInt(7, usuIn.getCodDepa());

			call.executeUpdate();

			cn.close();

			respuesta.setEstado(0);
			respuesta.setMensaje("usuario" + usuIn.getUsuario() + " a sido registrado con exito");

			System.out.println("salio de inUsu");
		} catch (Exception e) {
			respuesta.setEstado(1);
			e.printStackTrace();
		}
		return respuesta;
	}

	// EndPonit
	// http://localhost:8080/turisteando/tipopostt/AcUsu

	@POST
	@Path("/AcUsu")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO AcUsu(UsuarioDTO AcUsu) {

		System.out.println("Entro a AcUsu");

		RespuestaDTO respuesta = new RespuestaDTO();

		// System.out.println("Usuario: "+ usuIn.getUsuario());
		// System.out.println("Clave: "+ usuIn.getClave());

		try {
			Connection cn = UtilBDSQL.getConnectionSQL();
			// PreparedStatement pst = cn.prepareStatement("INSERT INTO usuario VALUES
			// (?,?)");
			String procedimientoAlmacenado = "{call ActualizarUsers(?,?,?,?,?,?,?,?)}";
			CallableStatement call = cn.prepareCall(procedimientoAlmacenado);

			call.setInt(1, AcUsu.getCodUsuario());
			call.setString(2, AcUsu.getUsuario());
			call.setString(3, AcUsu.getNombre());
			call.setString(4, AcUsu.getApellido());
			call.setString(5, AcUsu.getEmail());
			call.setString(6, AcUsu.getClave());
			call.setInt(7, AcUsu.getCodPais());
			call.setInt(8, AcUsu.getCodDepa());

			call.executeUpdate();

			cn.close();

			respuesta.setEstado(0);
			respuesta.setMensaje("usuario" + AcUsu.getUsuario() + " a sido Actualizado con exito");

			System.out.println("salio de inUsu");
		} catch (Exception e) {
			respuesta.setEstado(1);
			e.printStackTrace();
		}
		return respuesta;
	}

	// EndPonit
	// http://localhost:8080/turisteando/tipopostt/EliUsu

	@POST
	@Path("/EliUsu")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO EliUsu(UsuarioDTO EliUsu) {

		System.out.println("Entro a EliUsu");

		RespuestaDTO respuesta = new RespuestaDTO();

		// System.out.println("Usuario: "+ usuIn.getUsuario());
		// System.out.println("Clave: "+ usuIn.getClave());

		try {
			Connection cn = UtilBDSQL.getConnectionSQL();
			// PreparedStatement pst = cn.prepareStatement("INSERT INTO usuario VALUES
			// (?,?)");
			String procedimientoAlmacenado = "{call EliminarUsers(?)}";
			CallableStatement call = cn.prepareCall(procedimientoAlmacenado);

			call.setInt(1, EliUsu.getCodUsuario());

			call.executeUpdate();

			cn.close();

			respuesta.setEstado(0);
			// respuesta.setMensaje("usuario" + EliUsu.getUsuario() + " a sido Eliminado con
			// exito");

			System.out.println("salio de inUsu");
		} catch (Exception e) {
			respuesta.setEstado(1);
			e.printStackTrace();
		}
		return respuesta;
	}

/*------------------------------------------------------------------------------Tienda------------------------------------------------------------------------------------------------------*/

	// EndPonit
	// http://localhost:8080/turisteando/tipopostt/inTienda

	@POST
	@Path("/inTienda")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO inTienda(TiendaDTO inTienda) {

		System.out.println("Entro a inTienda");

		RespuestaDTO respuesta = new RespuestaDTO();

		try {
			Connection cn = UtilBDSQL.getConnectionSQL();
			// PreparedStatement pst = cn.prepareStatement("INSERT INTO usuario VALUES
			// (?,?)");
			String procedimientoAlmacenado = "{call CrearTienda(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			CallableStatement call = cn.prepareCall(procedimientoAlmacenado);

			call.setString(1, inTienda.getFoto());
			call.setString(2, inTienda.getNombreTienda());
			call.setString(3, inTienda.getDescripcion());
			call.setString(4, inTienda.getDireccion());
			call.setString(5, inTienda.getTelefono());
			call.setString(6, inTienda.getDiaAperTura());
			call.setString(7, inTienda.getDiaCierre());
			call.setString(8, inTienda.getHoraApertura());
			call.setString(9, inTienda.getHoraCierre());
			call.setInt(10, inTienda.getCodUsuario());
			call.setInt(11, inTienda.getCodPais());
			call.setInt(12, inTienda.getCodDepa());
			call.setInt(13, inTienda.getCodTipoTienda());

			call.executeUpdate();

			cn.close();

			respuesta.setEstado(0);
			respuesta.setMensaje("Tienda: " + inTienda.getNombreTienda() + " a sido registrado con exito");

			System.out.println("salio de inUsu");
		} catch (Exception e) {
			respuesta.setEstado(1);
			e.printStackTrace();
		}
		return respuesta;
	}

	// EndPonit
	// http://localhost:8080/turisteando/tipopostt/AcTienda

	@POST
	@Path("/AcTienda")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO AcTienda(TiendaDTO AcTienda) {

		System.out.println("Entro a AcTienda");

		RespuestaDTO respuesta = new RespuestaDTO();

		// System.out.println("Usuario: "+ usuIn.getUsuario());
		// System.out.println("Clave: "+ usuIn.getClave());

		try {
			Connection cn = UtilBDSQL.getConnectionSQL();
			// PreparedStatement pst = cn.prepareStatement("INSERT INTO usuario VALUES
			// (?,?)");
			String procedimientoAlmacenado = "{call ActualizarTienda(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			CallableStatement call = cn.prepareCall(procedimientoAlmacenado);

			call.setInt(1, AcTienda.getCodTienda());
			call.setString(2, AcTienda.getFoto());
			call.setString(3, AcTienda.getNombreTienda());
			call.setString(4, AcTienda.getDescripcion());
			call.setString(5, AcTienda.getDireccion());
			call.setString(6, AcTienda.getTelefono());
			call.setString(7, AcTienda.getDiaAperTura());
			call.setString(8, AcTienda.getDiaCierre());
			call.setString(9, AcTienda.getHoraApertura());
			call.setString(10, AcTienda.getHoraCierre());
			call.setInt(11, AcTienda.getCodUsuario());
			call.setInt(12, AcTienda.getCodPais());
			call.setInt(13, AcTienda.getCodDepa());
			call.setInt(14, AcTienda.getCodTipoTienda());

			call.executeUpdate();

			cn.close();

			respuesta.setEstado(0);
			respuesta.setMensaje("Tienda: " + AcTienda.getNombreTienda() + " a sido Actualizado con exito");

			System.out.println("salio de inUsu");
		} catch (Exception e) {
			respuesta.setEstado(1);
			e.printStackTrace();
		}
		return respuesta;
	}

	// EndPonit
	// http://localhost:8080/turisteando/tipopostt/EliTienda

	@POST
	@Path("/EliTienda")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO EliTienda(TiendaDTO EliTienda) {

		System.out.println("Entro a EliTienda");

		RespuestaDTO respuesta = new RespuestaDTO();

		try {
			Connection cn = UtilBDSQL.getConnectionSQL();
			String procedimientoAlmacenado = "{call EliminarTienda(?)}";
			CallableStatement call = cn.prepareCall(procedimientoAlmacenado);

			call.setInt(1, EliTienda.getCodTienda());

			call.executeUpdate();

			cn.close();

			respuesta.setEstado(0);
			// respuesta.setMensaje("Tienda: " + EliTienda.getNombreTienda() + " a sido
			// Eliminado con exito");

			System.out.println("salio de EliTienda");
		} catch (Exception e) {
			respuesta.setEstado(1);
			e.printStackTrace();
		}
		return respuesta;
	}

/*------------------------------------------------------------------------------Producto------------------------------------------------------------------------------------------------------*/

	// EndPonit
	// http://localhost:8080/turisteando/tipopostt/inProducto

	@POST
	@Path("/inProducto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO inProducto(ProductoDTO inProducto) {

		System.out.println("Entro a inProducto");

		RespuestaDTO respuesta = new RespuestaDTO();

		try {
			Connection cn = UtilBDSQL.getConnectionSQL();

			String procedimientoAlmacenado = "{call CrearProducto(?,?,?,?,?,?,?)}";
			CallableStatement call = cn.prepareCall(procedimientoAlmacenado);

			call.setString(1, inProducto.getFotoProducto());
			call.setString(2, inProducto.getNombreProducto());
			call.setDouble(3, inProducto.getPrecio());
			call.setString(4, inProducto.getDescripcion());
			call.setInt(5, inProducto.getStock());
			call.setInt(6, inProducto.getCodTipoProducto());
			call.setInt(7, inProducto.getCodTienda());

			call.executeUpdate();

			cn.close();

			respuesta.setEstado(0);
			respuesta.setMensaje("Producto: " + inProducto.getNombreProducto() + " a sido registrado con exito");

			System.out.println("salio de inProducto");
		} catch (Exception e) {
			respuesta.setEstado(1);
			e.printStackTrace();
		}
		return respuesta;
	}

	// EndPonit
	// http://localhost:8080/turisteando/tipopostt/AcProducto

	@POST
	@Path("/AcProducto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO AcProducto(ProductoDTO AcProducto) {

		System.out.println("Entro a AcProducto");

		RespuestaDTO respuesta = new RespuestaDTO();

		// System.out.println("Usuario: "+ usuIn.getUsuario());
		// System.out.println("Clave: "+ usuIn.getClave());

		try {
			Connection cn = UtilBDSQL.getConnectionSQL();
			String procedimientoAlmacenado = "{call ActualizarProducto(?,?,?,?,?,?,?)}";
			CallableStatement call = cn.prepareCall(procedimientoAlmacenado);

			call.setInt(1, AcProducto.getCodProducto());
			call.setString(2, AcProducto.getFotoProducto());
			call.setString(3, AcProducto.getNombreProducto());
			call.setDouble(4, AcProducto.getPrecio());
			call.setString(5, AcProducto.getDescripcion());
			call.setInt(6, AcProducto.getStock());
			call.setInt(7, AcProducto.getCodTipoProducto());

			call.executeUpdate();

			cn.close();

			respuesta.setEstado(0);
			respuesta.setMensaje("Producto: " + AcProducto.getNombreProducto() + " a sido Actualizado con exito");

			System.out.println("salio de AcProducto");
		} catch (Exception e) {
			respuesta.setEstado(1);
			e.printStackTrace();
		}
		return respuesta;
	}

	// EndPonit
	// http://localhost:8080/turisteando/tipopostt/EliProducto

	@POST
	@Path("/EliProducto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO EliProducto(ProductoDTO EliProducto) {

		System.out.println("Entro a EliProducto");

		RespuestaDTO respuesta = new RespuestaDTO();

		try {
			Connection cn = UtilBDSQL.getConnectionSQL();
			String procedimientoAlmacenado = "{call EliminarProducto(?)}";
			CallableStatement call = cn.prepareCall(procedimientoAlmacenado);

			call.setInt(1, EliProducto.getCodProducto());

			call.executeUpdate();

			cn.close();

			respuesta.setEstado(0);
			// respuesta.setMensaje("Tienda: " + EliTienda.getNombreTienda() + " a sido
			// Eliminado con exito");

			System.out.println("salio de EliProducto");
		} catch (Exception e) {
			respuesta.setEstado(1);
			e.printStackTrace();
		}
		return respuesta;
	}

/*------------------------------------------------------------------------------Pais------------------------------------------------------------------------------------------------------*/

	// EndPonit
	// http://localhost:8080/turisteando/tipopostt/inPais

	@POST
	@Path("/inPais")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO inPais(PaisDTO inPais) {

		System.out.println("Entro a inPais");

		RespuestaDTO respuesta = new RespuestaDTO();

		try {
			Connection cn = UtilBDSQL.getConnectionSQL();

			String procedimientoAlmacenado = "{call CrearPais(?)}";
			CallableStatement call = cn.prepareCall(procedimientoAlmacenado);

			call.setString(1, inPais.getNombrePais());			

			call.executeUpdate();

			cn.close();

			respuesta.setEstado(0);
			respuesta.setMensaje("Pais: " + inPais.getNombrePais() + " a sido registrado con exito");

			System.out.println("salio de inPais");
		} catch (Exception e) {
			respuesta.setEstado(1);
			e.printStackTrace();
		}
		return respuesta;
	}

	// EndPonit
	// http://localhost:8080/turisteando/tipopostt/AcPais

	@POST
	@Path("/AcPais")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO AcPais(PaisDTO AcPais) {

		System.out.println("Entro a AcPais");

		RespuestaDTO respuesta = new RespuestaDTO();

		// System.out.println("Usuario: "+ usuIn.getUsuario());
		// System.out.println("Clave: "+ usuIn.getClave());

		try {
			Connection cn = UtilBDSQL.getConnectionSQL();
			String procedimientoAlmacenado = "{call ActualizarPais(?,?)}";
			CallableStatement call = cn.prepareCall(procedimientoAlmacenado);

			call.setInt(1, AcPais.getCodpais());
			call.setString(2, AcPais.getNombrePais());
			

			call.executeUpdate();

			cn.close();

			respuesta.setEstado(0);
			respuesta.setMensaje("Pais: " + AcPais.getNombrePais() + " a sido Actualizado con exito");

			System.out.println("salio de AcPais");
		} catch (Exception e) {
			respuesta.setEstado(1);
			e.printStackTrace();
		}
		return respuesta;
	}

	// EndPonit
	// http://localhost:8080/turisteando/tipopostt/EliProducto

	@POST
	@Path("/EliPais")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO EliPais(PaisDTO EliPais) {

		System.out.println("Entro a EliPais");

		RespuestaDTO respuesta = new RespuestaDTO();

		try {
			Connection cn = UtilBDSQL.getConnectionSQL();
			String procedimientoAlmacenado = "{call EliminarPais(?)}";
			CallableStatement call = cn.prepareCall(procedimientoAlmacenado);

			call.setInt(1, EliPais.getCodpais());

			call.executeUpdate();

			cn.close();

			respuesta.setEstado(0);			

			System.out.println("salio de EliProducto");
		} catch (Exception e) {
			respuesta.setEstado(1);
			e.printStackTrace();
		}
		return respuesta;
	}

/*------------------------------------------------------------------------------Departamento------------------------------------------------------------------------------------------------------*/

	// EndPonit
	// http://localhost:8080/turisteando/tipopostt/inDepa
	@POST
	@Path("/inDepa")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO inDepa(DepartamentoDTO inDepa) {

		System.out.println("Entro a inDepa");

		RespuestaDTO respuesta = new RespuestaDTO();

		try {
			Connection cn = UtilBDSQL.getConnectionSQL();

			String procedimientoAlmacenado = "{call CrearDepartamento(?,?)}";
			CallableStatement call = cn.prepareCall(procedimientoAlmacenado);

			call.setString(1, inDepa.getNombreDepartamento());
			call.setInt(2, inDepa.getCodpais());
					

			call.executeUpdate();

			cn.close();

			respuesta.setEstado(0);
			respuesta.setMensaje("Departamento: " + inDepa.getNombreDepartamento() + " a sido registrado con exito");

			System.out.println("salio de inProducto");
		} catch (Exception e) {
			respuesta.setEstado(1);
			e.printStackTrace();
		}
		return respuesta;
	}

	// EndPonit
	// http://localhost:8080/turisteando/tipopostt/AcDepa

	@POST
	@Path("/AcDepa")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO AcDepa(DepartamentoDTO AcDepa) {

		System.out.println("Entro a AcDepa");

		RespuestaDTO respuesta = new RespuestaDTO();

		// System.out.println("Usuario: "+ usuIn.getUsuario());
		// System.out.println("Clave: "+ usuIn.getClave());

		try {
			Connection cn = UtilBDSQL.getConnectionSQL();
			String procedimientoAlmacenado = "{call ActualizarDepartamento(?,?,?)}";
			CallableStatement call = cn.prepareCall(procedimientoAlmacenado);

			call.setInt(1, AcDepa.getCodDepartamento());
			call.setInt(2, AcDepa.getCodpais());			
			call.setString(3, AcDepa.getNombreDepartamento());

			call.executeUpdate();

			cn.close();

			respuesta.setEstado(0);
			respuesta.setMensaje("Departamento: " + AcDepa.getNombreDepartamento() + " a sido Actualizado con exito");

			System.out.println("salio de AcProducto");
		} catch (Exception e) {
			respuesta.setEstado(1);
			e.printStackTrace();
		}
		return respuesta;
	}

	// EndPonit
	// http://localhost:8080/turisteando/tipopostt/EliDepa

	@POST
	@Path("/EliDepa")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO EliDepa(DepartamentoDTO EliDepa) {

		System.out.println("Entro a EliDepa");

		RespuestaDTO respuesta = new RespuestaDTO();

		try {
			Connection cn = UtilBDSQL.getConnectionSQL();
			String procedimientoAlmacenado = "{call EliminarDepartamento(?)}";
			CallableStatement call = cn.prepareCall(procedimientoAlmacenado);

			call.setInt(1, EliDepa.getCodDepartamento());

			call.executeUpdate();

			cn.close();

			respuesta.setEstado(0);			

			System.out.println("salio de EliDepa");
		} catch (Exception e) {
			respuesta.setEstado(1);
			e.printStackTrace();
		}
		return respuesta;
	}


/*------------------------------------------------------------------------------Login------------------------------------------------------------------------------------------------------*/
	
	// EndPonit
		// http://localhost:8080/turisteando/tipopostt/login

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO Login(UsuarioDTO login) {

		System.out.println("Entro a EliDepa");

		RespuestaDTO respuesta = new RespuestaDTO();

		try {
			Connection cn = UtilBDSQL.getConnectionSQL();
			String procedimientoAlmacenado = "{call LOGEO(?,?)}";
			CallableStatement call = cn.prepareCall(procedimientoAlmacenado);			
			
			call.setString(1, login.getUsuario());
			call.setString(2, login.getClave());

			//call.executeUpdate();

			cn.close();

			respuesta.setEstado(1);			

			System.out.println("salio de Login");
		} catch (Exception e) {
			respuesta.setEstado(0);
			e.printStackTrace();
		}
		return respuesta;
	}




















	
	
}