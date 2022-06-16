package service;

import java.sql.Date;
import java.util.ArrayList;

import model.RoomDTO;

public interface RoomServiceInterface {
	public ArrayList<RoomDTO> allRoom();
	public RoomDTO selectRoom(String roomId);
	// 날짜로 빈방 찾기
	public ArrayList<RoomDTO> selectEmptyRoom(Date date);
	public boolean addRoom(RoomDTO newRoom);
	public boolean updateRoom(String roomId,int price);
	public boolean deleteRoom(String roomId);
}
