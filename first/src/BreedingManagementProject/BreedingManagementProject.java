package BreedingManagementProject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BreedingManagementProject {
	
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		BreedingMode mode = new BreedingMode();
		int menu;
		do {
			try {
				System.out.println("Breeding Management Project입니다");
				System.out.println("(1)개체목록 추가 (2)개체목록 제거 (3)개체목록 편집 (4)개체목록 출력 (5)종료");
				System.out.print("메뉴를 입력해 주십시오 : "); menu = stdin.nextInt();
				switch(menu) {
				
				case 1:
					do{
						System.out.println("1, Add Insect");
						System.out.print("개체 코드 : ");int category = stdin.nextInt();
						System.out.print("이름을 입력 : "); String insect = stdin.next();
						System.out.print("무게 입력 : "); double weight = stdin.nextDouble();
						mode.Add_Insect(category, insect, weight);
						System.out.println();
						System.out.print("추가를 종료하시겠습니까? (0(종료)/1(반복)): "); int a = stdin.nextInt();
						
						if(a == 0) {
							break;
						}
						else if(a == 1) {
							continue;
						}
						
						else {
							System.out.println("유효하지 않은 입력입니다.");
						}
					}while(true);
					break;
					
				case 2:
					System.out.println("2, Delete Insect");
				    System.out.print("삭제할 유형을 선택 (0 : 전체삭제 / 1 : 선택삭제) : "); int num = stdin.nextInt();
				    if(num == 1) {
				    	System.out.print("삭제할 개체 번호 : "); int num2 = stdin.nextInt();
				    	mode.Delete_Insect(num2);
				    }
				    else if(num == 0) {
				    	mode.Info_Name.clear();
				    }
					System.out.println();
					break;
					
				case 3:
					System.out.println("3, Edit Insect");
					System.out.print("변경할 개체 번호 : "); int num1 = stdin.nextInt();
					System.out.print("무게 : "); double num2 = stdin.nextDouble();
					mode.Edit_Insect(num1, num2);
					System.out.println();
					break;
					
				case 4:
					System.out.println("4, View Insect");
					mode.ShowAll_Insect();
					System.out.println();
					break;
				}
			
				if(menu > 5 || menu < 1) {
					System.out.println("지원하지 않는 모드입니다.");
				}
				
				if(menu == 5) {
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