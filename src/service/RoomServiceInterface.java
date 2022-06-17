package service;

import java.sql.SQLException;

import java.util.ArrayList;

import model.RoomDTO;

public interface RoomServiceInterface {

	public ArrayList<RoomDTO> allRoom() throws SQLException;
	public RoomDTO selectRoom(int roomId) throws SQLException;
	// 날짜로 빈방 찾기

	public boolean addRoom(RoomDTO newRoom);
	public boolean updateRoom(int roomId,int price);
	public boolean deleteRoom(int roomId);
}
