# PupilPortFX
Student Record Management System in Java in JavaFX

# PupilPortFX Application Documentation
# Overview
PupilPortFX is a JavaFX-based application designed to manage student information effectively. It allows users to add, update, and view student details through a graphical user interface (GUI). The application ensures data integrity by preventing duplicate student IDs.

# System Requirements
JDK version 17 or higher.
JavaFX library setup in your IDE.

# Installation and Running
Setup: Download the .java and .fxml files. Ensure JavaFX is configured in your IDE.
Launch: Run the Main class to start the application.

# User Interface Overview
The application provides a GUI for interaction with the system.
Main Screen: The landing page with navigation buttons.

# 1. Add Student
Navigate to "Add Student".
Fill in the form and submit.

# Common Errors
Functionality allows users to add new student records into the system. It checks for duplicate IDs and validates input fields to ensure data integrity.
Empty Fields
Description: Occurs when one or more input fields are left empty.
Resolution: Ensure all fields are filled before submission.

# Duplicate ID
Description: Triggers when the entered student ID already exists in the system.
Resolution: Use a unique ID for each student.

# Invalid Number Format
Description: Happens when non-numeric values are entered in numeric fields (ID, Age, Year of Study).
Resolution: Enter valid numbers in the ID, Age, and Year of Study fields.

# 2. Update Student
Go to "Update Student".
Search with ID and update the information.
          
# Common Errors
Enables updating existing student information by searching with the student ID. It validates the existence of the student in the system.
Student Not Found
Description: Occurs when there is no student matching the entered ID.
Resolution: Verify the ID and try again.

# Invalid ID for Search
Description: Triggered by entering a non-numeric value in the search field.
Resolution: Use numeric values for searching.

# 3. View Students
Select "View Students" to list all or search by ID.

# Common Errors
Displays all registered students or allows searching for a specific student by ID. It formats the display of student details.

# Student Not Found (Search)
Description: When searching for a specific ID that does not exist.
Resolution: Check the ID and try again.
[Insert Image] Placeholder for Student Not Found in Search Error Screenshot
      
# Conclusion
PupilPortFX is a comprehensive solution for managing student information. Its intuitive interface and robust backend make it an excellent tool for educational institutions and teachers. By following the guidelines provided in this documentation, users can effectively utilize the application to manage student records.
