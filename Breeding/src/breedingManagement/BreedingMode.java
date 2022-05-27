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

//인터페이스를 다중상속 받은 BreedingMode클래스
	//객체를 저장할 링크드리스트 3개 선언
	LinkedList<InsectInfo> Info_Name = new LinkedList<>();
	LinkedList<Stock> Info_Stock = new LinkedList<>();
	LinkedList<DryInsect> Info_DryInsect = new LinkedList<>();
	
	//개체추가, 제거, 출력을 위한 객체와 편집을 위한 객체 생성
	InsectInfo ins; 
	InsectInfo edit = new InsectInfo();
	Stock sto;
	Stock edit2 = new Stock();
	DryInsect dins;
	DryInsect edit3 = new DryInsect();
	ExcutionClass ex = new ExcutionClass();
	Manual manual = new Manual();
	
	//설명서를 출력하기 위한 메서드
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
	
	//참조한  인터페이스의 메서드 BreedingInterface
	
	@Override
	public void Add_Insect(int id, String name, double weight, String stock) {//개체 추가 메서드 구현
		ins = new InsectInfo(id, name, weight);
		sto = new Stock(id, name, stock);
		Info_Name.add(ins);
		Info_Stock.add(sto);		
	}
	
	@Override
	public void	Delete_Insect(int id) {//개체 삭제 메서드 구현
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
	public void Edit_Insect(int id, double weight, int num) { //개체 편집 메서드 구현
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
	
	public void Search_Insect(int id) { //개체 검색 메서드 구현
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
	public void Show_Insect() { //개체 출력 메서드 구현
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
	
	//참조한  인터페이스의 메서드 BreedingInterface
	
	@Override
	public void Add_Insect(int id, String name, double length, String quality, String label) { //표본 추가 메서드 구현
		dins = new DryInsect(id, name, length, quality, label);
		Info_DryInsect.add(dins);
	}
	
	@Override
	public void Delete_Insect(int id, String name, double length) {//표본 제거 메서드 구현
		for(int i = 0; i < Info_DryInsect.size(); i++) {
			if(Info_DryInsect.get(i).getId() == id && Info_DryInsect.get(i).getLength() == length && Info_DryInsect.get(i).getName().equals(name)) {
				Info_DryInsect.remove(i);
			}
		}
	}
	
	@Override
	public void Edit_Insect(int id, String label, String quality) {//표본 편집 메서드 구현
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
	public void Search_DryInsect(int id) {//표본 검색 메서드 구현
		for(int i = 0; i < Info_DryInsect.size(); i++) {
			if(Info_DryInsect.get(i).getId() == id) {
				System.out.println(Info_DryInsect.get(i));
			}
		}
	}
	
	@Override
	public void Show_DryInsect() {//표본 출력 메서드 구현
		Iterator<DryInsect> ir1 = Info_DryInsect.iterator();
		while(ir1.hasNext()) {
			System.out.println(ir1.next());
		}
	}
		
		//메뉴 선택메서드
	public void selectMenu(Scanner input, BreedingMode object) {
		int menu;
		int menu2;
		do {
			try {
				System.out.println("Breeding Management Project입니다");
				System.out.println("(1)개체목록 추가 (2)개체목록 제거 (3)개체목록 편집 (4)개체검색 (5)개체목록 출력 (6)표본모드 (7)종료 (8)설명서");			
				System.out.print("메뉴를 입력해 주십시오 : "); menu = input.nextInt();
				switch(menu) {

				case 1://개체 추가
					do{//개체를 사용자가 원하는 만큼 입력이 가능하도록 반복문 사용
						try {
							System.out.println("1, Add Insect");
							System.out.print("개체 코드 : ");int category = input.nextInt();
							System.out.print("이름을 입력 : "); String insect = input.next();
							System.out.print("무게 입력 : "); double weight = input.nextDouble();
							System.out.print("톱밥종류 입력 : "); String stock = input.next();
							object.Add_Insect(category, insect, weight, stock);
							System.out.println();
							System.out.print("추가를 종료하시겠습니까? (0(종료)/1(반복)): "); int a = input.nextInt();

							if(a == 0) {
								logger.log("개체를 추가하였습니다.");
								System.out.println();
								break;
							}
							else if(a == 1) {
								logger.log("개체 추가를 계속합니다.");
								System.out.println();
								continue;
							}
							else {
								logger.log("개체추가 조건문 예외가 발생하였습니다.");
								break;
							}
						}catch (Exception e) {
							logger.log("입력값 타입 예외가 발생하였습니다.");
							input.nextLine();
							System.out.println();
							break;
						}
					}while(true);
					break;

				case 2://개체 제거
					try {
						System.out.println("2, Delete Insect"); 
						System.out.print("삭제할 유형을 선택 (0 : 전체삭제 / 1 : 선택삭제) : "); int num = input.nextInt();
						if(num == 1) {
							System.out.print("삭제할 개체 번호 : "); int num2 = input.nextInt();
							object.Delete_Insect(num2);//특정 개체를 삭제하기 위해 Delete_Insect(num2)메서드 사용
							logger.log("개체를 제거하였습니다.");
						}
						else if(num == 0) {
							object.Info_Name.clear();
							object.Info_Stock.clear();//리스트의 값을 모드 제거하는 메서드clear()호출
							logger.log("개체목록 전체를 제거하였습니다.");
							System.out.println();
						}
						else {
							logger.log("개체제거 조건문 예외가 발생하였습니다.");
							System.out.println();
						}
						System.out.println();
						break;
					}catch (Exception e) {					
						logger.log("입력값 타입 예외가 발생하였습니다.");
						input.nextLine();
						System.out.println();
						break;
					}

				case 3://개체 편집
					try {
						System.out.println("3, Edit Insect");
						System.out.print("변경할 개체 번호 : "); int num1 = input.nextInt();//개체를 구분하기 위한 아이디 입력
						System.out.print("무게 : "); double num2 = input.nextDouble();//그 개체의 변경할 무게 입력
						System.out.print("교체 횟수 : "); int num3 = input.nextInt();//개체 먹이 교체 횟수 변경
						object.Edit_Insect(num1, num2, num3);//Edit_Insect(num1, num2, num3)메서드 호출
						System.out.println();
						logger.log("개체정보를 수정하였습니다.");
						break;
					}catch (Exception e) {
						logger.log("개체 입력값 타입 예외가 발생하였습니다.");
						input.nextLine();
						System.out.println();
						break;
					}
						
				case 4://개체 검색
					try {
						System.out.println("4, Search_Insect");
						System.out.print("찾을 개체의 번호 입력 : "); int num4 = input.nextInt();
						object.Search_Insect(num4);
						logger.log("개체를 검색하였습니다.");
						System.out.println();
						break;
					}catch (Exception e) {
						logger.log("개체 입력값 타입 예외가 발생하였습니다.");
						input.nextLine();
						System.out.println();
						break;
					}
				case 5://개체 출력
					System.out.println("5, View Insect");
					object.Show_Insect();//ShowAll_Insect()메서드 호출
					logger.log("개체목록을 출력하였습니다.");
					System.out.println();
					break;
				
				case 6:
					System.out.println();
					logger.log("표본모드를 실행합니다.");
					System.out.println();
					do {
						try {
							System.out.println("DryInsect Management Mode");
							System.out.println("(1)표본추가 (2)표본제거 (3)표본편집 (4)표본검색 (5)표본목록 출력 (6)종료");
							System.out.print("메뉴를 입력해 주십시오 : "); menu2 = input.nextInt();
							switch(menu2) {
							case 1://표본 추가
								do{//사용자가 원하는 만큼 입력이 가능하도록 반복문 사용
									try {
										System.out.println("1, Add DryInsect");
										System.out.print("표본 코드 : ");int dcategory = input.nextInt();
										System.out.print("이름을 입력 : "); String dinsect = input.next();
										System.out.print("길이 입력 : "); double length = input.nextDouble();
										System.out.print("상태 입력 : "); String quality = input.next();
										System.out.print("라벨 입력 : "); String label = input.next();
										object.Add_Insect(dcategory, dinsect, length, quality, label);
										System.out.println();
										System.out.print("추가를 종료하시겠습니까? (0(종료)/1(반복)): "); int a = input.nextInt();
										if(a == 0) {
											logger.log("개체를 추가하였습니다.");
											System.out.println();
											break;
										}
										else if(a == 1) {
											logger.log("개체 추가를 계속합니다.");
											System.out.println();
											continue;
										}

										else {
											logger.log("개체추가 조건문 예외가 발생하였습니다.");
											System.out.println();
											break;
										}
									}catch(Exception e) {
										logger.log("입력값 타입 예외가 발생하였습니다.");
										input.nextLine();
										break;
									}
										
								}while(true);
								break;

							case 2://표본 제거
								try {
									System.out.println("2, Delete DryInsect"); 
								    System.out.print("삭제할 유형을 선택 (0 : 전체삭제 / 1 : 선택삭제) : "); int num5 = input.nextInt();
								    if(num5 == 1) {
								    	System.out.print("삭제할 표본 아이디 : "); int id = input.nextInt();
								    	System.out.print("삭제할 표본 길이 : "); double length = input.nextDouble();
								    	System.out.print("삭제할 표본 이름 : "); String name = input.next();
									   	object.Delete_Insect(id, name, length);//특정 개체를 삭제하기 위해 Delete_Insect(num2)메서드 사용
									   	logger.log("표본을 목록에서 제거하였습니다.");
									}
									else if(num5 == 0) {
								    	object.Info_DryInsect.clear();//리스트의 값을 모드 제거하는 메서드clear()호출
									   	logger.log("표본목록 전체를 제거하였습니다.");
									   	System.out.println();
									}
									System.out.println();
									break;
								}catch (Exception e) {
									logger.log("입력값 타입 예외가 발생하였습니다.");
									input.nextLine();
									System.out.println();
									break;
								}
									
							case 3://표본 편집
								try {
									System.out.println("3, Edit DryInsect");
									System.out.print("찾을 표본의 번호 : "); int num6 = input.nextInt();
									System.out.print("변경할 표본라벨 : "); String label = input.next();
									System.out.print("상태입력 : "); String quality = input.next();
									object.Edit_Insect(num6, label, quality);//Edit_Insect 메서드 호출
									logger.log("표본 정보를 수정했습니다.");
									System.out.println();
									break;
								}catch (Exception e) {
									logger.log("입력값 타입 예외가 발생하였습니다.");
									input.nextLine();
									System.out.println();
									break;
								}
								
							case 4://표본 검색
								try {
									System.out.println("4, Search_DryInsect");
									System.out.print("찾을 개체의 번호 입력 : "); int num7 = input.nextInt();
									object.Search_DryInsect(num7);//Search_DryInsect()메서드 호출
									logger.log("표본을 검색했습니다.");
									System.out.println();
									break;
								}catch (Exception e) {
									logger.log("입력값 타입 예외가 발생하였습니다.");
									input.nextLine();
									System.out.println();
									break;
								}

							case 5://표본 출력
								System.out.println("5, View DryInsect");
								object.Show_DryInsect();//ShowAll_DryInsect()메서드 호출
								logger.log("표본목록을 출력하였습니다.");
								System.out.println();
								break;
							}
								
							if(menu2 == 6) {
								logger.log("표본모드를 종료했습니다.");
								System.out.println();
								break;
							}

							if(menu2 > 6 || menu2 < 1) {//모드의 값이 범위를 벗어난 경우
								logger.log("표본모드 입력값 조건문 예외가 발생하였습니다.");
							}

						}catch(InputMismatchException e) {//입력의 자료형과 변수의 자료형이 다를 경우 예외처리
							logger.log("표본모드 입력값 타입 예외가 발생하였습니다.");
							break;
						}
					}while(true);
					break;
						
				case 8:
					logger.log("설명서를 열었습니다");
					object.Show_Manual();
					System.out.println();
					break;
				}
					
				if(menu == 7) {
					System.out.println();
					logger.log("프로젝트를 종료하였습니다.");
					break;
				}
					
				if(menu > 8 || menu < 1) {//모드의 값이 범위를 벗어난 경우
					logger.log("모드 범위 조건문 예외가 발생하였습니다.");
				}

			}catch(InputMismatchException e) {//입력의 자료형과 변수의 자료형이 다를 경우 예외처리
				logger.log("모드 입력값 타입 예외가 발생하였습니다.");
				break;
			}
		}while(true);
		input.close(); //스트림 닫기
	}
}