package org.monokepos.test;

import java.util.List;

import org.monokepos.test.dao.CustomerDAO;
import org.monokepos.test.dao.impl.HibernateCustomerDAO;
import org.monokepos.test.model.Customer;

/**
 * Hello world!
 *
 */
public class App {

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
		System.out.println("Hello World!");

		CustomerDAO customerDAO = new HibernateCustomerDAO();
		// Insert new data
//		Customer newCustomer = new Customer("Bill Gates", "Money Street, Seattle", "bill@bills.com");
		Customer newCustomer2 = new Customer("Pepe Mora3", "Calle Betis, Sevilla", "pepe@pepe.com");
		customerDAO.insert(newCustomer2);
		System.out.println("Inserted id: " + newCustomer2.getId());

		// Select all
		showAll(customerDAO);
		
		//Select one customer
		Customer oneCustomer = customerDAO.selectById(14);
		System.out.println("\nshow the Customer with ID = 1");
		System.out.println("--- CUSTOMER ----- table contents ---------------------");
		System.out.println("Selected Name: "+oneCustomer.getName());
		
		//Update a customer
		newCustomer2.setAddress("nueva dir");
		customerDAO.update(newCustomer2);
		System.out.println("\nShow after update");
		showAll(customerDAO);
		
	}

	// private static SessionFactory factory;
	// public static void main(String[] args) {
	//
	// try{
	//
	// Configuration config = new Configuration();
	// config.configure();
	// factory = new Configuration().configure().buildSessionFactory();
	//
	// }catch (Throwable ex) {
	//
	// System.err.println("Failed to create sessionFactory object." + ex);
	// throw new ExceptionInInitializerError(ex);
	//
	// }
	//
	// App ME = new App();
	//
	//
	// System.out.println("------------------------------------");
	// ME.listEmployees();
	// System.out.println("------------------------------------");
	// /* Add few employee records in database */
	// Integer empID1 = ME.addEmployee("Zara", "Ali", 1000);
	// Integer empID2 = ME.addEmployee("Daisy", "Das", 5000);
	// ME.addEmployee("John", "Paul", 10000);
	//
	// ME.addCustomer("pesertfpe", "niebla", "pepe@pertertertpe.es");
	// ME.addCustomer("pesertfpe", "niebla", "pepe@pertertertpe.es");
	//
	// /* List down all the employees */
	// ME.listEmployees();
	//
	// /* Update employee's records */
	// ME.updateEmployee(empID1, 5000);
	//
	// /* Delete an employee from the database */
	// ME.deleteEmployee(empID2);
	//
	// /* List down new list of the employees */
	// ME.listEmployees();
	// }
	// /* Method to CREATE an employee in the database */
	// public Integer addEmployee(String fname, String lname, int salary){
	// Session session = factory.openSession();
	// Transaction tx = null;
	// Integer employeeID = null;
	// try{
	// tx = session.beginTransaction();
	// Employee employee = new Employee(fname, lname, salary);
	// employeeID = (Integer) session.save(employee);
	// tx.commit();
	// }catch (HibernateException e) {
	// if (tx!=null) tx.rollback();
	// e.printStackTrace();
	// }finally {
	// session.close();
	// }
	// return employeeID;
	// }
	//
	//
	// public Long addCustomer(String name, String address, String email) {
	// Session session = factory.openSession();
	// Transaction tx = null;
	// Long customerID = null;
	// try {
	// tx = session.beginTransaction();
	// Customer customer = new Customer(name, address, email);
	// System.out.println(customer.toString());
	// customerID = (Long) session.save(customer);
	// } catch (HibernateException e) {
	// if (tx!=null) {
	// tx.rollback();
	// }
	// e.printStackTrace();
	// } finally {
	// session.close();
	// }
	// System.out.println(customerID);
	// return customerID;
	//
	// }
	//
	// /* Method to READ all the employees */
	// public void listEmployees( ){
	// Session session = factory.openSession();
	// Transaction tx = null;
	// try{
	// tx = session.beginTransaction();
	// List<Employee> employees = session.createQuery("FROM Employee").list();
	// List<Customer> customers = session.createQuery("FROM Customer").list();
	// for (Iterator<Customer> iterator =
	// customers.iterator(); iterator.hasNext();){
	// Customer customer = (Customer) iterator.next();
	// System.out.print("Customer: " + customer.getName());
	// System.out.print(" Address: " + customer.getAddress());
	// System.out.println(" Email: " + customer.getEmail());
	// }
	// for (Iterator<Employee> iterator =
	// employees.iterator(); iterator.hasNext();){
	// Employee employee = (Employee) iterator.next();
	// System.out.print("First Name: " + employee.getFirstName());
	// System.out.print(" Last Name: " + employee.getLastName());
	// System.out.println(" Salary: " + employee.getSalary());
	// }
	// tx.commit();
	// }catch (HibernateException e) {
	// if (tx!=null) tx.rollback();
	// e.printStackTrace();
	// }finally {
	// session.close();
	// }
	// }
	// /* Method to UPDATE salary for an employee */
	// public void updateEmployee(Integer EmployeeID, int salary ){
	// Session session = factory.openSession();
	// Transaction tx = null;
	// try{
	// tx = session.beginTransaction();
	// Employee employee =
	// (Employee)session.get(Employee.class, EmployeeID);
	// employee.setSalary( salary );
	// session.update(employee);
	// tx.commit();
	// }catch (HibernateException e) {
	// if (tx!=null) tx.rollback();
	// e.printStackTrace();
	// }finally {
	// session.close();
	// }
	// }
	// /* Method to DELETE an employee from the records */
	// public void deleteEmployee(Integer EmployeeID){
	// Session session = factory.openSession();
	// Transaction tx = null;
	// try{
	// tx = session.beginTransaction();
	// Employee employee =
	// (Employee)session.get(Employee.class, EmployeeID);
	// session.delete(employee);
	// tx.commit();
	// }catch (HibernateException e) {
	// if (tx!=null) tx.rollback();
	// e.printStackTrace();
	// }finally {
	// session.close();
	// }
	// }
}
