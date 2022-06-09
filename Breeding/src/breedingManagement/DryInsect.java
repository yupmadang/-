package breedingManagement;

public class DryInsect extends Insect{//추상클래스를 상속 받는 자식클래스
	//직렬화에 사용하는 클래스에 붙는 시리얼코드
	private static final long serialVersionUID = -5610027249538293148L;
	private double length;
	private String quality;
	private String label;
	
	public DryInsect(int id, String name, double length, String quality, String label) {
		this.id = id;
		this.name = name;
		this.length = length;
		this.quality =quality;
		this.label = label;
	}
	//표본 편집에 사용하는 디폴트 생성자
	public DryInsect() {}
	
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
	
	public double getLength() {
		return length;
	}
	
	public void setLength(double length) {
		this.length = length;
	}
	
	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
