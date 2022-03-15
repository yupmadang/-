package BreedingManagementProject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BreedingManagementProject {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int menu;
		do {
			try {
				System.out.println("Breeding Management Project입니다");
				System.out.println("(1)개체목록 추가 (2)개체목록 제거 (3)개체목록 편집 (4)개체목록 출력 (5)용품제고 확인 (6)종료");
				System.out.print("메뉴를 입력해 주십시오 : "); menu = stdin.nextInt();
				switch(menu) {
				
				case 1:
					System.out.println("1, Add Insect");
					System.out.println();
					break;
				case 2:
					System.out.println("2, Delete Insect");
					System.out.println();
					break;
				case 3:
					System.out.println("3, Edit Insect");
					System.out.println();
					break;
				case 4:
					System.out.println("4, View Insect");
					System.out.println();
					break;
				case 5:
					System.out.println("5, View Stock");
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
		
		
		/*System.out.println("1, Add Insect"); 프로젝트 2주차 변경사항 비교용
		System.out.println("2, Delete Insect");
		System.out.println("3, Edit Insect");
		System.out.println("4, View Insect");
		System.out.println("5, Exit Insect");*/
	}

}
