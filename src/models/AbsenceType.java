package models;

public class AbsenceType {
	private int id;
	private String nom;
	
	public AbsenceType(String nom) {
		this.id=0;
		this.nom=nom;
	}
	public AbsenceType(int ID, String nom) {
		this.id=ID;
		this.nom=nom;
	}
	
	public int getID() {
		return this.id;
	}
	public void setID(int newID) {
		this.id=newID;
	}
	public String getNom() {
		return this.nom;
	}
	public void setNom(String newNom) {
		this.nom=newNom;
	}

}
