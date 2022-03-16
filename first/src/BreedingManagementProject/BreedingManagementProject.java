package BreedingManagementProject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BreedingManagementProject {
	static Scanner stdin = new Scanner(System.in);
	
	public static void add_Insect(){
		System.out.println("개체명을 입력 : "); String ins = stdin.next();
		System.out.println("추가된 개체 : " + ins);
	}
	
	public static void Delete_Insect(){
		System.out.println("삭제할 개체 입력 : "); String ins = stdin.next();
		System.out.println("삭제된 개체 : " + ins);
	}
	
	public static void Edit_Insect() {
		System.out.println("수정할 개체 입력 : "); String ins = stdin.next();
		System.out.println("수정된 개체 : " + ins);
	}
	
	public static void View_Insect() {
		System.out.println("출력할 개체 입력 : "); String ins = stdin.next();
		System.out.println("출력된 개체들 : " + ins);
	}
	
	public static void View_Stock() {
		System.out.println("출력할 물품 입력 : "); String ins = stdin.next();
		System.out.println("출력한 뭏품 : " + ins);
	}
	
	public static void main(String[] args) {
		int menu;
		do {
			try {
				System.out.println("Breeding Management Project입니다");
				System.out.println("(1)개체목록 추가 (2)개체목록 제거 (3)개체목록 편집 (4)개체목록 출력 (5)용품제고 확인 (6)종료");
				System.out.print("메뉴를 입력해 주십시오 : "); menu = stdin.nextInt();
				switch(menu) {
				
				case 1:
					System.out.println("1, Add Insect");
					add_Insect();
					System.out.println();
					break;
				case 2:
					System.out.println("2, Delete Insect");
					Delete_Insect();
					System.out.println();
					break;
				case 3:
					System.out.println("3, Edit Insect");
					Edit_Insect();
					System.out.println();
					break;
				case 4:
					System.out.println("4, View Insect");
					View_Insect();
					System.out.println();
					break;
				case 5:
					System.out.println("5, View Stock");
					View_Stock();
					System.out.println();
					break;
				}
				if(menu > 6 || menu < 1) {
					System.out.println("지원하지 않는 모드입니다.");
				}
				
				if(menu == 6) {
					System.out.println("프로젝트를 종료합니다.");
					System.out.println();
					break;
				}
			}catch(InputMismatchException e) {
				System.out.println("유효하지 않은 입력입니다. 프로젝트를 종료합니다.");
				break;
			}
		}while(true);
		
		stdin.close();
	}

}
