package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class HomeWork {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {			
			// create a student object
			System.out.println("Creating new Employee object...");

			Employee tempStudent = new Employee("Lera", "Menko", "Priorbank");
								
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + 1);
			
			Employee myEmployee = session.get(Employee.class, 1);
			
			System.out.println("Get complete: " + myEmployee);
			
			// commit the transaction
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			List<Employee> theEmployee = session.createQuery("from Employee s where s.company='Priorbank'").getResultList();
			displayStudents(theEmployee);
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();	
			
			session.createQuery("delete from Employee where id=6").executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}	
	}
	
	private static void displayStudents(List<Employee> theEmployee) {
		for (Employee tempEmployee : theEmployee) {
			System.out.println(tempEmployee);
		}
	}
}
