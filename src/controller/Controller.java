package controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import exception.NotExistException;
import model.CustomerDTO;
import model.ReservationDTO;
import model.RoomDTO;
import service.CustomerService;
import service.ReservationService;
import service.RoomService;
import view.EndView;

public class Controller implements ControllerInterface{
	private static Controller instance = new Controller();
	private CustomerService customer = CustomerService.getInstance();
	private RoomService room = RoomService.getInstance();
//	private ReservationService reservation = ReservationService.getInstance();
	
	private Controller() {}
	
	public static Controller getInstance() {
		return instance;
	}
	
	// Customer Controller
	@Override
	public void allCustomer() {
		try {
			EndView.printAllData(customer.allCustomer());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void selectCustomer(String customerId) {
		try {
			EndView.printOne(customer.selectCustomer(customerId));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addCustomer(CustomerDTO newCustomer) {
		try {
			customer.addCustomer(newCustomer);
			EndView.Success("추가 성공!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void updateCustomer(String customerId, int headCount, String phoneNum) {
		try {
			customer.updateCustomer(customerId, headCount, phoneNum);
			EndView.Success("업데이트 성공!");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NotExistException e) {
			EndView.failView(e.getMessage());
		}
	}
	@Override
	public void deleteCustomer(String customerId) {
		try {
			customer.deleteCustomer(customerId);
			EndView.Success("삭제 성공!");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NotExistException e) {
			EndView.failView(e.getMessage());
		}
	}

	// Room Controller
	@Override
	public void allRoom() {
		try {
			EndView.printAllData(room.allRoom());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void selectRoom(int roomId) {
		try {
			EndView.printOne(room.selectRoom(roomId));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addRoom(RoomDTO newRoom) {
		try {
			room.addRoom(newRoom);
			EndView.Success("추가 성공!");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NotExistException e) {
			EndView.failView(e.getMessage());
		}
	}

	@Override
	public void updateRoom(int roomId, String price) {
		try {
			room.updateRoom(roomId, price);
			EndView.Success("업데이트 성공!");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NotExistException e) {
			EndView.failView(e.getMessage());
		}
	}

	@Override
	public void deleteRoom(int roomId) {
		try {
			room.deleteRoom(roomId);
			EndView.Success("삭제 성공!");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NotExistException e) {
			EndView.failView(e.getMessage());
		}
		
	}
	@Override
	//빈방 조회 잠시 보류
	public ArrayList<RoomDTO> selectEmptyRoom(Date date) {
		return null;
	}

	
	// Reservation Controller
	@Override
	public void allReservation() {
//		try {
//			EndView.printAllData(reservation.allReservation());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}

	@Override
	public void selectReservation(int reservationId) {
//		try {
//			EndView.printOne(reservation.selectReservation());
//		}catch (SQLException e){
//			e.printStackTrace();
//		}
	}

	@Override
	public void addReservation(ReservationDTO newReservation) {
//		try {
//			reservation.addReservation(newReservation);
//			EndView.Success("추가 성공!");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (NotExistException e) {
//			EndView.failView(e.getMessage());
//		}
	}

	@Override
	public void updateReservation(int reservationId, Date startDate, Date endDate) {
//		try {
//			reservation.updateReservation(reservationId, startDate,endDate);
//			EndView.Success("업데이트 성공!");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (NotExistException e) {
//			EndView.failView(e.getMessage());
//		}
	}

	@Override
	public void deleteReservation(int reservationId) {
//		try {
//			reservation.deleteReservation(reservationId);
//			EndView.Success("삭제 성공 !");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (NotExistException e) {
//			EndView.failView(e.getMessage());
//		}
	}

}
