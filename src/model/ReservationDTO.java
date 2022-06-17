package model;

import java.sql.Date;

public class ReservationDTO {
	
	private int reservationId;
	private String customerId;
	private int roomId;
	private Date startDate;
	private Date endDate;
	
	public ReservationDTO() {}
		
	public ReservationDTO(int reservationId ,String customerId, int roomId, Date startDate, Date endDate) {
		super();
		this.reservationId = reservationId;
		this.customerId = customerId;
		this.roomId = roomId;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public ReservationDTO(String customerId, int roomId, Date startDate, Date endDate) {

		super();
		this.customerId = customerId;
		this.roomId = roomId;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
//		return "ReservationDTO [reservationId=" + reservationId + ", customerId=" + customerId + ", roomId=" + roomId
//				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
		
		StringBuilder builder = new StringBuilder();
		builder.append("[예약 ID : ");
		builder.append(reservationId);
		builder.append(", 고객  ID : ");
		builder.append(customerId);
		builder.append(", 방번호 : ");
		builder.append(roomId);
		builder.append(", 숙박 시작 날짜 : ");
		builder.append(startDate);
		builder.append(", 숙박 종료 날짜 : ");
		builder.append(endDate);
		builder.append("]");
		return builder.toString();
	}
	
	
		
}
