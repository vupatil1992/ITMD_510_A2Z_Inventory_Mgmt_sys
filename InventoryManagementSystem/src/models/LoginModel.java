package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DBConnect;

public class LoginModel extends DBConnect {
 
	private String admin;
	private String uName;
	private String userType;
	private String password;
	public String getuserType() {
		return userType;
	}
	public void setuserType(String userType) {
		this.userType = userType;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getPassword() {
		return password;
	}
	public String getUserName() {
		return uName;
	}
	public void setUserName(String uName) {
		this.uName = uName;
	}
	public Boolean isAdmin() {
		if (admin.equals("user") ) 
			return false;
		else
			return true;
	}
	public void setAdmin(String admin) {
		
		this.admin = admin;
	}
		
	public Boolean getCredentials(String username, String password){
           
        	String query = "SELECT * FROM vish_pati_user WHERE username = ? and password = ?;";
            try(PreparedStatement stmt = connection.prepareStatement(query)) {
               stmt.setString(1, username);
               stmt.setString(2, password);
               ResultSet rs = 
            		   stmt.executeQuery();
                if(rs.next()) { 
                 
                	setUserName(rs.getString("username"));
                	setAdmin(rs.getString("usertype"));
                	return true;
               	}
             }catch (SQLException e) {
            	e.printStackTrace();   
             }
			return false;
    }
	

}//end class