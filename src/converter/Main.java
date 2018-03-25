package converter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main for start program
 * @author Pawan Intawongsa
 *
 */
public class Main extends Application {

	/**
	 * Start program by create scene  form fxml file
	 */
	@Override
	public void start(Stage stage) {
		try {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("Converter.fxml"));
			Scene scene = new Scene(root);
			
			stage.setScene(scene);
			stage.sizeToScene();
			stage.setTitle("Unit Converter");			
			stage.show();
		} catch (Exception e) {
			System.out.println("Exception creating scene: " + e.getMessage());
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) {
		launch(args);
	}

}
