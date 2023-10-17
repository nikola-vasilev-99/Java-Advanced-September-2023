package Unit6_DefiningClasses.EX.EX2_CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Employee>> departmentMap = new WeakHashMap<>();
        for (int i = 0; i < n; i++) {
            String [] employeeData = scanner.nextLine().split("\\s+");
            String name = employeeData[0];
            double salary = Double.parseDouble(employeeData[1]);
            String position = employeeData[2];
            String department = employeeData[3];
            String email = "n/a";
            int age = -1;

            if (employeeData.length == 6) {
                email = employeeData[4];
                age = Integer.parseInt(employeeData[5]);
            } else if (employeeData.length == 5) {
                if (employeeData[4].contains("@")) {
                    email = employeeData[4];
                } else {
                    age = Integer.parseInt(employeeData[4]);
                }
            }
            Employee employee = new Employee(name, salary, position, department, email, age);
            if (!departmentMap.containsKey(department)) {
                departmentMap.put(department, new ArrayList<>());
                departmentMap.get(department).add(employee);
            } else {
                departmentMap.get(department).add(employee);
            }
        }

        String maxAverageSalaryDepartment = departmentMap.entrySet().stream()
                .max(Comparator.comparingDouble(entry -> getAverageSalary(entry.getValue())))
                .get()//преобразуване от optional map в Map <String, List <Employee>> -> получаваме отдела с най-висока заплата
                .getKey();//вземаме key-а най отдела с най-висока заплата

        System.out.printf("Highest Average Salary: %s%n", maxAverageSalaryDepartment);
        List <Employee> employeeList = departmentMap.get(maxAverageSalaryDepartment);
        employeeList.sort(Comparator.comparingDouble(employee -> employee.getSalary())); //ascending by salary
        Collections.reverse(employeeList); // descending by salary
        
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }
    public static double getAverageSalary(List <Employee> employees) {
        double sum = 0;
        for (Employee employee: employees) {
            sum += employee.getSalary();
        }
        return sum / employees.size();
    }
}
