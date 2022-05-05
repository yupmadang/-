package breedingManagement;

import java.util.Iterator;
import java.util.LinkedList;

public class BreedingMode implements DryInsectInterface, BreedingInterface{ //인터페이스를 다중상속 받은 BreedingMode클래스
	//객체를 저장할 링크드리스트 3개 선언
	LinkedList<InsectInfo> Info_Name = new LinkedList<>();
	LinkedList<Stock> Info_Stock = new LinkedList<>();
	LinkedList<DryInsect> Info_DryInsect = new LinkedList<>();
	
	//개체추가, 제거, 출력을 위한 객체와 편집을 위한 객체 생성
	InsectInfo ins; 
	InsectInfo edit = new InsectInfo();
	Stock sto;
	Stock edit2 = new Stock();
	DryInsect dins;
	DryInsect edit3 = new DryInsect();
	
	//참조한  인터페이스의 메서드 BreedingInterface
	
	@Override
	public void Add_Insect(int id, String name, double weight, String stock) {//개체 추가 메서드 구현
		ins = new InsectInfo(id, name, weight);
		sto = new Stock(id, name, stock);
		Info_Name.add(ins);
		Info_Stock.add(sto);		
	}
	
	@Override
	public void	Delete_Insect(int id) {//개체 삭제 메서드 구현
		Iterator<InsectInfo> ir1 = Info_Name.iterator();
		Iterator<Stock> ir2 = Info_Stock.iterator();
		while(ir1.hasNext()) {
			if(ir1.next().getId() == id) {
				ir1.remove();
			}
		}
		while(ir2.hasNext()) {
			if(ir2.next().getId() == id) {
				ir2.remove();
			}
		}
		System.out.println("개체를 제거완료하였습니다.");
	}
	
	@Override
	public void Edit_Insect(int id, double weight, int num) { //개체 편집 메서드 구현
		for(int i = 0; i < Info_Name.size(); i++) {
			if(Info_Name.get(i).getId() == id) {
				edit.setId(Info_Name.get(i).getId());
				edit.setName(Info_Name.get(i).getName());
				edit.setWeight(weight);
				Info_Name.set(i, edit);
			}
		}
		for(int i = 0; i < Info_Stock.size(); i++) {
			if(Info_Stock.get(i).getId() == id) {
				edit2.setId(Info_Stock.get(i).getId());
				edit2.setName(Info_Stock.get(i).getName());
				edit2.setName2(Info_Stock.get(i).getName2());
				edit2.setNum(num);
				Info_Stock.set(i, edit2);
			}
		}
		
	}
	
	public void Search_Insect(int id) { //개체 검색 메서드 구현
		System.out.println("보유한 개체 현황입니다.");
		for(int i = 0; i < Info_Name.size(); i++) {
			if(Info_Name.get(i).getId() == id) {
				System.out.println(Info_Name.get(i));
			}
		}
		
		System.out.println("개체의 먹이 교체현황입니다.");
		for(int i = 0; i < Info_Stock.size(); i++) {
			if(Info_Stock.get(i).getId() == id) {
				System.out.println("보유한 개체 현황입니다.");
				System.out.println(Info_Stock.get(i));
			}
		}
	}
	
	@Override
	public void Show_Insect() { //개체 출력 메서드 구현
		Iterator<InsectInfo> ir1 = Info_Name.iterator();
		Iterator<Stock> ir2 = Info_Stock.iterator();
		
		System.out.println("보유 개체 현황입니다.");
		while(ir1.hasNext()) {
			System.out.println(ir1.next());	
		}
		
		System.out.println("개체의 먹이 교체현황입니다.");
		
		while(ir2.hasNext()) {
			System.out.println(ir2.next());	
		}
	}
	
	//참조한  인터페이스의 메서드 BreedingInterface
	
	@Override
	public void Add_Insect(int id, String name, double length, String quality, String label) { //표본 추가 메서드 구현
		dins = new DryInsect(id, name, length, quality, label);
		Info_DryInsect.add(dins);
	}
	
	@Override
	public void Delete_Insect(String label) {//표본 제거 메서드 구현
		Iterator<DryInsect> ir1 = Info_DryInsect.iterator();
		while(ir1.hasNext()) {
			if(ir1.next().getLabel().equals(label)) {
				ir1.remove();
				System.out.println("선택한 개체가 삭제되었습니다.");
			}
		}
	}
	
	@Override
	public void Edit_Insect(int id, String label, String quality) {//표본 편집 메서드 구현
		for(int i = 0; i < Info_DryInsect.size(); i++) {
			if(Info_DryInsect.get(i).getId() == id && Info_DryInsect.get(i).getLabel().equals(label)) {
				edit3.setId(Info_DryInsect.get(i).getId());
				edit3.setName(Info_DryInsect.get(i).getName());
				edit3.setLength(Info_DryInsect.get(i).getLength());
				edit3.setQuality(quality);
				edit3.setLabel(Info_DryInsect.get(i).getLabel());
			}
		}
	}
	
	@Override
	public void Search_DryInsect(int id) {//표본 검색 메서드 구현
		for(int i = 0; i < Info_DryInsect.size(); i++) {
			if(Info_DryInsect.get(i).getId() == id) {
				System.out.println(Info_DryInsect.get(i));
			}
		}
	}
	
	@Override
	public void Show_DryInsect() {//표본 출력 메서드 구현
		Iterator<DryInsect> ir1 = Info_DryInsect.iterator();
		while(ir1.hasNext()) {
			System.out.println(ir1.next());
		}
	}
}