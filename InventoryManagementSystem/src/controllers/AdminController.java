package controllers;

import java.io.IOException;
import java.net.URL;

import application.DynamicTable;
import application.Main;
import dao.ProductDao;
import dao.ReportDao;

import dao.UserDao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicLong;

import com.sun.corba.se.impl.orb.ParserTable.TestIIOPPrimaryToContactInfo;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import application.Main;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
//import dao.AdminProfileUpdateDao;
//import dao.AdminHistoryDao;
//import dao.CustomerCreateDao;
//import dao.CustomerProfileViewDao;
//import dao.FlightsSearchDao;
//import dao.TicketBookDao;
import models.LoginModel;

import models.ProductModel;
import models.UserProfileModel;

public class AdminController implements Initializable {

	@FXML
	private Pane pane1; // Pane update Profile 
	@FXML
	private Pane pane2; // Pane edit
	@FXML
	private Pane pane3; // Pane delete
	@FXML
	private Pane pane4;//ADD USER 
	@FXML
	private Button editbtn ;// view profile
	@FXML
	private TextField txtFname; // set text field for first name
	@FXML
	private TextField txtLname; // set text field for last name
	@FXML
	private TextField txtEmail; // set text field for Email
	@FXML
	private TextField txtPhone; // set text field for Phone
	@FXML
	private DatePicker txtDob; // set text field for Date of Birth
	@FXML
	private TextField txtUsername; // set user name text field
	@FXML
	private PasswordField txtPassword; // set password text field
	@FXML
	private Label lblErrorUU;
	@FXML
	private Label lblErrorC;
	@FXML
	private Button btnPaddUser; // set addUser button
//	@FXML
//	private Button deleteBtn; // set delete button
	@FXML
	private Button p1BtnUpdate; // set Update button
	@FXML
	private TextField fieldProdId;
	@FXML
	private TextField fieldProdName;
	@FXML
	private TextField fieldCategoryName;
	@FXML
	private TextField fieldDescNm;
	@FXML
	private TextField fieldQuant;
	@FXML
	private TextField fieldPrice;
	@FXML
	private TextField FDprodName;
	@FXML
	private Label lblerrorP;
	@FXML
	private Button btnAddP;
	@FXML
	private Button btnUpP;
	@FXML
	private Button btnViewP;
	@FXML
	private Button btnDelP;
	@FXML
	private Button addPBtn;
	@FXML
	private Button addB1;
	@FXML
	private Button editlink;
	@FXML
	private ChoiceBox<String> UserType1;
	@FXML
	private ChoiceBox<String> userlist;
	
	// set global user name object
		static UserProfileModel user = new UserProfileModel();
		static String userName = user.gettxtUsername();
		
	static String flag="";
	// Initialize the admin controller
		public void initialize(URL location, ResourceBundle resources) {
			final ObservableList<String> UserTypeL = FXCollections.observableArrayList("User", "Admin");
			UserType1.setItems(UserTypeL);
					}
		// set user name 
		public static void setUsername(String username) {
			userName = username;
		}
		// reset table view based on the values
		public void customResize(TableView<?> view) {

			AtomicLong width = new AtomicLong();
			view.getColumns().forEach(col -> {
				width.addAndGet((long) col.getWidth());
			});
			double tableWidth = view.getWidth();

			if (tableWidth > width.get()) {
				view.getColumns().forEach(col -> {
					col.setPrefWidth(col.getWidth() + ((tableWidth - width.get()) / view.getColumns().size()));
				});
			}
		}
		
		//method when admin clicks on viewProfile button
		public void viewProfile() {
			
			// Extract the data from the text fields of view
			// validating the given inputs
			// Create a DAO instance of the model
		
			pane1.setVisible(true);
			pane2.setVisible(true);

			pane3.setVisible(false);
			pane4.setVisible(true);
			addB1.setVisible(false);
			editlink.setVisible(true);
			
			UserDao usrDao = new UserDao();
			System.out.println("profile:"+userName);
			ArrayList<UserProfileModel> arrayList = usrDao.getUser(userName); // pass user name to get information
			
			// set values in the text fields in view profile screen
			for (UserProfileModel user : arrayList) {
				System.out.println("setting the values");
				txtFname.setText(user.gettxtFname());
				txtLname.setText(user.gettxtLname());
				txtDob.setValue(user.gettxtDob());
				txtEmail.setText(user.gettxtEmail());
				txtPhone.setText(Long.toString(user.gettxtPhone()));
				txtUsername.setText(user.gettxtUsername());
				txtPassword.setText("dummy");
				
			}
			
			
			
			}
		public void slide() {
			pane1.setVisible(true);
			pane2.setVisible(true);

			pane3.setVisible(true);
			pane4.setVisible(true);
			editlink.setVisible(false);
			//lblErrorC.setText("");
			
		}
		
