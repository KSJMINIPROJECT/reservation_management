package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.ReservationDTO;
import model.RoomDTO;
import utill.DBUtil;

public class ReservationDAO {
	
	//전체 예약 정보 조회
	public static ArrayList<ReservationDTO> allReservation() throws SQLException{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ReservationDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from reservation");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<ReservationDTO>();
			while(rset.next()) {
				list.add(new ReservationDTO(rset.getInt(1),rset.getString(2), rset.getInt(3), rset.getDate(4), rset.getDate(5) ));
			}
			
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
		
	}
	
	//예약 id로 예약 정보 조회
	public static ReservationDTO selectReservation(int reservationId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ReservationDTO reservation_info = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from reservation where reservation_id=?");
			pstmt.setInt(1, reservationId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				reservation_info = new ReservationDTO(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getDate(4),
						rset.getDate(5));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return reservation_info;
	}

	// 예약 추가
	public static boolean addReservation(ReservationDTO newReservation) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into reservation(customer_id, room_id, start_date, end_date) values(?, ?, ?, ?)");
			
			pstmt.setString(1, newReservation.getCustomerId());
			pstmt.setInt(2, newReservation.getRoomId());
			pstmt.setDate(3, newReservation.getStartDate());
			pstmt.setDate(4, newReservation.getEndDate());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt, stmt);
		}
		return false;
	}
	
	//예약 삭제
	public static boolean deleteReservation(int reservationId) throws SQLException {
	      
        Connection con = null;
        PreparedStatement pstmt = null;
     try {
        con = DBUtil.getConnection();
        pstmt = con.prepareStatement("delete from reservation where reservation_id=?");
        pstmt.setInt(1, reservationId);
        
        
        int result = pstmt.executeUpdate();
        if (result == 1) {
           
           return true;
        }
     }finally {
        DBUtil.close(con, pstmt);
     }
     return false;
  }
	
	//예약 수정
	public static boolean updateReservation(int reservationId,int roomId, Date startDate,Date endDate) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("update reservation set room_id =?, start_date = ?, end_date = ? where reservation_id=? ");
			pstmt.setInt(1, roomId);
			pstmt.setDate(2, startDate);
			pstmt.setDate(3, endDate);
			pstmt.setInt(4, reservationId);
			
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
			
		} finally {
			DBUtil.close(con, pstmt);
		}
		
		return false;
		
	}
	
	//빈 방 조회
	public static ArrayList<RoomDTO> searchEmptyRoom(Date reservationStartDate, Date reservationEndDate ) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RoomDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * \r\n" + 
					"from room\r\n" + 
					"where room_id not in(select room_id\r\n" + 
					"					from reservation\r\n" + 
					"                    where reservation.start_date <= ? \r\n" + 
					"						and reservation.end_date >= ?) ");
			pstmt.setDate(1, reservationEndDate);
			pstmt.setDate(2, reservationStartDate);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<RoomDTO>();
			while(rset.next()) {
				list.add(new RoomDTO(rset.getInt(1),rset.getInt(2), rset.getString(3), rset.getString(4)));
			}
			
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	//roomId로 빈방인지 체크
	public static boolean checkEmptyRoom(Date reservationStartDate, Date reservationEndDate,int roomId ) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RoomDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * \r\n" + 
					"from room\r\n" + 
					"where room_id = ? and room_id not in(select room_id\r\n" + 
					"					from reservation\r\n" + 
					"                    where reservation.start_date <= ? \r\n" + 
					"						and reservation.end_date >= ?) ");
			pstmt.setInt(1, roomId);
			pstmt.setDate(2, reservationEndDate);
			pstmt.setDate(3, reservationStartDate);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<RoomDTO>();
			if(rset.next()) {
				list.add(new RoomDTO(rset.getInt(1),rset.getInt(2), rset.getString(3), rset.getString(4)));
			}
			if(list.size()==1) {
				return true;
			}else {
				return false;
			}
			
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
	}
	
	
	
	
}
