package be.condorcet.metiers;

import be.condorcet.dao.DAOMessage;

public class MetierMessageCorbeille {
	private int id;
	private String message;
	
	public MetierMessageCorbeille(int id) {
		this.id = id;
	}
	
	public String getMessage() { return message; }
	
	// Mise en corbeille d'un message
	public void corbeille() {
		DAOMessage daoMessage = new DAOMessage();
		daoMessage.update(id);
	}
}
