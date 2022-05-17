package breedingManagement;

public class DryInsect extends Insect{//�߻�Ŭ������ ��� �޴� �ڽ�Ŭ����
	
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
	
	@Override//�߻�Ŭ������ �ִ� �޼��带 �������̵�
	public String toString() {
		return "[ǥ�� ��ȣ : "+ id + ", ǥ���� : " + name +", "+"���� : "+length+"mm, ����: "+quality+", �� : "+label+"]";
	}
}
