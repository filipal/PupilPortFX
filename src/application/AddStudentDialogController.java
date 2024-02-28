package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

// Controller for the AddStudentDialog, managing user interactions within the dialog
public class AddStudentDialogController {

    // FXML annotations to bind UI components from FXML to Java code
    @FXML
    private TextField nameStudentTextField;
    @FXML
    private TextField idStudentTextField;
    @FXML
    private TextField ageStudentTextField;
    @FXML
    private TextField yearStudyStudentTextField;
    @FXML
    private Label errorMessageLabel; 

    // Handler for the "Add Student" action
    @FXML
    private void addStudent() {
        errorMessageLabel.setVisible(false); // Initially hide the error message
        try {
            // Extract and parse input values from text fields
            String name = nameStudentTextField.getText();
            int id = Integer.parseInt(idStudentTextField.getText());
            int age = Integer.parseInt(ageStudentTextField.getText());
            int yearOfStudy = Integer.parseInt(yearStudyStudentTextField.getText());
            
            // Check if a student with the given ID already exists
            if (StudentManagement.findStudentById(id) != null) {
                // If yes, display an error message and terminate the method
                showErrorMessage("A student with this ID already exists.");
                return;
            }
            
            // Create a new student instance and add it to the student management system
            Student student = new Student(name, id, age, yearOfStudy);
            StudentManagement.addStudent(student);
            
            // Display a confirmation alert
            showAlert("Student Added", "Student successfully added!");
            
            // Close the dialog window
            Stage stage = (Stage) nameStudentTextField.getScene().getWindow();
            stage.close();
        } catch (NumberFormatException e) {
            // Display an error message for invalid numerical input
            showErrorMessage("Please enter valid numbers for ID, age, and year of study.");
        } catch (Exception e) {
            // Display a generic error message for any other exceptions
            showErrorMessage("An error occurred while adding the student.");
        }
    }

    // Utility method to display an information alert
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Utility method to display an error message in the UI
    private void showErrorMessage(String message) {
        errorMessageLabel.setText(message);
        errorMessageLabel.setVisible(true); // Make the error label visible
    }
}
