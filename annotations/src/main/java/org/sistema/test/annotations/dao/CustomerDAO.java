package org.sistema.test.annotations.dao;

import java.util.List;

import org.sistema.test.annotations.model.Customer;

/**
 * CustomerDAO interface
 * 
 * @author Eugenia Pérez Martínez
 *
 */
public interface CustomerDAO {

	public Customer selectById(Long id);

	public List<Customer> selectAll();

	public void insert(Customer customer);

	public void update(Customer customer);

	public void delete(Customer customer);

}
