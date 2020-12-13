/* Names: BhavyaSree Bindela, Sneha Rajulapally
 * CWID: A20448208,A20457266
 * Final Project: Airline Reservation System. 
 * Description: UserProfile model-setters and getters for User Profile  fields
 * Date: 05/09/2020
 * File: UserProfileModel.java*/

package models;

import java.time.LocalDate;

public class UserProfileModel {

	// instance fields
	private String txtUsername;
	private String txtLname;
	private String txtFname;
	private LocalDate txtDob;
	private String txtEmail;
	private long txtPhone;
	private String uType;
	

	// Getters and Setters for the fields

	/**
	 * @return the txtUname
	 */
	public String gettxtUsername() {
		return txtUsername;
	}

	/**
	 * @param txtUname the txtUname to set
	 */
	public void settxtUsername(String txtUsername) {
		this.txtUsername = txtUsername;
	}

	/**
	 * @return the txtLname
	 */
	public String gettxtLname() {
		return txtLname;
	}

	/**
	 * @param txtLname the txtLname to set
	 */
	public void settxtLname(String txtLname) {
		this.txtLname = txtLname;
	}

	/**
	 * @return the txtFname
	 */
	public String gettxtFname() {
		return txtFname;
	}

	/**
	 * @param txtFname the txtFname to set
	 */
	public void settxtFname(String txtFname) {
		this.txtFname = txtFname;
	}

	/**
	 * @return the txtDob
	 */
	public LocalDate gettxtDob() {
		return txtDob;
	}

	/**
	 * @param txtDob the txtDob to set
	 */
	public void settxtDob(LocalDate txtDob) {
		this.txtDob = txtDob;
	}

	

	/**
	 * @return the txtEmail
	 */
	public String gettxtEmail() {
		return txtEmail;
	}

	/**
	 * @param txtEmail the txtEmail to set
	 */
	public void settxtEmail(String txtEmail) {
		this.txtEmail = txtEmail;
	}
	public void setUserType(String userType) {
		 this.uType= userType;
	}
	public String getUserType() {
		return uType;
	}
	/**F
	 * @return the txtPhone
	 */
	public long gettxtPhone() {
		return txtPhone;
	}

	/**
	 * @param txtPhone the txtPhone to set
	 */
	public void settxtPhone(long txtPhone) {
		this.txtPhone = txtPhone;
	}
}
