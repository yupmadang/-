package breedingManagement;

public class InsectInfo extends Insect{//추상클래스를 상속 받은 자식클래스
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9090613252482453288L;

	public InsectInfo(int id, String name, double weight) {//초기화를 위한 생성자 생성
		this.id = id;
		this.name = name;
		this.weight = weight;
	}
	
	public InsectInfo() {}
	//get, set메서드
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
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	@Override //추상클래스에 있던 메서드를 오버라이드
	public String toString() {
		return "[개체 번호 : "+ id + ", 개체명 : " + name +", "+"무게 : "+weight+"g, 투입날짜: "+time1+"]";
	}
	
	
}
