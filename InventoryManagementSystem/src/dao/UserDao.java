/* Names: BhavyaSree Bindela, Sneha Rajulapally
 * CWID: A20448208,A20457266
 * Final Project: Airline Reservation System. 
 * Description: UserProfileUpdateDao-Create new user/admin or update profile
 * Date: 05/09/2020
 * File: UserProfileUpdateDao.java*/

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import models.LoginModel;
import models.ProductModel;
import models.UserProfileModel;

public class UserDao extends DBConnect {
	// Declare DB objects
	DBConnect connection = new DBConnect();

	// method to create user/admin by user
	public void CreateDetails(UserProfileModel customer) {
		// Query to insert new customer into database
		String sql1 = "INSERT INTO vish_pati_users(username, firstName, lastName, dob, email, contNum,usertype) VALUES (?, ?, ?, ?, ?, ?, ?)";

		// Use sql prepared statement for dynamic sql
		try {
			PreparedStatement statement = connection.getConnection().prepareStatement(sql1,
					Statement.RETURN_GENERATED_KEYS);

			// Set the parameters to the query
			statement.setString(1, customer.gettxtUsername());
			statement.setString(2, customer.gettxtLname());
			statement.setString(3, customer.gettxtFname());
			statement.setDate(4, java.sql.Date.valueOf(customer.gettxtDob()));
			statement.setString(5, customer.gettxtEmail());
			statement.setLong(6, customer.gettxtPhone());
			statement.setString(7, customer.getUserType());

			// Execute the insert
			statement.executeUpdate();

			System.out.println("Sucessfully added new customer"); // success message after creating customer in db

		} catch (SQLException e) { // error if the customer is not created successfully
			customer = null;
			System.out.println("Error while adding new customer: " + e.getMessage());
		}
	}

	// method to create login details in db
	public void CreateUser(LoginModel user) {
		String sql2 = "INSERT INTO vish_pati_user(username, password, usertype) VALUES (?, ?, ?)";

		try {
			PreparedStatement statement1 = connection.getConnection().prepareStatement(sql2,
					Statement.RETURN_GENERATED_KEYS);

			// Set the parameters to the query
			statement1.setString(1, user.getUserName());
			statement1.setString(2, user.getPassword());
			String usertype;
			if (user.getuserType() == "Admin") { // get usertype admin/user
				usertype = "admin";
			} else {
				usertype = "user";
			}
			statement1.setString(3, usertype);
			// Execute the insert for users
			statement1.executeUpdate();

			System.out.println("Sucessfully added new user credential details"); // success message if the user
																					// credentials are created
			connection.getConnection().close();
		} catch (SQLException e) { // error if the user credentials are not created
			user = null;
			System.out.println("Error while adding new user credential details: " + e.getMessage());
		}
	}
	// method to fetch the user profile details from table
		public ArrayList<UserProfileModel> getUser(String txtUsername) {
			
			String Sql = "Select firstName, lastName, dob, email, contNum,usertype from vish_pati_users "
					+ "where username = "
					+ "'" + txtUsername + "'";
			System.out.println(Sql);
			ArrayList<UserProfileModel> user = new ArrayList<UserProfileModel>();
			ResultSet rs = null;
System.out.println("hallo");
			try {
				Statement stmt = connection.getConnection().createStatement();

				rs = stmt.executeQuery(Sql);
				System.out.println("1");
int i=0;
				if (rs.next()) {
					UserProfileModel usr = new UserProfileModel();
					// set result set to the text fields
					System.out.println("2");
					usr.settxtFname(rs.getString(1));
					usr.settxtLname(rs.getString(2));
					usr.settxtDob(LocalDate.parse(rs.getString(3)));
					usr.settxtEmail(rs.getString(4));
					usr.settxtPhone(rs.getLong(5));
					usr.setUserType(rs.getString(6));
					System.out.println("3");
					System.out.println("Column [" + i + "] added [" + rs.getMetaData().getColumnName(i + 1) + "]");
					
					user.add(usr);
					System.out.println("Sucessfully fetched profile data from database"); // success message if the profile
																							// data is fetched successfully
				}
				System.out.println("5");
				return user;
			} catch (SQLException e) { // error if the profile data is not fetched successfully
				System.out.println("Error while fetching the user profile info: " + e.getMessage());
				return null;
			}
		}

		// Update the database with the user profile details
		public UserProfileModel update(String txtUsername, UserProfileModel user) {
			// Query to update the customer info in database
			String query = "Update vish_pati_users set firstName=?, lastName =?, dob=?, email=?, contNum=?, usertype=? "
					+ "where username = " + "'" + txtUsername + "'";
			System.out.println(query);
			// Use sql prepared statement for dynamic sql
			try {
				PreparedStatement statement = connection.getConnection().prepareStatement(query,
						Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, user.gettxtLname());
				statement.setString(2, user.gettxtFname());
				statement.setDate(3, java.sql.Date.valueOf(user.gettxtDob()));
				statement.setString(4, user.gettxtEmail());
				statement.setLong(5, user.gettxtPhone());
				statement.setString(6, user.getUserType());

				// Execute the update
				statement.executeUpdate();

				System.out.println("Sucessfully updated profile in the database"); // success message if the profile is
																					// updated in the database successfully

			} catch (SQLException e) { // error if the profile is not updated in the database successfully
				user = null;
				System.out.println("Error updating profile information in database: " + e.getMessage());
			}

			return user;  //return profile details
		}
		
	}

	
	

