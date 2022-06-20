package service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import exception.NotExistException;
import model.ReservationDTO;
import model.RoomDTO;


public interface ReservationServiceInterface {
	public ArrayList<ReservationDTO> allReservation() throws SQLException;
	public ReservationDTO selectReservation(int reservationId) throws SQLException, NotExistException;
	// 예약 추가시 roomStatus 'Y'로 변경
	public boolean addReservation(ReservationDTO newReservation) throws SQLException,NotExistException;
	public boolean updateReservation(int reservationId,int roomId, Date startDate,Date endDate) throws SQLException, NotExistException;
	// 예약 취소시 roomStatus 'N'으로 변경
	public boolean deleteReservation(int reservationId) throws SQLException, NotExistException;
	
	//빈방 검색
//	public ArrayList<RoomDTO> selectEmptyRoom(Date date) throws SQLException;
	public ArrayList<RoomDTO> searchEmptyRoom(Date reservationStartDate, Date reservationEndDate) throws SQLException, NotExistException;
	
	
}
