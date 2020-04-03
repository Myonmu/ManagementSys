package DAO;
import java.sql.*;
import models.User;

public class UserDAO extends ConnectDAO{
	public UserDAO() {
		super();
	}
	/**
	 * This is an auth process. The process returns an integer that represents the type of the user.
	 * Each type of user must contain field password and username.
	 * 0=login unsuccessful
	 * 1=logged in with Manager account
	 * 2=logged in with Teacher account
	 * 3=logged in with Student account
	 * @return access level
	 */
	public int login(User anonymous) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int access=0;
		int attempt=0;
		String[] searchField= {"Manager","Enseignant","Etudiant"};
		while (attempt<3) {
		try {
			con=DriverManager.getConnection(URL, LOGIN, PASS);
			ps=con.prepareStatement("SELECT password FROM ? WHERE username = ?");	
			ps.setString(1, searchField[attempt]);
			ps.setString(2, anonymous.getUsername());
			rs=ps.executeQuery();
			if(rs.next()) {
				access=rs.getString(1)==anonymous.getPassword()?attempt+1:0;
				attempt=3;
			}
			else {
				attempt++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return access;
		
	}
}
