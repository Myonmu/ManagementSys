package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Cours;
import models.Enseignant;

public class CoursDAO extends ConnectDAO{

	public CoursDAO() {
		super();
	}
	/**
	 * Create a course without indicating who teaches it.
	 * @param target
	 * @return
	 */
	public int add(Cours target) {
		Connection con=null;
		PreparedStatement ps=null;
		int rVal=0;
		try {
			con=DriverManager.getConnection(URL, LOGIN, PASS);
			ps=con.prepareStatement("INSERT INTO cours (id_cours,nom_cours,masse) VALUES (id_cours.NEXTVAL,?,?)");
			ps.setString(1, target.getNom());
			ps.setInt(2, target.getMasse());
			rVal=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return rVal;
	}
	public int modify(Cours target) {
		Connection con=null;
		PreparedStatement ps=null;
		int rVal=0;
		try {
			con=DriverManager.getConnection(URL, LOGIN, PASS);
			ps=con.prepareStatement("UPDATE cours SET nom=?, masse=? WHERE id_cours=?");
			ps.setString(1, target.getNom());
			ps.setInt(2, target.getMasse());
			ps.setInt(3, target.getID());
			rVal=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return rVal;
	}
	public int delete(Cours target) {
		Connection con=null;
		PreparedStatement ps=null;
		int rVal=0;
		try {
			con=DriverManager.getConnection(URL, LOGIN, PASS);
			ps=con.prepareStatement("DELETE FROM cours WHERE id_cours=?");
			ps.setInt(1, target.getID());
			rVal=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return rVal;
	}
	public ArrayList<Cours> readAll(){
		ArrayList<Cours> list=new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT * FROM cours");
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new Cours(rs.getInt("id_cours"), rs.getString("nom_cours"), rs.getInt("masse"),rs.getInt(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
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
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	/**
	 * Search the cours table knowing which teacher (ID) teaches them
	 * @param ensID
	 * @return list of cours fitting the criteria
	 */
	public ArrayList<Cours> searchByEns(int ensID){
		ArrayList<Cours> list=new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT * FROM cours WHERE ens_par=?");
			ps.setInt(1, ensID);
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new Cours(rs.getInt("id_cours"), rs.getString("nom_cours"), rs.getInt("masse"),rs.getInt(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
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
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	public Cours searchByName(String target) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Cours rCours=null;
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT * FROM cours WHERE nom_cours=?");
			ps.setString(1, target);
			rs=ps.executeQuery();
			if(rs.next()) {
				rCours.setID(rs.getInt("id_cours"));
				rCours.setNom(rs.getString("nom_cours"));
				rCours.setMasse(rs.getInt("masse"));
				rCours.setEnsPar(rs.getInt("ens_par"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
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
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return rCours;
	}
	public Cours searchByID(String target) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Cours rCours=null;
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT * FROM cours WHERE id_cours=?");
			ps.setString(1, target);
			rs=ps.executeQuery();
			if(rs.next()) {
				rCours.setID(rs.getInt("id_cours"));
				rCours.setNom(rs.getString("nom_cours"));
				rCours.setMasse(rs.getInt("masse"));
				rCours.setEnsPar(rs.getInt("ens_par"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
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
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return rCours;
	}
	/**
	 * Indicates a course is taught by a teacher
	 * @param cr
	 * The target cours object, taught by ens
	 * @param ens
	 * The target enseignant object
	 * @return
	 * number of lines midified.
	 */
    public int ensPar(Cours cr,Enseignant ens) {
    	Connection con=null;
		PreparedStatement ps=null;
		int rVal=0;
		try {
			con=DriverManager.getConnection(URL, LOGIN, PASS);
			ps=con.prepareStatement("UPDATE cours SET ens_par=? WHERE id_cours=?");
			ps.setInt(1, ens.getID());
			ps.setInt(2, cr.getID());
			rVal=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return rVal;
    }
	
}