package org.example;

import java.util.List;

public interface EmployeeDao
{
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
   void deleteEmployee(int id);
    Employee getEmployeeByID(int id);
    List getEmployees();
}
