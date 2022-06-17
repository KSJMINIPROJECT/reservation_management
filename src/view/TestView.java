package view;

import java.sql.SQLException;

import dao.CustomerDAO;
import dao.ReservationDAO;
import dao.RoomDAO;
import model.CustomerDTO;

public class TestView {

	public static void main(String[] args) {
		try {
			System.out.println(CustomerDAO.allCustomers());
//			System.out.println(CustomerDAO.getCustomer("a01"));
//			System.out.println(CustomerDAO.addCustomer(new CustomerDTO("a04", 3, "김민규", "010-1234-1234")));
//			System.out.println(CustomerDAO.deleteCustomer("a04"));
//			System.out.println(CustomerDAO.updateCustomer("a01", 7, "010-3456-4352"));
			System.out.println(ReservationDAO.allReservation());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
