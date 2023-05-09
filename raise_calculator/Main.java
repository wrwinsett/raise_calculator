package raise_calculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Main {
	public static void main(String[] args) {
		String employeesFolder = "employees.txt";
		File employeeData = new File(employeesFolder);
		EmployeeRecord employeeRecord = null;
		
		if (employeeData.exists()) {
            String searchKeyword = "Name";
            int lineNumber = 0;
            
            try (BufferedReader br = new BufferedReader(new FileReader(employeesFolder))) {
                String line;
                
                while ((line = br.readLine()) != null) {
                    lineNumber++;
                    if (line.contains(searchKeyword)) {
                    	String name = line.trim().split(":")[1].trim();
                        String salary = br.readLine().trim().split(":")[1].trim();
                        String travel = br.readLine().trim().split(":")[1].trim();
                        employeeRecord = new EmployeeRecord(name, salary, travel);
                        
                        System.out.println(employeeRecord);
                        }
                    
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            
        } else {
            System.out.println("your employees folder could not be found");
        }
	}
	
}