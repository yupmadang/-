package breedingManagement;

public class AliveInsect extends Insect{//�߻�Ŭ������ ��� ���� �ڽ�Ŭ����
	//����ȭ�� ����ϴ� Ŭ������ �ٴ� �ø����ڵ�
	private static final long serialVersionUID = -9090613252482453288L;
	public AliveInsect(int id, String name, double weight, String name2, int num, String date, String generation) {//�ʱ�ȭ�� ���� ������ ����
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.name2 = name2;
		this.num = num;
		this.date = date;
		this.generation = generation;
	}
	//��ü �������� ����ϴ� ����Ʈ ������
	public AliveInsect() {}
	
	//get, set�޼���
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
