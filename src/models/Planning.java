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
	
}
