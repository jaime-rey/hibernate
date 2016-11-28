package org.monokepos.test.model;

import javax.persistence.*;

/**
 * Represents the Customer data
 * 
 * @author Eugenia Pérez Martínez
 *
 */

@Entity
@Table( name = "CUSTOMER" )
public class Customer {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="CUSTOMER_ID")
	private int id;
	@Column(name="CUSTOMER_NAME")
	private String name;
	private String address;
	private String email;

	/**
	 * Default constructor
	 */
	public Customer() {

	}

	/**
	 * Constructor with all attributes
	 * 
	 * @param id
	 * @param name
	 * @param address
	 * @param email
	 */
	public Customer(String name, String address, String email) {
		this.name = name;
		this.address = address;
		this.email = email;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Customer [ name=" + name + ", address=" + address + ", email=" + email + "]";
	}
}
