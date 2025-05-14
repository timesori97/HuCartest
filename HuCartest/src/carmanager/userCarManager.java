package carmanager;

import java.util.Scanner;
 

public class userCarManager {

	private user[] ulist = new user[5];
	private Fix[] fixcarresult = new Fix[5];
	public userCarManager() {
		Scanner in = new Scanner(System.in);
		boolean flag = true;
		while (true) {
			System.out.println("1.자동차관리 2.수리정보 3.종료");
			int a = in.nextInt();
			switch (a) {
			case 1:
				carmenu();
				break;
			case 2:
				fix();
				break;
			case 3:
				System.out.println("프로그램 종료");
				flag = false;
			}
		}
	}

	private void carmenu() {
		Scanner in = new Scanner(System.in);
		boolean flag = true;
		while (true) {
			System.out.println("1.자동차번호 소유자 입력 2.전체보기 3.수리 4.종료");
			int a = in.nextInt();
			switch (a) {
			case 1:
				add();
				break;
			case 2:
				viewList();
				break;
			case 3: 
				fix();
				break;
			case 4:
				System.out.println("자동차 관리 종료");
				flag = false;
				break;
			}
		}

	}

	private void add() {
		Scanner in = new Scanner(System.in);
		user insert = new user();

		System.out.println("소유자의 이름을 입력하시오");
		String name = in.nextLine();
		System.out.println("자동차의 번호를 입력하시오");
		String num = in.nextLine();
		
		user result = addcar(name,num);

		for (int i = 0; i < ulist.length; i++) {
			if (ulist[i] == null) {
				ulist[i] = result;
				break;

			}

		}

	}
	private user addcar(String name,String num) {
		user insert = new user();
		insert.setUsername(name);
		insert.setCarnum(num);
		
		return insert;
	}
	
	


	private void viewList() {
		user getu = new user();
		for (int i = 0; i < ulist.length; i++) {
			if (ulist[i] != null) {
				System.out.println(ulist[i].getUsername());
				System.out.println(ulist[i].getCarnum());

			}

		}

	}
   private void fix() {
	   fixinput();
	   fixreserach();
   }
	
	
	private void fixreserach() {
		Fix getF = new Fix();
		for(int i = 0; i < fixcarresult.length; i++) {
			if(fixcarresult[i] != null) {
				System.out.println(getF.getFixtext());
				System.out.println(getF.getFixdate());
			}
		}
		user getu = new user();
		for (int i = 0; i < ulist.length; i++) {
			if (ulist[i] != null) {
				System.out.println(ulist[i].getUsername());
				System.out.println(ulist[i].getCarnum());

			}

		}
		
		
		
	}
	private void fixinput() {
Scanner in = new Scanner(System.in);
		
		String fixcarnum = in.nextLine();
		Fix fixcar = new Fix();
		
		System.out.println("해당 자동차의 수리 내역 입력");
		String text = in.nextLine();
		fixcar.setFixtext(text);
		System.out.println("해당 자동차의 수리 날짜를 입력하시오");
		int date = in.nextInt();
		in.nextLine();
		fixcar.setFixdate(date);
		
		for(int i = 0; i  < ulist.length; i++) {
			if(fixcarnum.equals(ulist[i].getCarnum())) {
				fixcarresult[i] = fixcar;
			}
		}
	}
}
