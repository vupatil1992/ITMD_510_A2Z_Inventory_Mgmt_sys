/* Names: Vishakha Patil
 * CWID: A
 * Description: ProductDao-Fetch product details from database
 * Date: 11/20/2020
 * File: ProductDao.java*/

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.ProductModel;

public class ProductDao extends DBConnect {
	// Declare DB objects
	DBConnect connection = new DBConnect();

	// Fetch the product data from table
	public ArrayList<ProductModel> getProd() {
		String Sql = "Select * from vish_pati_product";
		ResultSet rs = null;
		ArrayList<ProductModel> productData = new ArrayList<ProductModel>();
		try 
		{
			Statement stmt = connection.getConnection().createStatement();
			System.out.println("heyyyyyyy not working1");
			rs = stmt.executeQuery(Sql);
			System.out.println("heyyyyyyy not working2");
			if (rs.next()) 
			{
				System.out.println("heyyyyyyy not working3");
				ProductModel t1 = new ProductModel();
				// set result set to the text fields
				t1.setFieldProdId(rs.getInt(1));
				t1.setFieldProdName(rs.getString(2));
				t1.setFieldCategoryName(rs.getString(3));
				t1.setFieldDescName(rs.getString(4));
				t1.setFieldQuant(rs.getInt(5));
				t1.setFieldPrice(rs.getDouble(6));
				productData.add(t1);
				System.out.println(t1.getFieldDescName());
		        for (int i = 0; i < productData.size(); i++) 
		            System.out.print(productData.get(i) + " "); 
				System.out.println("Sucessfully fetched product details from database"); // success message to get
																							// product details
				}
			connection.getConnection().close();
				return productData; //return product details
			} 
			catch (SQLException e) { // error if product details not fetched
				System.out.println("Error while fetching the product details: " + e.getMessage());
				return null;
			}
		}
	// Fetch the product data from table
		public int getPId() {
			String Sql = "Select MAX(productId) AS prodId from vish_pati_product";
			ResultSet rs = null;
			int lastProdId;
			try 
			{System.out.println("heyyyyyyy not working1");
				Statement stmt = connection.getConnection().createStatement();
				System.out.println("heyyyyyyy not working2");
				rs = stmt.executeQuery(Sql);
				System.out.println("heyyyyyyy not working3");
				if (rs.next()) 
				{
					System.out.println("heyyyyyyy not working4");
				}
				ProductModel t1 = new ProductModel();
				lastProdId=rs.getInt(1);
				System.out.println("heyyyyyyy not working");
				System.out.println(lastProdId);
					t1.setFieldProdId(rs.getInt(1));
					System.out.println(t1.getFieldProdId());
					System.out.println("Sucessfully fetched product details from database"); // success message to get
																								// product details
					connection.getConnection().close();
					return lastProdId; //return product details
				} 
				catch (SQLException e) { // error if product details not fetched
					System.out.println("Error while fetching the product details: " + e.getMessage());
					return 0;
				}
			}
	// method to create new product
		public void createProduct(ProductModel product) {
			String sql = "INSERT INTO vish_pati_product(productName, categoryName, description,quantity,price) "
					+ "VALUES (?, ?, ?, ?, ?)";
			try {
				PreparedStatement statement = connection.getConnection().prepareStatement(sql,
						Statement.RETURN_GENERATED_KEYS);

				// Set the parameters to the query
				
				statement.setString(1, product.getFieldProdName());
				statement.setString(2, product.getFieldCategoryName());
				statement.setString(3, product.getFieldDescName());
				statement.setInt(4, product.getFieldQuant());
				statement.setDouble(5, product.getFieldPrice());
				statement.executeUpdate();

				System.out.println("Sucessfully added new product"); // success message if the user
																						// credentials are created
			
				connection.getConnection().close();
			} catch (SQLException e) { // error if the user credentials are not created
				System.out.println("Error while adding new product: " + e.getMessage());
			}
		}
		public ArrayList<String> getProdTry() {
			String Sql = "Select productName from vish_pati_product";
			ResultSet rs = null;
			ArrayList<ProductModel> productData = new ArrayList<ProductModel>();
			try 
			{
				Statement stmt = connection.getConnection().createStatement();
				
				rs = stmt.executeQuery(Sql);
				ArrayList<String> prodN = new ArrayList<>();
				
				if (rs.next()) 
				{
					ProductModel t1 = new ProductModel();
					// set result set to the text fields
					prodN.add(t1.getFieldProdName());
					
					
			        
					System.out.println("Sucessfully fetched product details from database"); // success message to get
																								// product details
					}
				for (int i = 0; i < prodN.size(); i++) 
		            System.out.print(prodN.get(i) + " "); 
				connection.getConnection().close();
					return prodN; //return product details
				} 
				catch (SQLException e) { // error if product details not fetched
					System.out.println("Error while fetching the product details: " + e.getMessage());
					return null;
				}
		}
		public void deleteProd(String FDprodName) {
			// Query to update the customer info in database
						String sql = "Select * from vish_pati_product "
			+ "where productName = " + "'" +FDprodName+ "'";
					
						System.out.println("sql"+sql);
					
						ResultSet rs = null;
						ArrayList<ProductModel> productData = new ArrayList<ProductModel>();
						try 
						{
							Statement stmt = connection.getConnection().createStatement();
							System.out.println("heyyyyyyy not working1");
							rs = stmt.executeQuery(sql);
							System.out.println("heyyyyyyy not working2");
							System.out.println("dat:"+rs.getString(2));
							if (rs.next()) 
							{
								
								//ProductModel t1 = new ProductModel();
								System.out.println("dat:"+rs.getString(2));
								// set result set to the text fields
							
								try {
									String sql2 = "DELETE FROM vish_pati_product WHERE productId = ? AND productName = ? AND categoryName= ? AND description = ? AND quantity = ? AND +\"\n"
											+ "				+ \"price = ?;\";";
										System.out.println(sql2);
									// Use sql prepared statement for dynamic sql
									PreparedStatement statement = connection.getConnection().prepareStatement(sql2,
											Statement.RETURN_GENERATED_KEYS);
									// Set the parameters to the query
									System.out.println("dat:"+rs.getString(2));
									statement.setInt(1, rs.getInt(1));
									statement.setString(2,rs.getString(2));
									statement.setString(3, rs.getString(3));
									statement.setString(4, rs.getString(4));
									statement.setInt(5, rs.getInt(5));
									statement.setDouble(6, rs.getDouble(6));
									

									// Execute the delete
									statement.executeUpdate();
									System.out.println("Sucessfully fetched product details from database");

									System.out.println("Deleted the product"); // success message if the ticket record is successfully deleted
																				// form database

								} catch (SQLException e) { // error if the ticket record is not successfully deleted form database

									System.out.println("Error while deleting a product: " + e.getMessage());
								}
								//productData.add(t1);
								//System.out.println(t1.getFieldDescName());
//						        for (int i = 0; i < productData.size(); i++) 
//						            System.out.print(productData.get(i) + " "); 
								 // success message to get
																											// product details
								}
							connection.getConnection().close();
								//return product details
							} 
							catch (SQLException e) { // error if product details not fetched
								System.out.println("Error while fetching the product details: " + e.getMessage());
							
							}
		}
}
