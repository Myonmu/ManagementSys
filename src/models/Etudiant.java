package models;

public class Etudiant extends User{
	private String email;
	
	public Etudiant(String username, String password, String nom, String prenom,String email) {
		super(username,password,nom,prenom);
		this.email=email;
	}
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String newEmail){
		this.email=newEmail;
	}
}
