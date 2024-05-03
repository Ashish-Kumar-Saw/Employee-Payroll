import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Employee{
    private String name;
    private int id;

    public Employee(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString(){
        return "Employee[name="+name+", id="+id+", salary="+calculateSalary()+"]";
    }
}

class FullTimeEmployee extends Employee{
    private double monthlySalary;

    public FullTimeEmployee(String name,int id,double monthlySalary){
        super(name,id);
        this.monthlySalary = monthlySalary;
    }


    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class partTimeEmployee extends Employee{
        private int hoursWorked;
        private double hourlyRates;

        public partTimeEmployee(String name,int id,int hoursWorked,double hourlyRates){
            super(name,id);
            this.hoursWorked = hoursWorked;
            this.hourlyRates = hourlyRates;
        }

        @Override
    public double calculateSalary(){
            return hoursWorked * hourlyRates;
        }
}

class PayrollSystem{
    private List<Employee> employeeList;

    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove = null;
            for (Employee employee : employeeList) {
                if (employee.getId() == id) {
                    employeeToRemove = employee;
                    break;
                }
            }
            if (employeeToRemove != null) {
                employeeList.remove(employeeToRemove);
            }
            System.out.println("Removing Employee "+id);
    }

    public void displayEmployee(){
        for (Employee employee : employeeList){
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee E1 = new FullTimeEmployee("vikas",1,70000.0);
        partTimeEmployee E2 = new partTimeEmployee("Alexander",2,150,100);

        payrollSystem.addEmployee(E1);
        payrollSystem.addEmployee(E2);

        System.out.println("        ======Initial Employee Details =======");
        payrollSystem.displayEmployee();
        System.out.println();


        payrollSystem.removeEmployee(2);

        System.out.println("Remaining Employee: ");
        payrollSystem.displayEmployee();
    }
}