		//method when admin clicks on addUser button
		public void addUser()throws IOException {
			// method to launch login screen when user clicks on signup button
			pane1.setVisible(false);
			pane4.setVisible(true);
			pane3.setVisible(false);
			pane2.setVisible(false);
			addB1.setVisible(true);
			
			p1BtnUpdate.setDisable(false);
			txtUsername.clear();
			txtPassword.clear();
			txtLname.clear();
			txtFname.clear();
			txtPhone.clear();
			txtEmail.clear();
			txtDob.setValue(null);
			
			}
		
		//method when admin clicks on product button
		public void product() {
			DynamicTable d = new DynamicTable("product");
			// call method from DynamicTable class and pass some arbitrary query string
			d.buildData("Select * from vish_pati_product");
				}
		//method when admin clicks on order button
		public void order() {
			DynamicTable d = new DynamicTable("order");
			// call method from DynamicTable class and pass some arbitrary query string
			d.buildData("Select * from vish_pati_order");
		}
		public void category() {
			
			DynamicTable d = new DynamicTable("category");
			// call method from DynamicTable class and pass some arbitrary query string
			d.buildData("Select * from vish_pati_category");
				}
		//method when admin clicks on sales button
		public void sales() {
			DynamicTable d = new DynamicTable("sales");
			// call method from DynamicTable class and pass some arbitrary query string
			d.buildData("Select * from vish_pati_sales");
		}
		
		//method when admin clicks on generateReport button
		public void generateReport() {
			
			 ObservableList<PieChart.Data> pieChartDetails = FXCollections.observableArrayList(
			         new PieChart.Data("Iphone 5S", 13), 
			         new PieChart.Data("Samsung Grand", 25), 
			         new PieChart.Data("MOTO G", 10), 
			         new PieChart.Data("Nokia Lumia", 22)); 
			       
			      //Creating a Pie chart 
			      PieChart pieChart = new PieChart(pieChartDetails); 
			              
			      //Setting the title of the Pie chart 
			      pieChart.setTitle("Sales Report"); 
			       
			      //setting the direction to arrange the data 
			      pieChart.setClockwise(true); 
			       
			      //Setting the length of the label line 
			      pieChart.setLabelLineLength(50); 

			      //Setting the labels of the pie chart visible  
			      pieChart.setLabelsVisible(true); 
			       
			      //Setting the start angle of the pie chart  
			      pieChart.setStartAngle(180);     
			         
			      //Creating a Group object  
			      Group root = new Group(pieChart); 
			         
			      //Creating a scene object 
			      Scene scene = new Scene(root, 600, 400);  
			      
			      //Setting title to the Stage 
			      Stage secondStage = new Stage();
			      secondStage.setTitle("Generated Sales Report View"); 
			         
			      //Adding scene to the stage 
			      secondStage.setScene(scene); 
			         
			      //Displaying the contents of the stage 
			      secondStage.show();
			  
					
		}
		
		
		// Method when admin clicks on logout button
		public void logout() {
			// Alert message to thank admin
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Thank you Message");
			alert.setHeaderText("Inventory management System");
			alert.setContentText("Logged out successfully");
			alert.showAndWait();
			System.out.println("Logged out successfully");
			// Launching home screen to admin
			try {
				AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/HomeView.fxml")); // launch
																												// homeview
																												// screen
				Scene scene = new Scene(root, 800, 600);
				Main.stage.setScene(scene);
				Main.stage.setTitle("Inventory management System");
				System.out.println("Launched Inventory management System Home Screen");
				Main.stage.show();
			} catch (Exception e) { // error when launching screen
				System.out.println("Error in inflating view: " + e.getMessage());
			}
		}
		
