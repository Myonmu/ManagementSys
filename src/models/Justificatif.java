package models;

public class Justificatif {
	private int id;
	private String trj;//Trajectory of the file
	
	public Justificatif(int id, String trj) {
		this.id=id;
		this.trj=trj;
	}
	public Justificatif(String trj) {
		this.id=0;
		this.trj=trj;
	}
	
	public int getID() {
		return this.id;
	}
	public String getTrj() {
		return this.trj;
	}
	public void setID(int newID) {
		this.id=newID;
	}
	public void setTrj(String newTrj) {
		this.trj=newTrj;
	}

}
