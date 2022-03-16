package BreedingManagementProject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BreedingManagementProject {
	static Scanner stdin = new Scanner(System.in);
	
	public static void add_Insect(){
		System.out.println("��ü���� �Է� : "); String ins = stdin.next();
		System.out.println("�߰��� ��ü : " + ins);
	}
	
	public static void Delete_Insect(){
		System.out.println("������ ��ü �Է� : "); String ins = stdin.next();
		System.out.println("������ ��ü : " + ins);
	}
	
	public static void Edit_Insect() {
		System.out.println("������ ��ü �Է� : "); String ins = stdin.next();
		System.out.println("������ ��ü : " + ins);
	}
	
	public static void View_Insect() {
		System.out.println("����� ��ü �Է� : "); String ins = stdin.next();
		System.out.println("��µ� ��ü�� : " + ins);
	}
	
	public static void View_Stock() {
		System.out.println("����� ��ǰ �Է� : "); String ins = stdin.next();
		System.out.println("����� ��ǰ : " + ins);
	}
	
	public static void main(String[] args) {
		int menu;
		do {
			try {
				System.out.println("Breeding Management Project�Դϴ�");
				System.out.println("(1)��ü��� �߰� (2)��ü��� ���� (3)��ü��� ���� (4)��ü��� ��� (5)��ǰ���� Ȯ�� (6)����");
				System.out.print("�޴��� �Է��� �ֽʽÿ� : "); menu = stdin.nextInt();
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
					System.out.println("�������� �ʴ� ����Դϴ�.");
				}
				
				if(menu == 6) {
					System.out.println("������Ʈ�� �����մϴ�.");
					System.out.println();
					break;
				}
			}catch(InputMismatchException e) {
				System.out.println("��ȿ���� ���� �Է��Դϴ�. ������Ʈ�� �����մϴ�.");
				break;
			}
		}while(true);
		
		stdin.close();
	}

}
