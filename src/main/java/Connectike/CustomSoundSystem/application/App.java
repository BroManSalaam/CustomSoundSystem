package Connectike.CustomSoundSystem.application;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			System.out.println("loading scenes...");
			Parent root = FXMLLoader.load(getClass().getResource("../resources/fxml/main.fxml"));

			Scene scene = new Scene(root);
			
			System.out.println("loading css content...");
			scene.getStylesheets().add(getClass().getResource("../resources/css/application.css").toExternalForm());
			
			System.out.println("finalizing initialization...");
			primaryStage.setScene(scene);
			primaryStage.show();
						
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public void stop() throws Exception {
		System.out.println("closing platform...");
		Platform.exit();
		super.stop();
		System.out.println("terminating program...");
		System.exit(0);
	}



	public static void main(String[] args) {
		System.out.println("launching...");
		launch(args);
	}
}
