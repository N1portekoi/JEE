package be.condorcet.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class Adresse implements Serializable{
	private static final long serialVersionUID = 1L;
	private String adresse;
	private ArrayList<String> adressesIndesirables;
	
	public Adresse() { adressesIndesirables = new ArrayList<>(); }

	public String getAdresse() { return adresse; }
	public void setAdresse(String adresse) { this.adresse = adresse; }
	public ArrayList<String> getBlackList() { return adressesIndesirables; }
	public void setBlackList(ArrayList<String> blackList) { this.adressesIndesirables = blackList; }
	public static long getSerialversionuid() { return serialVersionUID; }
	
	
	public void ajouterAdresseIndesitable(String adresse) {adressesIndesirables.add(adresse);}
	public void supprimerAdresseIndesitable(String adresseIndesirable) {
		boolean trouve = false;
		int i = -1;
		do {
			i++;
			if (adressesIndesirables.get(i).equals(adresseIndesirable)) {
				adressesIndesirables.remove(i);
				trouve = true;
			}
		} while(i < adressesIndesirables.size() - 1 && !trouve);
	}
	@Override
	public String toString() { return adresse; }
}
