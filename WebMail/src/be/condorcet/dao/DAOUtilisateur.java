package be.condorcet.dao;

import java.sql.*;

import be.condorcet.beans.Utilisateur;

public class DAOUtilisateur extends DAO {
	public DAOUtilisateur() {
		super();
	}
	
	// Cr�e un utilisateur
	public boolean create (Utilisateur utilisateur)  {
		boolean create = true;
		CallableStatement statement = null;
		try {
			statement = connect.prepareCall("{call PROCEDURE_ENREGISTREMENT(?,?,?,?,?)}");
			statement.setString(1, utilisateur.getNom());
			statement.setString(2, utilisateur.getPrenom());
			statement.setString(3, utilisateur.getPseudo());
			statement.setString(4, utilisateur.getPassword());
			statement.registerOutParameter(5, Types.INTEGER);
			statement.execute();
			if (statement.getInt(5) == 0) {
				message = "Enregistrement effectu� !";
			}
			else {
				message = "Login d�ja existant !";
				create = false;
			}
		} catch (SQLException e) {
			message = "Probl�me de base de donn�e !";
			create = false;
		}
		return create;
	}
	
	// R�cupere un utilisateur si pseudo et password correcte, sinon null
	public Utilisateur find(String pseudo, String password) {
		Utilisateur utilisateur = null;
		try {
			CallableStatement statement = connect.prepareCall("{call PROCEDURE_CONNEXION(?,?,?,?,?)}");
			statement.setString(1, pseudo);
			statement.setString(2, password);
			statement.registerOutParameter(3, Types.INTEGER);
			statement.registerOutParameter(4, Types.VARCHAR);
			statement.registerOutParameter(5, Types.VARCHAR);
			statement.execute();
			if (statement.getInt(3) == 1) {
				utilisateur = new Utilisateur();
				utilisateur.setPseudo(pseudo);
				utilisateur.setNom(statement.getString(4));
				utilisateur.setPrenom(statement.getString(5));
			}
			else {
				message = "Login/Password incorrect !";
			}
		} catch (SQLException e) {
			message = "Probl�me de base de donn�e !";
		}
		return utilisateur;
	}
}


