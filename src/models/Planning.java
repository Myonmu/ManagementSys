package models;

public class Planning {
	private int id;
	private int sess; //session (ID
	private int mat; //matiere=cours (ID
	private int dow; //Day of week
	private String horaire;
	private String type; //TD/TP/AMPHI/DS
	private int duree;
	private int gr; //Suivi par quel groupe (ID
	private int ens; //enseigne par quel enseignant (ID
	
	public Planning(int sessID,int matID, int dow,String horaire, String type, int duree, int grID, int ensID) {
		this.id=0;
		this.sess=sessID;
		this.mat=matID;
		this.dow=dow;
		this.horaire=horaire;
		this.type=type;
		this.duree=duree;
		this.gr=grID;
		this.ens=ensID;
	}
	public Planning(int ID,int sessID,int matID, int dow,String horaire, String type, int duree, int grID, int ensID) {
		this.id=ID;
		this.sess=sessID;
		this.mat=matID;
		this.dow=dow;
		this.horaire=horaire;
		this.type=type;
		this.duree=duree;
		this.gr=grID;
		this.ens=ensID;
	}

	public int getID() {
		return this.id;
	}
	public void setID(int id) {
		this.id=id;
	}
	public int getSess() {
		return this.sess;
	}
	public void setSess(int sess) {
		this.sess=sess;
	}
	public int getMat() {
		return this.mat;
	}
	public void setMat(int mat) {
		this.mat=mat;
	}
	public int getDow() {
		return this.dow;
	}
	public void setDow(int dow) {
		this.dow=dow;
	}
	public String getHoraire() {
		return this.horaire;
	}
	public void setHoraire(String i) {
		this.horaire=i;
	}
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type=type;
	}
	public int getDuree() {
		return this.duree;
	}
	public void setDuree(int duree) {
		this.duree=duree;
	}
	public int getGr() {
		return this.gr;
	}
	public void setGr(int gr) {
		this.gr=gr;
	}
	public int getEns() {
		return this.ens;
	}
	public void setEns(int ens) {
		this.ens=ens;
	}
}
