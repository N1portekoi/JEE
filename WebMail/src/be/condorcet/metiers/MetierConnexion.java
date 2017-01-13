package be.condorcet.metiers;

import be.condorcet.beans.Utilisateur;
import be.condorcet.dao.DAOUtilisateur;

public class MetierConnexion {
	private String pseudo;
	private String password;
	private String message;
	
	public MetierConnexion(String pseudo, String password) {
		this.pseudo = pseudo;
		this.password = password;
		this.message = "Champ(s) vide(s) : ";
	}
	
	public String getMessage() { return message; }
	
	// Se connecter
	public Utilisateur connexion() {
		Utilisateur utilisateur = null;
		boolean check = true;

		// Champ pseudo vide ?
		if (pseudo.length() == 0) {
			check = false;
			message += "pseudo, ";
		}
		// Champ password vide ?
		if (password.length() == 0) {
			check = false;
			message += "password, ";
		}
		// Recupere l'utilisateur dans la DB
		if (check) {
			DAOUtilisateur daoUtilsateur = new DAOUtilisateur();
			utilisateur = daoUtilsateur.find(pseudo, password);
			message = daoUtilsateur.getMessage();
		}
		return utilisateur;
	}
}
