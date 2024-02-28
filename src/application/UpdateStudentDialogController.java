package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateStudentDialogController {

    @FXML
    private TextField updateNameTextField, updateAgeTextField, updateYearTextField; // TextFields for entering updated student information
    @FXML
    private Button searchIdButton, updateStudentButton; // Buttons for searching and updating a student
    @FXML
    private Label errorMessageLabel; // Label for displaying error messages

    private Student currentStudent; // Currently selected student for updating

    // Searches for a student by their ID and fills the form with their current information
    @FXML
    private void searchId() {
        errorMessageLabel.setText("");
        errorMessageLabel.setVisible(false);

        // Assumes the ID is always the first TextField before the "Search" button
        TextField idTextField = (TextField) searchIdButton.getScene().lookup("#idTextField");
        int studentId;
        try {
            studentId = Integer.parseInt(idTextField.getText());
        } catch (NumberFormatException e) {
            showErrorMessage("Invalid ID format."); // Display error if ID is not a valid number
            return;
        }

        currentStudent = StudentManagement.findStudentById(studentId);
        if (currentStudent != null) {
            // If the student exists, fill the form with their current information
            updateNameTextField.setText(currentStudent.getName());
            updateAgeTextField.setText(String.valueOf(currentStudent.getAge()));
            updateYearTextField.setText(String.valueOf(currentStudent.getYearOfStudy()));

            // Make the fields and the update button visible
            setFieldsVisibility(true);
        } else {
            showErrorMessage("Student with the provided ID does not exist."); // Display error if no student found
        }
    }

    // Updates the student's information based on the form's input
    @FXML
    private void updateStudent() {
        if (currentStudent != null) {
            try {
                // Update currentStudent's information with form input
                currentStudent.setName(updateNameTextField.getText());
                currentStudent.setAge(Integer.parseInt(updateAgeTextField.getText()));
                currentStudent.setYearOfStudy(Integer.parseInt(updateYearTextField.getText()));
                
                StudentManagement.updateStudent(currentStudent); // Update the student in the management system
                showSuccessMessage("Student updated successfully."); // Inform the user of success
                
                // Close the dialog after successful update
                Stage stage = (Stage) updateStudentButton.getScene().getWindow();
                stage.close();
            } catch (NumberFormatException e) {
                showErrorMessage("Please enter valid numbers for age and year of study."); // Display error for invalid numbers
            }
        }
    }

    // Sets the visibility of the update form fields and button
    private void setFieldsVisibility(boolean visible) {
        updateNameTextField.setVisible(visible);
        updateAgeTextField.setVisible(visible);
        updateYearTextField.setVisible(visible);
        updateStudentButton.setVisible(visible);
    }

    // Displays an error message
    private void showErrorMessage(String message) {
        errorMessageLabel.setText(message);
        errorMessageLabel.setVisible(true); // Make sure to set the label as visible
    }
    
    // You can use an Alert dialog to display a success message or implement another method of notifying the user
    private void showSuccessMessage(String message) {
        // Implementation depends on your preference
    }
}
