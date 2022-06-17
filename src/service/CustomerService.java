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
	//고객 존재 여부 확인
	public void notExistCustomer(String customerId) throws SQLException, NotExistException {
		CustomerDTO customer = CustomerDAO.selectCustomer(customerId);
		if(customer == null) {
			throw new NotExistException("검색하신 고객 정보가 없습니다.");
		}
	}
	
	//새로운 고객 저장
	// 만약 아이디가 겹친다면?
	@Override
	public boolean addCustomer(CustomerDTO newCustomer) throws SQLException {
		return CustomerDAO.addCustomer(newCustomer);
	}
	
	//기존 고객 정보 수정
	// 만약 아이디가 없다면?
	@Override
	public boolean updateCustomer(String customerId, int headCount, String phoneNum) throws SQLException, NotExistException {
		notExistCustomer(customerId);
		return CustomerDAO.updateCustomer(customerId, headCount, phoneNum);
	}
	// 고객 정보 삭제
	// 만약 아이디가
	@Override
	public boolean deleteCustomer(String customerId) throws SQLException, NotExistException {
		notExistCustomer(customerId);
		
		return CustomerDAO.deleteCustomer(customerId);
	}
	
	//모든 고객 정보 반환
	@Override
	public ArrayList<CustomerDTO> allCustomer() throws SQLException {
		
		return CustomerDAO.allCustomers();
	}
	
	//고객 id로 고객 검색
	@Override
	public CustomerDTO selectCustomer(String customerId) throws SQLException {
		
		return CustomerDAO.selectCustomer(customerId);
	}

}
