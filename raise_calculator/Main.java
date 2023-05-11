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
            	//uses the buffered reader to read the string value I assigned to the text file
                String line;
                int lineNumber = 0;

                while ((line = br.readLine()) != null) {
                    lineNumber++;
                    if (line.contains(SEARCH_KEYWORD)) {
                    	//search keyword defined up top as name
                        String name = extractValue(line);
                        //uses extracted Value method we made on line where search was found
                        String salary = extractValue(br.readLine());
                        String travel = extractValue(br.readLine());
                        employeeRecord = new EmployeeRecord(name, salary, travel);

                        System.out.println(employeeRecord);
                        
                        if (employeeRecord.multiplier() >= 1) {
                            System.out.println(name + " is up for a raise of $" + employeeRecord.raise(employeeRecord.multiplier()));
                            System.out.println("----------------");
                        }
                        
                        else {
                        	System.out.println(name + " is performing at reason for their salary.");
                        	System.out.println("----------------");
                        }
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
        //replace all method takes everything before the semicolon and replaces it with nothing
        //".*" everything before
        //the trim method cleans up any whitespace
    }
}
