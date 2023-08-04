package com.yavdev.section13.Employees;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Company {
    final private List<Employee> employees;

    public Company(List<Employee> employees) {
        this.employees = employees;
    }

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
                return new Comparator<EmployeeInfo>() {
                    @Override
                    public int compare(EmployeeInfo o1, EmployeeInfo o2) {
                        return o1.fullName.compareTo(o2.fullName);
                    }
                };
            }

            private static Comparator<EmployeeInfo> byYearsWorked() {
                return new Comparator<EmployeeInfo>() {
                    @Override
                    public int compare(EmployeeInfo o1, EmployeeInfo o2) {
                        return o1.yearsWorked - o2.yearsWorked;
                    }
                };
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
