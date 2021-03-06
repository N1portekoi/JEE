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
import be.condorcet.beans.MessageIndesirable;

public class DAOMessageIndesirable extends DAO {
	public DAOMessageIndesirable() {
		super();
	}
	
	// Recherche et fourni un message indesirable selon l'id
	public MessageIndesirable find(int id) {
		MessageIndesirable messageIndesirable= null;
		try {
			CallableStatement statement = connect.prepareCall("{call PROCEDURE_MAIL(?,?)}");
			statement.setInt(1, id);
			statement.registerOutParameter(2, Types.STRUCT, "TYPE_MAIL");
			statement.execute();
			Struct resultElement = (Struct) statement.getObject(2);
			messageIndesirable = new MessageIndesirable();
			messageIndesirable.setId(((BigDecimal)resultElement.getAttributes()[0]).intValue());
			messageIndesirable.setExpediteur((String) resultElement.getAttributes()[1]);
			messageIndesirable.setObjet((String) resultElement.getAttributes()[3]);
			messageIndesirable.setMessage((String) resultElement.getAttributes()[4]);
		} catch (SQLException e) {
			messageIndesirable = null;
			message = "Probl�me de base de donn�e !";
		}
		return messageIndesirable;
	}
	
	// Recherche et fourni des messages indesirables selon une adresse
	public ArrayList<MessageIndesirable> find(Adresse adresse) {
		
		ArrayList<MessageIndesirable> messagesIndesirable = null;
		try {
			CallableStatement statement = connect.prepareCall("{call PROCEDURE_MAILSINDESIRABLES(?,?)}");
			statement.setString(1, adresse.getAdresse());
			statement.registerOutParameter(2, Types.ARRAY, "TYPE_TABMAILS");
			statement.execute();
			Array resultArray = (Array)statement.getObject(2);
		    Object[] resultStructArray = (Object[])resultArray.getArray();
		    messagesIndesirable = new ArrayList<>();
		    for (int i = 0; i < resultStructArray.length; i++) {
		    	Struct resultElement = (Struct)resultStructArray[i];
		    	MessageIndesirable messageIndesirable = new MessageIndesirable();
		    	messageIndesirable.setId(((BigDecimal)resultElement.getAttributes()[0]).intValue());
		    	messageIndesirable.setExpediteur((String) resultElement.getAttributes()[1]);
		    	messageIndesirable.setDestinataire(adresse);
		    	messageIndesirable.setObjet((String) resultElement.getAttributes()[3]);
		    	messageIndesirable.setEtat(((BigDecimal)resultElement.getAttributes()[5]).intValue());
		    	messageIndesirable.setDate(((Timestamp)resultElement.getAttributes()[6]).toLocalDateTime().toLocalDate());
		    	messagesIndesirable.add(messageIndesirable);
		    }
		} catch (SQLException e) {
			message = "Probl�me de base de donn�e !";
		}
		return messagesIndesirable;
	}
}


