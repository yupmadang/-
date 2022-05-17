package breedingManagement;

import java.io.Serializable;
//사용할 설명을 담기 위한 클래스
public class ExcutionClass implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7549719661888557078L;
	
	public void HaveIns() {
		System.out.println("보유한 개체 현황입니다.");
	}
	
	public void MealIns() {
		System.out.println("개체의 먹이 교체 현황입니다.");
	}

}
