package view;

import java.util.ArrayList;

public class EndView {
	
	// 모든 정보 출력
	public static void printAllData(ArrayList<?> allData) {
		if(!allData.isEmpty()) {
			allData.stream().forEach(System.out::println);
		}else {
			System.out.println("검색 정보 없음");
		}
	}
	// 특정 정보 하나만 출력
	public static void printOne(Object oneData) {
		System.out.println(oneData);
	}
	
	// 성공시
	public static void Success(String msg) {
		System.out.println(msg);
	}
	// 실패시
	public static void failView(String msg) {
		System.out.println(msg);
	}
	
}
