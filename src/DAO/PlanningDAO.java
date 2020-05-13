package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import models.Planning;
import models.PlanningAff;
/**
 * 
 * @author Hippocrate
 *
 */
public class PlanningDAO extends ConnectDAO {
	public PlanningDAO(){
		super();
	}
	/**
	 * adds a planning
	 * @param target
	 * @return nb of rows added
	 */
	public int add(Planning target) {
		Connection con=null;
		PreparedStatement ps=null;
		int rVal=0;
		try {
			con=DriverManager.getConnection(URL, LOGIN, PASS);
			ps=con.prepareStatement("INSERT INTO planning (id_planning,sess,mat,dow,horaire,type_cr,duree,gr,ens) "
					+ "VALUES (planning_id.NEXTVAL,?,?,?,?,?,?,?,?)");
			ps.setInt(1, target.getSess());
			ps.setInt(2, target.getMat());
			ps.setInt(3, target.getDow());
			ps.setString(4, target.getHoraire());
			ps.setString(5, target.getType());
			ps.setInt(6, target.getDuree());
			ps.setInt(7, target.getGr());
			ps.setInt(8, target.getEns());
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
	 * modifies a planning
	 * @param target
	 * @return nb of rows modified
	 */
	public int modify(Planning target) {
		Connection con=null;
		PreparedStatement ps=null;
		int rVal=0;
		try {
			con=DriverManager.getConnection(URL, LOGIN, PASS);
			ps=con.prepareStatement("UPDATE planning SET sess=?,mat=?,dow=?,horaire=?,type_cr=?,duree=?,gr=?,ens=? WHERE id_planning=?");
			ps.setInt(1, target.getSess());
			ps.setInt(2, target.getMat());
			ps.setInt(3, target.getDow());
			ps.setString(4, target.getHoraire());
			ps.setString(5, target.getType());
			ps.setInt(6, target.getDuree());
			ps.setInt(7, target.getGr());
			ps.setInt(8, target.getEns());
			ps.setInt(9, target.getID());
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
	 * deletes a planning
	 * @param target
	 * @return nb of rows deleted
	 */
	public int delete(Planning target) {
		Connection con=null;
		PreparedStatement ps=null;
		int rVal=0;
		try {
			con=DriverManager.getConnection(URL, LOGIN, PASS);
			ps=con.prepareStatement("DELETE FROM planning WHERE id_planning=?");
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
	 * reads all planning
	 * @return list of planning
	 */
	public ArrayList<Planning> readAll(){
		ArrayList<Planning> list=new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT * FROM planning ORDER BY id_planning");
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new Planning(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getInt(4),
						rs.getString(5), rs.getString(6), rs.getInt(7),rs.getInt(8), rs.getInt(9)));
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
	 * search a planning by its id
	 * @param target id
	 * @return planning object
	 */
	public Planning searchByID(int target) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Planning rPlanning=new Planning(target, target, target, target, null, null, target, target, target);
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT * FROM planning WHERE id_planning=?");
			ps.setInt(1, target);
			rs=ps.executeQuery();
			if(rs.next()) {
				rPlanning.setID(rs.getInt(1));
				rPlanning.setSess(rs.getInt(2));
				rPlanning.setMat(rs.getInt(3));
				rPlanning.setDow(rs.getInt(4));
				rPlanning.setHoraire(rs.getString(5));
				rPlanning.setType(rs.getString(6));
				rPlanning.setDuree(rs.getInt(7));
				rPlanning.setGr(rs.getInt(8));
				rPlanning.setEns(rs.getInt(9));

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
		return rPlanning;
	}
	/**
	 * Reads a more user-friendly planning list
	 * @return the planning list (PlanningAff objects)
	 */
	public ArrayList<PlanningAff> readPlanningAff(){
		ArrayList<PlanningAff> list=new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT id_planning,id_session,dow,horaire,nom_cours,"
					+ "type_cr,duree,groupe.num AS grNum, enseignant.nom AS ensNom, id_ens,id_cours"
					+ " FROM planning INNER JOIN sess ON sess=id_session "
					+ "INNER JOIN cours ON mat=id_cours INNER JOIN groupe ON gr=id_gr "
					+ "INNER JOIN enseignant ON ens=id_ens ORDER BY id_planning");
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new PlanningAff(rs.getInt("id_planning"),rs.getInt("id_session"), rs.getString("dow"), rs.getString("horaire"),
						rs.getString("nom_cours"), rs.getString("type_cr"), rs.getInt("duree"),rs.getInt("grNum"), rs.getString("ensNom")
						, rs.getInt("id_ens"),rs.getInt("id_cours")));
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
	 * Calculates the number of weeks between a given date and the session initial date
	 * @param planningID
	 * @param dateAbs 
	 * @return
	 * @throws ParseException
	 */
	public int calculateWeek(int planningID,String dateAbs) throws ParseException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int diffWeeks=0;
		DateFormat df=new SimpleDateFormat("DD/MM/YYYY");
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT date_debut FROM sess INNER JOIN planning ON id_session=sess WHERE id_planning=?");
			ps.setInt(1, planningID);
			rs=ps.executeQuery();
			if(rs.next()) {
				Date date=rs.getDate(1);
				Date dateIN=df.parse(dateAbs);
				long diffMs=dateIN.getTime()-date.getTime();
				int diffDays=(int) (diffMs/(24*60*60*1000));
				diffWeeks=diffDays/7+1;
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
		return diffWeeks;
	}
}
