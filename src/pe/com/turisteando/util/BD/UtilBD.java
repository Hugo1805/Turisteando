package pe.com.turisteando.util.BD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class UtilBD {

    public static Connection getConnection(){
    	Connection con = null;
        try {
        	System.out.println("Entro a connecion");
        	
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost/prueba?useTimezone=true&serverTimezone=UTC";
            String usr = "root";
            String psw = "mysql";
            
            con = DriverManager.getConnection(url,usr,psw);
 
        } catch (ClassNotFoundException e) {
        	
        	System.out.println("Error >> Drive no instalado");
           
             
        } catch (SQLException e) {
        	System.out.println("Error >> de conexion con la BD");            
             
        }catch (Exception e) {
			System.out.println("Error >> " + e.getMessage());
		}
        return con;
    }


}
