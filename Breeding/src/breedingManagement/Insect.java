package breedingManagement;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Insect implements Serializable{ //부모클래스를 추상클래스로 변경

	/**
	 * 
	 */
	private static final long serialVersionUID = -1601939913873827408L;
	SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");		
	Date time = new Date();
	
	protected String time1 = format1.format(time);
	protected int id;
	protected String name;
	protected double weight;

	public String toString() { //상속으로 구현할 메서드이므로 null반환
		return null;
	}
}