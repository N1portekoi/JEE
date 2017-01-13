package be.condorcet.dao;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Struct;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;

import be.condorcet.beans.Adresse;
import be.condorcet.beans.MessageRecu;

public class DAOMessageSupprime extends DAO {
	public DAOMessageSupprime() {
		super();
	}
	
	// Recherche et fourni des messages recus mis en corbeille selon une adresse
	public ArrayList<MessageRecu> find(Adresse adresse) {
		ArrayList<MessageRecu> messagesRecus = null;
		try {
			CallableStatement statement = connect.prepareCall("{call PROCEDURE_MAILSSUPPRIMES(?,?)}");
			statement.setString(1, adresse.getAdresse());
			statement.registerOutParameter(2, Types.ARRAY, "TYPE_TABMAILS");
			statement.execute();
			Array resultArray = (Array)statement.getObject(2);
		    Object[] resultStructArray = (Object[])resultArray.getArray();
		    messagesRecus = new ArrayList<>();
		    for (int i = 0; i < resultStructArray.length; i++) {
		    	Struct resultElement = (Struct)resultStructArray[i];
		    	MessageRecu emailRecu = new MessageRecu();
			    emailRecu.setId(((BigDecimal)resultElement.getAttributes()[0]).intValue());
			    emailRecu.setExpediteur((String) resultElement.getAttributes()[1]);
			    emailRecu.setDestinataire(adresse);
			    emailRecu.setObjet((String) resultElement.getAttributes()[3]);
			    emailRecu.setEtat(((BigDecimal)resultElement.getAttributes()[5]).intValue());
			    emailRecu.setDate(((Timestamp)resultElement.getAttributes()[6]).toLocalDateTime().toLocalDate());
			    messagesRecus.add(emailRecu);
		    }
		} catch (SQLException e) {
			message = "Probl�me de base de donn�e !";
		}
		return messagesRecus;
	}
}


