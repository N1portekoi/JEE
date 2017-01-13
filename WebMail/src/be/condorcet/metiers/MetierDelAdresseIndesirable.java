package be.condorcet.metiers;

import be.condorcet.dao.DAOAdresseIndesirable;

public class MetierDelAdresseIndesirable {
	private String adresse;
	private String adresseInde;
	private String message;
	
	public MetierDelAdresseIndesirable(String adresse, String adresseInde) {
		this.adresse = adresse;
		this.adresseInde = adresseInde;
	}
	
	public String getMessage() { return message; }

	// Supprime une adresse indesirable
	public boolean delAdresseInde() {
		boolean ok = true;
		DAOAdresseIndesirable daoAdresseIndesirable = new DAOAdresseIndesirable();
		if (daoAdresseIndesirable.delete(adresse, adresseInde)) {
			message = "Adresse ajout�e !";
		}
		else {
			message = daoAdresseIndesirable.getMessage();
		}
		return ok;
	}
}
