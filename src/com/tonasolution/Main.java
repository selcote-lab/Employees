package com.tonasolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        Employee zouhaire = new Employee("zouhaire EL AKIOUI", 29);
        Employee ali = new Employee("Ali kara", 28);
        Employee ahmed = new Employee("Ahmed nano", 31);

        List<Employee> employees = new ArrayList<>();
        employees.add(zouhaire);
        employees.add(ali);
        employees.add(ahmed);

        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(" ") + 1);
        };

        String lastName = getLastName.apply(zouhaire);
        System.out.println(lastName);

        Function<Employee, String> getFirstName = (Employee employee) -> {
          return employee.getName().substring(0, employee.getName().indexOf(" "));
        };

//        String firstName = getFirstName.apply(employees.get(1));
//        System.out.println(firstName);

        Random random1 = new Random();
        for(Employee employee: employees){
            if(random1.nextBoolean()){
                System.out.println(getName(getLastName, employee));
            } else {
                System.out.println(getName(getFirstName, employee));
            }
        }

        Function<Employee, String> upperCase = (Employee employee) -> employee.getName().toUpperCase();
        Function<String, String> firstName =  name -> name.substring(0, name.indexOf(' '));
        Function chainedFunction = upperCase.andThen(firstName);
        System.out.println(chainedFunction.apply(zouhaire));

        BiFunction<String, Employee, String> conactAge = (String name, Employee employee) -> {
            return name.concat(" " + employee.getAge());
        };
        System.out.println("Contactenation " + conactAge.apply("zouhaire", employees.get(0)));

    }

    private static String getName(Function<Employee, String> getName, Employee employee){
        return getName.apply(employee);
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
