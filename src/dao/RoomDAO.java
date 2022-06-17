package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.RoomDTO;
import utill.DBUtil;

public class RoomDAO {
	//모든 방 보여주기
	
	public static ArrayList<RoomDTO> allRoom() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RoomDTO> roomlist = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from room");
			rset = pstmt.executeQuery();
			
			roomlist = new ArrayList<RoomDTO>();
			while (rset.next()) {
				roomlist.add(new RoomDTO(rset.getInt(1), rset.getInt(2), rset.getString(3), rset.getString(4)));
			}
		}finally {
			DBUtil.close(con, pstmt, rset);
		}
		return roomlist;
	}

	
	// 방 찾기 selectRoom int roomId
	public static RoomDTO selectRoom(int roomId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		RoomDTO slroom = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from room where room_id=?");
			pstmt.setInt(1, roomId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				slroom = new RoomDTO(rset.getInt(1), rset.getInt(2), rset.getString(3), rset.getString(4));
			}
		}finally {
			DBUtil.close(con, pstmt, rset);
		}
		
		return slroom;
	}	
	
	//방 추가하기
	public static boolean addRoom(RoomDTO newRoom) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con= DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into room(room_id,max_capacity,price,region) values(?, ?, ?, ?)");
			pstmt.setInt(1, newRoom.getRoomId());
			pstmt.setInt(2, newRoom.getMax_Capacity());
			pstmt.setString(3, newRoom.getPrice());
			pstmt.setString(4, newRoom.getRegion());
			int result = pstmt.executeUpdate();
			if (result==1) {
				return true;
			}
			
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	
	//roomId로 price 변경하기
	public static boolean updateRoom(int roomId, String price) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement("update room set price = ? where room_id=?");
			pstmt.setString(1, price);
			pstmt.setInt(2, roomId);
			

		
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
		}
		}finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
			
		//방 삭제
	public static boolean deleteRoom(int roomId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from room where room_id=?");
			pstmt.setInt(1, roomId);
			
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
		}

}





