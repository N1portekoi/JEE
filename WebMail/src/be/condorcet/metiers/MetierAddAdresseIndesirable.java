package be.condorcet.metiers;

import be.condorcet.dao.DAOAdresseIndesirable;

public class MetierAddAdresseIndesirable {
	private String adresse;
	private String adresseInde;
	private String message;
	
	public MetierAddAdresseIndesirable(String adresse, String adresseInde) {
		this.adresse = adresse;
		this.adresseInde = adresseInde;
	}
	
	public String getMessage() { return message; }

	// Ajoute une adresse indésirable
	public boolean addAdresseInde() {
		boolean check = true;
		if (adresseInde.length() == 0) {
			check = false;
			message = "Champ vide : Adresse à bloquer.";
		}
		else {
			adresseInde += "@condorcet.be";
			if (!adresseInde.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")) {
				check = false;
				message = "Caractère(s) non autorisé(s) !";
			}
		}
		if (check) {
			DAOAdresseIndesirable daoAdresseIndesirable = new DAOAdresseIndesirable();
			if (daoAdresseIndesirable.create(adresse, adresseInde)) {
				message = "Adresse ajoutée !";
			}
			else {
				message = daoAdresseIndesirable.getMessage();
			}
		}		
		return check;
	}
}
