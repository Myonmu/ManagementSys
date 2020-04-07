package models;

import java.util.ArrayList;

public class Groupe  {
	private int id;
	private int num;
	private int cap;
	private ArrayList<Etudiant> listEtu;
	
	public Groupe (int num,int cap) {
		this.id=0;
		this.num=num;
		this.cap=cap;
		listEtu=new ArrayList<>();
	}
	
	public Groupe(int id,int num, int cap) {
		this.id=id;
		this.num=num;
		this.cap=cap;
		listEtu=new ArrayList<>();
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
	public void showList() {
		for(Etudiant i:listEtu) {
			i.printAll();
		}
	}
	public void addEtu(Etudiant etu) {
		this.listEtu.add(etu);
	}
	public void deleteEtu(Etudiant etu) {
		this.listEtu.remove(etu);
	}
	
	public void modifyEtu(Etudiant etu) {
		//to be continued
	}
}
