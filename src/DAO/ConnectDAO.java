package DAO;
/**
 * DAO for basic connection
 * @author Hippocrate
 *
 */
public class ConnectDAO {

	 final static String URL= "jdbc:oracle:thin:@localhost:1521:xe";
	 final static String LOGIN="BDD1";
	 final static String PASS="BDD1";
	 
	 
	 public ConnectDAO() {
		 try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Driver not found");
		}		   
	 }
	 
	 
}
