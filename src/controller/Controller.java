package controller;

import java.security.Provider.Service;
import java.sql.Date;
import java.util.ArrayList;

import model.CustomerDTO;
import model.ReservationDTO;
import model.RoomDTO;
import service.CustomerService;

public class Controller implements ControllerInterface{
	private static Controller instance = new Controller();
	
	private Controller() {}
	
	public static Controller getInstance() {
		return instance;
	}
	
	// Customer Controller
	@Override
	public void allCustomer() {
		
	}
	@Override
	public CustomerDTO selectCustomer(String customerId) {
		// TODO Auto-generated method stub
		return null;
	}

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
	public ArrayList<RoomDTO> selectEmptyRoom(Date date) {
		// TODO Auto-generated method stub
		return null;
	}



	// Room Controller
	@Override
	public ArrayList<RoomDTO> allRoom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomDTO selectRoom(int roomId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addRoom(RoomDTO newRoom) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateRoom(int roomId, String price) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteRoom(int roomId) {
		// TODO Auto-generated method stub
		return false;
	}

	
	// Reservation Controller
	@Override
	public ArrayList<ReservationDTO> allReservation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReservationDTO selectReservation(String reservationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addReservation(ReservationDTO newReservation) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateReservation(String reservationId, String startDate, String endDate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteReservation(String reservationId) {
		// TODO Auto-generated method stub
		return false;
	}

}
