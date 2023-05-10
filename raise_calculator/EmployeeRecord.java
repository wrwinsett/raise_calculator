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

    public String toString() {
        return "Name: " + name + ", Salary: " + salary + ", Travel: " + travel;
    }

}
