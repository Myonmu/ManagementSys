package models;

public class Enseignant extends User{

	public String tel;
	
	
	public Enseignant(String nom, String prenom, String tel, String username, String password) {
		super(username, password,nom,prenom);
		this.tel=tel;
	}
	
	public String getTel() {
		return this.tel;
	}
	
	public void setTel(String newTel) {
		this.tel=newTel;
	}
	
	@Override
	public void printAll() {
		super.printAll();
		System.out.println("TEL:"+this.tel);
	}

}
