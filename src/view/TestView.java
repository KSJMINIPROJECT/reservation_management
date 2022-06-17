package view;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.CustomerDAO;
import dao.ReservationDAO;
import dao.RoomDAO;
import model.CustomerDTO;
import model.ReservationDTO;
import model.RoomDTO;
import service.ReservationServiceInterface;

public class TestView {

	public static void main(String[] args) {
		try {
//			System.out.println(CustomerDAO.allCustomers());
//			System.out.println(CustomerDAO.getCustomer("a01"));
//			System.out.println(CustomerDAO.addCustomer(new CustomerDTO("a04", 3, "김민규", "010-1234-1234")));
//			System.out.println(CustomerDAO.deleteCustomer("a04"));
//			System.out.println(CustomerDAO.updateCustomer("a01", 7, "010-3456-4352"));
//			System.out.println(ReservationDAO.allReservation());
//			System.out.println(ReservationDAO.addReservation(new ReservationDTO("a05", 12, "2022-05-31", "2022-06-01")));
//			System.out.println(RoomDAO.allRoom());
			System.out.println(RoomDAO.selectRoom(1));
//			System.out.println(RoomDAO.addRoom(new RoomDTO(10,5,"50,000","asd")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
