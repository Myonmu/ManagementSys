package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * a CONSTANTS table used to store quota
 * @author Hippocrate
 *
 */
public class ConstantsDAO extends ConnectDAO{
	public ConstantsDAO() {
		super();
	}
	/**
	 * Reads the quota value from the db
	 * @return quota value
	 */
	public int readQ() {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int rVal=-1;
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			ps=con.prepareStatement("SELECT constValue FROM constants WHERE description='Quota'");
			rs=ps.executeQuery();
			if(rs.next()) {
				rVal=rs.getInt("constValue");
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
		return rVal;
	}
	/**
	 * Modifies the quota. Adds it if it is not in the table.
	 * @param newValue
	 * @return number of rows modified/added.
	 */
	public int modifyQ(int newValue) {
		Connection con=null;
		PreparedStatement ps=null;
		int rVal=0;
		
		try {
			con=DriverManager.getConnection(URL,LOGIN,PASS);
			if(readQ()==-1) {
				ps=con.prepareStatement("INSERT INTO constants (description,constValue) VALUES ('Quota',?)");
				ps.setInt(1, newValue);
			}else {
				ps=con.prepareStatement("UPDATE constants SET constValue=? WHERE description='Quota'");
				ps.setInt(1, newValue);
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
}
