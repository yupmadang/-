package breedingproject;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Insect {
	//���� �ð��� �ҷ���
	SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");		
	Date time = new Date();
	String time1 = format1.format(time);
	//Ŭ������ ������ ����, private�� ���������� �������� �������� �������� ������ ���� Ŭ���� �������� ����
	protected int id;
	protected String name;
	private double weight;
	//����� ���� ������ ����
	public Insect(int id, String name, double weight) {
		this.id = id;
		this.name = name;
		this.weight = weight;
	}
	public Insect() {}//edit �ν��Ͻ��� ���� ���� ����ũ �����ڸ� ������
	//get,set�޼��带 ����Ͽ� �ܺο����� ������ �������� ���� ����, edit�ν��Ͻ����� Ȱ��
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String toString() {
		return ("[��ü ��ȣ :"+id+", ��ü�� : "+name+", ���� : "+weight+"g ,������ : "+time1+"]");
	}
}
