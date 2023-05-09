package raise_calculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		String employeesFolder = "employees.txt";
		File employeeData = new File(employeesFolder);
		
		if (employeeData.exists()) {
            String searchKeyword = "Name";
            int lineNumber = 0;
            
            try (BufferedReader br = new BufferedReader(new FileReader(employeesFolder))) {
                String line;
                
                while ((line = br.readLine()) != null) {
                    lineNumber++;
                    if (line.contains(searchKeyword)) {
                        System.out.println(line);
                        for (int i = 0; i < 2; i++) {
                            line = br.readLine();
                            if (line != null) {
                                System.out.println(line);
                            }
                    }
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