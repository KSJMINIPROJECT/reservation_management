package service;

import java.sql.SQLException;

import java.util.ArrayList;

import exception.NotExistException;
import model.RoomDTO;

public interface RoomServiceInterface {

	public ArrayList<RoomDTO> allRoom() throws SQLException;
	public RoomDTO selectRoom(int roomId) throws SQLException;
	// 날짜로 빈방 찾기
  
	public boolean addRoom(RoomDTO newRoom) throws SQLException, NotExistException;
	public boolean updateRoom(int roomId,String price) throws SQLException, NotExistException;
	public boolean deleteRoom(int roomId) throws SQLException, NotExistException;

}
