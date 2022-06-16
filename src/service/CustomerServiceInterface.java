package service;

import java.util.ArrayList;

import model.CustomerDTO;

public interface CustomerServiceInterface {
	public ArrayList<CustomerDTO> allCustomer();
	public CustomerDTO selectCustomer(String customerId);
	public boolean addCustomer(CustomerDTO newCustomer);
	public boolean updateCustomer(String customerId,int headCount,String phoneNum);
	public boolean deleteCustomer(String customerId);
}
