package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.CustomerDTO;
import utill.DBUtil;

public class CustomerDAO {
	//숙박 고객 추가
	public static boolean addCustomer(CustomerDTO customer) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into customer values(?,?,?,?)");
			pstmt.setString(1, customer.getCustomerId());
			pstmt.setInt(2, customer.getHeadCount());
			pstmt.setString(3, customer.getCustomerName());
			pstmt.setString(4, customer.getPhoneNumber());
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	//고객id로 정보 수정
	
	public static boolean updateCustomer(String customerId,int headCount,String phoneNum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("update customer set head_count =?, phone_number = ? where customer_id=? ");
			pstmt.setInt(1, headCount);
			pstmt.setNString(2, phoneNum);
			pstmt.setString(3, customerId);
			
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
			
		} finally {
			DBUtil.close(con, pstmt);
		}
		
		return false;
		
	}
	
	//고객 id로 정보 삭제
	public static boolean deleteCustomer(String customerId) throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from customer where customer_id=?");
			pstmt.setString(1, customerId);
			
			int result = pstmt.executeUpdate();
			if(result == 1) {
				return true;
			}
		} finally{
			DBUtil.close(con, pstmt);
		}
		
		return false;
		
	}
	
	
	//모든 고객 검색
	public static ArrayList<CustomerDTO> allCustomers() throws SQLException{
		Connection con= null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CustomerDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from customer");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<CustomerDTO>();
			while(rset.next()) {
				list.add(new CustomerDTO(rset.getString(1), rset.getInt(2), rset.getString(3), rset.getString(4)));
			}
		}
		finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
		}
	
	
	//id로 해당 고객의 모든 정보 반환
	public static CustomerDTO selectCustomer(String customerId) throws SQLException {
		Connection con= null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		CustomerDTO Customer = null;
		
		try {
			
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from customer where customer_id=?");
			pstmt.setString(1, customerId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				Customer = new CustomerDTO(rset.getString(1), rset.getInt(2), rset.getString(3), rset.getString(4));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		
		
		
		
		return Customer;
		
	}

	
}

