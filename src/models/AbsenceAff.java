package models;

public class AbsenceAff {

	private int id;
	private int etu;
	private int plan;
	private String matiere;
	private String type;
	private String date;
	private int heure;
	private String just;
	private String etat;
	private String comment;
	public AbsenceAff(int id, int etu, int plan, String matiere, String type, String date, 
			int heure, String just, String etat, String comment) {
		this.id=id;
		this.etu=etu;
		this.plan=plan;
		this.matiere=matiere;
		this.type=type;
		this.date=date;
		this.heure=heure;
		this.just=just;
		this.etat=etat;
		this.comment=comment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getHeure() {
		return heure;
	}
	public void setHeure(int heure) {
		this.heure = heure;
	}
	public String getJust() {
		return just;
	}
	public void setJust(String just) {
		this.just = just;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getPlan() {
		return plan;
	}
	public void setPlan(int plan) {
		this.plan = plan;
	}
	public int getEtu() {
		return etu;
	}
	public void setEtu(int etu) {
		this.etu = etu;
	}
	
}
