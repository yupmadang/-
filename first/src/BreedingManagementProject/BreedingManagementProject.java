package BreedingManagementProject;

import java.util.InputMismatchException;
import java.util.HashSet;
import java.util.Scanner;

public class BreedingManagementProject {
	
	public static void add_Insect(HashSet <String> n, String name){
		n.add(name);
		if(n.contains(name) == false) {
			System.out.println("개체의 추가에 실패하였습니다.");
		}
	}
	
	public static void Delete_Insect(HashSet <String> n, String index){
			if(n.contains(index)==true) {
				n.remove(index);
				if(n.contains(index)==true) {
					System.out.println("삭제에 실패하였습니다.");
				}
			}
		}
	
	public static void Edit_Insect(HashSet <String> n, String index, String index2) {
		n.remove(index);
		n.add(index2);
		if(n.contains(index2) == false) {
			System.out.println("값의 변경에 실패하였습니다.");
		}
	}
	
	public static void View_Insect(HashSet <String> n) {
			System.out.println(n.toString());
	}
	
	public static void main(String[] args) {
		HashSet <String> ins = new HashSet <String> ();
		Scanner stdin = new Scanner(System.in);
		int menu;
		do {
			try {
				System.out.println("Breeding Management Project입니다");
				System.out.println("(1)개체목록 추가 (2)개체목록 제거 (3)개체목록 편집 (4)개체목록 출력 (5)종료");
				System.out.print("메뉴를 입력해 주십시오 : "); menu = stdin.nextInt();
				switch(menu) {
				
				case 1:
					System.out.println("1, Add Insect");
					String insect = stdin.next();
					add_Insect(ins, insect);
					System.out.println();
					break;
				case 2:
					System.out.println("2, Delete Insect");
					String insect2 = stdin.next();
					Delete_Insect(ins, insect2);
					System.out.println();
					break;
				case 3:
					System.out.println("3, Edit Insect");
					String insect3 = stdin.next();
					String insect4 = stdin.next();
					Edit_Insect(ins,insect3,insect4);
					System.out.println();
					break;
				case 4:
					System.out.println("4, View Insect");
					View_Insect(ins);
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

