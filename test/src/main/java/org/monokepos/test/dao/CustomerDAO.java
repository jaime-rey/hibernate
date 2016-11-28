package org.monokepos.test.dao;

import java.util.List;

import org.monokepos.test.model.Customer;

/**
 * CustomerDAO interface
 * 
 * @author Eugenia Pérez Martínez
 *
 */
public interface CustomerDAO {

	public Customer selectById(int id);

	public List<Customer> selectAll();

	public void insert(Customer customer);

	public void update(Customer customer);

	public void delete(Customer customer);

}
