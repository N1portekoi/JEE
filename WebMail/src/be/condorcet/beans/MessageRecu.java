package be.condorcet.beans;

public class MessageRecu extends Message {
	private static final long serialVersionUID = 1L;
	private String expediteur;
	private Adresse destinataire;
	private int etat;
	private int corbeille;
	
	public MessageRecu() { super(); }	
	public String getExpediteur() { return expediteur; }
	public void setExpediteur(String expediteur) { this.expediteur = expediteur; }
	public Adresse getDestinataire() { return destinataire; }
	public void setDestinataire(Adresse destinataire) { this.destinataire = destinataire; }
	public int getEtat() { return etat; }
	public void setEtat(int etat) { this.etat = etat; }
	public int getCorbeille() { return corbeille; }
	public void setCorbeille(int corbeille) { this.corbeille = corbeille; }
	public static long getSerialversionuid() { return serialVersionUID; }
}
