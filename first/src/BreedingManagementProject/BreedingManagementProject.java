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
				System.out.println("Breeding Management Project�Դϴ�");
				System.out.println("(1)��ü��� �߰� (2)��ü��� ���� (3)��ü��� ���� (4)��ü��� ��� (5)����");
				System.out.print("�޴��� �Է��� �ֽʽÿ� : "); menu = stdin.nextInt();
				switch(menu) {
				
				case 1:
					do{
						System.out.println("1, Add Insect");
						System.out.print("��ü �ڵ� : ");int category = stdin.nextInt();
						System.out.print("�̸��� �Է� : "); String insect = stdin.next();
						System.out.print("���� �Է� : "); double weight = stdin.nextDouble();
						mode.Add_Insect(category, insect, weight);
						System.out.println();
						System.out.print("�߰��� �����Ͻðڽ��ϱ�? (0(����)/1(�ݺ�)): "); int a = stdin.nextInt();
						
						if(a == 0) {
							break;
						}
						else if(a == 1) {
							continue;
						}
						
						else {
							System.out.println("��ȿ���� ���� �Է��Դϴ�.");
						}
					}while(true);
					break;
					
				case 2:
					System.out.println("2, Delete Insect");
				    System.out.print("������ ������ ���� (0 : ��ü���� / 1 : ���û���) : "); int num = stdin.nextInt();
				    if(num == 1) {
				    	System.out.print("������ ��ü ��ȣ : "); int num2 = stdin.nextInt();
				    	mode.Delete_Insect(num2);
				    }
				    else if(num == 0) {
				    	mode.Info_Name.clear();
				    }
					System.out.println();
					break;
					
				case 3:
					System.out.println("3, Edit Insect");
					System.out.print("������ ��ü ��ȣ : "); int num1 = stdin.nextInt();
					System.out.print("���� : "); double num2 = stdin.nextDouble();
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
					System.out.println("�������� �ʴ� ����Դϴ�.");
				}
				
				if(menu == 5) {
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