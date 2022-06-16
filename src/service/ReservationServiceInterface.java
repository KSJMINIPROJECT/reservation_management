package service;

import java.util.ArrayList;

import model.ReservationDTO;


public interface ReservationServiceInterface {
	public ArrayList<ReservationDTO> allReservation();
	public ReservationDTO selectReservation(String reservationId);
	// 예약 추가시 roomStatus 'Y'로 변경
	public boolean addReservation(ReservationDTO newReservation);
	public boolean updateReservation(String reservationId,String startDate,String endDate);
	// 예약 취소시 roomStatus 'N'으로 변경
	public boolean deleteReservation(String reservationId);
}
