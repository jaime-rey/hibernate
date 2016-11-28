package org.sistema.test.annotations;

import java.util.List;

import org.sistema.test.annotations.dao.CustomerDAO;
import org.sistema.test.annotations.dao.impl.HibernateCustomerDAO;
import org.sistema.test.annotations.model.Customer;

public class Main {

	/**
	 * App entry point.
	 * 
	 * @param customerDAO
	 */
	public static void showAll(CustomerDAO customerDAO) {
		List<Customer> customers = customerDAO.selectAll();
		System.out.println("--- CUSTOMER ----- table contents	-----------");
		for (Customer customer : customers) {
			System.out.println("Id: " + customer.getId());
			System.out.println(" - Name: " + customer.getName());
			System.out.println(" - Address: " + customer.getAddress());
		}
		System.out.println("Total Customers: " + customers.size());
	}

	public static void main(String[] args) {
		CustomerDAO customerDAO = new HibernateCustomerDAO();
		//Select all
		showAll(customerDAO);

		// Insert new data
		Customer newCustomer = new Customer("Bill Gates", "Money Street, Seattle",
				"bill@bills.com");
		customerDAO.insert(newCustomer);
		System.out.println("Inserted id: " + newCustomer.getId());
		newCustomer = new Customer("Steve Jobs", "Vegan Street, Palo Alto",
				"isteve@apple.com");
		customerDAO.insert(newCustomer);
		System.out.println("Inserted id: " + newCustomer.getId());		
		System.out.println("\nShow data after new insert");
		showAll(customerDAO);
		
		// Select just one
		Customer oneCustomer = customerDAO.selectById(Long.valueOf(1));
		System.out.println("\nShow the customer with ID=1");
		System.out.println("--- CUSTOMER ----- table contents	-----------");
		System.out.println("Selected Name: " + oneCustomer.getName());

		// Update a customer
		newCustomer.setAddress("Buggy software Street, Illinois");
		customerDAO.update(newCustomer);
		System.out.println("\nShow data after update");
		showAll(customerDAO);

		// Delete one customer
		customerDAO.delete(newCustomer);
		System.out.println("\nShow data after deletion");
		showAll(customerDAO);
	}
}
