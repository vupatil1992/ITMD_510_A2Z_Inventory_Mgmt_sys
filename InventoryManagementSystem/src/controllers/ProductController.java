package controllers;
import java.io.IOException;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


//
//import java.io.IOException;
//import java.net.URL;
//import application.Main;
//import models.ProductModel;
//import dao.ProductDao;
//
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Optional;
//import java.util.ResourceBundle;
//import java.util.concurrent.atomic.AtomicLong;
//import javafx.application.Platform;
//import application.Main;
//import javafx.fxml.FXML;
//import javafx.scene.input.MouseEvent;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Node;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.DatePicker;
//import javafx.scene.control.Label;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.TextInputDialog;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
//import javafx.scene.control.ChoiceBox;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.Pane;
//import javafx.stage.Stage;
////import dao.AdminProfileUpdateDao;
////import dao.AdminHistoryDao;
////import dao.CustomerCreateDao;
////import dao.CustomerProfileViewDao;
////import dao.FlightsSearchDao;
////import dao.TicketBookDao;
//import javafx.collections.*;
////import models.CustomerProfileModel;
////import models.CustomerProfileModel;
////import models.FlightSearchModel;
////import models.HistoryModel;
////import models.FlightSearchModel;
////import models.HistoryModel;
////import models.AdminProfileModel;
////import models.CustomerProfileModel;
////import models.FlightSearchModel;
////import models.HistoryModel;
////import models.TicketBookModel;
//import models.LoginModel;
//

public class ProductController{
	
	private Button btnViewP;
	public void delete() throws IOException {
		

	}
//
//	@FXML
//	private Label fieldProdId;
//	@FXML
//	private Label fieldProdName;
//	@FXML
//	private Label fieldCategoryName;
//	@FXML
//	private Label fieldDescName;
//	@FXML
//	private Label fieldQuant;
//	@FXML
//	private Label fieldPrice;
//	@FXML
//	private Label lblerrorP;
//	@FXML
//	private Button btnAddP;
//	@FXML
//	private Pane pane3; // set pane 1
//	
//	
//	
//	public void addProduct() {
//		pane3.setVisible(true);
//			lblerrorP.setText("");
//			
//			// Extract the data from the text fields of view
//			// validating the given inputs
//			String prodId = this.fieldProdId.getText();
//			if (prodId == null || prodId.trim().equals("")) {
//				lblerrorP.setText("Error: Product Id should not be empty");
//				return;
//			}
//
//			String prodName = this.fieldProdName.getText();
//			if (prodName == null || prodName.trim().equals("")) {
//				lblerrorP.setText("Error: Product Name should not be empty");
//				return;
//			}
//			
//			String catName =  this.fieldCategoryName.getText();
//			if (catName == null || catName.trim().equals("")) {
//				lblerrorP.setText("Error: Product Category should not be empty");
//				return;
//			}
//
//			String descN = this.fieldDescName.getText();
//			if (descN == null || descN.trim().equals("")) {
//				lblerrorP.setText("Error: Product Description should not be empty");
//				return;
//			}
//
//			String quant = this.fieldQuant.getText();
//			if (quant == null || quant.trim().equals("")) {
//				lblerrorP.setText("Error: Quantity number should be a number");
//				return;
//			}
//			String price = this.fieldPrice.getText();
//			if (price == null || price.trim().equals("")) {
//				lblerrorP.setText("Error: Price should be a number");
//				return;
//			}
//
//			
//			
//
//			// Create Product Object
//			ProductModel product = new ProductModel();
//			
//			// Set the values from the view
//			product.setFieldProdId(prodId);
//			product.setFieldProdName(prodName);
//			product.setFieldCategoryName(catName);
//			product.setFieldDescName(descN);
//			product.setFieldQuant(Integer.parseInt(quant));
//			product.setFieldPrice(Double.parseDouble(price));
//			
//			// alert message to show that creation was successful
//			Alert alert = new Alert(AlertType.INFORMATION);
//			alert.setTitle("Success Message");
//			
//			System.out.println("Product added Successfully!");
//			alert.setContentText("Product added Successfully!");
//			alert.showAndWait();
//			btnAddP.setDisable(true); // disable create button after successful creation
//			System.out.println("Creation successful!");
//		
//		
//	}
//	public void updateProduct() {
//		pane3.setVisible(true);
//		
//		// Create a DAO instance of the model
//		ProductDao prodDetailDao = new ProductDao();
//		ArrayList<ProductModel> arrayList = prodDetailDao.getProd();
//		// set the values fetched from data based
////		try {
//////				for (ProductModel prodDeta : arrayList) 
//////				{
////					System.out.println("Displaying product details");
////					fieldProdId.setText((prodDeta.getFieldProdId()));
////					fieldProdName.setText(prodDeta.getFieldProdName());
////					fieldCategoryName.setText(prodDeta.getFieldCategoryName());
////					fieldDescName.setText(prodDeta.getFieldDescName());
////					fieldQuant.setText(Integer.toString(prodDeta.getFieldQuant()));
////					fieldPrice.setText(Double.toString(prodDeta.getFieldPrice()));
//////				}
////				} catch (Exception e) { // error when launching next screen
////					System.out.println("Error in setting ticket details: " + e.getMessage());
////				}
//		
//	}
//	public void viewProduct() {
//		pane3.setVisible(true);
//	
//		// Create a DAO instance of the model
//		ProductDao prodDetailDao = new ProductDao();
//		ArrayList<ProductModel> arrayList = prodDetailDao.getProd();
//		// set the values fetched from data based
//		try {
//				for (ProductModel prodDeta : arrayList) 
//				{
//					System.out.println("Displaying product details");
//					fieldProdId.setText((prodDeta.getFieldProdId()));
//					fieldProdName.setText(prodDeta.getFieldProdName());
//					fieldCategoryName.setText(prodDeta.getFieldCategoryName());
//					fieldDescName.setText(prodDeta.getFieldDescName());
//					fieldQuant.setText(Integer.toString(prodDeta.getFieldQuant()));
//					fieldPrice.setText(Double.toString(prodDeta.getFieldPrice()));
//				}
//				} catch (Exception e) { // error when launching next screen
//					System.out.println("Error in setting ticket details: " + e.getMessage());
//				}
//		
//	}
//	public void deleteProduct() {
//		
//		
//	}
//		
//	
//		
}