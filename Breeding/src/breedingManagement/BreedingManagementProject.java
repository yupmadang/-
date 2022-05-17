package breedingManagement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;
//����ȭ�� ������ ������Ʈ
public class BreedingManagementProject implements Serializable{
	private static final long serialVersionUID = 6607174531419980773L;
	//���� �о���� �޼��� : ������Ʈ�� �����ϱ� ���� �M���Ͽ� ������ ���� ������ ����
	static BreedingMode getObject(String fileName) {
		BreedingMode br = null;
		FileInputStream file;
		try {
			file = new FileInputStream("Breeding.txt");
			ObjectInputStream in = new ObjectInputStream(file);
			br = (BreedingMode) in.readObject();
			
			in.close();
			file.close();
			
		} catch (FileNotFoundException e) {
			return br;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return br;
	}
	//���ϻ����޼��� : ������Ʈ�� ����Ǹ� ������Ʈ
	static void PutObject(BreedingMode mode ,String fileName) { 
		try {
			FileOutputStream file1 = new FileOutputStream("Breeding.txt");
			ObjectOutputStream out = new ObjectOutputStream(file1);
			out.writeObject(mode);
			
			out.close();
			file1.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//�α� ������ �������� ���� : 1���� ���ϸ� ������
	static LogClass logger = new LogClass("log.txt");

	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		BreedingMode breedingMode = getObject("Breeding.ser");
		
		if(breedingMode == null) {
			breedingMode = new BreedingMode(input);
		}
		
		selectMenu(input, breedingMode);
		PutObject(breedingMode, "Breeding.ser");
	}
	
	//�޴� ���ø޼���
	
	static void selectMenu(Scanner input, BreedingMode object) {
		int menu;
		int menu2;
		do {
			try {
				System.out.println("Breeding Management Project�Դϴ�");
				System.out.println("(1)��ü��� �߰� (2)��ü��� ���� (3)��ü��� ���� (4)��ü�˻� (5)��ü��� ��� (6)ǥ����� (7)���� (8)����");
				System.out.print("�޴��� �Է��� �ֽʽÿ� : "); menu = input.nextInt();
				switch(menu) {

				case 1://��ü �߰�
					do{//��ü�� ����ڰ� ���ϴ� ��ŭ �Է��� �����ϵ��� �ݺ��� ���
						try {
							System.out.println("1, Add Insect");
							System.out.print("��ü �ڵ� : ");int category = input.nextInt();
							System.out.print("�̸��� �Է� : "); String insect = input.next();
							System.out.print("���� �Է� : "); double weight = input.nextDouble();
							System.out.print("������� �Է� : "); String stock = input.next();
							object.Add_Insect(category, insect, weight, stock);
							System.out.println();
							System.out.print("�߰��� �����Ͻðڽ��ϱ�? (0(����)/1(�ݺ�)): "); int a = input.nextInt();

							if(a == 0) {
								logger.log("��ü�� �߰��Ͽ����ϴ�.");
								System.out.println();
								break;
							}
							else if(a == 1) {
								logger.log("��ü �߰��� ����մϴ�.");
								System.out.println();
								continue;
							}

							else {
								logger.log("��ü�߰� ���ǹ� ���ܰ� �߻��Ͽ����ϴ�.");
								break;
							}
						}catch (Exception e) {
							logger.log("�Է°� Ÿ�� ���ܰ� �߻��Ͽ����ϴ�.");
							input.nextLine();
							System.out.println();
							break;
						}
					}while(true);
					break;

				case 2://��ü ����
					try {
						System.out.println("2, Delete Insect"); 
						System.out.print("������ ������ ���� (0 : ��ü���� / 1 : ���û���) : "); int num = input.nextInt();
						if(num == 1) {
							System.out.print("������ ��ü ��ȣ : "); int num2 = input.nextInt();
							object.Delete_Insect(num2);//Ư�� ��ü�� �����ϱ� ���� Delete_Insect(num2)�޼��� ���
							logger.log("��ü�� �����Ͽ����ϴ�.");
						}
						else if(num == 0) {
							object.Info_Name.clear();
							object.Info_Stock.clear();//����Ʈ�� ���� ��� �����ϴ� �޼���clear()ȣ��
							logger.log("��ü��� ��ü�� �����Ͽ����ϴ�.");
							System.out.println();
						}
						else {
							logger.log("��ü���� ���ǹ� ���ܰ� �߻��Ͽ����ϴ�.");
							System.out.println();
						}
						System.out.println();
						break;
					}catch (Exception e) {
						
						logger.log("�Է°� Ÿ�� ���ܰ� �߻��Ͽ����ϴ�.");
						input.nextLine();
						System.out.println();
						break;
					}

				case 3://��ü ����
					try {
						System.out.println("3, Edit Insect");
						System.out.print("������ ��ü ��ȣ : "); int num1 = input.nextInt();//��ü�� �����ϱ� ���� ���̵� �Է�
						System.out.print("���� : "); double num2 = input.nextDouble();//�� ��ü�� ������ ���� �Է�
						System.out.print("��ü Ƚ�� : "); int num3 = input.nextInt();//��ü ���� ��ü Ƚ�� ����
						object.Edit_Insect(num1, num2, num3);//Edit_Insect(num1, num2, num3)�޼��� ȣ��
						System.out.println();
						logger.log("��ü������ �����Ͽ����ϴ�.");
						break;
					}catch (Exception e) {
						logger.log("��ü �Է°� Ÿ�� ���ܰ� �߻��Ͽ����ϴ�.");
						input.nextLine();
						System.out.println();
						break;
					}
					
				case 4://��ü �˻�
					try {
						System.out.println("4, Search_Insect");
						System.out.print("ã�� ��ü�� ��ȣ �Է� : "); int num4 = input.nextInt();
						object.Search_Insect(num4);
						logger.log("��ü�� �˻��Ͽ����ϴ�.");
						System.out.println();
						break;
					}catch (Exception e) {
						logger.log("��ü �Է°� Ÿ�� ���ܰ� �߻��Ͽ����ϴ�.");
						input.nextLine();
						System.out.println();
						break;
					}
				case 5://��ü ���
					System.out.println("5, View Insect");
					object.Show_Insect();//ShowAll_Insect()�޼��� ȣ��
					logger.log("��ü����� ����Ͽ����ϴ�.");
					System.out.println();
					break;
				
				case 6:
					System.out.println();
					logger.log("ǥ����带 �����մϴ�.");
					System.out.println();
					do {
						try {
							System.out.println("DryInsect Management Mode");
							System.out.println("(1)ǥ���߰� (2)ǥ������ (3)ǥ������ (4)ǥ���˻� (5)ǥ����� ��� (6)����");
							System.out.print("�޴��� �Է��� �ֽʽÿ� : "); menu2 = input.nextInt();
							switch(menu2) {

							case 1://ǥ�� �߰�
								do{//����ڰ� ���ϴ� ��ŭ �Է��� �����ϵ��� �ݺ��� ���
									try {
										System.out.println("1, Add DryInsect");
										System.out.print("ǥ�� �ڵ� : ");int dcategory = input.nextInt();
										System.out.print("�̸��� �Է� : "); String dinsect = input.next();
										System.out.print("���� �Է� : "); double length = input.nextDouble();
										System.out.print("���� �Է� : "); String quality = input.next();
										System.out.print("�� �Է� : "); String label = input.next();
										object.Add_Insect(dcategory, dinsect, length, quality, label);
										System.out.println();
										System.out.print("�߰��� �����Ͻðڽ��ϱ�? (0(����)/1(�ݺ�)): "); int a = input.nextInt();

										if(a == 0) {
											logger.log("��ü�� �߰��Ͽ����ϴ�.");
											System.out.println();
											break;
										}
										else if(a == 1) {
											logger.log("��ü �߰��� ����մϴ�.");
											System.out.println();
											continue;
										}

										else {
											logger.log("��ü�߰� ���ǹ� ���ܰ� �߻��Ͽ����ϴ�.");
											System.out.println();
											break;
										}
									}catch(Exception e) {
										logger.log("�Է°� Ÿ�� ���ܰ� �߻��Ͽ����ϴ�.");
										input.nextLine();
										break;
									}
									
								}while(true);
								break;

							case 2://ǥ�� ����
								try {
									System.out.println("2, Delete DryInsect"); 
								    System.out.print("������ ������ ���� (0 : ��ü���� / 1 : ���û���) : "); int num5 = input.nextInt();
								    if(num5 == 1) {
								    	System.out.print("������ ǥ�� ���̵� : "); int id = input.nextInt();
								    	System.out.print("������ ǥ�� ���� : "); double length = input.nextDouble();
								    	System.out.print("������ ǥ�� �̸� : "); String name = input.next();
								    	object.Delete_Insect(id, name, length);//Ư�� ��ü�� �����ϱ� ���� Delete_Insect(num2)�޼��� ���
								    	logger.log("ǥ���� ��Ͽ��� �����Ͽ����ϴ�.");
								    }
								    else if(num5 == 0) {
								    	object.Info_DryInsect.clear();//����Ʈ�� ���� ��� �����ϴ� �޼���clear()ȣ��
								    	logger.log("ǥ����� ��ü�� �����Ͽ����ϴ�.");
								    	System.out.println();
								    }
									System.out.println();
									break;
								}catch (Exception e) {
									logger.log("�Է°� Ÿ�� ���ܰ� �߻��Ͽ����ϴ�.");
									input.nextLine();
									System.out.println();
									break;
								}
								
							case 3://ǥ�� ����
								try {
									System.out.println("3, Edit DryInsect");
									System.out.print("ã�� ǥ���� ��ȣ : "); int num6 = input.nextInt();
									System.out.print("������ ǥ���� : "); String label = input.next();
									System.out.print("�����Է� : "); String quality = input.next();
									object.Edit_Insect(num6, label, quality);//Edit_Insect �޼��� ȣ��
									logger.log("ǥ�� ������ �����߽��ϴ�.");
									System.out.println();
									break;
								}catch (Exception e) {
									logger.log("�Է°� Ÿ�� ���ܰ� �߻��Ͽ����ϴ�.");
									input.nextLine();
									System.out.println();
									break;
								}
								
							case 4://ǥ�� �˻�
								try {
									System.out.println("4, Search_DryInsect");
									System.out.print("ã�� ��ü�� ��ȣ �Է� : "); int num7 = input.nextInt();
									object.Search_DryInsect(num7);//Search_DryInsect()�޼��� ȣ��
									logger.log("ǥ���� �˻��߽��ϴ�.");
									System.out.println();
									break;
								}catch (Exception e) {
									logger.log("�Է°� Ÿ�� ���ܰ� �߻��Ͽ����ϴ�.");
									input.nextLine();
									System.out.println();
									break;
								}

							case 5://ǥ�� ���
								System.out.println("5, View DryInsect");
								object.Show_DryInsect();//ShowAll_DryInsect()�޼��� ȣ��
								logger.log("ǥ������� ����Ͽ����ϴ�.");
								System.out.println();
								break;
							}
							
							if(menu2 == 6) {
								logger.log("ǥ����带 �����߽��ϴ�.");
								System.out.println();
								break;
							}

							if(menu2 > 6 || menu2 < 1) {//����� ���� ������ ��� ���
								logger.log("ǥ����� �Է°� ���ǹ� ���ܰ� �߻��Ͽ����ϴ�.");
							}

						}catch(InputMismatchException e) {//�Է��� �ڷ����� ������ �ڷ����� �ٸ� ��� ����ó��
							logger.log("ǥ����� �Է°� Ÿ�� ���ܰ� �߻��Ͽ����ϴ�.");
							break;
						}
					}while(true);
					break;
					
				case 8:
					logger.log("������ �������ϴ�");
					object.Show_Manual();
					System.out.println();
					break;
				}
				
				if(menu == 7) {
					System.out.println();
					logger.log("������Ʈ�� �����Ͽ����ϴ�.");
					break;
				}
				
				if(menu > 8 || menu < 1) {//����� ���� ������ ��� ���
					logger.log("��� ���� ���ǹ� ���ܰ� �߻��Ͽ����ϴ�.");
				}

			}catch(InputMismatchException e) {//�Է��� �ڷ����� ������ �ڷ����� �ٸ� ��� ����ó��
				logger.log("��� �Է°� Ÿ�� ���ܰ� �߻��Ͽ����ϴ�.");
				break;
			}
		}while(true);

		input.close(); //��Ʈ�� �ݱ�
	}
}