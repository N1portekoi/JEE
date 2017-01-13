package be.condorcet.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class Utilisateur implements Serializable{
	private static final long serialVersionUID = 1L;
	private String pseudo;
	private String password;
	private String nom;
	private String prenom;
	private ArrayList<Adresse> adresses;

	public Utilisateur() { adresses = new ArrayList<>(); }
	
	public String getPseudo() { return pseudo; }
	public void setPseudo(String pseudo) { this.pseudo = pseudo; }
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; }
	public String getPrenom() { return prenom; }
	public void setPrenom(String prenom) { this.prenom = prenom; }
	public ArrayList<Adresse> getAdresses() { return adresses; }
	public void setAdresses(ArrayList<Adresse> adresses) { this.adresses = adresses; }
	public static long getSerialversionuid() { return serialVersionUID; }
	
	public void ajouterAdresse(Adresse adresse) { adresses.add(adresse); }
	public void supprimerAdresse(String adresse) {
		boolean trouve = false;
		int i = -1;
		do {
			i++;
			if (adresses.get(i).getAdresse().equals(adresse)) {
				adresses.remove(i);
				trouve = true;
			}
		} while(i < adresses.size() - 1 && !trouve);
	}
	// Supprimer les adresses
	public void effacerAdresses() { adresses.clear(); }
	// Retrouver adresse
	public Adresse findAdresse (String a) {
		Adresse adresse = null;
		boolean trouve = false;
		int i = -1;
		do {
			i++;
			if (adresses.get(i).getAdresse().equals(a)) {
				adresse = adresses.get(i);
				trouve = true;
			}
		} while(i < adresses.size() - 1 && !trouve);
		return adresse;
	}
	
	@Override
	public String toString() {
		return pseudo;
	}
	
}