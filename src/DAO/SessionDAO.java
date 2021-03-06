package DAO;
import java.sql.*;
import java.text.*;
import java.util.ArrayList;


import models.Session;

/**
 * 
 * @author Hippocrate
 *
 */
public class SessionDAO  extends ConnectDAO{
	public SessionDAO() {
		super();
	}
	/**
	 * search a session by its number
	 * @param target number
	 * @return session object
	 */
	public Session searchByNum(String target) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Session rSession=new Session(0, 0, target);
		DateFormat df=new SimpleDateFormat("DD/MM/YYYY");
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT id_session, num_session,TO_CHAR(date_debut,'DD/MM/YYYY') FROM sess WHERE num_session=?");
			ps.setString(1, target);
			rs=ps.executeQuery();
			if(rs.next()) {
				rSession.setID(rs.getInt(1));
				rSession.setNum(rs.getInt(2));
				rSession.setDate(rs.getString(3));
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
		return rSession;
	}
	/**
	 * search a session py its id
	 * @param id
	 * @return session object
	 */
	public Session searchByID(int i) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Session rSession=new Session(0, 0, "");
		DateFormat df=new SimpleDateFormat("DD/MM/YYYY");
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT id_session, num_session,TO_CHAR(date_debut,'DD/MM/YYYY') FROM sess WHERE id_session=?");
			ps.setInt(1, i);
			rs=ps.executeQuery();
			if(rs.next()) {
				rSession.setID(rs.getInt(1));
				rSession.setNum(rs.getInt(2));
				rSession.setDate(rs.getString(3));
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
		return rSession;
	}
	
	/**
	 * Adds a session into the database.
	 * @param target
	 * A constructed session object, ID of the object is irrelevant.
	 * @return
	 * Number of lines added (1)
	 */
	public int add(Session target) {
		Connection con=null;
		PreparedStatement ps=null;
		int rVal=0;
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("INSERT INTO sess (id_session,num_session,date_debut) VALUES (session_id.NEXTVAL,?,TO_DATE(? ,'dd/mm/yyyy'))");
			ps.setInt(1, target.getNum());
			ps.setString(2, target.getDate());
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
	 * Modifies a session. Only [num_session] and [date_debut] can be modified.
	 * @param target
	 * The up-to-date session object
	 * @return
	 * Number of lines modified (1)
	 */
	public int modify (Session target) {
		Connection con=null;
		PreparedStatement ps=null;
		int rVal=0;
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("UPDATE sess SET num_session=?,date_debut=TO_DATE(?,'dd/mm/yyyy') WHERE id_session=?");
			ps.setInt(1, target.getNum());
			ps.setString(2, target.getDate());
			ps.setInt(3,target.getID());
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
	 * Delete a session. 
	 * @param target
	 * The target session to be deleted
	 * @return
	 * Number of lines deleted (1)
	 */
	public int delete(Session target) {
		Connection con=null;
		PreparedStatement ps=null;
		int rVal=0;
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("DELETE FROM sess WHERE id_session=?");
			ps.setInt(1,target.getID());
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
 * Reads all sessions in the table.
 * @return list
 * a list of session objects.
 */
	public ArrayList<Session> readAll(){
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Session> list=new ArrayList<>();
		DateFormat df=new SimpleDateFormat("MM/DD/YYYY");
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT id_session, num_session,TO_CHAR(date_debut,'DD/MM/YYYY') FROM sess ORDER BY id_session");
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new Session(rs.getInt(1), rs.getInt(2),rs.getString(3)));
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
		return list;
	}
}
