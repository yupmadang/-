package BreedingManagementProject;

public class Stock extends Insect { //Insect Ŭ���� ���
	
	private String name2;
	private int num = 1;

	public Stock(int id, String name, String name2, int num) { //������ ����
		super(id, name, 0.0); //�θ� Ŭ������ �����ڸ� ����
		this.name2 = name2;
		this.num = num;
	}
	
	public Stock() {//edit2�� ���� ����Ʈ ������
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
	
	public String toString() {//����� toString �޼��� ������
		return "[��ü ��ȣ : "+ id + ", ��ü�� : " + name +", "+"��� ���� : "+name2+", ��ü Ƚ��: "+num+"]";
	}
	
}