		public void create() {

			lblErrorC.setText("");
			// Extract the data from the text fields of view
			// validating the given inputs
			String fname = this.txtFname.getText();
			if (fname == null || fname.trim().equals("")) {
				lblErrorC.setText("Error: First Name should not be empty");
				return;
			}
			String lnm = this.txtLname.getText();
			if (lnm == null || lnm.trim().equals("")) {
				lblErrorC.setText("Error: Last Name should not be empty");
				return;
			}


			LocalDate DOB = this.txtDob.getValue();
			if (DOB == null) {
				lblErrorC.setText("Error: Date of Birth should not be empty");
				return;
			}

			String email = this.txtEmail.getText();
			if (email == null || email.trim().equals("")) {
				lblErrorC.setText("Error: Email should not be empty");
				return;
			}

			String phone = this.txtPhone.getText();
			if ((phone == null) || (phone.trim().equals("")) || (!phone.matches("\\d*"))) {
				lblErrorC.setText("Error: Phone number should be a number");
				return;
			}


			String userType = (String) this.UserType1.getValue();

			String USERNAME = this.txtUsername.getText();
			if (USERNAME == null || USERNAME.trim().equals("")) {
				lblErrorC.setText("Error: User Name should not be empty");
				return;
			}

			String PASSWORD = this.txtPassword.getText();
			if (PASSWORD == null || PASSWORD.trim().equals("")) {
				lblErrorC.setText("Error: Password should not be empty");
				return;
			}

			// Create Customer Object
			UserProfileModel userP = new UserProfileModel();
			// Create User Object
			LoginModel user = new LoginModel();

			// Set the values from the view
			userP.settxtUsername(USERNAME);
			userP.settxtLname(lnm);
			userP.settxtFname(fname);
			userP.settxtDob(DOB);
			userP.settxtEmail(email);
			userP.settxtPhone(Long.parseLong(phone));
			user.setUserName(USERNAME);
			user.setuserType(userType);
			try {
				user.setPassword(hashText(PASSWORD));
			} catch (NoSuchAlgorithmException e1) {
				System.out.println("Error while setting hash password" + e1.getMessage());
			}

			// Create data access instance for customer object
			UserDao C1 = new UserDao();
			C1.CreateDetails(userP);
			C1.CreateUser(user);

			// alert message to show that creation was successful
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Message to Admin");
			alert.setHeaderText("Success Message!");
			System.out.println("User Created Successfully!");
			alert.setContentText("User Created Successfully!");
			alert.showAndWait();
			//createBtn.setDisable(true); // disable create button after successful creation
			System.out.println("Creation successful!");
		}
		private String hashText(String password) throws NoSuchAlgorithmException {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());

			byte byteData[] = md.digest();

			// convert the byte to hex format method 1
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			return sb.toString();
		}
		public void update() {
			pane1.setVisible(true);
			pane4.setVisible(true);
			pane3.setVisible(false);
			pane2.setVisible(false);
			lblErrorUU.setText("");
			// Extract the data from text fields

			// Validate the data and check if all the value are entered
			String fName = this.txtFname.getText();
			if (fName == null || fName.trim().equals("")) {
				lblErrorUU.setText("Error: First Name should not be empty");
				return;
			}

			String lname = this.txtLname.getText();
			if (lname == null || lname.trim().equals("")) {
				lblErrorUU.setText("Error: Last Name should not be empty");
				return;
			}

			
			LocalDate dob = this.txtDob.getValue();
			if (dob == null) {
				lblErrorUU.setText("Error: Date of Birth should not be empty");
				return;
			}

			String email = this.txtEmail.getText();
			if (email == null || email.trim().equals("")) {
				lblErrorUU.setText("Error: Email should not be empty");
				return;
			}

			String phone = this.txtPhone.getText();
			if ((phone == null) || (phone.trim().equals("")) || (!phone.matches("\\d*"))) {
				lblErrorUU.setText("Error: Phone number should be a number");
				return;
			}

			

			// Create a Customer object to set the values
			UserProfileModel user = new UserProfileModel();
			user.settxtFname(fName);
			user.settxtLname(lname);
			user.settxtDob(dob);
			user.settxtEmail(email);
			user.settxtPhone(Long.parseLong(phone));
			txtUsername.setEditable(false);
			txtPassword.setEditable(false);

			// Create data access instance for customerView object
			UserDao usr = new UserDao();
			usr.update(userName, user);
			// alert message to show that profile has been updated successfully
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Message");
			System.out.println("Profile updated successfully!");
			alert.setHeaderText("Success message");
			alert.setContentText("Profile updated successfully!");
			alert.showAndWait();
			System.out.println("Profile updated successfully!");
		}
		
		public void getUser() {
			
		}
		
		public void deleteP() {
//	
			pane1.setVisible(false);
			pane2.setVisible(false);
			pane3.setVisible(true);
			pane4.setVisible(false);

			ProductDao prodDetailDao = new ProductDao();
			ProductModel pmodel = new ProductModel();
			try {

				
				
			
//				ArrayList<String> arrayList = prodDetailDao.getProdTry();
//				final ObservableList<String> proddetails = FXCollections.observableArrayList(arrayList);
//				userlist.setItems(proddetails);
				String prodNF = this.FDprodName.getText();
				pmodel.setFDprodName(prodNF);
				
				
				prodDetailDao.deleteProd(prodNF);
			 // refresh history details table after deletion
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Alert Message");
			alert.setHeaderText("Delete Info");
			alert.setContentText("Product has been deleted Successfully!!");
			System.out.println("Deleted Selected record successfully");
			alert.showAndWait();
		} catch (Exception e) { // Error to display while deleting record
			System.out.println("Error while deleting the Product" + e.getMessage());
		}
//		
}
}