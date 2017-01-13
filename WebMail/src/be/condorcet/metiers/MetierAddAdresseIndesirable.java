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

	// Ajoute une adresse ind�sirable
	public boolean addAdresseInde() {
		boolean check = true;
		if (adresseInde.length() == 0) {
			check = false;
			message = "Champ vide : Adresse � bloquer.";
		}
		else {
			adresseInde += "@condorcet.be";
			if (!adresseInde.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")) {
				check = false;
				message = "Caract�re(s) non autoris�(s) !";
			}
		}
		if (check) {
			DAOAdresseIndesirable daoAdresseIndesirable = new DAOAdresseIndesirable();
			if (daoAdresseIndesirable.create(adresse, adresseInde)) {
				message = "Adresse ajout�e !";
			}
			else {
				message = daoAdresseIndesirable.getMessage();
			}
		}		
		return check;
	}
}
