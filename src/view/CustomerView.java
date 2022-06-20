package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.Controller;
import model.CustomerDTO;

public class CustomerView {
	
	public static boolean customerView(Scanner scan) throws InputMismatchException {
		Controller controller = Controller.getInstance();
		String customerId;
		String phoneNum;
		String customerName;
		int selectNum =0;
		boolean check =true;
		int headCount;
		do {
			System.out.println("-----------Customer_management------------");
			System.out.println("1. 전체 고객 검색");
			System.out.println("2. 특정 고객 검색");
			System.out.println("3. 고객 추가");
			System.out.println("4. 고객 정보 수정");
			System.out.println("5. 고객 정보 삭제");
			System.out.println("6. 뒤로가기");
			System.out.println("7. 종료");
			System.out.println("------------------------------------------");
			System.out.print("번호를 입력하세요 : ");
			selectNum = scan.nextInt();
			switch (selectNum) {
			case 1:
				System.out.println("전체 고객 리스트");
				controller.allCustomer();
				break;
			case 2:
				System.out.print("고객Id를 입력하세요(String) : ");
				customerId =scan.next();
				controller.selectCustomer(customerId);
				break;
			case 3:
				System.out.print("고객 Id를 입력하세요(String) : ");
				customerId = scan.next();
				if(!controller.existCustomer(customerId)) {
					break;
				};
				System.out.print("고객 인원을 입력하세요 : ");
				headCount = scan.nextInt();
				System.out.print("휴대폰 번호를 입력하세요 : ");
				phoneNum = scan.next();
				System.out.print("이름을 입력하세요 : ");
				customerName = scan.next();
				CustomerDTO newCustomer = new CustomerDTO(customerId,headCount,customerName,phoneNum);
				controller.addCustomer(newCustomer);
				break;
			case 4:
				System.out.print("수정할 고객Id 입력(String) : ");
				customerId =scan.next();
				if(!controller.selectCustomer(customerId)) {
					break;
				};
				System.out.print("변경할 고객 인원을 입력하세요 : ");
				headCount = scan.nextInt();
				System.out.print("변경할 고객의 전화번호를 입력하세요 : ");
				phoneNum = scan.next();
				controller.updateCustomer(customerId,headCount,phoneNum);
				break;
			case 5:
				System.out.print("삭제할 고객Id 입력(String) : ");
				customerId =scan.next();
				controller.deleteCustomer(customerId);
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
