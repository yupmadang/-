package breedingManagement;

public class InsectInfo extends Insect{//�߻�Ŭ������ ��� ���� �ڽ�Ŭ����
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9090613252482453288L;

	public InsectInfo(int id, String name, double weight) {//�ʱ�ȭ�� ���� ������ ����
		this.id = id;
		this.name = name;
		this.weight = weight;
	}
	
	public InsectInfo() {}
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
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	@Override //�߻�Ŭ������ �ִ� �޼��带 �������̵�
	public String toString() {
		return "[��ü ��ȣ : "+ id + ", ��ü�� : " + name +", "+"���� : "+weight+"g, ���Գ�¥: "+time1+"]";
	}
	
	
}
