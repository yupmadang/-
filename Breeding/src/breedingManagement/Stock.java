package breedingManagement;

public class Stock extends Insect {//�߻�Ŭ������ ��� �޴� �ڽ�Ŭ����

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
	
	@Override//�߻�Ŭ������ �ִ� �޼��带 �������̵�
	public String toString() {
		return "[��ü ��ȣ : "+ id + ", ��ü�� : " + name +", "+"��� ���� : "+name2+", ��ü Ƚ��: "+num+"ȸ]";
	}
}