package be.condorcet.metiers;

import be.condorcet.beans.MessageEnvoye;
import be.condorcet.dao.DAOMessageEnvoye;

public class MetierMessageEnvoye {
	private int id;
	private String message;
	
	public MetierMessageEnvoye(int id) {
		this.id = id;
	}
	
	public String getMessage() { return message; }
	
	// Recupere un message envoyé
	public MessageEnvoye messageEnvoye() {
		DAOMessageEnvoye daoMessageEvoye= new DAOMessageEnvoye();
		MessageEnvoye messageEnvoye = daoMessageEvoye.find(id);
		message = daoMessageEvoye.getMessage();
    	return messageEnvoye;
	}
}
