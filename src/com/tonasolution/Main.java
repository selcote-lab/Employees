package com.tonasolution;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Employee zouhaire = new Employee("zouhaire", 29);
        Employee ali = new Employee("Ali", 28);
        Employee ahmed = new Employee("Ahmed", 31);

        List<Employee> employees = new ArrayList<>();
        employees.add(zouhaire);
        employees.add(ali);
        employees.add(ahmed);

        printEmployeesByAge(
                employees, "Print employees over 30",
                employee -> employee.getAge() > 30
        );

        printEmployeesByAge(
                employees,
                "Print employees less or equal to 30",
                employee -> employee.getAge() <= 30
        );
    }

    private static void printEmployeesByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition){
        System.out.println(ageText);
        employees.forEach(employee -> {
            if(ageCondition.test(employee)){
                System.out.println(employee.getName());
            }
        });
    }

}
