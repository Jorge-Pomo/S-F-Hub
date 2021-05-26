package prue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class prue {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://54.235.194.103/bd_s&fhub", "Conectar", "12345678");
			System.out.println("si");
			Statement  s = conexion.createStatement();
			
			//ResultSet rs = s.executeQuery ("INSERT INTO usuario VALUES (DEFAULT, "+ txtUser + ", "+ txtContra + ", "+ checkPublicidad + ", "+ checkPrivacidad + ", " + txtTelef + ", " + txtEmail +")");
			
			ResultSet rs = s.executeQuery ("SELECT * FROM usuario");
			
			while (rs.next()){
				
				System.out.println (rs.getString(1));
				
				}
			
			conexion.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
