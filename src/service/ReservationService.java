package service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.CustomerDAO;
import dao.ReservationDAO;
import exception.NotExistException;
import model.CustomerDTO;
import model.ReservationDTO;
import model.RoomDTO;

public class ReservationService implements ReservationServiceInterface {
	private static ReservationService instance = new ReservationService();
	CustomerService customer=CustomerService.getInstance();
	RoomService room =RoomService.getInstance();
	ReservationService reservation = ReservationService.getInstance();
	
	private ReservationService(){
	}
	public static ReservationService getInstance() {
		return instance;
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
			throw new NotExistException("해당하는 예약정보가 없습니다.");
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
	@Override
	public boolean updateReservation(int reservationId, int roomId, Date startDate, Date endDate) throws SQLException, NotExistException {
			return ReservationDAO.updateReservation(reservationId, roomId, startDate, endDate);
	}
	
	//id로 예약 정보 삭제
	@Override
	public boolean deleteReservation(int reservationId) throws SQLException, NotExistException {
		selectReservation(reservationId);
		return ReservationDAO.deleteReservation(reservationId);
	}
	
	@Override
	// 빈방 검색(하루 기준)
	public ArrayList<RoomDTO> selectEmptyRoom(Date date) throws SQLException {
		
		return ReservationDAO.selectEmptyRoom(date);
	}
}