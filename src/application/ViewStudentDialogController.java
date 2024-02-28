package application;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;

public class ViewStudentDialogController {

    @FXML
    private ListView<Student> studentsListView; // ListView for displaying list of students
    @FXML
    private TextField studentIdTextField; // TextField for inputting student ID
    @FXML
    private Label errorLabel; // Label for displaying error messages

    // Initializes the controller class. This method is automatically called
    // after the FXML file has been loaded.
    @FXML
    public void initialize() {
        // Customize the display of ListView items using a custom cell factory
        studentsListView.setCellFactory(lv -> new ListCell<Student>() {
            @Override
            protected void updateItem(Student student, boolean empty) {
                super.updateItem(student, empty);
                if (empty || student == null) {
                    setText(null); // Clear the text
                } else {
                    // Format and set the text for non-empty cells
                    setText(String.format("Name: %s, ID: %d, Age: %d, Year of Study: %d",
                            student.getName(), student.getId(), student.getAge(), student.getYearOfStudy()));
                }
            }
        });
    }

    // Searches for a student by ID when the search button is clicked
    @FXML
    private void searchStudentById() {
        errorLabel.setText(""); // Clear the error message at the beginning
        try {
            int id = Integer.parseInt(studentIdTextField.getText());
            Student student = StudentManagement.findStudentById(id);
            if (student != null) {
                studentsListView.getItems().setAll(student); // Display the found student
                errorLabel.setVisible(false); // Hide the error label
            } else {
                errorLabel.setText("No student with this ID exists."); // Set error message
                errorLabel.setVisible(true); // Show the error label
            }
        } catch (NumberFormatException e) {
            errorLabel.setText("ID must be a number."); // Set error message for invalid input
            errorLabel.setVisible(true); // Show the error label
        }
    }

    // Displays all students when the 'Show All' button is clicked
    @FXML
    private void viewAllStudents() {
        studentsListView.getItems().setAll(StudentManagement.getAllStudents()); // Load all students into the ListView
    }
}
