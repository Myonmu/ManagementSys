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
				result.add(new Enseignant(rs.getInt("id_ens"),rs.getString("username"), rs.getString("password"),
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
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
		
	}
	public int add(Enseignant newEns) {
		if(!this.usernameViolationCheck(newEns)) {
		Connection con=null;
		PreparedStatement ps=null;
		int rVal = 0;
		try {
			con=DriverManager.getConnection(URL, LOGIN, PASS);
			ps=con.prepareStatement("INSERT INTO Enseignant (id_ens,username, password, nom, prenom, tel) VALUES (enseignant_id.NEXTVAL,?,?,?,?,?) ");
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
		else {
			System.out.println("Username violation detected");
			return -1;
		}
	}
	public int modify(Enseignant target) {
		Connection con=null;
		PreparedStatement ps=null;
		int rVal=0;
		try {
			con=DriverManager.getConnection(URL, LOGIN, PASS);
			ps=con.prepareStatement("UPDATE enseignant SET nom=?, prenom=?, username=?,password=?, tel=? WHERE id_ens=?");
			ps.setString(1, target.getNom());
			ps.setString(2, target.getPrenom());
			ps.setString(3, target.getUsername());
			ps.setString(4, target.getPassword());
			ps.setString(5, target.getTel());
			ps.setInt(6, target.getID());
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
	
	public int delete(Enseignant target) {
		Connection con=null;
		PreparedStatement ps=null;
		int rVal = 0;
		try {
			con=DriverManager.getConnection(URL, LOGIN, PASS);
		    ps=con.prepareStatement("DELETE FROM enseignant WHERE id_ens=?");
		    ps.setInt(1, target.getID());
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
