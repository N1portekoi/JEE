package be.condorcet.metiers;

import be.condorcet.beans.Adresse;
import be.condorcet.beans.MessageEnvoye;
import be.condorcet.beans.Utilisateur;
import be.condorcet.dao.DAOMessageEnvoye;

public class MetierNouveauMessage {
	private Adresse expediteur;
	private String destinataire;
	private String objet;
	private String mess;
	private String message;
	
	public MetierNouveauMessage(String destinataire, String objet, String mess, Utilisateur utilisateur, String adresse) {
		this.expediteur = utilisateur.findAdresse(adresse);
		this.destinataire = destinataire.trim();
		this.objet = objet;
		this.mess = mess;
	}
	
	public String getMessage() { return message; }
	
	// Créer un nouveau message
	public boolean nouveauMessage() {
		boolean check = true;
		if (destinataire.length() == 0) {
			check = false;
			message = "Champ vide : Votre nouvelle adresse.";
		}
		if (check) {
			MessageEnvoye messageEnvoye = new MessageEnvoye();
			messageEnvoye.setDestinataire(destinataire);
			messageEnvoye.setMessage(mess);
			messageEnvoye.setObjet(objet);
			messageEnvoye.setExpediteur(expediteur);
			DAOMessageEnvoye daoMessageEnvoye = new DAOMessageEnvoye();
			check = daoMessageEnvoye.create(messageEnvoye);
		}
		return check;
	}
}
