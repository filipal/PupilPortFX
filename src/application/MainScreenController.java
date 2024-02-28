package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

// Controller for the main screen of the application
public class MainScreenController {

    // FXML annotations to inject UI components from FXML layout
    @FXML
    private VBox addStudentForm; // Container for the add student form
    @FXML
    private TextField nameInput; // Input field for student's name
    @FXML
    private TextField idInput; // Input field for student's ID
    @FXML
    private TextField ageInput; // Input field for student's age
    @FXML
    private TextField gradeInput; // Input field for student's grade (not used in final version)

    // Handler for opening the Add Student dialog
    public void openAddStudentDialog(ActionEvent event) {
        openDialog("AddStudentDialog.fxml", "Add Student");
    }

    // Handler for opening the Update Student dialog
    public void openUpdateStudentDialog(ActionEvent event) {
        openDialog("UpdateStudentDialog.fxml", "Update Student");
    }

    // Handler for opening the View Student dialog
    public void openViewStudentDialog(ActionEvent event) {
        openDialog("ViewStudentDialog.fxml", "View Student");
    }

    // Handler to exit the application
    public void exitApplication(ActionEvent event) {
        System.exit(0);
    }

    // Utility method to clear all input fields in the form
    private void clearForm() {
        nameInput.clear();
        idInput.clear();
        ageInput.clear();
        gradeInput.clear();
    }

    // Utility method to show an alert dialog with a specific title and message
    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Helper method to open a dialog window based on the FXML file and title
    private void openDialog(String fxmlFile, String title) {
        try {
            // Load the FXML file and create a new stage for the popup dialog
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent parent = fxmlLoader.load();    

            Scene scene = new Scene(parent);
            
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL); // Make the dialog modal
            stage.setScene(scene);
            stage.setTitle(title);
            stage.showAndWait(); // Display the dialog and wait until it is closed
        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace in case of an error
        }
    }
}
