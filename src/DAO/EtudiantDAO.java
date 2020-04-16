package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Enseignant;
import models.Etudiant;
import models.Groupe;

public class EtudiantDAO extends UserDAO{
	public EtudiantDAO() {
		super();
	}
	/**
	 * Search a specific etudiant knowing the ID
	 * @param ID
	 * @return the target etudiant object
	 */
	public Etudiant searchByID(int ID){
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Etudiant result=null;
		
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT * FROM etudiant WHERE id_ens=?");
			ps.setInt(1, ID);
			rs=ps.executeQuery();
			while(rs.next()) {
				result=new Etudiant(rs.getInt(1),rs.getString("username"), rs.getString("password"),
						rs.getString("nom"),rs.getString("prenom"), rs.getString(6),rs.getInt(7));
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
	/**
	 * Read all records in the Etudiant table. 
	 * @return list
	 * A list of Etudiant objects
	 */
	public ArrayList<Etudiant> readAll(){
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Etudiant> result=new ArrayList<>();
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT * FROM etudiant");
			rs=ps.executeQuery();
			while(rs.next()) {
				result.add(new Etudiant(rs.getInt("id_etu"),rs.getString("username"), rs.getString("password"),
						rs.getString("nom"),rs.getString("prenom"), rs.getString("email"),rs.getInt(7)));
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
	/**
	 * Search in the Etudiant table knowing which group they belong to
	 * @param groupeID
	 * @return List of etudiant objects fitting the criteria
	 */
	public ArrayList<Etudiant> searchByGroupe(int groupeID){
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Etudiant> result=new ArrayList<>();
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT * FROM etudiant WHERE groupNum=?");
			ps.setInt(1, groupeID);
			rs=ps.executeQuery();
			while(rs.next()) {
				result.add(new Etudiant(rs.getInt("id_etu"),rs.getString("username"), rs.getString("password"),
						rs.getString("nom"),rs.getString("prenom"), rs.getString("email"),rs.getInt(7)));
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
	/**
	 * Search the etudiant table by name
	 * @param nom
	 * @param prenom
	 * @return list of etudiant objects containning nom and prenom 
	 */
	public ArrayList<Etudiant> searchByName(String nom, String prenom){
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Etudiant> result=new ArrayList<>();
		
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT * FROM etudiant WHERE nom LIKE '%?%' AND prenom LIKE '%?%");
			ps.setString(1, nom);
			ps.setString(2, prenom);
			rs=ps.executeQuery();
			while(rs.next()) {
				result.add(new Etudiant(rs.getInt(1),rs.getString("username"), rs.getString("password"),
						rs.getString("nom"),rs.getString("prenom"), rs.getString(6),rs.getInt(7)));
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
	/**
	 * Adds a student in the Etudiant table
	 * @param newEtu
	 * the Etudiant object to be added
	 * @return
	 * Number of lines added. -1 means the process is aborted because of username violation.
	 */
	public int add(Etudiant newEtu) {
		if(!this.usernameViolationCheck(newEtu)) {
		Connection con=null;
		PreparedStatement ps=null;
		int rVal = 0;
		try {
			con=DriverManager.getConnection(URL, LOGIN, PASS);
			ps=con.prepareStatement("INSERT INTO etudiant (id_etu,username, password, nom, prenom, email) VALUES (etudiant_id.NEXTVAL,?,?,?,?,?) ");
			ps.setString(1,newEtu.getUsername());
			ps.setString(2, newEtu.getPassword());
			ps.setString(3, newEtu.getNom());
			ps.setString(4, newEtu.getPrenom());
			ps.setString(5, newEtu.getEmail());
			rVal=ps.executeUpdate();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Issue spotted");
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
			System.out.println("Username violation detected, aborted.");
			return -1;
		}
	}
	/**
	 * Modifies a student in the table.
	 * @param target
	 * The Etudiant object up-to-date
	 * @return
	 * Number of lines modified
	 */
	public int modify(Etudiant target) {
		Connection con=null;
		PreparedStatement ps=null;
		int rVal=0;
		try {
			con=DriverManager.getConnection(URL, LOGIN, PASS);
			ps=con.prepareStatement("UPDATE etudiant SET nom=?, prenom=?, username=?,password=?, email=? WHERE id_etu=?");
			ps.setString(1, target.getNom());
			ps.setString(2, target.getPrenom());
			ps.setString(3, target.getUsername());
			ps.setString(4, target.getPassword());
			ps.setString(5, target.getEmail());
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
	/**
	 * Deletes a student from the list
	 * @param target
	 * The student to be deleted
	 * @return
	 * Number of lines deleted
	 */
	public int delete(Etudiant target) {
		Connection con=null;
		PreparedStatement ps=null;
		int rVal = 0;
		try {
			con=DriverManager.getConnection(URL, LOGIN, PASS);
		    ps=con.prepareStatement("DELETE FROM etudiant WHERE id_etu=?");
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
	/**
	 * Assign a student to a group
	 * @param etu
	 * The student needed to be assigned
	 * @param gr
	 * The group which the student is assigned to
	 * @return rVal
	 * Number of modified records.
	 */
	public int assignTo(Etudiant etu,Groupe gr) {
		Connection con=null;
		PreparedStatement ps=null;
		int rVal=0;
		try {
			con=DriverManager.getConnection(URL, LOGIN, PASS);
			ps=con.prepareStatement("UPDATE etudiant SET groupNum=? WHERE id_etu=?");
			ps.setInt(1, gr.getID());
			ps.setInt(2, etu.getID());
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
