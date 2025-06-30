package cpe121.karlvince.exam1;

import static kaviyes.lib.Std.*;

public class Employee {
    private static final int MAX_EMPLOYEES = 999;
    private String[] employeeName = new String[MAX_EMPLOYEES];
    private int[] employeeID = new int[MAX_EMPLOYEES];
    private double[] employeeSalary = new double[MAX_EMPLOYEES];
    private int count = 0; // note to self; tracker to reduce error yawa

    public Employee(String name, int id, double salary) {
        addEmployee(name, id, salary);
    }

    public void addEmployee(String name, int id, double salarary) {
        if (count < MAX_EMPLOYEES) {
            employeeName[count] = name;
            employeeID[count] = id;
            employeeSalary[count] = salarary;
            count++;
        }
    }

    public void displayAll() { // debug onoly
        for (int i = 0; i < count; i++) {
            print("Employee ID      : %d",employeeID[i]); newl();
            print("Employee Name    : %s",employeeName[i]); newl();
            print("Employee Salary  : %.2f",employeeSalary[i]); newl();
        }
    }

    public String getName(int index) {
        if (index >= 0 && index < count) {
            return employeeName[index];
        }
        return null;
    }

    public int getIdString(int index) {
        if (index >= 0 && index < count) {
            return employeeID[index];
        }
        return -1;
    }

    public int calculateSalary() {
        return 0;
    }

    public double getTotalPayroll() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += employeeSalary[i];
        }
        return total;
    }

    public double getAverageSalary() {
        if (count == 0) return 0;
        return getTotalPayroll() / count;
    }

    public String getHighestSalaryName() {
            if (count == 0) return "N/A";
            String name = employeeName[0];
            double max = employeeSalary[0];
            for (int i = 1; i < count; i++) {
                if (employeeSalary[i] > max) {
                    max = employeeSalary[i];
                    name = employeeName[i];
                };
            }

            return name;
        }

    public double getHighestSalary() {
        if (count == 0) return 0;
        double max = employeeSalary[0];
        for (int i = 1; i < count; i++) {
            if (employeeSalary[i] > max) max = employeeSalary[i];
        }
        return max;
    }

    public int getEmployeeCount() {
        return count;
    }
}
