import java.awt.*;
import java.awt.event.*;

public class LabActivity4EmpInfoSystemGUI extends Frame implements ActionListener {
    TextField fnameInput, lnameInput, ageInput, hoursWorkedField, hourlyWageInput;
    TextArea outputArea;
    Button computeButton;

    public LabActivity4EmpInfoSystemGUI {
        setLayout(new GridLayout(7, 2, 10, 10));

        add(new Label("First Name:"));
        fnameInput = new TextField();
        add(fnameInput);

        add(new Label("Last Name:"));
        lnameInput = new TextField();
        add(lnameInput);

        add(new Label("Age:"));
        ageInput = new TextField();
        add(ageInput);

        add(new Label("Hours Worked:"));
        hoursWorkedField = new TextField();
        add(hoursWorkedField);

        add(new Label("Hourly Wage:"));
        hourlyWageInput = new TextField();
        add(hourlyWageInput);

        computeButton = new Button("Compute");
        computeButton.addActionListener(this);
        add(computeButton);

        outputArea = new TextArea("", 3, 40, TextArea.SCROLLBARS_VERTICAL_ONLY);
        outputArea.setEditable(false);
        add(outputArea);


        setTitle("Employee Information System");
        setSize(500, 350);
        setResizable(false);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        String firstName = fnameInput.getText().trim();
        String lastName = lnameInput.getText().trim();
        String ageText = ageInput.getText().trim();
        String hoursText = hoursWorkedField.getText().trim();
        String wageText = hourlyWageInput.getText().trim();

        if (firstName.isEmpty() || lastName.isEmpty() || ageText.isEmpty() || hoursText.isEmpty() || wageText.isEmpty()) {
            outputArea.setText("All fields must be filled.");
            return;
        }

        int age;
        float hoursWorked;
        float hourlyWage;

        try {
            age = Integer.parseInt(ageText);
        } catch (NumberFormatException ex) {
            outputArea.setText("Error: Age must be a valid integer. Please enter a valid number for Age.");
            return;
        }

        try {
            hoursWorked = Float.parseFloat(hoursText);
        } catch (NumberFormatException ex) {
            outputArea.setText("Please enter a valid number for Hours Worked.");
            return;
        }

        try {
            hourlyWage = Float.parseFloat(wageText);
        } catch (NumberFormatException ex) {
            outputArea.setText("Please enter a valid number for Hourly Wage.");
            return;
        }

        String fullName = firstName + " " + lastName;
        float dailyWage = hoursWorked * hourlyWage;

        outputArea.setText("Full Name: " + fullName + "\nAge: " + age + "\nDaily Wage: PHP " + String.format("%.2f", dailyWage));
    }

    public static void main(String[] args) {
        new EmployeeInfoSystem();
    }
      }
