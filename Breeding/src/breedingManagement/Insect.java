package breedingManagement;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Insect { //부모클래스를 추상클래스로 변경

	SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");		
	Date time = new Date();
	
	protected String time1 = format1.format(time);
	protected int id;
	protected String name;
	protected double weight;

	public String toString() {
		return null;
	}
}