package be.condorcet.metiers;

import java.util.ArrayList;

import be.condorcet.beans.Adresse;
import be.condorcet.beans.Utilisateur;
import be.condorcet.dao.DAOAdresse;

public class MetierAdresses {
	private Utilisateur utilisateur;
	private String message;
	
	public MetierAdresses(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public String getMessage() { return message; }

	// Recupere une liste d'adresse
	public void adresses() {
		utilisateur.effacerAdresses();
		DAOAdresse daoAdresse = new DAOAdresse();
		ArrayList<Adresse> adresses = daoAdresse.find(utilisateur);
		for (Adresse adresse : adresses) {
			utilisateur.ajouterAdresse(adresse);
		}
		message = daoAdresse.getMessage();
	}
	
	// Ajoute une adresse
	public boolean ajouter(String _adresse) {
		boolean check = true;
		if (_adresse.length() == 0) {
			check = false;
			message = "Champ vide : Votre nouvelle adresse.";
		}
		else {
			_adresse += "@condorcet.be";
			if (!_adresse.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")) {
				check = false;
				message = "Caract�re(s) non autoris�(s) !";
			}
		}
		if (check) {
			Adresse adresse = new Adresse();
			adresse.setAdresse(_adresse);
			DAOAdresse daoAdresse = new DAOAdresse();
			if(daoAdresse.create(adresse, utilisateur)) {
				utilisateur.ajouterAdresse(adresse);
			}
			else {
				check = false;
			}
			message = daoAdresse.getMessage();
		}
		return check;
	}
	
	// Supprime une adresse
	public boolean supprimer(String adresse) {
		boolean check;
		DAOAdresse daoAdresse = new DAOAdresse();
		check = daoAdresse.delete(adresse);
		if (check) {
			utilisateur.supprimerAdresse(adresse);
		}
		else{
			check = false;
		}
		message = daoAdresse.getMessage();
		return check;
	}
}