package dao;

import java.sql.Connection;
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
				list.add(new ReservationDTO(rset.getInt("reservation_id"), rset.getString(2), rset.getInt(3), rset.getDate(4), rset.getDate(5) ));
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
			pstmt = con.prepareStatement("insert into (customer_id, room_id, start_date, end_date) bt_project values(?, ?, ?, ?)");
			
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
	public static boolean updateReservation(int reservationId,int roomId, String startDate,String endDate) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("update reservation set room_id =?, start_date = ?, end_date =? where reservation_id=? ");
			pstmt.setInt(1, roomId);
			pstmt.setNString(2, startDate);
			pstmt.setString(3, endDate);
			
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
