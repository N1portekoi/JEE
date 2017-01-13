package be.condorcet.dao;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

public class DAOAdresseIndesirable extends DAO {
	public DAOAdresseIndesirable() {
		super();
	}
	
	public boolean create (String adresse, String adresseInde)  {
		boolean create = true;
		CallableStatement statement = null;
		try {
			statement = connect.prepareCall("{call PROCEDURE_ADDADRESSEINDE(?,?,?)}");
			statement.setString(1, adresse);
			statement.setString(2, adresseInde);
			statement.registerOutParameter(3, Types.INTEGER);
			statement.execute();
			if (statement.getInt(3) == 1) {
				message = "Adresse d�ja existante !";
				create = false;
			}
		} catch (SQLException e) {
			message = "Probl�me de base de donn�e !";
			create = false;
		}
		return create;
	}
	
	public ArrayList<String> find(String adresse) {
		ArrayList<String> adresses = null;
		try {
			CallableStatement statement = connect.prepareCall("{call PROCEDURE_ADRESSESINDE(?,?)}");
			statement.setString(1, adresse);
			statement.registerOutParameter(2, Types.ARRAY, "TYPE_TABADRESSES");
			statement.execute();
			String[] tab = (String[]) statement.getArray(2).getArray();
			adresses = new ArrayList<>();
			for (String s : tab) {
				adresses.add(s);
			}
		} catch (SQLException e) {
			message = "Probl�me de base de donn�e !";
		}
		return adresses;
	}
	
	public boolean delete (String adresse, String adresseInde) {
		boolean delete = true;
		CallableStatement statement = null;
		try {
			statement = connect.prepareCall("{call PROCEDURE_REMOVEADRESSEINDE(?, ?)}");
			statement.setString(1, adresse);
			statement.setString(2, adresseInde);
			statement.execute();
		} catch (SQLException e) {
			message = "Probl�me de base de donn�e !";
			delete = false;
		}
		return delete;
	}
}


