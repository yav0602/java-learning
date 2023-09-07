package com.yavdev.section13.Employees;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public record Company(List<Employee> employees) {

    public void displayEmployees() {
        class EmployeeInfo {
            final private String fullName;
            final private int yearsWorked;

            EmployeeInfo(Employee employee) {
                final int currentYear = LocalDate.now().getYear();

                this.fullName = employee.firstName() + ' ' + employee.lastName();
                this.yearsWorked = currentYear - employee.hireDate();
            }

            @Override
            public String toString() {
                return String.format("%s, %d", this.fullName, this.yearsWorked);
            }
        }
        class EmployeeInfoComparator {
            private static Comparator<EmployeeInfo> byFullName() {
                return Comparator.comparing(o -> o.fullName);
            }

            private static Comparator<EmployeeInfo> byYearsWorked() {
                return Comparator.comparingInt(o -> o.yearsWorked);
            }
        }

        final List<EmployeeInfo> employeeInfoList = new ArrayList<>();

        for (var employee : this.employees) {
            employeeInfoList.add(new EmployeeInfo(employee));
        }

        employeeInfoList.sort(EmployeeInfoComparator.byFullName());
        System.out.println(employeeInfoList);

        employeeInfoList.sort(EmployeeInfoComparator.byYearsWorked());
        System.out.println(employeeInfoList);
    }
}
