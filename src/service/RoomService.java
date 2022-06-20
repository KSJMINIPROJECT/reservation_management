package service;

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
	
	//모든 객실 정보 반환
	public ArrayList<RoomDTO> allRoom() throws SQLException {
		return RoomDAO.allRoom();
	};
	
	//객실 이름으로 검색 selectRoom
	public RoomDTO selectRoom(int roomId) throws SQLException, NotExistException {
		RoomDTO room=RoomDAO.selectRoom(roomId);
	      if(room == null) {
	         throw new NotExistException("존재하지않는 객실입니다.");
	      }
	      return room;
	   }
	
	//객실 추가하기 add
	public boolean addRoom(RoomDTO newRoom) throws SQLException {
		return RoomDAO.addRoom(newRoom);
	}

	@Override
	//객실 내용 갱신 update
	public boolean updateRoom(int roomId, String price) throws SQLException {
		return RoomDAO.updateRoom(roomId, price);	
	}

	@Override
	//객실 삭제 delete
	public boolean deleteRoom(int roomId) throws SQLException, NotExistException {
		selectRoom(roomId);
		return RoomDAO.deleteRoom(roomId);
	}
	public void existRoom(int roomId) throws SQLException, NotExistException {
		RoomDTO room=RoomDAO.selectRoom(roomId);
	      if(room != null) {
	         throw new NotExistException("이미 존재하는 객실입니다.");
	      }
	  }
	
}
