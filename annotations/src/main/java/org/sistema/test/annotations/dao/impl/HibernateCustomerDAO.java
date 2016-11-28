package org.sistema.test.annotations.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.sistema.test.annotations.HibernateSession;
import org.sistema.test.annotations.dao.CustomerDAO;
import org.sistema.test.annotations.model.Customer;

/**
 * Hibernate specific Customer DAO
 * 
 * @author Eugenia Pérez Martínez
 *
 */
public class HibernateCustomerDAO implements CustomerDAO {
	/*
	 * selects one customer by Id
	 * 
	 * @param id
	 * 
	 * @return Customer
	 */
	public Customer selectById(Long id) {
		// SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		// Session session = sessionFactory.openSession();
		Session session = HibernateSession.getSession();
		Customer customer = session.get(Customer.class, id);
		session.close();
		return customer;
	}

	/*
	 * retrieves all customers from db
	 * 
	 * @return List of customers
	 */

	public List<Customer> selectAll() {
		// SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		// Session session = sessionFactory.openSession();

		Session session = HibernateSession.getSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Customer> criteria = builder.createQuery(Customer.class);
		Root<Customer> c = criteria.from(Customer.class);
		criteria.select(c);
		
		TypedQuery<Customer> query = session.createQuery(criteria);
		List<Customer> results = query.getResultList();

//		List<Customer> customers = session.createCriteria(Customer.class).list();
		
		session.close();
		return results;
	}

	/*
	 * inserts a new customer in database retrieves generated id and sets to
	 * customer instance
	 * 
	 * @param new customer
	 */
	public void insert(Customer customer) {
		// SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		// Session session = sessionFactory.openSession();

		Session session = HibernateSession.getSession();
		session.beginTransaction();
		Long id = (Long) session.save(customer);
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
		// SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		// Session session = sessionFactory.openSession();

		Session session = HibernateSession.getSession();
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
		// SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		// Session session = sessionFactory.openSession();

		Session session = HibernateSession.getSession();
		session.beginTransaction();
		session.delete(customer);
		session.getTransaction().commit();
		session.close();
	}
}
