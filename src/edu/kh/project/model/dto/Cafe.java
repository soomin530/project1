package edu.kh.project.model.dto;

public class Cafe {
	
		// 필드
		private String menuName; // 메뉴 이름
		private int price; // 가격
		private String mainIngredients; // 주재료
		private int menuNum; // 메뉴 번호
		
		// 기본생성자
		public Cafe() {}

		// 매개변수생성자
		public Cafe(String menuName, int price, String mainIngredients, int menuNum) {
			super();
			this.menuName = menuName;
			this.price = price;
			this.mainIngredients = mainIngredients;
			this.menuNum = menuNum;
		}

		// getter / setter
		public String getMenuName() {
			return menuName;
		}

		public void setMenuName(String menuName) {
			this.menuName = menuName;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public String getMainIngredients() {
			return mainIngredients;
		}

		public void setMainIngredients(String mainIngredients) {
			this.mainIngredients = mainIngredients;
		}

		public int getMenuNum() {
			return menuNum;
		}

		public void setMenuNum(int menuNum) {
			this.menuNum = menuNum;
		}

		@Override
		public String toString() {
			return menuNum + "번 메뉴 : " + menuName + 
					 " / 가격 : " + price + "원 / 주재료 : " + mainIngredients;
		}
		
		

}
