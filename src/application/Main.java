package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Main class for the JavaFX application. Extends from javafx.application.Application
public class Main extends Application {
    
    // The start method is the main entry point for all JavaFX applications
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the main screen layout from an FXML file
        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        
        // Set the title of the primary stage/window
        primaryStage.setTitle("PupilPortFX");
        
        // Set the scene of the primary stage with the loaded layout and size
        primaryStage.setScene(new Scene(root));
        
        // Display the primary stage
        primaryStage.show();
    }

    // The main method is ignored in correctly deployed JavaFX application.
    // main() serves only as fallback in case the application can not be
    // launched through deployment artifacts, e.g., in IDEs with limited FX
    // support. NetBeans ignores main().
    public static void main(String[] args) {
        // Launch the JavaFX application. This method doesn't return until the application has exited.
        launch(args);
    }
}
