package models;

public class Cours {

	private int id;
	private String nom;
	private int masse;
	private Enseignant ens_par;
	
	public Cours(String nom, int masse) {
		this.id=0;
		this.masse=masse;
		this.nom=nom;
		this.ens_par=null;
	}
	
	public Cours(int id,String nom,int masse) {
		this.id=id;
		this.nom=nom;
		this.masse=masse;
		this.ens_par=null;
	}
	
	public int getID() {
		return this.id;
	}
	
	public void setID(int newID) {
		this.id=newID;
	}
	
	public int getMasse() {
		return this.masse;
	}
	
	public void setMasse(int newMasse) {
		this.masse=newMasse;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String newNom) {
		this.nom=newNom;
	}
	
	public Enseignant getEnsPar() {
		return this.ens_par;
	}
	public void setEnsPar(Enseignant newEns) {
		this.ens_par=newEns;
	}
}
