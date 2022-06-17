package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RoomView {
	public static boolean roomView() throws InputMismatchException{
		Scanner scan = new Scanner(System.in);
		int roomId;
		int maxCapacity;
		String price;
		String region;
		String date;
		int selectNum =0;
		boolean check =true;
		do {
			System.out.println("-------------Room_management--------------");
			System.out.println("1. 전체 객실 검색");
			System.out.println("2. 특정 객실 검색");
			System.out.println("3. 빈방 검색");
			System.out.println("4. 객실 정보 추가");
			System.out.println("5. 객실 정보 수정");
			System.out.println("6. 객실 정보 삭제");
			System.out.println("7. 종료");
			System.out.println("------------------------------------------");
			System.out.print("번호를 입력하세요 : ");
			selectNum = scan.nextInt();
			switch (selectNum) {
			case 1:
				System.out.println("전체 객실 리스트");
//				Controller.allRoom();
				check =false;
				break;
			case 2:
				System.out.print("객실ID를 입력하세요 : ");
				roomId =scan.nextInt();
//				Controller.selectRoom(roomId);
				check =false;
				break;
			case 3:
				System.out.print("조회하실 날짜를 입력하세요 : ");
				date = scan.next();
//				controller.selectEmptyRoom(date);
				
			case 4:
				System.out.print("객실의 ID를 입력하세요 : ");
				roomId = scan.nextInt();
				System.out.print("객실의 최대 수용 인원을 입력하세요 : ");
				maxCapacity = scan.nextInt();
				System.out.print("객실의 가격을 입력하세요 : ");
				price = scan.next();
				System.out.print("객실의 지역을 입력하세요 : ");
				region = scan.next();
//				RoomDTO newRoom = new RoomDTO(roomId,maxCapacity,price,region);
//				Controller.addRoom(newRoom);
				check=false;
				break;
			case 5:
				System.out.print("수정할 객실Id 입력하세요 : ");
				roomId =scan.nextInt();
				System.out.print("수정할 객실의 가격을 입력하세요 : ");
				price = scan.next();
//				Controller.updateRoom(customerId,price);
				check =false;
				break;
			case 6:
				System.out.print("삭제할 객실Id 입력 : ");
				roomId =scan.nextInt();
//				Controller.deleteRoom(roomId);
				check =false;
				break;
			case 7:
				return false;
			default:
				System.out.println("잘못된 입력값입니다. 다시 입력하세요");
				break;
			}
		} while (check);
		return true;
	}
}
