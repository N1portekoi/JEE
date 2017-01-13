package be.condorcet.metiers;

import java.util.ArrayList;

import be.condorcet.beans.Adresse;
import be.condorcet.beans.MessageRecu;
import be.condorcet.beans.Utilisateur;
import be.condorcet.dao.DAOMessageRecu;

public class MetierMessagesRecus {
	private Adresse adresse;
	private String message;
	
	public MetierMessagesRecus(String adresse, Utilisateur utilisateur) {
		this.adresse = utilisateur.findAdresse(adresse);
	}
	
	public String getMessage() { return message; }
	
	// récupere une liste de message recu non mis en corbeille
	public ArrayList<MessageRecu> messagesRecus() {
		DAOMessageRecu daoMessageRecu = new DAOMessageRecu();
		ArrayList<MessageRecu> messageRecu = daoMessageRecu.find(adresse);
		message = daoMessageRecu.getMessage();
    	return messageRecu;
	}
}
