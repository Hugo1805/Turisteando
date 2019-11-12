package pe.com.turisteando.util.BD;

import java.sql.Connection;
import java.sql.DriverManager;

public class UtilBDSQL {
	
	private static Connection cn;
	
	public static Connection getConnectionSQL() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//cn=DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=Turisteando","sa","sql");
			cn=DriverManager.getConnection("jdbc:sqlserver://turisteandodb.database.windows.net:1433;database=Turistenado;user=administrador@turisteandodb;password=Turisteandobd01;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
		} catch (Exception e) {
			cn=null;
		}
		
		return cn;
	}
	
	public static void main(String[] args){
		Connection pruebaCn=UtilBDSQL.getConnectionSQL();
		if(pruebaCn!= null) {
			System.out.println("Conectado");
			System.out.println(pruebaCn);
		}else
		{
			System.out.println("Desconectado");
		}
	}

}
