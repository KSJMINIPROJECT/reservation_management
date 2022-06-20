package view;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.Controller;
import model.CustomerDTO;
import model.ReservationDTO;
import model.RoomDTO;
import service.ReservationService;

public class ReservationView {
	public static boolean reservationView(Scanner scan) throws InputMismatchException {
			Controller controller = Controller.getInstance();
			ReservationDTO reservation = null;
			int roomId;
			int reservationId;
			String customerId;
			Date startDate;
			Date endDate;
			int selectNum =0;
			boolean check =true;
			do {
				System.out.println("-----------Reservation_management------------");
				System.out.println("1. 전체 예약 검색");
				System.out.println("2. 특정 예약 검색");
				System.out.println("3. 예약 추가");
				System.out.println("4. 예약 정보 수정");
				System.out.println("5. 예약 정보 삭제");
				System.out.println("6. 뒤로가기");
				System.out.println("7. 종료");
				System.out.println("------------------------------------------");
				System.out.print("번호를 입력하세요 : ");
				selectNum = scan.nextInt();
				switch (selectNum) {
				case 1:
					System.out.println("전체 예약 리스트");
					controller.allReservation();
					break;
				case 2:
					System.out.print("고객Id를 입력하세요 : ");
					reservationId =scan.nextInt();
					controller.selectReservation(reservationId);
					break;
				case 3:
					System.out.print("예약하시는 고객Id를  입력하세요 : ");
					customerId = scan.next();
					if(!controller.selectCustomer(customerId)) {
						break;
					}
					System.out.print("예약하시는 방ID를 입력하세요 : ");
					roomId= scan.nextInt();
					if((!controller.selectRoom(roomId))||
							(!controller.checkHeadCount(roomId, customerId))) {
						break;
					}
					System.out.print("예약 시작일자를 입력하세요 : ");
					startDate=java.sql.Date.valueOf(scan.next());
					System.out.print("예약 마지막일자를 입력하세요 : ");
					endDate=java.sql.Date.valueOf(scan.next());
					if(!controller.checkEmptyRoom(startDate,endDate,roomId)) {
						break;
					};
					ReservationDTO newReservation = new ReservationDTO(customerId,roomId,startDate,endDate);
					controller.addReservation(newReservation);
					break;
				case 4:
					System.out.print("수정할 예약Id 입력 : ");
					reservationId =scan.nextInt();
					if((reservation=controller.selectReservation(reservationId)) == null) {
						break;
					}
					System.out.print("변경할 방Id를 입력하세요 : ");
					roomId = scan.nextInt();
					if((!controller.selectRoom(roomId))||
							(!controller.checkHeadCount(roomId,reservation.getCustomerId()))) {
						break;
					}
					System.out.print("변경할 시작일자를 입력하세요 : ");
					startDate=java.sql.Date.valueOf(scan.next());
					System.out.print("변경할 마지막일자를 입력하세요 : ");
					endDate=java.sql.Date.valueOf(scan.next());
					if(!controller.checkEmptyRoom(startDate,endDate,roomId)) {
						break;
					};
						controller.updateReservation(reservationId,roomId,startDate,endDate);
				
					break;
				case 5:
					System.out.print("삭제할 예약Id 입력 : ");
					reservationId =scan.nextInt();
					controller.deleteReservation(reservationId);
					break;
				case 6:
					return true;
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
