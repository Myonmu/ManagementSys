
package models;
public class User {
	protected int id;
	protected String username;
	protected String password;
	protected String nom;
	protected String prenom;
	/**
	 * Create an empty user.
	 */
	public User() {
		this.id=0;
		this.username="";
		this.password="";
		this.nom="";
		this.prenom="";

	}
	public User(String nom,String prenom) {
		this.id=0;
		this.nom=nom;
		this.prenom=prenom;
		this.username="";
		this.password="";
	}
	/**
	 * Create a user by username and password
	 * @param username
	 * @param password
	 */
	public User(String username, String password,String nom,String prenom)
	{
		this.id=0;
		this.username=username;
		this.password=password;
		this.nom=nom;
		this.prenom=prenom;
	}
	public User(int ID,String username, String password,String nom,String prenom)
	{
		this.id=ID;
		this.username=username;
		this.password=password;
		this.nom=nom;
		this.prenom=prenom;
	}
	
	/**
	 * generates random username and password
	 */
	public void randomizer() {
		String randUsername="";
		String randPassword="";
		for(int i=0;i<8;i++) {
			randUsername=randUsername+Integer.toString((int)(Math.random()*9));
			randPassword=randPassword+Character.toString((char)('A'+Math.random()*25));
		}
		this.username=randUsername;
		this.password=randPassword;
	}
	
	public int getID() {
		return this.id;
	}
	public void setID(int ID) {
		this.id=ID;
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
		System.out.println("ID="+this.id+"  NOM:"+this.nom+"  PRENOM:"+this.prenom);
		System.out.println("USERNAME:"+this.username+"  PASSWORD:"+this.password);
	}
	
	}
