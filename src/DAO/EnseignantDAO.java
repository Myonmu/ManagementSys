package DAO;
import java.sql.*;
import java.util.ArrayList;

import models.Enseignant;

public class EnseignantDAO extends UserDAO{

	public EnseignantDAO() {
		super();
	}
	
	public ArrayList<Enseignant> readAll(){
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Enseignant> result=new ArrayList<>();
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT * FROM enseignant");
			rs=ps.executeQuery();
			while(rs.next()) {
				result.add(new Enseignant(rs.getString("username"), rs.getString("password"),
						rs.getString("nom"),rs.getString("prenom"), rs.getString("tel")));
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
		}
		return result;
		
	}
	public int add(Enseignant newEns) {
		Connection con=null;
		PreparedStatement ps=null;
		int rVal = 0;
		try {
			con=DriverManager.getConnection(URL, LOGIN, PASS);
			ps=con.prepareStatement("INSERT INTO Enseignant (id,username, password, nom, prenom, tel) VALUES (enseignant_id.NEXTVAL,?,?,?,?,?) ");
			ps.setString(1,newEns.getUsername());
			ps.setString(2, newEns.getPassword());
			ps.setString(3, newEns.getNom());
			ps.setString(4, newEns.getPrenom());
			ps.setString(5, newEns.getTel());
			rVal=ps.executeUpdate();
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
		}
		return rVal;
	}
	
	}
