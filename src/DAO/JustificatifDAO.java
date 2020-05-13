package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Justificatif;
/**
 * 
 * @author Hippocrate
 *
 */
public class JustificatifDAO extends ConnectDAO{
	public JustificatifDAO() {
		super();
	}
	
	/**
	 * adds a justification
	 * @param target
	 * @return nb of rows added
	 */
	public int add(Justificatif target) {
		Connection con=null;
		PreparedStatement ps=null;
		int rVal=0;
		try {
			con=DriverManager.getConnection(URL, LOGIN, PASS);
			ps=con.prepareStatement("INSERT INTO justificatif (id_just,trj) VALUES (just_id.NEXTVAL,?)");
			ps.setString(1, target.getTrj());
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
	/**
	 * modifies a justification
	 * @param target
	 * @return number of rows modified
	 */
	public int modify(Justificatif target) {
		Connection con=null;
		PreparedStatement ps=null;
		int rVal=0;
		try {
			con=DriverManager.getConnection(URL, LOGIN, PASS);
			ps=con.prepareStatement("UPDATE justificatif SET trj=? WHERE id_just=?)");
			ps.setString(1, target.getTrj());
			ps.setInt(2, target.getID());
			rVal=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Just Mod issue");
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
	/**
	 * deletes a justification
	 * @param target
	 * @return number of rows deleted
	 */
	public int delete(Justificatif target) {
		Connection con=null;
		PreparedStatement ps=null;
		int rVal=0;
		try {
			con=DriverManager.getConnection(URL, LOGIN, PASS);
			ps=con.prepareStatement("DELETE FROM justificatif WHERE id_just=?)");
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
	/**
	 * reads all justifications
	 * @return  list of justification
	 */
	public ArrayList<Justificatif> readAll(){
		ArrayList<Justificatif> list=new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT * FROM justificatif ORDER BY id_just");
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new Justificatif(rs.getInt("id_just"), rs.getString("trj")));
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
	 * search a justification by its id
	 * @param id
	 * @return target justification
	 */
	public Justificatif searchByID(int id){
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Justificatif rJust= new Justificatif(null);
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT * FROM justificatif WHERE id_just=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				rJust.setID(rs.getInt("id_just"));
				rJust.setTrj(rs.getString("trj"));
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
		return rJust;
	}
	/**
	 * searches a justification by its trajectory
	 * @param trj
	 * @return target justification
	 */
	public Justificatif searchByTrj(String trj){
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Justificatif rJust= new Justificatif(null);
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT * FROM justificatif WHERE trj=?");
			ps.setString(1, trj);
			rs=ps.executeQuery();
			if(rs.next()) {
				rJust.setID(rs.getInt("id_just"));
				rJust.setTrj(rs.getString("trj"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Just Search trj issue");
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
		return rJust;
	}

}
