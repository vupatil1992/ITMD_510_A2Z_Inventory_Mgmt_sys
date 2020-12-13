/* Names: BhavyaSree Bindela, Sneha Rajulapally
 * CWID: A20448208,A20457266
 * Final Project: Airline Reservation System. 
 * Description: TicketView model-setters and getters for Ticket View fields
 * Date: 05/09/2020
 * File: TicketViewModel.java*/

package models;

public class ProductModel {

	// instance fields
	
	private int fieldProdId;
	private String fieldProdName;
	private String fieldCategoryName;
	private String fieldDescNm;
	private int fieldQuant;
	private double fieldPrice;
	private String FDprodName;
	
	
	// Getters and Setters for the fields

	public int getFieldProdId() {
		return fieldProdId;
	}

	public void setFieldProdId(int fieldProdId) {
		this.fieldProdId = fieldProdId;
	}
	public String getFDprodName() {
		return FDprodName;
	}

	public void setFDprodName(String FDprodName) {
		this.FDprodName = FDprodName;
	}

	public String getFieldProdName() {
		return fieldProdName;
	}

	public void setFieldProdName(String fieldProdName) {
		this.fieldProdName = fieldProdName;
	}

	public String getFieldCategoryName() {
		return fieldCategoryName;
	}

	public void setFieldCategoryName(String fieldCategoryName) {
		this.fieldCategoryName = fieldCategoryName;
	}

	public String getFieldDescName() {
		return fieldDescNm;
	}

	public void setFieldDescName(String fieldDescName) {
		this.fieldDescNm = fieldDescName;
	}

	public int getFieldQuant() {
		return fieldQuant;
	}

	public void setFieldQuant(int fieldQuant) {
		this.fieldQuant = fieldQuant;
	}

	public double getFieldPrice() {
		return fieldPrice;
	}

	public void setFieldPrice(double fieldPrice) {
		this.fieldPrice = fieldPrice;
	}

}
