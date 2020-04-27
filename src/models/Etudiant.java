package models;

public class Etudiant extends User{
	private String email;
	private int gr_id;
	public Etudiant(String username, String password, String nom, String prenom,String email,int gr) {
		super(username,password,nom,prenom);
		this.email=email;
		this.gr_id=gr;
	}
	public Etudiant(int ID,String username, String password, String nom, String prenom,String email,int gr) {
		super(ID,username,password,nom,prenom);
		this.email=email;
		this.gr_id=gr;
	}
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String newEmail){
		this.email=newEmail;
	}
	public int getGr() {
		return this.gr_id;
	}
	public void setGr(int gr) {
		this.gr_id=gr;
	}
}
