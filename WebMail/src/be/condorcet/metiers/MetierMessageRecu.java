package be.condorcet.metiers;

import be.condorcet.beans.MessageRecu;
import be.condorcet.dao.DAOMessageRecu;

public class MetierMessageRecu {
	private int id;
	private String message;
	
	public MetierMessageRecu(int id) {
		this.id = id;
	}
	
	public String getMessage() { return message; }
	
	// Recupere un message recu
	public MessageRecu messageRecu() {
		DAOMessageRecu daoMessageRecu = new DAOMessageRecu();
		MessageRecu messageRecu = daoMessageRecu.find(id);
		message = daoMessageRecu.getMessage();
    	return messageRecu;
	}
}