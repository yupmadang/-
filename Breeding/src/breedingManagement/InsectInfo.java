package breedingManagement;

public class InsectInfo extends Insect{
	
	public InsectInfo(int id, String name, double weight) {
		this.id = id;
		this.name = name;
		this.weight = weight;
	}
	
	public InsectInfo() {}
	
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
	
	public String toString() {
		return "[��ü ��ȣ : "+ id + ", ��ü�� : " + name +", "+"���� : "+weight+"g, ���Գ�¥: "+time1+"]";
	}
	
	
}
