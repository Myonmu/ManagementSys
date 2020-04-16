package models;


public class Groupe  {
	private int id;
	private int num;
	private int cap;
	
	public Groupe (int num,int cap) {
		this.id=0;
		this.num=num;
		this.cap=cap;
	}
	
	public Groupe(int id,int num, int cap) {
		this.id=id;
		this.num=num;
		this.cap=cap;

	}
	
	public int getID() {
		return this.id;
	}
	public void setID(int newID) {
		this.id=newID;
	}
	public int getNum() {
		return this.num;
	}
	public void setNum(int newNum) {
		this.num=newNum;
	}
	public int getCap() {
		return this.cap;
	}
	public void setCap(int newCap) {
		this.cap=newCap;
	}

}
