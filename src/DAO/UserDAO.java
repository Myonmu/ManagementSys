package DAO;
import java.sql.*;

import models.User;
import models.userID;

public class UserDAO extends ConnectDAO{
	static final String[] SEARCHFIELD= {"enseignant","etudiant","gestionnaire"};
	static final String[] IDFIELD= {"id_ens","id_etu","id_gest"};
	static final int maxAttempt=3;
	static String tableName="";
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
		while (attempt<maxAttempt) {
		try {
			con=DriverManager.getConnection(URL, LOGIN, PASS);
			ps=con.prepareStatement("SELECT password,"+IDFIELD[attempt]+" FROM "+SEARCHFIELD[attempt]+" WHERE username = ?");	
			ps.setString(1, anonymous.getUsername());
			rs=ps.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).contentEquals(anonymous.getPassword()))
				{
					System.out.println("login successful");
					access=attempt+1;
					attempt=maxAttempt;
					userID.setUserID(rs.getInt(2));
					userID.setUSERTYPE(access);
				}
				else{
					access=0;
					attempt=maxAttempt;
					System.out.println("login unsuccessful");
				}
			}
			else {
				attempt++;
				System.out.println(attempt +" "+ access + "next search");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Pb spotted");
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		}
		return access;
		
	}
	public boolean usernameViolationCheck(User newUser) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		boolean rVal=false;
		try {
			con=DriverManager.getConnection(URL, LOGIN, PASS);
			int searchIndex=0;
			while(searchIndex<maxAttempt) {
				ps=con.prepareStatement("SELECT username FROM "+SEARCHFIELD[searchIndex]+" WHERE username = ?");
				ps.setString(1, newUser.getUsername());
				rs=ps.executeQuery();
				if(rs.next()) {
					rVal=true;
					searchIndex=maxAttempt;
				}
				else {
					searchIndex++;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return rVal;
	}
	
	
		
	}
