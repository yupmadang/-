package BreedingManagementProject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BreedingManagementProject {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int menu;
		do {
			try {
				System.out.println("Breeding Management Project�Դϴ�");
				System.out.println("(1)��ü��� �߰� (2)��ü��� ���� (3)��ü��� ���� (4)��ü��� ��� (5)��ǰ���� Ȯ�� (6)����");
				System.out.print("�޴��� �Է��� �ֽʽÿ� : "); menu = stdin.nextInt();
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
		
		
		/*System.out.println("1, Add Insect"); ������Ʈ 2���� ������� �񱳿�
		System.out.println("2, Delete Insect");
		System.out.println("3, Edit Insect");
		System.out.println("4, View Insect");
		System.out.println("5, Exit Insect");*/
	}

}
