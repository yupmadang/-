package breedingManagement;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Insect implements Serializable{ //�θ�Ŭ������ �߻�Ŭ������ ����

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

	public String toString() { //������� ������ �޼����̹Ƿ� null��ȯ
		return null;
	}
}