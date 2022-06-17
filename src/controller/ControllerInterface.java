package controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.CustomerDAO;
import model.CustomerDTO;
import model.ReservationDTO;
import model.RoomDTO;

public interface ControllerInterface {
	// customer CRUD
	// 모든 고객 정보 조회
	public void allCustomer();
	
	
	// 특정 고객 고객ID로 조회
	public CustomerDTO selectCustomer(String customerId);
	// roomStatus로 빈방 조회
	public ArrayList<RoomDTO> selectEmptyRoom(Date date);
	// 고객 추가
	public boolean addCustomer(CustomerDTO newCustomer);
	// 고객 정보 수정(인원,전화번호)
	public boolean updateCustomer(String customerId,int headCount,String phoneNum);
	// 고객 정보 삭제
	public boolean deleteCustomer(String customerId);
	
	// Room CRUD
	// 모든 객실 정보 조회
	public ArrayList<RoomDTO> allRoom();
	// 특정 객실 정보 조회
	public RoomDTO selectRoom(int roomId);
	// 객실 추가
	public boolean addRoom(RoomDTO newRoom);
	// 객실 정보 수정
	public boolean updateRoom(int roomId,String price);
	// 객실 정보 삭제
	public boolean deleteRoom(int roomId);
	
	// Reservation CRUD
	// 모든 예약 현황 조회
	public ArrayList<ReservationDTO> allReservation();
	// 특정 예약 현황 조회
	public ReservationDTO selectReservation(String reservationId);
	// 예약 추가
	public boolean addReservation(ReservationDTO newReservation);
	// 에약 정보 수정
	public boolean updateReservation(String reservationId,String startDate,String endDate);
	// 예약 정보 삭제
	public boolean deleteReservation(String reservationId);
	
	
	
	
}
