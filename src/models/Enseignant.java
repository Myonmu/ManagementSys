package models;

public class Enseignant extends User{

	public String tel;
	
	
	public Enseignant(String username, String password,String nom, String prenom, String tel) {
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
