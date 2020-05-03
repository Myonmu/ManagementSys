package models;

public class Absence {
	private int id;
	private int plan;
	private int week;
	private int etu;
	private int etat;
	private int just;
	private String comment;
	
	public Absence(int id,int plan,int week,int etu,int etat,int just, String comment) {
		this.id=id;
		this.plan=plan;
		this.week=week;
		this.etu=etu;
		this.etat=etat;
		this.just=just;
		this.comment=comment;
	}
	public Absence(int plan,int week,int etu,int etat,int just, String comment) {
		this.id=0;
		this.plan=plan;
		this.week=week;
		this.etu=etu;
		this.etat=etat;
		this.just=just;
		this.comment=comment;
	}
	public Absence(int plan,int week,int etu, String comment) {
		this.id=0;
		this.plan=plan;
		this.week=week;
		this.etu=etu;
		this.comment=comment;
	}
	public int getID() {
		return this.id;
	}
	public int getPlan() {
		return this.plan;
	}
	public int getWeek() {
		return this.week;
	}
	public int getEtu() {
		return this.etu;
	}
	public int getEtat() {
		return this.etat;
	}
	public String getComment() {
		return this.comment;
	}
	public void setID(int newID) {
		this.id=newID;
	}
	public void setPlan(int newPlan) {
		this.plan=newPlan;
	}
	public void setWeek(int newWeek) {
		this.week=newWeek;
	}
	public void setEtu(int newEtu) {
		this.etu=newEtu;
	}
	public void setEtat(int newEtat) {
		this.etat=newEtat;
	}
	public int getJust() {
		return just;
	}
	public void setJust(int just) {
		this.just = just;
	}
	public void setComment(String comment) {
		this.comment=comment;
	}

}
