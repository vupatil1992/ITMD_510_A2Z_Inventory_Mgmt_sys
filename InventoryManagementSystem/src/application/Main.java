package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static Stage stage; // set global stage object!!!

	@Override
	public void start(Stage primaryStage) {
	
		//primaryStage.hide();

		try {
			stage = primaryStage;
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/HomeView.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
			stage.setTitle("Home Page");//title of window
			stage.setScene(scene);
			stage.show();
			System.out.println("Inventory Management System launched successfully");

		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		launch(args);
	}
}
