package prue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class prue {
	
	private static String dia1;
	private static String dia2;
	private static String dia3;
	private static String dia4;
	private static String dia5;
	private static String dia6;
	private static String dia7;

	public static void main(String[] args) {
		
		int dia[] = { 0, 0, 0, 0, 0, 0, 0 };
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://54.235.194.103/bd_s&fhub", "Conectar",
					"12345678");

			Statement s = conexion.createStatement();
			ResultSet rs = s.executeQuery("SELECT Fecha, COUNT(Fecha) FROM usuario GROUP BY Fecha ORDER BY Fecha DESC LIMIT 7");

			int i = 0;
			
			while (rs.next()){
				dia[i] = Integer.parseInt(rs.getString(2));
				i++;
			}
			
			for (int j = 0; j < dia.length; j++) {
				
				System.out.println(dia[j]);
			}
			
			
		} catch (Exception e) {

		}
	}

}
