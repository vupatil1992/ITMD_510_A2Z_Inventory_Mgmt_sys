/* Names: BhavyaSree Bindela, Sneha Rajulapally
 * CWID: A20448208,A20457266
 * Final Project: Airline Reservation System. 
 * Description: FlightSearchDao-Fetch flight details based on selection criteria from database
 * Date: 05/09/2020
 * File: FlightSearchDao.java*/

package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;


public class ReportDao extends DBConnect {
	// Declare DB objects
//		DBConnect connection = new DBConnect();
//	
//		try {
//			Connection conn = connection.getConnection();
//			// SQL FOR SELECTING DATA
//			String sql = "Select productName,quantity from vish_pati_sales;";
//			// ResultSet object
//			ResultSet rs = conn.createStatement().executeQuery(sql);
//			while (rs.next()) {
//				// Iterate Row
//				ObservableList<String> data = FXCollections.observableArrayList();
//				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
//					// Iterate Column, grab data
//					data.add(rs.getString(i));
//				}
//				System.out.println("Row [" + (ridx++) + "] added " + data);
//				
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Error on Building Data");
//		}
	
	
}