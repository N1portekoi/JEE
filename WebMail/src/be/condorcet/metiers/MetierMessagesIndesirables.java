package be.condorcet.metiers;

import java.util.ArrayList;

import be.condorcet.beans.Adresse;
import be.condorcet.beans.MessageIndesirable;
import be.condorcet.beans.Utilisateur;
import be.condorcet.dao.DAOMessageIndesirable;

public class MetierMessagesIndesirables {
	private Adresse adresse;
	private String message;
	
	public MetierMessagesIndesirables(String adresse, Utilisateur utilisateur) {
		this.adresse = utilisateur.findAdresse(adresse);
	}
	
	public String getMessage() { return message; }
	
	// Recupere la liste des messages indesirables
	public ArrayList<MessageIndesirable> messagesIndesirables() {
		DAOMessageIndesirable daoMessagesIndesirables = new DAOMessageIndesirable();
		ArrayList<MessageIndesirable> messagesIndesirables = daoMessagesIndesirables.find(adresse);
		message = daoMessagesIndesirables.getMessage();
    	return messagesIndesirables;
	}
}
