package org.example.management;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {
    @FXML
    private TableView<Employee> tableView;
    @FXML
    private TableColumn<Employee, String> nameColumn;
    @FXML
    private TableColumn<Employee, String> typeColumn;
    @FXML
    private TableColumn<Employee, Double> salaryColumn;
    @FXML
    private TextField nameField;
    @FXML
    private ComboBox<String> typeDropdown;
    @FXML
    private TextField annualSalaryField;
    @FXML
    private TextField hourlyWageField;
    @FXML
    private TextField hoursWorkedField;
    @FXML
    private TextField maxHoursField;
    @FXML
    private Button addButton;
    @FXML
    private Button calculateButton;
    @FXML
    private Button removeButton;

    private final ObservableList<Employee> employees = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        typeDropdown.getItems().addAll("Full-time", "Part-time", "Contractor");
        tableView.setItems(employees);

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        typeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(
                cellData.getValue() instanceof FullTimeEmployee ? "Full-time" :
                        cellData.getValue() instanceof PartTimeEmployee ? "Part-time" : "Contractor"));

        // Wrap calculateSalary() in SimpleDoubleProperty
        salaryColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().calculateSalary()).asObject());

        addButton.setOnAction(e -> addEmployee());
        calculateButton.setOnAction(e -> tableView.refresh());
        removeButton.setOnAction(e -> removeEmployee());
    }

    private void addEmployee() {
        String name = nameField.getText();
        String type = typeDropdown.getValue();

        try {
            Employee employee = null;
            if ("Full-time".equals(type)) {
                double annualSalary = Double.parseDouble(annualSalaryField.getText());
                employee = new FullTimeEmployee(name, annualSalary);
            } else if ("Part-time".equals(type)) {
                double hourlyWage = Double.parseDouble(hourlyWageField.getText());
                int hoursWorked = Integer.parseInt(hoursWorkedField.getText());
                employee = new PartTimeEmployee(name, hourlyWage, hoursWorked);
            } else if ("Contractor".equals(type)) {
                double hourlyRate = Double.parseDouble(hourlyWageField.getText());
                int maxHours = Integer.parseInt(maxHoursField.getText());
                employee = new Contractor(name, hourlyRate, maxHours);
            }

            if (employee != null) {
                employees.add(employee);
                clearFields();
            }
        } catch (NumberFormatException ex) {
            showAlert();
        }
    }

    private void removeEmployee() {
        Employee selectedEmployee = tableView.getSelectionModel().getSelectedItem();
        if (selectedEmployee != null) {
            employees.remove(selectedEmployee);
        }
    }

    private void clearFields() {
        nameField.clear();
        annualSalaryField.clear();
        hourlyWageField.clear();
        hoursWorkedField.clear();
        maxHoursField.clear();
        typeDropdown.getSelectionModel().clearSelection();
    }

    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Input");
        alert.setContentText("Please ensure all fields contain valid numbers.");
        alert.showAndWait();
    }
}