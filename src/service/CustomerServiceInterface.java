package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.CustomerDAO;
import model.CustomerDTO;

public interface CustomerServiceInterface {
	public ArrayList<CustomerDTO> allCustomer() throws SQLException;
	public CustomerDTO selectCustomer(String customerId) throws SQLException;
	
	
	public boolean addCustomer(CustomerDTO newCustomer);
	public boolean updateCustomer(String customerId,int headCount,String phoneNum);
	public boolean deleteCustomer(String customerId);
}
