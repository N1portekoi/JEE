package be.condorcet.metiers;

import be.condorcet.beans.MessageIndesirable;
import be.condorcet.beans.MessageRecu;
import be.condorcet.dao.DAOMessageIndesirable;

public class MetierMessageIndesirable {
	private int id;
	private String message;
	
	public MetierMessageIndesirable(int id) {
		this.id = id;
	}
	
	public String getMessage() { return message; }
	
	// Recupere un message indesirable
	public MessageRecu messageIndesirable() {
		DAOMessageIndesirable daoMessageIndesirable = new DAOMessageIndesirable();
		MessageIndesirable messageIndesirable = daoMessageIndesirable.find(id);
		message = daoMessageIndesirable.getMessage();
    	return messageIndesirable;
	}
}
