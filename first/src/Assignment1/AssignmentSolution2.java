package Assignment1;

import java.util.Scanner;

public class AssignmentSolution2 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int total;
		System.out.print("��带 �Է��ϼ���. : "); int menu = stdin.nextInt();
		System.out.print("�� ���� �Է��ϼ���. : "); int a = stdin.nextInt(); 	int b = stdin.nextInt();
		switch(menu) {
		case 1 :
			total = a + b;
			System.out.println(total);
			break;
		case 2 :
			total = a - b;
			System.out.println(total);
			break;
		case 3 :
			total = a * b;
			System.out.println(total);
			break;
		case 4 :
			total = a / b;
			System.out.println("��� : "+total);
			break;
		default : 
			System.out.println("�������� �ʾƿ�!");
		}
		
		//stdin.close();
	}
}