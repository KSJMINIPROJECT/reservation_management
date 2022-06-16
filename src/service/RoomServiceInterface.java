package service;

import java.util.ArrayList;

import model.RoomDTO;

public interface RoomServiceInterface {
	public ArrayList<RoomDTO> allRoom();
	public RoomDTO selectRoom(int roomId);
	// 날짜로 빈방 찾기
	
	public boolean addRoom(RoomDTO newRoom);
	public boolean updateRoom(int roomId,int price);
	public boolean deleteRoom(int roomId);
}
