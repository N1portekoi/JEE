package be.condorcet.metiers;

import java.util.ArrayList;

import be.condorcet.beans.Adresse;
import be.condorcet.beans.MessageRecu;
import be.condorcet.beans.Utilisateur;
import be.condorcet.dao.DAOMessageSupprime;

public class MetierMessagesSupprimes {
	private Adresse adresse;
	private String message;
	
	public MetierMessagesSupprimes(String adresse, Utilisateur utilisateur) {
		this.adresse = utilisateur.findAdresse(adresse);
	}
	
	public String getMessage() { return message; }
	
	//Recupere une liste de message recu mis en corbeille
	public ArrayList<MessageRecu> messagesSupprimes() {
		DAOMessageSupprime daoMessageSupprimes = new DAOMessageSupprime();
		ArrayList<MessageRecu> messageRecu = daoMessageSupprimes.find(adresse);
		message = daoMessageSupprimes.getMessage();
    	return messageRecu;
	}
}
