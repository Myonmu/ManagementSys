package models;

public class PlanningAff {
	private int id;
	private int session;
	private String dow;
	private String horaire;
	private String matiere;
	private String type;
	private int duree;
	private int groupe;
	private String ens;
	private int idEns;
	private int idMat;
	public PlanningAff( int id, int session,String dow,String horaire,String matiere,String type,
			int duree,int groupe, String ens,int idEns,int idMat) {
		this.id=id;
		this.session=session;
		this.dow=dow;
		this.horaire=horaire;
		this.matiere=matiere;
		this.type=type;
		this.duree=duree;
		this.groupe=groupe;
		this.ens=ens;
		this.idEns=idEns;
		this.idMat=idMat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSession() {
		return session;
	}
	public void setSession(int session) {
		this.session = session;
	}
	public String getDow() {
		return dow;
	}
	public void setDow(String dow) {
		this.dow = dow;
	}
	public String getHoraire() {
		return horaire;
	}
	public void setHoraire(String horaire) {
		this.horaire = horaire;
	}
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public String getEns() {
		return ens;
	}
	public void setEns(String ens) {
		this.ens = ens;
	}
	public int getGroupe() {
		return groupe;
	}
	public void setGroupe(int groupe) {
		this.groupe = groupe;
	}
	public int getIdEns() {
		return idEns;
	}
	public void setIdEns(int idEns) {
		this.idEns = idEns;
	}
	public int getIdMat() {
		return idMat;
	}
	public void setIdMat(int idMat) {
		this.idMat = idMat;
	}
	
}
