package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


import models.Absence;

public class AbsenceDAO extends ConnectDAO {
	public AbsenceDAO() {
		super();
	}
	public int add(Absence target) {
		Connection con=null;
		PreparedStatement ps=null;
		int rVal=0;
		try {
			con=DriverManager.getConnection(URL, LOGIN, PASS);
			ps=con.prepareStatement("INSERT INTO absence "
					+ "(id_abs,plan,week,etu,etat,just,comment) VALUES "
					+ "(abs_id.NEXTVAL,?,?,?,?,?,?)");
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
	public int modify(Absence target) {
		Connection con=null;
		PreparedStatement ps=null;
		int rVal=0;
		try {
			con=DriverManager.getConnection(URL, LOGIN, PASS);
			ps=con.prepareStatement("UPDATE absence SET plan=?,week=?,etu=?,etat=?,just=?,comment=? WHERE id_abs=?)");
			ps.setInt(1, target.getPlan());
			ps.setInt(2,target.getWeek());
			ps.setInt(3, target.getEtu());
			ps.setInt(4, target.getEtat());
			ps.setInt(5, target.getJust());
			ps.setString(6, target.getComment());
			ps.setInt(7, target.getID());
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
	
	public int delete(Absence target) {
		Connection con=null;
		PreparedStatement ps=null;
		int rVal=0;
		try {
			con=DriverManager.getConnection(URL, LOGIN, PASS);
			ps=con.prepareStatement("DELETE FROM absence WHERE id_abs=?)");
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
	
	public ArrayList<Absence> readAll(){
		ArrayList<Absence> list=new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT * FROM absence");
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
	
	public String calcDate(int id) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String rDate="";
		DateFormat df=new SimpleDateFormat("DD/MM/YYYY");
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT date_debut,week FROM absence INNER JOIN planning ON plan=id_planning"
					+ "INNER JOIN session ON id_session=sess WHERE id_abs=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				int week=rs.getInt(2);
				Date date=rs.getDate(1);
				Calendar cal=Calendar.getInstance();
				cal.setTime(date);
				cal.add(Calendar.DATE, -week*7);
				date=cal.getTime();
				rDate=df.format(date);
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
		return rDate;
	}

}
