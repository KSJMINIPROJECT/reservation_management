package service;

import java.sql.Date;
import java.util.ArrayList;

import model.ReservationDTO;
import model.RoomDTO;


public interface ReservationServiceInterface {
	public ArrayList<ReservationDTO> allReservation();
	public ReservationDTO selectReservation(int reservationId);
	// 예약 추가시 roomStatus 'Y'로 변경
	public boolean addReservation(ReservationDTO newReservation);
	public boolean updateReservation(int reservationId,String startDate,String endDate);
	// 예약 취소시 roomStatus 'N'으로 변경
	public boolean deleteReservation(int reservationId);
	// 빈방 검색
	public ArrayList<RoomDTO> selectEmptyRoom(Date date);
}
