package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.CustomerDAO;
import model.CustomerDTO;

public class CustomerService implements CustomerServiceInterface{

	@Override
	public boolean addCustomer(CustomerDTO newCustomer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCustomer(String customerId, int headCount, String phoneNum) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCustomer(String customerId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<CustomerDTO> allCustomer() throws SQLException {
		
		return CustomerDAO.allCustomers();
	}

	@Override
	public CustomerDTO selectCustomer(String customerId) throws SQLException {
		
		return CustomerDAO.getCustomer(customerId);
	}

}
