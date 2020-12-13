package controllers;

import application.Main;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import models.LoginModel;
import models.UserProfileModel;

public class LoginController {
	

	@FXML
	private TextField txtUname;

	@FXML
	private PasswordField txtPass;

	@FXML
	private Label lblUnError,lblPassError;

	private LoginModel model;
	@FXML
	private CheckBox chkloginadmin;

	public LoginController() {
		model = new LoginModel();
	}


	public void login() {
		
		String username = this.txtUname.getText();
		String password = this.txtPass.getText();
		lblUnError.setText("");
		// Validations
		if (username == null || username.trim().equals("") && (password == null || password.trim().equals(""))) {
			lblUnError.setText("User name Cannot be empty or spaces");
			lblPassError.setText("Password Cannot be empty or spaces");
			return;
			
		}
		if (username == null || username.trim().equals("")) {
			
			lblUnError.setText("Username Cannot be empty or spaces");
			return;
//			
			
		}
		if (password == null || password.trim().equals("")) {
			lblPassError.setText("Password Cannot be empty or spaces");
			return;
		}
		

		// authentication check
		checkCredentials(username, password);

	}
	
	public void cancel() {
		lblUnError.setText("");
		lblPassError.setText("");
		txtUname.setText("");
		txtPass.setText("");
	}
	
	public void checkCredentials(String username, String password) {
		Boolean isValid = model.getCredentials(username, password);
		if (!isValid) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Login Failed");
			alert.setHeaderText(null);
			alert.setContentText("User does not exist!");

			alert.showAndWait();
			lblPassError.setText("");
			lblUnError.setText("");
			return;
		}
		try {
			AnchorPane root;
			String userName="";
			System.out.println("Welcome "+ username);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Welcome Message");
			alert.setHeaderText("Inventory Management System");
			alert.setContentText("Welcome " + username + "!");
			alert.showAndWait();
			if (model.isAdmin() && isValid) {
				// If user is admin, inflate admin view
				System.out.println("loged in successfuly as Admin");
				 userName = model.getUserName();  
				 UserProfileModel u = new UserProfileModel();
					u.settxtUsername(userName);
					System.out.println("login: "+userName);
				root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/AdminView.fxml"));
				Main.stage.setTitle("Admin View");
				AdminController.setUsername(username);

			} else {
				
				root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/UserView.fxml"));
				// ***Set user ID acquired from db****
				 userName = model.getUserName();  
				System.out.println("login: "+userName);
				UserProfileModel u = new UserProfileModel();
				u.settxtUsername(userName);
				Main.stage.setTitle("User View");
				UserController.setUsername(username);
			}
			
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
		

		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
			e.printStackTrace();
		}

	}
	public void home() throws IOException {
		try {
			// launch home screen
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/HomeView.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
			Main.stage.show();
			Main.stage.setTitle("Home");
			System.out.println("Launched Inventory Management System Home Screen");
		} catch (Exception e) { // error when launching home screen
			System.out.println("Error occured while inflating Home view:" + e.getMessage());
		}

	}
}