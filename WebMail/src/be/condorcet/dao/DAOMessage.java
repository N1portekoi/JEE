package be.condorcet.dao;

import java.sql.CallableStatement;
import java.sql.SQLException;

public class DAOMessage extends DAO {
	public DAOMessage() {
		super();
	}
	
	// Retire ou met dans la corbeille le message selon son etat
	// IN : id du message
	public boolean update(int id) {
		boolean ok = true;
		try {
			CallableStatement statement = connect.prepareCall("{call PROCEDURE_UPDATEMAIL(?)}");
			statement.setInt(1, id);
			statement.execute();
		} catch (SQLException e) {
			ok = false;
			message = "Problème de base de donnée !";
		}
		return ok;
	}
	
	// Supprime definitivement le message
	// IN : id du message
	public boolean delete(int id) {
		boolean ok = true;
		try {
			CallableStatement statement = connect.prepareCall("{call PROCEDURE_REMOVEMAIL(?)}");
			statement.setInt(1, id);
			statement.execute();
		} catch (SQLException e) {
			ok = false;
			message = "Problème de base de donnée !";
		}
		return ok;
	}
}


