package org.monokepos.test.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.monokepos.test.HibernateSession;
import org.monokepos.test.dao.CustomerDAO;
import org.monokepos.test.model.Customer;

/**
 * Hibernate specific Customer DAO
 * 
 * @author Eugenia Pérez Martínez
 *
 */
public class HibernateCustomerDAO implements CustomerDAO {

//	private static SessionFactory factory;

	/*
	 * selects one customer by Id
	 * 
	 * @param id
	 * 
	 * @return Customer
	 */
	public Customer selectById(int id) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		Customer customer = (Customer) session.get(Customer.class, id);
		session.close();
		return customer;
	}

	/*
	 * retrieves all customers from db
	 * 
	 * @return List of customers
	 * 
	 */
	
	public static <T> List<Customer> castList(Class<? extends T> clazz, Collection<?> c) {
	    List<Customer> r = (List<Customer>) new ArrayList<Customer>(c.size());
	    for(Object o: c)
	      r.add((Customer) clazz.cast(o));
	    return r;
	}
	
	
	
	public List<Customer> selectAll() {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		List<Customer> customers = castList(Customer.class, session.createCriteria(Customer.class).list());
		
		session.close();
		return customers;
	}

	/*
	 * inserts a new customer in database retrieves generated id and sets to
	 * customer instance
	 * 
	 * @param new customer
	 */
	public void insert(Customer customer) {

		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		int id = (int) session.save(customer);
		customer.setId(id);
		session.getTransaction().commit();
		session.close();
	}

	/*
	 * updates customer
	 * 
	 * @param customer to update
	 */
	public void update(Customer customer) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.merge(customer);
		session.getTransaction().commit();
		session.close();
	}

	/*
	 * delete given customer
	 * 
	 * @param customer to delete
	 */
	public void delete(Customer customer) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(customer);
		session.getTransaction().commit();
		session.close();
	}
}
