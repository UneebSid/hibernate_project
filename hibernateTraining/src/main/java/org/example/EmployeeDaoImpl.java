package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionLazyDelegator;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao
{
    private Configuration config =  new Configuration();
    private SessionFactory sessionFactory;
    private Session session;

    Transaction transaction;

    public EmployeeDaoImpl()
    {
        config.configure("hibernate.cfg.xml");
        sessionFactory = config.buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    public void addEmployee(Employee employee)
    {
        session.save(employee);

    }

    public void updateEmployee(Employee employee)
    {
        session.saveOrUpdate(employee);
    }

    public void deleteEmployee(int id)
    {
        Employee employee = session.get(Employee.class, id);
        if(employee !=null)
        {
            session.delete(employee);
        }

    }

    public Employee getEmployeeByID(int id)
    {
        return session.get(Employee.class, id);
    }

    public  List getEmployees()
    {
        Query query = session.createQuery("from Employee");
        List employees = query.getResultList();
        return employees;
    }
    public Session getSession() {
        return session;
    }

    public Transaction getTransaction() {
        return transaction;
    }
}
