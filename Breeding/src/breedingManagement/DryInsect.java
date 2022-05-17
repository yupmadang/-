package breedingManagement;

public class DryInsect extends Insect{//추상클래스를 상속 받는 자식클래스
	
	/**
	 * 
	 */
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
	
	public DryInsect() {}
	
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
	
	@Override//추상클래스에 있던 메서드를 오버라이드
	public String toString() {
		return "[표본 번호 : "+ id + ", 표본명 : " + name +", "+"길이 : "+length+"mm, 상태: "+quality+", 라벨 : "+label+"]";
	}
}
