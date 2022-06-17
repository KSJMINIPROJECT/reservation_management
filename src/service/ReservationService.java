package service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ReservationDAO;
import exception.NotExistException;
import model.ReservationDTO;
import model.RoomDTO;

public class ReservationService implements ReservationServiceInterface {
	CustomerService customer=CustomerService.getInstance();
	RoomService room =RoomService.getInstance();
	
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
	public ReservationDTO selectReservation(int reservationId) throws SQLException {
		// TODO Auto-generated method stub
		return ReservationDAO.selectReservation(reservationId);
	}
	//예약 추가
	@Override
	public boolean addReservation(ReservationDTO newReservation) throws SQLException {
		if((customer.selectCustomer(newReservation.getCustomerId()) != null)
				&& (room.selectRoom(newReservation.getRoomId()) != null )){
					return ReservationDAO.addReservation(newReservation);
				}
		return false;
	}
	
	//예약 id로 예약 정보 업데이트
	@Override
	public boolean updateReservation(int reservationId, int roomId, String startDate, String endDate) throws SQLException, NotExistException {
		notExistReservation(reservationId);
		if(room.selectRoom(roomId)!=null) {
			return ReservationDAO.updateReservation(reservationId, roomId, startDate, endDate);
		}
		return false;
	}
	
	//id로 예약 정보 삭제
	@Override
	public boolean deleteReservation(int reservationId) throws SQLException, NotExistException {
		notExistReservation(reservationId);
		return ReservationDAO.deleteReservation(reservationId);
	}

	@Override
	// 빈방 검색
	public ArrayList<RoomDTO> selectEmptyRoom(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

}
