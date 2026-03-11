package org.example;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class ProgramsWithStream {


    public static void main(String[] args) {
        ArrayList<Employee> employees = createEmployeeList();

        System.out.println("Write a program to print employee details working in each department");
        Map<String, List<Employee>> empByDept = employees.stream().collect(groupingBy(Employee::getDepartment, toList()));
        System.out.println(empByDept);
        System.out.println();

        System.out.println("Write a program to print employee name working in each department");
        Map<String, List<String>> empNameByDept = employees.stream().collect(groupingBy(
                Employee::getDepartment,
                mapping(Employee::getName, toList())
        ));
        System.out.println(empNameByDept);
        System.out.println();


        System.out.println("Write a program to print employees count working in each department");
        Map<String, Long> empCountByDept = employees.stream().collect(groupingBy(
                Employee::getDepartment,
                counting()
        ));
        System.out.println(empCountByDept);
        System.out.println();


        System.out.println("Write a program to print active and inactive employees in the given collection");
        Map<Boolean, List<String>> empNameByActive = employees.stream().collect(groupingBy(
                Employee::getActive,
                mapping(Employee::getName, toList())
        ));
        empNameByActive.forEach((key, value) -> {
            if (key == true)
                System.out.println("Active Employees : " + value);
            else
                System.out.println("Inactive Employees: " + value);
        });
        System.out.println();


        System.out.println("Write a program to print Max/Min employee salary from the given collection");
        Optional<Employee> maxSalaryEmp = employees.stream().max(Comparator.comparing(Employee::getSalary));
        Optional<Employee> minSalaryEmp = employees.stream().min(Comparator.comparing(Employee::getSalary));
        System.out.println("Max Salary Emp: "+ maxSalaryEmp.get().getName());
        System.out.println("Min Salary Emp: "+ minSalaryEmp.get().getName());
        System.out.println();


        System.out.println("Write a program to print Max/Min active employee salary from the given collection");
        String maxSalaryEmpName = employees.stream()
                .filter(Employee::getActive)
                .max(Comparator.comparing(Employee::getSalary))
                .get().getName();
        String minSalaryEmpName = employees.stream()
                .filter(Employee::getActive)
                .min(Comparator.comparing(Employee::getSalary))
                .get().getName();
        System.out.println();

//        System.out.println("Write a program to print Max/Min active employee salary - name from the given collection");


        System.out.println("Write a program to print the max salary of an employee from each department");
        Map<String, Optional<Long>> maxSalaryByDept = employees.stream().collect(groupingBy(
                Employee::getDepartment,
                mapping(Employee::getSalary, maxBy(Comparator.naturalOrder()))
        ));
        System.out.println(maxSalaryByDept);
        System.out.println();

        System.out.println("Write a program to print the avg salary of employees");
        Double avgSalary = employees.stream().collect(averagingDouble(Employee::getSalary));
        System.out.println(avgSalary);
        System.out.println();

        System.out.println("Write a program to print the avg salary of employees by dept");
        Map<String, Double> avgSalaryByDept = employees.stream().collect(groupingBy(
                Employee::getDepartment,
                averagingDouble(Employee::getSalary)
        ));
        System.out.println(avgSalaryByDept);
        System.out.println();


        System.out.println("Write a program to print names of all employees having salary more than 15k");
        List<String> empSalaryGt15k = employees.stream()
                .filter(e -> e.getSalary() > 15000L)
                .map(Employee::getName)
                .collect(toList());
        System.out.println(empSalaryGt15k);
        System.out.println();


        System.out.println("Write a program to print male and female employees count");
        Map<String, Long> empCountByGender = employees.stream().collect(groupingBy(
                Employee::getGender,
                counting()
        ));
        System.out.println(empCountByGender);
        System.out.println();


        System.out.println("Write a program to print male and female employees names");
        Map<String, List<String>> empNameByGender = employees.stream().collect(groupingBy(
                Employee::getGender,
                mapping(Employee::getName, toList())
        ));
        System.out.println(empNameByGender);
        System.out.println();

        System.out.println("Write a program to print male/female with highest salary");
        employees.stream().collect(groupingBy(
                        Employee::getGender, Collectors.toList()))
                .forEach((key, value) -> System.out.println("Max Salaried " + key + " is : " +
                        value.stream().max(Comparator.comparingLong(Employee::getSalary))
                                .map(Employee::getName).get()));



    }

    private static ArrayList<Employee> createEmployeeList() {

        ArrayList<Employee> emp = new ArrayList<>();
        emp.add(Employee.builder().id(1).name("Tom").department("Dev").active(true).salary(10000L).gender("male").build());
        emp.add(Employee.builder().id(2).name("Jim").department("HR").active(true).salary(20000L).gender("male").build());
        emp.add(Employee.builder().id(3).name("Jack").department("Dev").active(true).salary(15000L).gender("male").build());
        emp.add(Employee.builder().id(4).name("Rosie").department("Ops").active(false).salary(30000L).gender("female").build());
        emp.add(Employee.builder().id(5).name("Alice").department("Ops").active(true).salary(25000L).gender("female").build());
        emp.add(Employee.builder().id(6).name("Tim").department("Dev").active(false).salary(5000L).gender("male").build());
        emp.add(Employee.builder().id(7).name("Kenan").department("HR").active(false).salary(35000L).gender("male").build());
        emp.add(Employee.builder().id(8).name("Alice").department("HR").active(false).salary(28000L).gender("female").build());

        return emp;
    }
}
