package breedingproject;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Insect {
	//현재 시간을 불러옴
	SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");		
	Date time = new Date();
	String time1 = format1.format(time);
	//클래스의 변수를 선언, private로 접근제어자 선언으로 직접적인 변수로의 접근은 같은 클래스 내에서만 가능
	protected int id;
	protected String name;
	private double weight;
	//사용자 정의 생성자 생성
	public Insect(int id, String name, double weight) {
		this.id = id;
		this.name = name;
		this.weight = weight;
	}
	public Insect() {}//edit 인스턴스를 위해 따로 디폴크 생성자를 선언함
	//get,set메서드를 사용하여 외부에서의 변수에 직접적인 접근 차단, edit인스턴스에서 활용
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
		return ("[개체 번호 :"+id+", 개체명 : "+name+", 무게 : "+weight+"g ,투입일 : "+time1+"]");
	}
}
