package cpe121.karlvince.exam1;

import static kaviyes.lib.Std.clear;
import static kaviyes.lib.Std.drawLine;
import static kaviyes.lib.Std.newl;
import static kaviyes.lib.Std.print;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static int LINE = 50;
    public static void main(String[] args) throws IOException {
        String choice;
        boolean isRunning = true;
        boolean isRunningChild = false;
        Employee FullTimeEmployee = new Employee("CEO Jameson", 1, 50000);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        do {
        clear();
        print("HR Control Lite"); newl();
        drawLine(LINE, '-'); newl();
        
        print("[1] Register an Employee"); newl();
        print("[2] Get detailed report"); newl();
        print("[3] Exit"); newl(2);  

        print("> "); choice = in.readLine();

        try {
            if (Integer.parseInt(choice) == 3) {isRunning = false;}

            else if (Integer.parseInt(choice) == 1) {
                isRunningChild = true;
                clear();
                print("HR Control Lite - Register"); newl();
                drawLine(LINE, '-'); newl();
                print("/b to stop the registration"); newl(2);

                do {
                    print("Employee Name: ");
                    String name = in.readLine();
                    if (name.contains("/b")) {isRunningChild = false; break;}

                    print("Employee ID: ");
                    String idStr = in.readLine();
                    if (idStr.contains("/b")) {isRunningChild = false; break;}

                    print("Employee Salary: ");
                    String salaryStr = in.readLine();
                    if (salaryStr.contains("/b")) {isRunningChild = false; break;}

                    try {
                        int id = Integer.parseInt(idStr);
                        double salary = Double.parseDouble(salaryStr);
                        FullTimeEmployee.addEmployee(name, id, salary);
                        isRunningChild = false;
                        print("Employee registered"); newl();
                    } catch (NumberFormatException e) {
                        print("Invalid input."); newl();
                    }
                } while (isRunningChild);
                print("Returning to main menu..."); newl();
            }
            else if (Integer.parseInt(choice) == 2) {
                clear();
                print("HR Control Lite - Detailed Report"); newl();
                drawLine(LINE, '-'); newl();
                newl();
                print("Total payroll        : %.2f", FullTimeEmployee.getTotalPayroll()); newl();
                print("Average salary       : %.2f", FullTimeEmployee.getAverageSalary()); newl();
                print("Highest salary       : %.2f", FullTimeEmployee.getHighestSalary()); newl();
                print("Number of Employees  : %d", FullTimeEmployee.getEmployeeCount()); newl();
                print("Press Enter to return");
                in.readLine();
            }

        } catch (NumberFormatException e) {
            // ignore
        }
        
        } while (isRunning);

        in.close();

    }
}
