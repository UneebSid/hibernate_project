package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        while (flag)
        {
            System.out.println("******************************");
            System.out.println("Select from the options below");
            System.out.println("******************************");
            System.out.println("Press 1: Add Employee");
            System.out.println("Press 2: Update Employee");
            System.out.println("Press 3: Delete Employee");
            System.out.println("Press 4: Get Employee by id");
            System.out.println("Press 5: Get employees");
            System.out.println("Press 5: Exit");

            int input = scanner.nextInt();


            switch (input)
            {
                case 1://add employee
                    System.out.println("Enter name:");
                    String name = scanner.next();
                    System.out.println("Enter email:");
                    String email = scanner.next();
                    System.out.println("Enter Id: ");
                    int id = scanner.nextInt();

                    Employee employee = new Employee();
                    employee.setName(name);
                    employee.setEmail(email);
                    employee.setId(id);
                    employeeDao.addEmployee(employee);
                    break;

                case 2:
                    Employee employee1;
                    System.out.println("please provide id of record you wish to update");
                    int id1 = scanner.nextInt();
                    employee1 = employeeDao.getEmployeeByID(id1);
                    System.out.println("Please enter updated name:");
                    String updatedName = scanner.next();
                    System.out.println("Please Enter updated email:");
                    String updatedEmail = scanner.next();
                    employee1.setEmail(updatedEmail);
                    employee1.setName(updatedName);
                    employeeDao.updateEmployee(employee1);
                    break;

                case 3:
                    System.out.println("Please provide id of the record you wish to delete:");
                    int idDelete = scanner.nextInt();
                    employeeDao.deleteEmployee(idDelete);
                    break;

                case 4:
                    System.out.println("Please type Id number of the record you wish to see: ");
                    int idNum = scanner.nextInt();
                    System.out.println(employeeDao.getEmployeeByID(idNum));
                    break;

                case 5:
                    System.out.println(employeeDao.getEmployees());
                    break;


                case 6:
                    System.out.println("Thank you!");
                    System.out.println("Exiting...");
                    employeeDao.getTransaction().commit();
                    employeeDao.getSession().close();
                    flag = false;
                    break;

                default:
                    System.out.println("Please Choose between 1 - 6");
            }
        }


    }
}
