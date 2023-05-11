package raise_calculator;

public class EmployeeRecord {
	private String name;
	private double salary;
	private double travel;
	//private data to call to for the purposes of comparison

	public EmployeeRecord(String name, String salary, String travel) {
		// TODO Auto-generated constructor stub
		this.name = name;
        this.salary = Double.parseDouble(salary);
        this.travel = Double.parseDouble(travel);
        //the Double.parseDouble allows us to parse the string for a double and convert it
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public double getTravel() {
        return travel;
    }
    
    public double multiplier() {
        return travel / 100.0;
    }
    
    public double raise(double d) {
    	return salary/d; 
    }

    public String toString() {
        return "Name: " + name + ", Salary: " + salary + ", Travel: " + travel;
    }

}
