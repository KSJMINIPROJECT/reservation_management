package controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.CustomerDAO;
import exception.NotExistException;
import model.CustomerDTO;
import model.ReservationDTO;
import model.RoomDTO;

public interface ControllerInterface {
	// customer CRUD
	// 모든 고객 정보 조회
	public void allCustomer();
	
	
	// 특정 고객 고객ID로 조회
	public boolean selectCustomer(String customerId);
	// 고객 추가
	public void addCustomer(CustomerDTO newCustomer);
	// 고객 정보 수정(인원,전화번호)
	public void updateCustomer(String customerId,int headCount,String phoneNum);
	// 고객 정보 삭제
	public void deleteCustomer(String customerId);
	
	// Room CRUD
	// 모든 객실 정보 조회
	public void allRoom();
	// 특정 객실 정보 조회
	public boolean selectRoom(int roomId);
	// 객실 추가
	public void addRoom(RoomDTO newRoom);
	// 객실 정보 수정
	public void updateRoom(int roomId,String price);
	// 객실 정보 삭제
	public void deleteRoom(int roomId);
	
	// Reservation CRUD
	// 모든 예약 현황 조회
	public void allReservation();
	// 특정 예약 현황 조회
	public boolean selectReservation(int reservationId);
	// 예약 추가
	public void addReservation(ReservationDTO newReservation);
	// 에약 정보 수정
	public void updateReservation(int reservationId,int roomId,Date startDate,Date endDate);
	// 예약 정보 삭제
	public void deleteReservation(int reservationId);
	
	
	// roomStatus로 빈방 조회
	public void selectEmptyRoom(Date date) throws NotExistException;


//	public void selectEmptyRoom(String date) throws NotExistException;


	
	
}
