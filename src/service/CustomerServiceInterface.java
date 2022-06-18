package service;

import java.sql.SQLException;
import java.util.ArrayList;

import exception.NotExistException;
import model.CustomerDTO;

public interface CustomerServiceInterface {
	public ArrayList<CustomerDTO> allCustomer() throws SQLException;
	public CustomerDTO selectCustomer(String customerId) throws SQLException, NotExistException;
	
	
	public boolean addCustomer(CustomerDTO newCustomer) throws SQLException, NotExistException;
	public boolean updateCustomer(String customerId,int headCount,String phoneNum) throws SQLException, NotExistException;
	public boolean deleteCustomer(String customerId) throws SQLException, NotExistException;
}
