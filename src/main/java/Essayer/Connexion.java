package Essayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	
	private static String url = "jdbc:mysql://localhost:3306/clubDRAME?serverTimezone=GMT";
	//String url = "jdbc:postgresql://localhost:5432/club";
	private static String user = "root";
	private static String password = "";
	private static Connection co = null;
	
	public static Connection getCo() {
		try {
		    co = DriverManager.getConnection(url, user, password);
		    if (co != null) {
		        System.out.println("Connexion réussie !");
		    } else {
		        System.out.println("Echec de le connexion!");
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return co;
	}
	
	public static boolean disconnect() {
		if (co!=null)
			try {
				co.close();
				System.out.println("Déconnexion réussie !");
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}

}
