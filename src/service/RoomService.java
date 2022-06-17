package service;

import java.io.NotActiveException;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.RoomDAO;
import exception.NotExistException;
import model.RoomDTO;

public class RoomService implements RoomServiceInterface {

	public static RoomService instance = new RoomService();
	
	private RoomService() {	
	}
	
	public static RoomService getInstance() {
		return instance;
	}
	
	//객실을 찾을 수 없을때
	public boolean notExistRoom(int roomId) throws SQLException {
		RoomDTO checkRoom = RoomDAO.selectRoom(roomId);
		if (checkRoom == null) {
			return true;
		}else {
			return false;
		}
	}

	//모든 객실 정보 반환
	public ArrayList<RoomDTO> allRoom() throws SQLException {
		return RoomDAO.allRoom();
	};
	
	//객실 이름으로 검색 selectRoom
	public RoomDTO selectRoom(int roomId) throws SQLException {
		return RoomDAO.selectRoom(roomId);
	}
	
	//객실 추가하기 add
	public boolean addRoom(RoomDTO newRoom) throws SQLException, NotExistException {
		if(notExistRoom(newRoom.getRoomId())) {
			RoomDAO.addRoom(newRoom);
			return true;
		}else {
			throw new NotExistException("이미 있는 객실ID입니다.");
		}
	}

	@Override
	//객실 내용 갱신 update
	public boolean updateRoom(int roomId, String price) throws SQLException, NotExistException {
		if(notExistRoom(roomId)) {
			throw new NotExistException("수정하려는 Id의 객실이 없습니다.");
		}else {
			RoomDAO.updateRoom(roomId, price);
		}
			
		return false;
	}

	@Override
	//객실 삭제 delete
	public boolean deleteRoom(int roomId) throws SQLException, NotExistException {
		if(notExistRoom(roomId)){
			throw new NotExistException("삭제하려는 Id의 객실이 없습니다.");
		}else {
			RoomDAO.deleteRoom(roomId);
		}
		return false;
	}
	
}
