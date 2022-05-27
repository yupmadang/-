package breedingManagement;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class BreedingMode implements DryInsectInterface, BreedingInterface, Serializable{ 
	static LogClass logger = new LogClass("log.txt");
    /**
	 * 
	 */
	private static final long serialVersionUID = 3499476101535632006L;
	transient Scanner input;
	public BreedingMode(Scanner input) {
		this.input = input;
	}

//�������̽��� ���߻�� ���� BreedingModeŬ����
	//��ü�� ������ ��ũ�帮��Ʈ 3�� ����
	LinkedList<InsectInfo> Info_Name = new LinkedList<>();
	LinkedList<Stock> Info_Stock = new LinkedList<>();
	LinkedList<DryInsect> Info_DryInsect = new LinkedList<>();
	
	//��ü�߰�, ����, ����� ���� ��ü�� ������ ���� ��ü ����
	InsectInfo ins; 
	InsectInfo edit = new InsectInfo();
	Stock sto;
	Stock edit2 = new Stock();
	DryInsect dins;
	DryInsect edit3 = new DryInsect();
	ExcutionClass ex = new ExcutionClass();
	Manual manual = new Manual();
	
	//������ ����ϱ� ���� �޼���
	public void Show_Manual() {
		try {
			BufferedReader buffer = new BufferedReader(new FileReader("Manual.txt"));
			while(true) {
				String str = buffer.readLine();
				if(str == null) {
					break;
				}
				
				System.out.println(str);
			}
			buffer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//������  �������̽��� �޼��� BreedingInterface
	
	@Override
	public void Add_Insect(int id, String name, double weight, String stock) {//��ü �߰� �޼��� ����
		ins = new InsectInfo(id, name, weight);
		sto = new Stock(id, name, stock);
		Info_Name.add(ins);
		Info_Stock.add(sto);		
	}
	
	@Override
	public void	Delete_Insect(int id) {//��ü ���� �޼��� ����
		for(int i = 0; i < Info_Name.size(); i++) {
			if(Info_Name.get(i).getId() == id) {
				Info_Name.remove(i);
			}
		}
		for(int i = 0; i < Info_Stock.size(); i++) {
			if(Info_Stock.get(i).getId() == id) {
				Info_Stock.remove(i);
			}
		}
	}
	
	@Override
	public void Edit_Insect(int id, double weight, int num) { //��ü ���� �޼��� ����
		for(int i = 0; i < Info_Name.size(); i++) {
			if(Info_Name.get(i).getId() == id) {
				edit.setId(Info_Name.get(i).getId());
				edit.setName(Info_Name.get(i).getName());
				edit.setWeight(weight);
				Info_Name.set(i, edit);
			}
		}
		for(int i = 0; i < Info_Stock.size(); i++) {
			if(Info_Stock.get(i).getId() == id) {
				edit2.setId(Info_Stock.get(i).getId());
				edit2.setName(Info_Stock.get(i).getName());
				edit2.setName2(Info_Stock.get(i).getName2());
				edit2.setNum(num);
				Info_Stock.set(i, edit2);
			}
		}
	}
	
	public void Search_Insect(int id) { //��ü �˻� �޼��� ����
		ex.HaveIns();
		for(int i = 0; i < Info_Name.size(); i++) {
			if(Info_Name.get(i).getId() == id) {
				System.out.println(Info_Name.get(i));
			}
		}
		ex.MealIns();
		for(int i = 0; i < Info_Stock.size(); i++) {
			if(Info_Stock.get(i).getId() == id) {
				System.out.println(Info_Stock.get(i));
			}
		}
	}
	
	@Override
	public void Show_Insect() { //��ü ��� �޼��� ����
		Iterator<InsectInfo> ir1 = Info_Name.iterator();
		Iterator<Stock> ir2 = Info_Stock.iterator();
		ex.HaveIns();
		while(ir1.hasNext()) {
			System.out.println(ir1.next());
		}
		System.out.println();
		ex.MealIns();
		while(ir2.hasNext()) {
			System.out.println(ir2.next());
		}
	}
	
	//������  �������̽��� �޼��� BreedingInterface
	
	@Override
	public void Add_Insect(int id, String name, double length, String quality, String label) { //ǥ�� �߰� �޼��� ����
		dins = new DryInsect(id, name, length, quality, label);
		Info_DryInsect.add(dins);
	}
	
	@Override
	public void Delete_Insect(int id, String name, double length) {//ǥ�� ���� �޼��� ����
		for(int i = 0; i < Info_DryInsect.size(); i++) {
			if(Info_DryInsect.get(i).getId() == id && Info_DryInsect.get(i).getLength() == length && Info_DryInsect.get(i).getName().equals(name)) {
				Info_DryInsect.remove(i);
			}
		}
	}
	
	@Override
	public void Edit_Insect(int id, String label, String quality) {//ǥ�� ���� �޼��� ����
		for(int i = 0; i < Info_DryInsect.size(); i++) {
			if(Info_DryInsect.get(i).getId() == id && Info_DryInsect.get(i).getLabel().equals(label)) {
				edit3.setId(Info_DryInsect.get(i).getId());
				edit3.setName(Info_DryInsect.get(i).getName());
				edit3.setLength(Info_DryInsect.get(i).getLength());
				edit3.setQuality(quality);
				edit3.setLabel(Info_DryInsect.get(i).getLabel());
				Info_DryInsect.set(i, edit3);
			}
		}
	}
	
	@Override
	public void Search_DryInsect(int id) {//ǥ�� �˻� �޼��� ����
		for(int i = 0; i < Info_DryInsect.size(); i++) {
			if(Info_DryInsect.get(i).getId() == id) {
				System.out.println(Info_DryInsect.get(i));
			}
		}
	}
	
	@Override
	public void Show_DryInsect() {//ǥ�� ��� �޼��� ����
		Iterator<DryInsect> ir1 = Info_DryInsect.iterator();
		while(ir1.hasNext()) {
			System.out.println(ir1.next());
		}
	}
		
		//�޴� ���ø޼���
	public void selectMenu(Scanner input, BreedingMode object) {
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