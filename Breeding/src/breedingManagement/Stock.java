package breedingManagement;

public class Stock extends Insect {//추상클래스를 상속 받는 자식클래스

	private String name2;
	private int num = 1;

	public Stock(int id, String name, String name2) {
		this.id = id;
		this.name = name;
		this.name2 = name2;
	}

	public Stock() {}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id= id;	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	@Override//추상클래스에 있던 메서드를 오버라이드
	public String toString() {
		return "[개체 번호 : "+ id + ", 개체명 : " + name +", "+"톱밥 종류 : "+name2+", 교체 횟수: "+num+"회]";
	}
}