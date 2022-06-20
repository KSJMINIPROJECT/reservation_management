package controller;

import java.sql.Date;
import java.sql.SQLException;

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
	private ReservationService reservation = ReservationService.getInstance();
	
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
	public boolean selectCustomer(String customerId) {
		try {
			EndView.printOne(customer.selectCustomer(customerId));
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NotExistException e) {
			EndView.failView(e.getMessage());
		}return false;
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
	public boolean existCustomer(String customerId) {
		try {
			customer.existCustomer(customerId);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NotExistException e) {
			EndView.failView(e.getMessage());
		}
		return false;
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
	public boolean selectRoom(int roomId) {
		try {
			EndView.printOne(room.selectRoom(roomId));
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NotExistException e) {
			EndView.failView(e.getMessage());
		}
		return false;
	}

	@Override
	public void addRoom(RoomDTO newRoom) {
		try {
			room.addRoom(newRoom);
			EndView.Success("추가 성공!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateRoom(int roomId, String price) {
		try {
			room.updateRoom(roomId, price);
			EndView.Success("업데이트 성공!");
		} catch (SQLException e) {
			e.printStackTrace();
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
	public boolean existRoom(int roomId) {
		try {
			room.existRoom(roomId);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NotExistException e) {
			EndView.failView(e.getMessage());
		}
		return false;
	}
	@Override
	//빈방 조회(예약 시작, 예약 종료) 기준으로 조회
	public void searchEmptyRoom(Date reservationStartDate,Date reservationEndDate)  {
		try {
			EndView.printAllData(reservation.searchEmptyRoom(reservationStartDate, reservationEndDate));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NotExistException e) {
			EndView.failView(e.getMessage());
		}
	}
	// roomId로 빈방인지 체크
	public boolean checkEmptyRoom(Date reservationStartDate,Date reservationEndDate,int roomId)  {
		try {
			reservation.checkEmptyRoom(reservationStartDate, reservationEndDate,roomId);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NotExistException e) {
			EndView.failView(e.getMessage());
		}
		return false;
	}

	
	// Reservation Controller
	@Override
	public void allReservation() {
		try {
			EndView.printAllData(reservation.allReservation());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ReservationDTO selectReservation(int reservationId) {
		ReservationDTO selectReservation = null;
		try {
			selectReservation = reservation.selectReservation(reservationId);
			EndView.printOne(selectReservation);
			return selectReservation;
		}catch (SQLException e){
			e.printStackTrace();
		} catch (NotExistException e) {
			EndView.failView(e.getMessage());
		} return selectReservation;
	}

	@Override
	public void addReservation(ReservationDTO newReservation) {
		try {
			reservation.addReservation(newReservation);
			EndView.Success("추가 성공!");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NotExistException e) {
			EndView.failView(e.getMessage());
		}
	}

	@Override
	public void updateReservation(int reservationId,int roomId, Date startDate, Date endDate) {
		try {
			reservation.updateReservation(reservationId,roomId, startDate,endDate);
			EndView.Success("업데이트 성공!");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NotExistException e) {
			EndView.failView(e.getMessage());
		}
	}

	@Override
	public void deleteReservation(int reservationId) {
		try {
			reservation.deleteReservation(reservationId);
			EndView.Success("삭제 성공 !");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NotExistException e) {
			EndView.failView(e.getMessage());
		}
	}
	public boolean checkHeadCount(int roomId, String customerId) {
		try {
			return reservation.checkHeadCount(roomId, customerId);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NotExistException e) {
			EndView.failView(e.getMessage());
		}return false;
	}
	

}
