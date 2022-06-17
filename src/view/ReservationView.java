package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReservationView {
	public static boolean reservationView() throws InputMismatchException {
			Scanner scan = new Scanner(System.in);
			int roomId;
			int reservationId;
			String customerId;
			String startDate;
			String endDate;
			int selectNum =0;
			boolean check =true;
			do {
				System.out.println("-----------Reservation_management------------");
				System.out.println("1. 전체 예약 검색");
				System.out.println("2. 특정 예약 검색");
				System.out.println("3. 예약 추가");
				System.out.println("4. 예약 정보 수정");
				System.out.println("5. 예약 정보 삭제");
				System.out.println("6. 종료");
				System.out.println("------------------------------------------");
				System.out.print("번호를 입력하세요 : ");
				selectNum = scan.nextInt();
				switch (selectNum) {
				case 1:
					System.out.println("전체 예약 리스트");
//					Controller.allReservation();
					check =false;
					break;
				case 2:
					System.out.print("고객Id를 입력하세요 : ");
					reservationId =scan.nextInt();
//					Controller.selectReservation(reservationId);
					check =false;
					break;
				case 3:
					System.out.print("예약하시는 고객Id를  입력하세요 : ");
					customerId = scan.next();
					System.out.print("예약하시는 방ID를 입력하세요 : ");
					roomId= scan.nextInt();
					System.out.print("예약 시작일자를 입력하세요 : ");
					startDate = scan.next();
					System.out.print("예약 마지막일자를 입력하세요 : ");
					endDate = scan.next();
//					ReservationDTO newReservation = new reservationDTO(customerId,roomId,startDate,endDate);
//					Controller.addReservation(newReservation);
					check=false;
					break;
				case 4:
					System.out.print("수정할 예약Id 입력 : ");
					reservationId =scan.nextInt();
					System.out.print("변경할 방Id를 입력하세요 : ");
					roomId = scan.nextInt();
					System.out.print("변경할 시작일자를 입력하세요 : ");
					startDate = scan.next();
					System.out.print("변경할 마지막일자를 입력하세요 : ");
					endDate = scan.next();
//					Controller.updateReservation(reservationId,startDate,endDate);
					check =false;
					break;
				case 5:
					System.out.print("삭제할 예약Id 입력 : ");
					reservationId =scan.nextInt();
//					Controller.deleteReservation(reservationId);
					check =false;
					break;
				case 6:
					return false;
				default:
					System.out.println("잘못된 입력값입니다. 다시 입력하세요");
					break;
				}
			} while (check);
			return true;
		}
}
