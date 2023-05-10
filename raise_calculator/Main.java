package raise_calculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static final String SEARCH_KEYWORD = "Name";

    public static void main(String[] args) {
        String employeesFolder = "employees.txt";
        File employeeData = new File(employeesFolder);
        EmployeeRecord employeeRecord = null;

        if (employeeData.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(employeesFolder))) {
                String line;
                int lineNumber = 0;

                while ((line = br.readLine()) != null) {
                    lineNumber++;
                    if (line.contains(SEARCH_KEYWORD)) {
                        String name = extractValue(line);
                        String salary = extractValue(br.readLine());
                        String travel = extractValue(br.readLine());
                        employeeRecord = new EmployeeRecord(name, salary, travel);

                        System.out.println(employeeRecord);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error reading employee data file: " + e.getMessage());
            }
        } else {
            System.err.println("Employee data file not found: " + employeesFolder);
        }
    }

    private static String extractValue(String line) {
        return line.replaceAll(".*:", "").trim();
    }
}
