package app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import app.entity.Employee;
import app.hibernate.HibernateUtil;

public class EmployeeDAO {
	public void saveEmployee(Employee emp) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(emp);
		transaction.commit();
	}
	
	public void updateEmployee(Employee emp) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(emp);
		transaction.commit();
	}
	
	public List<Employee> getEmpList(){
		List<Employee> emplist = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		emplist = session.createQuery("from Employee").getResultList();
		transaction.commit();
		return emplist;
	}
	
	public Employee getEmployee(String id) {
		Employee emp = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		emp = session.get(Employee.class, id);
		transaction.commit();
		return emp;
	}
	
	public void deleteEmployee(String id) {
		Employee emp = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		emp = session.get(Employee.class, id);
		if(emp != null) {
			session.delete(emp);
		}
		transaction.commit();
	}
}
