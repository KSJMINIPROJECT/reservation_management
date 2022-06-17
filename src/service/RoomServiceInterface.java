package service;

import java.util.ArrayList;

import model.RoomDTO;

public interface RoomServiceInterface {
	public ArrayList<RoomDTO> allRoom();
	public RoomDTO selectRoom(String roomId);
	public boolean addRoom(RoomDTO newRoom);
	public boolean updateRoom(String roomId,int price);
	public boolean deleteRoom(String roomId);
}
