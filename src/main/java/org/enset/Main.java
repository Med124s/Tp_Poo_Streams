package org.enset;

import org.enset.Ex2.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John Doe", "IT", 50000));
        employees.add(new Employee("Jane Smith", "HR", 60000));
        employees.add(new Employee("Alice Johnson", "Finance", 70000));

        // 1. Calculer la somme totale des salaires
        double totalSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println("Somme totale des salaires : " + totalSalary);

        // 2. Trier la liste des employés par ordre alphabétique du nom
        employees.sort(Comparator.comparing(Employee::getName));
        System.out.println("Liste des employés triée par nom : ");
        employees.forEach(employee -> System.out.println(employee.getName()));

        // 3. Trouver l'employé avec le salaire le plus bas
        Optional<Employee> minSalaryEmployee = employees.stream()
                .min(Comparator.comparing(Employee::getSalary));
        minSalaryEmployee.ifPresent(employee ->
                System.out.println("Employé avec le salaire le plus bas : " + employee.getName()));

        // 4. Obtenir la liste des employés ayant un salaire supérieur à une valeur donnée
        double thresholdSalary = 55000;
        List<Employee> highSalaryEmployees = employees.stream()
                .filter(employee -> employee.getSalary() > thresholdSalary)
                .toList();
        System.out.println("Liste des employés ayant un salaire supérieur à " + thresholdSalary + " : ");
        highSalaryEmployees.forEach(employee -> System.out.println(employee.getName()));

        // 5. Trouver l'employé avec le salaire le plus élevé
        Optional<Employee> maxSalaryEmployee = employees.stream()
                .reduce((employee1, employee2) ->
                        employee1.getSalary() > employee2.getSalary() ? employee1 : employee2);
        maxSalaryEmployee.ifPresent(employee ->
                System.out.println("Employé avec le salaire le plus élevé : " + employee.getName()));

        // 6. Concaténer les noms de tous les employés
        String concatenatedNames = employees.stream()
                .map(Employee::getName)
                .reduce((name1, name2) -> name1 + ", " + name2)
                .orElse("");
        System.out.println("Noms de tous les employés : " + concatenatedNames);
    }
}