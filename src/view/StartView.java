package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StartView{
	public static void main(String[] args)  {
		Scanner scan =null;
		try {
		scan = new Scanner(System.in);
		int selectNum = 0;
		boolean check = true;
		
		do {
			System.out.println("----------Reservation_management----------");
			System.out.println("1. 고객 관리");
			System.out.println("2. 객실 관리");
			System.out.println("3. 예약 관리");
			System.out.println("4. 종료");
			System.out.println("------------------------------------------");
			System.out.print("번호를 입력하세요 : ");
			selectNum = scan.nextInt();
			switch (selectNum) {
			case 1:
				check =CustomerView.customerView(scan);
				break;
			case 2:
				check=RoomView.roomView(scan);
				break;
			case 3:
				check=ReservationView.reservationView(scan);
				break;
			case 4:
				check =false;
				break;
			default:
				System.out.println("잘못된 입력값입니다. 다시 입력하세요");
				break;
			}
		} while (check);
		}catch(InputMismatchException e) {
			System.out.println("잘못된 타입입니다.");
		}finally {
			scan.close();
		}
		System.out.println("-------------------종료--------------------");
		
		
	}
}
