package be.condorcet.beans;

public class MessageEnvoye extends Message {
	private static final long serialVersionUID = 1L;
	private String destinataire;
	private Adresse expediteur;
	
	public MessageEnvoye() { super(); }

	public String getDestinataire() { return destinataire; }
	public void setDestinataire(String destinataire) { this.destinataire = destinataire; }
	public Adresse getExpediteur() { return expediteur; }
	public void setExpediteur(Adresse expediteur) { this.expediteur = expediteur; }
	public static long getSerialversionuid() { return serialVersionUID; }
}
