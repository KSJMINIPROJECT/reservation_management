package service;

import java.io.NotActiveException;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.RoomDAO;
import model.RoomDTO;

public class RoomService implements RoomServiceInterface {

	public static RoomService instance = new RoomService();
	
	private RoomService() {	
	}
	
	public static RoomService getInstance() {
		return instance;
	}
	
	//객실을 찾을 수 없을때
	public void notExistRoom(int roomId) throws SQLException, NotActiveException {
		RoomDTO checkRoom = RoomDAO.selectRoom(roomId);
		if (checkRoom == null) {
			throw new NotActiveException("검색하신 객실을 찾을 수 없습니다.");
		}
	}

	
	//모든 객실 정보 반환
	public ArrayList<RoomDTO> allRoom() throws SQLException {
		return RoomDAO.allRoom();
	};
	
	//객실 이름으로 검색 selectRoom
	public RoomDTO selectRoom(int roomId)  throws SQLException {
		return RoomDAO.selectRoom(roomId);
	}
	
	//객실 추가하기 add
	public boolean addRoom(RoomDTO newRoom) {
		return false;
	}

	@Override
	public boolean updateRoom(int roomId, int price) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteRoom(int roomId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	//객실 내용 갱신 update
	
	//객실 삭제 delete
	
	
	
	
	
	
	
	
	
	
}
