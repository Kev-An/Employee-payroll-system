import java.util.ArrayList;
import java.util.List;

abstract class Employee{
    private String name;
    private int id;

    public Employee(String name, int id){
        this.name=name;
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public int getid(){
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public  String toString(){
        return "Employee[name="+name+",id="+id+",salary="+calculateSalary()+"]";
    }
}
class FullTimeEmployee extends Employee{
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary){
        super(name, id);
        this.monthlySalary=monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

}
class PayrollSystem{
    private ArrayList<Employee> employeeList;
    public PayrollSystem(){
        employeeList= new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);

    }
    public void removeEmployee(int id){
        Employee EmployeeToRemove=null;
        for(Employee employee:employeeList){
           if(employee.getid()==id){
               EmployeeToRemove=employee;
               break;
           }
        }
        if (EmployeeToRemove!=null){
            employeeList.remove(EmployeeToRemove);
        }
    }

    public void displayEmployees(){
        for (Employee employee:employeeList){
            System.out.println(employee);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem=new PayrollSystem();
        FullTimeEmployee emp1=new FullTimeEmployee("akash",1,70000.0);
        PartTimeEmployee emp2=new PartTimeEmployee("Kevin",2,40,100);
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        System.out.println("Initial employee details: ");
        payrollSystem.displayEmployees();
        System.out.println("Remove employees");
        payrollSystem.removeEmployee(2);
        System.out.println("remaining employees");
        payrollSystem.displayEmployees();

    }
}
