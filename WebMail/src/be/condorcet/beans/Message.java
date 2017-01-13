package be.condorcet.beans;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Message implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String objet;
	private String message;
	private LocalDate date;
	
	protected Message() {}

	
	public int getId() { return id; }
	public void setId(int id) { this.id = id;}
	public String getObjet() { return objet; }
	public void setObjet(String objet) { this.objet = objet; }
	public String getMessage() { return message; }
	public void setMessage(String message) { this.message = message; }
	public LocalDate getDate() { return date; }
	public void setDate(LocalDate date) { this.date = date; }
	public static long getSerialversionuid() { return serialVersionUID; }
}

