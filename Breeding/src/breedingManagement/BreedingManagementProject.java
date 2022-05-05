package breedingManagement;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BreedingManagementProject {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		BreedingMode mode = new BreedingMode(); //BreedingMode �����ڷ����� mode�̸��� �ν��Ͻ� ����
		//switch ���ǹ��� ����ϱ� ���� ���� menu, menu2�� ����
		int menu;
		int menu2;
		do {
			try {
				System.out.println("Breeding Management Project�Դϴ�");
				System.out.println("(1)��ü��� �߰� (2)��ü��� ���� (3)��ü��� ���� (4)��ü�˻� (5)��ü��� ��� (6)ǥ����� (7)����");
				System.out.print("�޴��� �Է��� �ֽʽÿ� : "); menu = stdin.nextInt();
				switch(menu) {

				case 1://��ü �߰�
					do{//��ü�� ����ڰ� ���ϴ� ��ŭ �Է��� �����ϵ��� �ݺ��� ���
						System.out.println("1, Add Insect");
						System.out.print("��ü �ڵ� : ");int category = stdin.nextInt();
						System.out.print("�̸��� �Է� : "); String insect = stdin.next();
						System.out.print("���� �Է� : "); double weight = stdin.nextDouble();
						System.out.print("������� �Է� : "); String stock = stdin.next();
						mode.Add_Insect(category, insect, weight, stock);
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

				case 2://��ü ����
					System.out.println("2, Delete Insect"); 
				    System.out.print("������ ������ ���� (0 : ��ü���� / 1 : ���û���) : "); int num = stdin.nextInt();
				    if(num == 1) {
				    	System.out.print("������ ��ü ��ȣ : "); int num2 = stdin.nextInt();
				    	mode.Delete_Insect(num2);//Ư�� ��ü�� �����ϱ� ���� Delete_Insect(num2)�޼��� ���
				    }
				    else if(num == 0) {
				    	mode.Info_Name.clear();//����Ʈ�� ���� ��� �����ϴ� �޼���clear()ȣ��
				    }
					System.out.println();
					break;

				case 3://��ü ����
					System.out.println("3, Edit Insect");
					System.out.print("������ ��ü ��ȣ : "); int num1 = stdin.nextInt();//��ü�� �����ϱ� ���� ���̵� �Է�
					System.out.print("���� : "); double num2 = stdin.nextDouble();//�� ��ü�� ������ ���� �Է�
					System.out.print("��ü Ƚ�� : "); int num3 = stdin.nextInt();//��ü ���� ��ü Ƚ�� ����
					mode.Edit_Insect(num1, num2, num3);//Edit_Insect(num1, num2, num3)�޼��� ȣ��
					System.out.println();
					break;
					
				case 4://��ü �˻�
					System.out.println("4, Search_Insect");
					System.out.print("ã�� ��ü�� ��ȣ �Է� : "); int num4 = stdin.nextInt();
					mode.Search_Insect(num4);
					System.out.println();
					break;

				case 5://��ü ���
					System.out.println("4, View Insect");
					mode.Show_Insect();//ShowAll_Insect()�޼��� ȣ��
					System.out.println();
					break;
				
				case 6:
					do {
						try {
							System.out.println("DryInsect Management Mode");
							System.out.println("(1)ǥ���߰� (2)ǥ������ (3)ǥ������ (4)ǥ���˻� (5)ǥ����� ��� (6)����");
							System.out.print("�޴��� �Է��� �ֽʽÿ� : "); menu2 = stdin.nextInt();
							switch(menu2) {

							case 1://ǥ�� �߰�
								do{//����ڰ� ���ϴ� ��ŭ �Է��� �����ϵ��� �ݺ��� ���
									System.out.println("1, Add DryInsect");
									System.out.print("ǥ�� �ڵ� : ");int dcategory = stdin.nextInt();
									System.out.print("�̸��� �Է� : "); String dinsect = stdin.next();
									System.out.print("���� �Է� : "); double length = stdin.nextDouble();
									System.out.print("���� �Է� : "); String quality = stdin.next();
									System.out.print("�� �Է� : "); String label = stdin.next();
									mode.Add_Insect(dcategory, dinsect, length, quality, label);
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

							case 2://ǥ�� ����
								System.out.println("2, Delete DryInsect"); 
							    System.out.print("������ ������ ���� (0 : ��ü���� / 1 : ���û���) : "); int num5 = stdin.nextInt();
							    if(num5 == 1) {
							    	System.out.print("������ ǥ�� �� : "); String label = stdin.next();
							    	mode.Delete_Insect(label);//Ư�� ��ü�� �����ϱ� ���� Delete_Insect(num2)�޼��� ���
							    }
							    else if(num5 == 0) {
							    	mode.Info_Name.clear();//����Ʈ�� ���� ��� �����ϴ� �޼���clear()ȣ��
							    }
								System.out.println();
								break;

							case 3://ǥ�� ����
								System.out.println("3, Edit DryInsect");
								System.out.print("ã�� ǥ���� ��ȣ : "); int num6 = stdin.nextInt();
								System.out.print("������ ǥ���� : "); String label = stdin.next();
								System.out.print("�����Է� : "); String quality = stdin.next();
								mode.Edit_Insect(num6, label, quality);//Edit_Insect �޼��� ȣ��
								System.out.println();
								break;
								
							case 4://ǥ�� �˻�
								System.out.println("4, Search_DryInsect");
								System.out.print("ã�� ��ü�� ��ȣ �Է� : "); int num7 = stdin.nextInt();
								mode.Search_DryInsect(num7);//Search_DryInsect()�޼��� ȣ��
								System.out.println();
								break;

							case 5://ǥ�� ���
								System.out.println("4, View DryInsect");
								mode.Show_DryInsect();//ShowAll_DryInsect()�޼��� ȣ��
								System.out.println();
								break;
							}

							if(menu2 > 6 || menu2 < 1) {//����� ���� ������ ��� ���
								System.out.println("�������� �ʴ� ����Դϴ�.");
							}

							if(menu2 == 6) {//���α׷� ����
								System.out.println("������Ʈ�� �����մϴ�.");
								System.out.println();
								break;
							}
						}catch(InputMismatchException e) {//�Է��� �ڷ����� ������ �ڷ����� �ٸ� ��� ����ó��
							System.out.println("��ȿ���� ���� �Է��Դϴ�. ������Ʈ�� �����մϴ�.");
							break;
						}
					}while(true);
					break;
				}
				
				if(menu > 7 || menu < 1) {//����� ���� ������ ��� ���
					System.out.println("�������� �ʴ� ����Դϴ�.");
				}

				if(menu == 7) {//���α׷� ����
					System.out.println("������Ʈ�� �����մϴ�.");
					System.out.println();
					break;
				}
			}catch(InputMismatchException e) {//�Է��� �ڷ����� ������ �ڷ����� �ٸ� ��� ����ó��
				System.out.println("��ȿ���� ���� �Է��Դϴ�. ������Ʈ�� �����մϴ�.");
				break;
			}
		}while(true);

		stdin.close(); //��Ʈ�� �ݱ�
	}
}