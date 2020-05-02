package models;

public class Enseignant extends User{

	private String tel;
	
	
	public Enseignant(String username, String password,String nom, String prenom, String tel) {
		super(username, password,nom,prenom);
		this.tel=tel;
	}
	public Enseignant(int ID,String username, String password,String nom, String prenom, String tel) {
		super(ID,username, password,nom,prenom);
		this.tel=tel;
	}
	
	public Enseignant() {
		// TODO Auto-generated constructor stub
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
