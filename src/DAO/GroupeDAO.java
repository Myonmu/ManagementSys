package DAO;
import java.sql.*;
import java.util.ArrayList;

import models.Etudiant;
import models.Groupe;

public class GroupeDAO extends ConnectDAO {

	public GroupeDAO() {
		super();
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
		    rs.previous();
		    while(rs.next()) {
		    	target.addEtu(new Etudiant(rs.getInt("id_etu"),rs.getString("username"),rs.getString("password"),
		    			rs.getString("nom"),rs.getString("prenom"),rs.getString("email")));
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
	
}
