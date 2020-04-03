package models;
public class User {
	protected String username;
	protected String password;
	protected String nom;
	protected String prenom;
	protected int access;
	/**
	 * Create an empty user.
	 */
	public User() {
		this.username="";
		this.password="";
		this.nom="";
		this.prenom="";
		this.access=0;
	}
	/**
	 * Create a user by username and password
	 * @param username
	 * @param password
	 */
	public User(String username, String password,String nom,String prenom)
	{
		this.username=username;
		this.password=password;
		this.nom=nom;
		this.prenom=prenom;
		this.access=0;
	}
	
	/**
	 * generates random username and password
	 */
	public void randomizer() {
		String randUsername="";
		String randPassword="";
		for(int i=0;i<8;i++) {
			randUsername=randUsername+Integer.toString((int) Math.pow(10, i)*(int)Math.random()*9);
			randPassword=randPassword+String.valueOf('A'+(int)Math.random()*25);
		}
		this.username=randUsername;
		this.password=randPassword;
	}
	
	public String getUsername() {
		return this.username;
		}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getNom() {
		return this.nom;
	}
	public String getPrenom() {
		return this.prenom;
	}
	
	public void setPassword(String newPass) {
		this.password=newPass;
	}
	
	public void setUsername(String newUsername) {
		this.username=newUsername;
	}
	
	public void setNom(String newNom) {
		this.nom=newNom;
	}
	
	public void setPrenom(String newPrenom) {
		this.prenom=newPrenom;
	}
	
	public void printAll() {
		System.out.println("NOM:"+this.nom+"  PRENOM:"+this.prenom);
		System.out.println("USERNAME:"+this.username+"  PASSWORD:"+this.password);
	}
	}
