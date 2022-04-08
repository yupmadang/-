package BreedingManagementProject;

public class Stock extends Insect { //Insect 클래스 상속
	
	private String name2;
	private int num = 1;

	public Stock(int id, String name, String name2, int num) { //생성자 생성
		super(id, name, 0.0); //부모 클래스의 생성자를 참조
		this.name2 = name2;
		this.num = num;
	}
	
	public Stock() {//edit2를 위한 디폴트 생성자
	}
	
	public void setNum(int num) {
		this.num= num;	
	}
	
	public int getNum() {
		return num;
	}

	public String getName2() {
		return name2;
	}
	
	public void setName2(String name2) {
		this.name2 = name2;
	}
	
	public String toString() {//출력할 toString 메서드 재정의
		return "[개체 번호 : "+ id + ", 개체명 : " + name +", "+"톱밥 종류 : "+name2+", 교체 횟수: "+num+"]";
	}
	
}
