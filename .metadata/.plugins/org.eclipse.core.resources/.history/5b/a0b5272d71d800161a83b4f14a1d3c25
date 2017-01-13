package be.condorcet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverACCESS {
	private static Connection snglConnection = null;

    private DriverACCESS() {
    	try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	snglConnection  = DriverManager.getConnection("jdbc:oracle:thin:exa9/examen@char-oracle11.condorcet.be:1521:xe");
        } catch (ClassNotFoundException e) {
        	System.out.println("Impossible de trouver le driver pour la base de donnée!");
        } catch (SQLException e) {
        	System.out.println("Impossible de se connecter à  la base de donnée.");
        }
        if (snglConnection == null) {
        	System.out.println("La base de donnée est innaccessible, fermeture du programme.");
            System.exit(0);
        }
    }

    public static Connection getInstance() {
        if (snglConnection == null) {
            new DriverACCESS();
        }
        return snglConnection;
    }
}