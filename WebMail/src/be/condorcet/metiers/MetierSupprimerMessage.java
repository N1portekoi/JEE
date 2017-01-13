package be.condorcet.metiers;

import be.condorcet.dao.DAOMessage;

public class MetierSupprimerMessage {
	private int id;
	private String message;
	
	public MetierSupprimerMessage(int id) {
		this.id = id;
	}
	
	public String getMessage() { return message; }
	
	// Supprime le message selon id
	public void supprimer() {
		DAOMessage daoMessage = new DAOMessage();
		daoMessage.delete(id);
	}
}
