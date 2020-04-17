package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import models.Planning;

public class PlanningDAO extends ConnectDAO {
	public PlanningDAO(){
		super();
	}
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
	
	public ArrayList<Planning> readAll(){
		ArrayList<Planning> list=new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT * FROM planning");
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
	public Planning searchByID(int target) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Planning rPlanning=null;
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT * FROM cours WHERE id_cours=?");
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
}
