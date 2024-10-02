package edu.kh.project.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.kh.project.model.dto.Cafe;
/*
 * 번호를 입력받아 각각 화면 출력
 * 1. 메뉴 소개 (조회)
 * 2. 메뉴 번호로 주문 받기
 * 3. 메뉴 추가 및 메뉴 변경 가능하게 하기 (추가, 수정)
 * 4. 판매 부진한 메뉴 삭제 가능하게 한다 (삭제)
 * */

public class cafeService {
	
		// 필드
		private Scanner sc = new Scanner(System.in);
		
		// 메뉴 저장할 List
		private List<Cafe> drink = new ArrayList<Cafe>(); 
		
		// 주문한 메뉴 저장할 List
		private List<Cafe> order = new ArrayList<Cafe>();
		
		public cafeService() {
			
			// List 에 메뉴 5개 등록
			drink.add(new Cafe("아메리카노", 2080, "콜롬비아 원두", 1));
			drink.add(new Cafe("자몽에이드", 3500, "자몽", 2));
			drink.add(new Cafe("딸기라떼", 4000, "딸기", 3));
			drink.add(new Cafe("히비스커스티", 2500, "히비스커스 꽃잎", 4));
			drink.add(new Cafe("초코스무디", 4000, "초콜릿", 5));
		}
		
		
		// 메서드
		public void displayMenu() {
			
			try {
				
				int menuNum = 0;
			
				do {
					
					System.out.println("*** [ 수민 카페 ] ***");
					System.out.println("1. 메뉴 조회");
					System.out.println("2. 메뉴 주문");
					System.out.println("3. 메뉴 추가");
					System.out.println("4. 메뉴 변경");
					System.out.println("5. 메뉴 삭제");
					System.out.println("0. 프로그램 종료");
					
					System.out.print("\n선택 (번호로 입력해주세요!) : ");
				
					menuNum = sc.nextInt();
					
					switch(menuNum) {
					case 1 : displayAllMenu(drink); break;
					case 2 : myOrder(); break;
					case 3 : System.out.println(addMenu()); break;
					case 4 : System.out.println(modifyMenu()); break;
					case 5 : System.out.println(removeMenu()); break; */
					case 0 : System.out.println("종료되었습니다."); break;
					default : System.out.println("메뉴에 있는 번호만 입력해주세요.\n"); break;				
					
					}
					
				} while(menuNum != 0);
				
			} catch (Exception e) {
				System.out.println("예외 발생");
				e.printStackTrace(); // 예외 추적
					
			}
		}
	
		
		/** 메뉴 조회 O
		 * @param list
		 */
		public void displayAllMenu(List<Cafe> list) {
			
			//flag 해서 true 일 때 -- 수민 카페 메뉴 -- 뜨게 하기
			// false면 메뉴만 뜨게 하기
			
			
			if(true)System.out.println("\n-- 수민 카페 메뉴 --");
			
			if(list.isEmpty()) {
				System.out.println("추가한 음료가 없습니다. 음료를 등록해주세요.");
				
			} else {
				for(Cafe temp : list) {
					System.out.println(temp);

			}
				System.out.println("\n");
		}
	}
		
		/**
		 * 메뉴 주문
		 */
		public void myOrder() {
			System.out.println("\n-- 메뉴 주문 --");
			
			displayAllMenu(drink); // false일 때 -- 수민 카페 메뉴 -- 안 뜨게 하기
			
			System.out.print("주문하실 음료를 선택해주세요. (번호로 입력해주세요!) : ");
			int orderDrink = sc.nextInt();
			
			boolean flag = true;
			
			// for문 안에 if 문으로 flag false시 주문한 메뉴명 + 주문 성공 출력 띄우기
			for(Cafe cafe : drink) {
				if(cafe.getMenuNum()==orderDrink) {
					flag = false;
					order.add(cafe);
					System.out.println(cafe.getMenuName() + " 주문 완료 ~!\n");
					break;
				}
			}
			
			// 메뉴판에 없는 메뉴번호 입력 시 메뉴판에 있는 메뉴만 입력해주세요 출력
			if(flag) System.out.println("일치하는 메뉴 번호가 없습니다.");
			
		
		}
		
