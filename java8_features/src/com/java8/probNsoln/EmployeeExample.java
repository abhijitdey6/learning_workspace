package com.java8.probNsoln;

import com.java8.db.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeExample {
    static List<Employee> employeeList = new ArrayList<Employee>();
    static{
        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

    }
    public static void main(String[] args) {
        System.out.println("No of male and female employees in the org:"+countMaleFemale());
        System.out.println("Distinct departments:"+printDepartmentsName());
        System.out.println("Calculate Male Female Avg Age:"+calcMaleFemaleAvgAge());
        System.out.println("Highest paid employee:"+highestPaidEmployee());
        System.out.println("Employees joined after 2015:"+emplListJoinedAfterDate());
        System.out.println("Employee count in each department:"+countEmployeeInDepartments());
        System.out.println("Average salary in each department:"+avgSalaryInDepartments());
        System.out.println("Youngest employess in Product And Developement:"+youngestEmployeeInProductAndDevelopment());
        System.out.println("Employee with highest experience:"+employeeWithHighestExperience());
        System.out.println("Count Male and female in sales and marketting:"+countMaleFemaleinSales());
        System.out.println("List all the employee name in each department:");
        listNameInEachDepartment();
        calculateAvgAndTotalSalary();
        partitionEmployeeByAge();
    }

    //How many male and female employees are there in the organization?
    public static Map<String,Long> countMaleFemale(){
        return employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
    }

    //Print the name of all departments in the organization?
    public static List<String> printDepartmentsName(){
        return employeeList.stream()
                .map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList());
    }

    //What is the average age of male and female employees?
    public static Map<String,Double> calcMaleFemaleAvgAge(){
        return employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getAge)));
    }

    //Get the details of highest paid employee in the organization?
    public static Employee highestPaidEmployee(){
        return employeeList.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)))
                .get();
    }

    //Get the names of all employees who have joined after 2015?
    public static List<Employee> emplListJoinedAfterDate(){
        return employeeList.stream()
                .filter(employee -> {
                    return employee.getYearOfJoining()>2015;
                }).collect(Collectors.toList());
    }

    //Count the number of employees in each department?
    public static Map<String,Long> countEmployeeInDepartments(){
        return employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
    }
    //What is the average salary of each department?
    public static Map<String,Double> avgSalaryInDepartments(){
        return employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
    }
    //Get the details of youngest male employee in the product development department?
    public static Employee youngestEmployeeInProductAndDevelopment(){
        return employeeList.stream()
                .filter(employee -> {
                    return employee.getDepartment().equalsIgnoreCase("Product Development");
                })
                .collect(Collectors.minBy(Comparator.comparing(Employee::getAge)))
                .get();
    }
    //Who has the most working experience in the organization?
    public static Employee employeeWithHighestExperience(){
        return employeeList.stream()
                .sorted(Comparator.comparing(Employee::getYearOfJoining))
                .findFirst()
                .get();
    }
    //How many male and female employees are there in the sales and marketing team?
    public static Map<String,Long> countMaleFemaleinSales(){
        return employeeList.stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase("Sales And Marketing"))
                .collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
    }
    //List down the names of all employees in each department?
    public static void listNameInEachDepartment(){
        Map<String,List<Employee>> mp= employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        Set<Map.Entry<String,List<Employee>>> entries=mp.entrySet();
        for(Map.Entry<String,List<Employee>> entry:entries){
            System.out.println(entry.getKey());
            System.out.println("-------------------------------");
            entry.getValue().stream().forEach(employee -> {
                System.out.println(employee.getName());
            });
        }
    }
    //What is the average salary and total salary of the whole organization?
    public static void calculateAvgAndTotalSalary(){
        DoubleSummaryStatistics doubleSummaryStatistics=employeeList.stream()
                        .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Average Salary:"+doubleSummaryStatistics.getAverage()+"\nTotal Salary:"+doubleSummaryStatistics.getSum());
    }
    //Separate the employees who are younger or equal to 25 years from
    //those employees who are older than 25 years.
    public static void partitionEmployeeByAge(){
        Map<Boolean,List<Employee>> partitionedMap=employeeList.stream()
                .collect(Collectors.partitioningBy(employee -> {
                    return employee.getAge() > 25;
                }));
        partitionedMap.entrySet().forEach((b)->{
            if(b.getKey()){
                System.out.println("Employee having age greater than 25:"+b.getValue());
            }else{
                System.out.println("Employee having age less than 25:"+b.getValue());
            }
        });
    }
}
