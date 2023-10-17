package Unit6_DefiningClasses.EX.EX2_CompanyRoster;

import org.w3c.dom.ls.LSOutput;

public class Employee {
    
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email; //optional
    private int age; // optional

    public Employee(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName() + " ").append(String.format("%.2f", getSalary()) + " ").append(getEmail() + " ").append(getAge());
        return sb.toString();
    }
}
