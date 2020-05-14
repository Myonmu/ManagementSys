package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


import models.Absence;
import models.AbsenceAff;
/**
 * Absence DAO
 * @author Hippocrate
 *
 */
public class AbsenceDAO extends ConnectDAO {
	public AbsenceDAO() {
		super();
	}
	/**
	 * Adding an absence in to the db
	 * @param target target absence
	 * @return number of rows added
	 */
	public int add(Absence target) {
		Connection con=null;
		PreparedStatement ps=null;
		int rVal=0;
		try {
			con=DriverManager.getConnection(URL, LOGIN, PASS);
			ps=con.prepareStatement("INSERT INTO absence "
					+ "(id_abs,plan,week,etu,etat,just,commentaire) VALUES "
					+ "(absence_id.NEXTVAL,?,?,?,?,?,?)");
			ps.setInt(1, target.getPlan());
			ps.setInt(2,target.getWeek());
			ps.setInt(3, target.getEtu());
			ps.setInt(4, target.getEtat());
			ps.setInt(5, target.getJust());
			ps.setString(6, target.getComment());
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
	 * Add an absence without justification into the db
	 * @param target target absence without absencetype nor justification
	 * @return numberof rows added.
	 */
	public int addNoJust(Absence target) {
		Connection con=null;
		PreparedStatement ps=null;
		int rVal=0;
		try {
			con=DriverManager.getConnection(URL, LOGIN, PASS);
			ps=con.prepareStatement("INSERT INTO absence "
					+ "(id_abs,plan,week,etu,commentaire) VALUES "
					+ "(absence_id.NEXTVAL,?,?,?,?)");
			ps.setInt(1, target.getPlan());
			ps.setInt(2,target.getWeek());
			ps.setInt(3, target.getEtu());
			ps.setString(4, target.getComment());
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
	 * Modifies an absence
	 * @param target target absence to be modified
	 * @return number of rows modified. Normally 1.
	 */
	public int modify(Absence target) {
		Connection con=null;
		PreparedStatement ps=null;
		int rVal=0;
		try {
			con=DriverManager.getConnection(URL, LOGIN, PASS);
			if(target.getEtat()!=0&&target.getJust()!=0) {
				ps=con.prepareStatement("UPDATE absence SET plan=?,week=?,etu=?,etat=?,just=?,commentaire=? WHERE id_abs=?");
				ps.setInt(1, target.getPlan());
				ps.setInt(2,target.getWeek());
				ps.setInt(3, target.getEtu());
				ps.setInt(4, target.getEtat());
				ps.setInt(5, target.getJust());
				ps.setString(6, target.getComment());
				ps.setInt(7, target.getID());
			}
			else if(target.getEtat()==0&&target.getJust()!=0){
				ps=con.prepareStatement("UPDATE absence SET plan=?,week=?,etu=?,just=?,commentaire=? WHERE id_abs=?");
				ps.setInt(1, target.getPlan());
				ps.setInt(2,target.getWeek());
				ps.setInt(3, target.getEtu());
				ps.setInt(4, target.getJust());
				ps.setString(5, target.getComment());
				ps.setInt(6, target.getID());
			}else if(target.getEtat()!=0&&target.getJust()==0){
				ps=con.prepareStatement("UPDATE absence SET plan=?,week=?,etu=?,etat=?,commentaire=? WHERE id_abs=?");
				ps.setInt(1, target.getPlan());
				ps.setInt(2,target.getWeek());
				ps.setInt(3, target.getEtu());
				ps.setInt(4, target.getEtat());
				ps.setString(5, target.getComment());
				ps.setInt(6, target.getID());
			}else {
				ps=con.prepareStatement("UPDATE absence SET plan=?,week=?,etu=?,commentaire=? WHERE id_abs=?");
				ps.setInt(1, target.getPlan());
				ps.setInt(2,target.getWeek());
				ps.setInt(3, target.getEtu());
				ps.setString(4, target.getComment());
				ps.setInt(5, target.getID());
			}
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
	 * Deletes an absence
	 * @param target target absence to be deleted
	 * @return number of rows deleted
	 */
	public int delete(Absence target) {
		Connection con=null;
		PreparedStatement ps=null;
		int rVal=0;
		try {
			con=DriverManager.getConnection(URL, LOGIN, PASS);
			ps=con.prepareStatement("DELETE FROM absence WHERE id_abs=?");
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
	 * Read all absence record
	 * @return list of records
	 */
	public ArrayList<Absence> readAll(){
		ArrayList<Absence> list=new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT * FROM absence ORDER BY id_abs");
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new Absence(rs.getInt(1), rs.getInt(2), rs.getInt(3), 
						rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7)));
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
	 * Search for a complete absence object, knowing the id.
	 * @param id
	 * @return the absence object
	 */
	public Absence searchByID(int id){
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Absence rAbs= new Absence(id, id, id, id, id, id, null);
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT * FROM absence WHERE id_abs=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				rAbs.setID(rs.getInt(1));
				rAbs.setPlan(rs.getInt(2));
				rAbs.setWeek(rs.getInt(3));
				rAbs.setEtu(rs.getInt(4));
				rAbs.setEtat(rs.getInt(5));
				rAbs.setJust(rs.getInt(6));
				rAbs.setComment(rs.getString(7));
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
		return rAbs;
	}
	/**
	 * Calculates the exact date of absence
	 * @param id of the target absence
	 * @return Date in DD/MM/YYYY format
	 */
	public String calcDate(int id) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String rDate="";
		DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT TO_CHAR(date_debut,'DD/MM/YYYY'),week,dow FROM absence INNER JOIN planning ON plan=id_planning"
					+ " INNER JOIN sess ON id_session=sess WHERE id_abs=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				int week=rs.getInt(2);
				System.out.println(week);
				int dow=rs.getInt(3);
				System.out.println(dow);
				System.out.println("date_debut "+rs.getString(1));
				Date date=df.parse(rs.getString(1));
				System.out.println("date_debut "+date);
				System.out.println(date);
				Calendar cal=Calendar.getInstance();
				cal.setTime(date);
				cal.add(Calendar.DATE, (week-1)*7+(dow-1));
				date=cal.getTime();
				System.out.println(date);
				rDate=df.format(date);
				System.out.println(rDate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
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
		return rDate;
	}
	/**
	 * Reads all absence record, in a user-friendly style.
	 * @return list of records
	 */
	public ArrayList<AbsenceAff> readAff(){
		ArrayList<AbsenceAff> list=new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT id_abs,etu AS id_etu,id_planning,nom_cours,type_cr,horaire,duree,just,typeAbs.nom AS etatAbs,commentaire"
					+ " FROM absence INNER JOIN planning ON plan=id_planning INNER JOIN cours ON id_cours=mat LEFT OUTER JOIN typeAbs ON etat=id_type"
					+ " ORDER BY id_abs ASC");
			rs=ps.executeQuery();
			while(rs.next()) {
				String date=this.calcDate(rs.getInt("id_abs"));
				String just_state="PAS ENCORE DEPOSE";
				if(rs.getInt("just")!=0) {
					just_state="DEJA DEPOSE";
				}
				String state=rs.getString("etatAbs");
				if(rs.wasNull()) {
					state="N/A";
				}
				String comment=rs.getString("commentaire");
				if(rs.wasNull()) {
					comment="N/A";
				}
				list.add(new AbsenceAff(rs.getInt("id_abs"), rs.getInt("id_etu"), rs.getInt("id_planning"), 
						rs.getString("nom_cours"), rs.getString("type_cr"), date+" "+rs.getString("horaire"),
						rs.getInt("duree"), just_state, state,comment));
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
	 * Gets all students' email address whose absence total surpass the quota, 
	 * @return list of email address.
	 */
	public ArrayList<String> getWarningMailList() {
		ArrayList<String> list=new ArrayList<String>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ConstantsDAO cDAO=new ConstantsDAO();
		int quota=cDAO.readQ();
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT email,SUM(duree) FROM absence INNER JOIN planning ON plan=id_planning "
					+ "INNER JOIN etudiant ON etu=id_etu GROUP BY email HAVING SUM(duree)>?");
			ps.setInt(1, quota);
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("email"));
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

}
