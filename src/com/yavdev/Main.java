package com.yavdev;

import com.yavdev.section13.Employees.Company;
import com.yavdev.section13.Employees.Employee;

import java.util.List;

public class Main {

    public static void main(String[] args) {
       var company = new Company(List.of(
               new Employee("Artur",  "Yerokhin", 2021),
               new Employee("Oleksii",  "Bezborod'ko", 2018),
               new Employee("Kirill",  "Kowalchuck", 2022),
               new Employee("Nikolay",  "Semchak", 2023)
       ));

       company.displayEmployees();

    }
}
