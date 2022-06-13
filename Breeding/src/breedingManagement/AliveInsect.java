package breedingManagement;

public class AliveInsect extends Insect{//추상클래스를 상속 받은 자식클래스
	//직렬화에 사용하는 클래스에 붙는 시리얼코드
	private static final long serialVersionUID = -9090613252482453288L;
	public AliveInsect(int id, String name, double weight, String name2, int num, String date, String generation) {//초기화를 위한 생성자 생성
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.name2 = name2;
		this.num = num;
		this.date = date;
		this.generation = generation;
	}
	//개체 편집에서 사용하는 디폴트 생성자
	public AliveInsect() {}
	
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
	
	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getNum() {
		return num;
	}

	public String getDate() {
		return date;
	}
	
	public void setNum(int num) {
		this.num = num;
		
	}
	
	public void setDate(String date) {
		this.date = date;	
	}
	
	public String getGeneration() {
		return generation;
	}
	
	public void setGeneration(String generation) {
		this.generation = generation;
	}
}
