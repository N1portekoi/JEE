package be.condorcet.metiers;

import be.condorcet.beans.Utilisateur;
import be.condorcet.dao.DAOUtilisateur;

public class MetierEnregistrement {
	private String pseudo;
	private String password;
	private String password2;
	private String nom;
	private String prenom;
	
	private String message;
	
	public MetierEnregistrement(String pseudo, String password, String password2, String nom, String prenom) {
		this.pseudo = pseudo.trim();
		this.password = password.trim();
		this.password2 = password2.trim();
		this.nom = nom.trim();
		this.prenom = prenom.trim();
		this.message = "Champ(s) vide(s) : ";
	}
	
	public String getMessage() { return message; }

	// Enregistre un utilisateur
	public boolean execute() {
		boolean check = true;
		if (pseudo.length() == 0) {
			check = false;
			message += "pseudo, ";
		}
		if (password.length() == 0) {
			check = false;
			message += "password, ";
		}
		if (password2.length() == 0) {
			check = false;
			message += "password2, ";
		}
		if (nom.length() == 0) {
			check = false;
			message += "nom, ";
		}
		if (prenom.length() == 0) {
			check = false;
			message += "prenom, ";
		}
		if (!password.equals(password2)) {
			check = false;
		}
		if (check) {
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setNom(nom);
			utilisateur.setPrenom(prenom);
			utilisateur.setPseudo(pseudo);
			utilisateur.setPassword(password);
			DAOUtilisateur dao = new DAOUtilisateur();
			dao.create(utilisateur);
			message = dao.getMessage();
		}
		return check;
	}
}
