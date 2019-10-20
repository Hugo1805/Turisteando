package pe.com.turisteando.rest.get;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Past;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mysql.cj.protocol.Message;
import com.mysql.cj.xdevapi.PreparableStatement;

//import com.mysql.jdbc.Connection;

//import com.mysql.jdbc.Pr;
import com.mysql.jdbc.Driver;

import pe.com.turisteando.rest.dto.usuarioDTO;
import pe.com.turisteando.util.BD.UtilBD;



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
	
	
	//EndPonit
	//http://localhost:8080/turisteando/tiposgetttt/listadoUsuario
		
	@GET
	@Path("/listadoUsuario")
	@Produces(MediaType.APPLICATION_JSON)
	public List<usuarioDTO>listadoUsuario(){
		System.out.println("entro a listado usuario");
		
		List<usuarioDTO>listadoUsuario = new ArrayList<>();		
		try {
			Statement stmt = UtilBD.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select * from usuario");
			
			usuarioDTO usu = new usuarioDTO();
			while (rs.next()) {
				usu = new usuarioDTO();
				usu.setUsuario(rs.getString("usuario"));
				usu.setClave(rs.getString("clave")); 
				
				listadoUsuario.add(usu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listadoUsuario;
	}

	
	//EndPonit
	//http://localhost:8080/turisteando/tiposgetttt/inUsu
	
	@POST
	@Path("/inUsu")
	@Consumes(MediaType.CHARSET_PARAMETER)	
	public void inUsuario(@FormParam("usuario")String usuario,@FormParam("clave") String clave){
		
		System.out.println("Entro a inUsu");
		
		usuarioDTO usu = new usuarioDTO();
		usu.setUsuario(usuario);
		usu.setClave(clave);
		
		try {
			Connection cn = UtilBD.getConnection();
			PreparedStatement pst = cn.prepareStatement("INSERT INTO usuario (usuario, clave) VALUES (?,?)");
			
			pst.setString(1,usu.getUsuario());
			pst.setString(2,usu.getClave());
			pst.executeUpdate();
						
			System.out.println("usuario ingresado"+ " " + usu.getUsuario()+ " " + usu.getClave());
			
			cn.close();
			
			System.out.println("salio de inUsu");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
