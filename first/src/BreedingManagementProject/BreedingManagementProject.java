package BreedingManagementProject;

import java.util.InputMismatchException;
import java.util.HashSet;
import java.util.Scanner;

public class BreedingManagementProject {
	
	public static void add_Insect(HashSet <String> n, String name){
		n.add(name);
		if(n.contains(name) == false) {
			System.out.println("��ü�� �߰��� �����Ͽ����ϴ�.");
		}
	}
	
	public static void Delete_Insect(HashSet <String> n, String index){
			if(n.contains(index)==true) {
				n.remove(index);
				if(n.contains(index)==true) {
					System.out.println("������ �����Ͽ����ϴ�.");
				}
			}
		}
	
	public static void Edit_Insect(HashSet <String> n, String index, String index2) {
		n.remove(index);
		n.add(index2);
		if(n.contains(index2) == false) {
			System.out.println("���� ���濡 �����Ͽ����ϴ�.");
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
				System.out.println("Breeding Management Project�Դϴ�");
				System.out.println("(1)��ü��� �߰� (2)��ü��� ���� (3)��ü��� ���� (4)��ü��� ��� (5)����");
				System.out.print("�޴��� �Է��� �ֽʽÿ� : "); menu = stdin.nextInt();
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

