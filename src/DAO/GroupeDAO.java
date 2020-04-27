package DAO;
import java.sql.*;
import java.util.ArrayList;


import models.Groupe;
public class GroupeDAO extends ConnectDAO {

	public GroupeDAO() {
		super();
	}
	/**
	 * Search the groupe table by num
	 * @param target   the num of the target groupe
	 * @return a groupe object satisfying the condition
	 */
	public Groupe searchByNum(int target) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Groupe result=null;
		
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT * FROM groupe WHERE num=?");
			ps.setInt(1, target);
			rs=ps.executeQuery();
			while(rs.next()) {
				result=new Groupe(rs.getInt(1),rs.getInt(2),rs.getInt(3));
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
	 * Search the groupe table by ID
	 * @param target
	 * @return a groupe object with same ID as the parameter.
	 */
	public Groupe searchByID(int ID) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Groupe result=null;
		
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT * FROM groupe WHERE id_gr=?");
			ps.setInt(1, ID);
			rs=ps.executeQuery();
			while(rs.next()) {
				result=new Groupe(rs.getInt(1),rs.getInt(2),rs.getInt(3));
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
	 * This function reads info of a group, with all students listed.
	 * @param num 
	 * The group number
	 * @return Group
	 * A group object with list of students filled
	 */
	public Groupe readInfo(int num) {
		Groupe target=new Groupe(0,0);
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=DriverManager.getConnection(URL, LOGIN, PASS);
			ps=con.prepareStatement("SELECT * FROM groupe INNER JOIN etudiant ON etudiant.groupNum=groupe.num WHERE groupe.num=?");
		    ps.setInt(1,num);
		    rs=ps.executeQuery();
		    rs.next();
		    target.setID(rs.getInt("id_gr"));
		    target.setCap(rs.getInt("cap"));
		    target.setNum(rs.getInt("num"));
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
		return target;
	}
	/**
	 * This function reads the list of groups
	 * @return ListOfGroup
	 * Group objects in this list have empty student lists.
	 */
	public ArrayList<Groupe> readGrList(){
		ArrayList<Groupe> list=new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT * FROM groupe");
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new Groupe(rs.getInt("id_gr"), rs.getInt("num"), rs.getInt("cap")));
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

	public int add(Groupe newGr) {
		Connection con=null;
		PreparedStatement ps=null;
		int rVal=0;
		try {
			con=DriverManager.getConnection(URL, LOGIN, PASS);
			ps=con.prepareStatement("INSERT INTO groupe (id_gr,num,cap) VALUES (groupe_id.NEXTVAL,?,?)");
			ps.setInt(1, newGr.getNum());
			ps.setInt(2, newGr.getCap());
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
	public int modify(Groupe target) {
		Connection con=null;
		PreparedStatement ps=null;
		int rVal=0;
		try {
			con=DriverManager.getConnection(URL, LOGIN, PASS);
			ps=con.prepareStatement("UPDATE groupe SET num=?, cap=? WHERE id_gr=?");
			ps.setInt(1, target.getNum());
			ps.setInt(2, target.getCap());
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
	public int delete(Groupe target) {
		Connection con=null;
		PreparedStatement ps=null;
		int rVal=0;
		try {
			con=DriverManager.getConnection(URL, LOGIN, PASS);
			ps=con.prepareStatement("DELETE FROM groupe WHERE id_gr=?");
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
	

}
