package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.CustomerDAO;
import exception.NotExistException;
import model.CustomerDTO;

public class CustomerService implements CustomerServiceInterface{
	private static CustomerService instance = new CustomerService();
	
	private CustomerService() {}
	
	public static CustomerService getInstance() {
		return instance;
	}
	CustomerService customer = CustomerService.getInstance();
	
	//새로운 고객 저장
	@Override
	public boolean addCustomer(CustomerDTO newCustomer) throws SQLException{
		return CustomerDAO.addCustomer(newCustomer);
	}
	
	//기존 고객 정보 수정

	@Override
	public boolean updateCustomer(String customerId, int headCount, String phoneNum) throws SQLException{
		return CustomerDAO.updateCustomer(customerId, headCount, phoneNum);
	}

	@Override
	public boolean deleteCustomer(String customerId) throws SQLException, NotExistException {
		selectCustomer(customerId);
		return CustomerDAO.deleteCustomer(customerId);
	}
	//모든 고객 정보 반환
	//(만약 고객이 한명도 없다면?)
	@Override
	public ArrayList<CustomerDTO> allCustomer() throws SQLException {
		
		return CustomerDAO.allCustomers();
	}
	
	//고객 id로 고객 검색
	@Override
	public CustomerDTO selectCustomer(String customerId) throws SQLException, NotExistException {
		CustomerDTO customer=CustomerDAO.selectCustomer(customerId);
	      if(customer == null) {
	         throw new NotExistException("존재하지 않는 고객입니다.");
	      }
	      return customer;
	  }
	public void existCustomer(String customerId) throws SQLException, NotExistException {
		CustomerDTO customer=CustomerDAO.selectCustomer(customerId);
	      if(customer != null) {
	         throw new NotExistException("이미 존재하는 고객입니다.");
	      }
	  }
		
	

}
