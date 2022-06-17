package service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ReservationDAO;
import exception.NotExistException;
import model.ReservationDTO;
import model.RoomDTO;

public class ReservationService implements ReservationServiceInterface {
	private static ReservationService instance = new ReservationService();
	
	private ReservationService() {}
	
	public static ReservationService getInstance() {
		return instance;
	}
	
	CustomerService customer=CustomerService.getInstance();
	RoomService room =RoomService.getInstance();
	ReservationService reservation = ReservationService.getInstance();
	
	public void notExistReservation(int reservationId) throws SQLException, NotExistException {
		ReservationDTO Reservation = ReservationDAO.selectReservation(reservationId);
		if (Reservation == null) {
			throw new NotExistException("검색한  예약이 존재하지 않습니다.");
		}
	}
	
	//모든 예약 정보 반환
	@Override
	public ArrayList<ReservationDTO> allReservation() throws SQLException {
		return ReservationDAO.allReservation();
	}
	//에약 id로 특정 예약 정보 조회
	@Override
	public ReservationDTO selectReservation(int reservationId) throws SQLException, NotExistException {
		ReservationDTO reservation = ReservationDAO.selectReservation(reservationId);
		if(reservation == null) {
			throw new NotExistException();
		}
		return reservation;
	}
	//예약 추가
	@Override
	public boolean addReservation(ReservationDTO newReservation) throws SQLException, NotExistException {
		if((customer.selectCustomer(newReservation.getCustomerId()) != null)
				&& (room.selectRoom(newReservation.getRoomId()) != null )){
					return ReservationDAO.addReservation(newReservation);
				}else {
					throw new NotExistException("신규 예약 추가 할 수 없습니다.");
				}
	}
	
	//예약 id로 예약 정보 업데이트
	// 예약id가 없다면?
	@Override
	public boolean updateReservation(int reservationId, int roomId, String startDate, String endDate) throws SQLException, NotExistException {
			return ReservationDAO.updateReservation(reservationId, roomId, startDate, endDate);
	}
	
	//id로 예약 정보 삭제
	// 예약 id가 없다면?
	@Override
	public boolean deleteReservation(int reservationId) throws SQLException, NotExistException {
			return ReservationDAO.deleteReservation(reservationId);
	
	}
	
	@Override
	public ArrayList<RoomDTO> selectEmptyRoom(Date date) {
		
		return null;
	}

}
