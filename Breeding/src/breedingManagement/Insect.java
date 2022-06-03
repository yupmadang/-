package breedingManagement;

import java.io.Serializable;

public abstract class Insect implements Serializable{ //부모클래스를 추상클래스로 변경

	private static final long serialVersionUID = -1601939913873827408L;

	protected int id;
	protected String name;
	protected double weight;
	protected String name2;
	protected int num;
	protected String date;

}