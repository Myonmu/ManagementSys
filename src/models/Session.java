package models;

public class Session {
	private int id;
	private int num;
	private String startDate;
	
	public Session(int num, String startDate) {
		this.id=0;
		this.num=num;
		this.startDate=startDate;
	}
	public Session (int ID, int num,String startDate) {
		this.id=ID;
		this.num=num;
		this.startDate=startDate;
	}
	
	public int getID() {
		return this.id;
	}
	public int getNum() {
		return this.num;
	}
	public String getDate() {
		return this.startDate;
	}
	
	public void setID(int newID) {
		this.id=newID;
	}
	public void setNum(int newNum) {
		this.num=newNum;
	}
	public void setDate(String newDate) {
		this.startDate=newDate;
	}
	
}
