package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.text.Text;


public class Main extends Application {

	Text textCounter;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		textCounter = new Text();
		Parent root = FXMLLoader.load(getClass().getResource("/view/CalendarFXML.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Gerador de calendario");
		primaryStage.setResizable(false);
		primaryStage.show();

	}
	
	

	public static void main(String[] args) {
		launch(args);

	}

	
	
}
