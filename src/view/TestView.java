package view;

import java.sql.SQLException;

import dao.CustomerDAO;
import dao.ReservationDAO;
import dao.RoomDAO;
import model.CustomerDTO;
import model.RoomDTO;

public class TestView {

	public static void main(String[] args) {
		try {
			System.out.println(CustomerDAO.allCustomers());
//			System.out.println(CustomerDAO.getCustomer("a01"));
//			System.out.println(CustomerDAO.addCustomer(new CustomerDTO("a04", 3, "김민규", "010-1234-1234")));
//			System.out.println(CustomerDAO.deleteCustomer("a04"));
//			System.out.println(CustomerDAO.updateCustomer("a01", 7, "010-3456-4352"));
//			System.out.println(ReservationDAO.allReservation());
//			System.out.println(RoomDAO.allRoom());
//			System.out.println(RoomDAO.selectRoom(7));
//			System.out.println(RoomDAO.addRoom(new RoomDTO(7,5,"70,000","울산")));
//			System.out.println(RoomDAO.updateRoom(7, "10,000"));
//			System.out.println(RoomDAO.deleteRoom(7));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