		/** 메뉴 추가 O
		 * @return
		 */
		public String addMenu() {
			System.out.println("\n-- 메뉴 추가 --");
			System.out.print("메뉴 번호 : ");
			int menuNum = sc.nextInt();
			
			System.out.print("메뉴 이름 : ");
			String menuName = sc.next();
			
			System.out.print("가격 : ");
			int price = sc.nextInt();
			sc.nextLine(); // 입력버퍼에 남은 개행문자 제거
			
			System.out.print("주재료 : ");
			String mainIngredients = sc.nextLine();
			
			Cafe newMenu = new Cafe(menuName, price, mainIngredients, menuNum);
			drink.add(newMenu);
			
			return "등록 완료";
			
		}
		
		/** 메뉴 변경
		 * @return
		 */
		public String modifyMenu() {
		
			displayAllMenu(drink); // false일 때 -- 수민 카페 메뉴 -- 안 뜨게 하기
			
			System.out.println("\n-- 메뉴 변경 --");
			
			int editMenu = 0;
			
			System.out.print("수정할 메뉴 번호를 입력해주세요 : ");
			int menuNum = sc.nextInt();
			
			boolean flag = true;
			
			for(Cafe temp : drink) {
				
				if(temp.getMenuNum() == menuNum) {
					flag = false;
					
					System.out.println("\n어떤 정보를 수정하시겠습니까?\n");
					System.out.println("1. 메뉴명");
					System.out.println("2. 가격");
					System.out.println("3. 주재료");
					System.out.println("0. 수정 종료");
					System.out.print("\n수정하고 싶은 정보 번호를 입력해주세요 : ");
					
					editMenu = sc.nextInt();
					
					// 수정 하나 끝나고 종료되지 않고 추가로 수정할 번호를 받을 수 있게 하기
					switch (editMenu) {
					case 1: System.out.println("\n>> 메뉴명 수정<<");
							System.out.print("수정할 메뉴명을 입력해주세요 : ");
							String menuName = sc.next(); 
							temp.setMenuName(menuName);
							break;
							
					case 2: System.out.println("\n>> 가격 수정<<");
							System.out.print("수정할 가격을 입력해주세요 : ");
							int price = sc.nextInt();
							temp.setPrice(price);
							break;
					
					case 3: System.out.println("\n>> 주재료 수정<<");
							System.out.print("수정할 주재료를 입력해주세요 : ");
							String mainIngredients = sc.next(); 
							temp.setMainIngredients(mainIngredients);
							break;
					
					case 0: System.out.println("메뉴 수정을 종료합니다.");break;
					default : System.out.println("메뉴에 있는 번호만 입력해주세요.");
					}
				}
			}
			
			if(flag) {
				return "일치하는 메뉴 번호가 없습니다.";
			}
			return "수정 완료 ~";
		}
		
		public String removeMenu() {
			System.out.println("\n-- 메뉴 삭제 --");
			
			displayAllMenu(drink); // false일 때 -- 수민 카페 메뉴 -- 안 뜨게 하기
			
			System.out.print("삭제할 메뉴의 번호를 입력해주세요 : ");
			int delet = sc.nextInt();
			
			for(Cafe temp : drink) {
				
				if(temp.getMenuNum() == delet) {
					int index = drink.indexOf(temp);
					
					System.out.println("정말 삭제하시겠습니까? (Y/N) : ");
					
					char answer = sc.next().toUpperCase().charAt(0);
					
					if(answer == 'Y') {
						drink.remove(index);
						break;
					} else {
						return "취소";
					}
				}
			}
			
			return "메뉴가 삭제되었습니다.";
		}
}
