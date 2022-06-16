package model;

public class RoomDTO {
	private int roomId; // �� ��ȣ
	private int max_Capacity; //�ִ�����ο�
	private String price; //����
	private String region; // ����
	private String roomStatus; //���డ�ɿ���
	
	public RoomDTO(int roomId, int max_Capacity, String price, String region, String roomStatus) {
		super();
		this.roomId = roomId;
		this.max_Capacity = max_Capacity;
		this.price = price;
		this.region = region;
		this.roomStatus = roomStatus;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getMax_Capacity() {
		return max_Capacity;
	}

	public void setMax_Capacity(int max_Capacity) {
		this.max_Capacity = max_Capacity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	@Override
	public String toString() {
//		return "RoomDTO [roomId=" + roomId + ", max_Capacity=" + max_Capacity + ", price=" + price + ", region="
//				+ region + ", roomStatus=" + roomStatus + "]";
		StringBuilder builder = new StringBuilder();
		builder.append("[�� ��ȣ : ");
		builder.append(roomId);
		builder.append(", �ִ� �����ο� : ");
		builder.append(max_Capacity);
		builder.append(", ���� : ");
		builder.append(price);
		builder.append(", ���� : ");
		builder.append(region);
		builder.append(", ���డ�ɿ��� : ");
		builder.append(roomStatus);
		return builder.toString();
	}
	
}
