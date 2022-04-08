package BreedingManagementProject;
import java.util.Iterator;
import java.util.LinkedList;
public class BreedingMode { //개체의 추가, 제거, 편집, 출력의 메서드를 담은 클래스
	LinkedList<Insect> Info_Name = new LinkedList<>();//링크드 리스트 선언
	LinkedList<Stock> Info_Stock = new LinkedList<>();//링크드 리스트 선언
	Insect ins; //개체추가, 제거, 출력을 위한 Insect형의 ins
	Insect edit = new Insect();
	Stock sto;
	Stock edit2 = new Stock();
	//생성자는 존재하지 않지만 컴파일러가 자동으로 디폴트 생성자를 삽입
	public void Add_Insect(int id, String name, double weight, String stock) {//개체 추가 메소드
		int num = 1;
		ins = new Insect(id, name, weight); //리스트에 삽입을 위한 객체를 생성, 객체의 요소에는 id, name, weight 변수 값이 필요
		sto = new Stock(id, name, stock, num);
		Info_Name.add(ins);//리스트에 객체를 저장
		Info_Stock.add(sto);
	}
	public void Delete_Insect(int id) {//개체 제거 메서드
		Iterator<Insect> ir = Info_Name.iterator();//Iterator메서드를 사용해서 순회
		while(ir.hasNext()) {//리스트의 다음 값이 있는 경우
			if(ir.next().getId() == id) {
				ir.remove();//ir이 가리키는 요소 제거
				System.out.println("제거할 개체를 제거하였습니다.");
			}
		}
	}
	public void ShowAll_Insect() {//개체 출력 메서드
		Iterator<Insect> ir = Info_Name.iterator();//Iterator메서드를 사용해서 순회
		Iterator<Stock> ir2 = Info_Stock.iterator();//Iterator메서드를 사용해서 순회
		while(ir.hasNext()) {//리스트의 다음 값이 있는 경우
		    System.out.println(ir.next());//리스트의 값을 출력
		}
		while(ir2.hasNext()) {//리스트의 다음 값이 있는 경우
		    System.out.println(ir2.next());//리스트의 값을 출력
		}
	}
	
	public void Edit_Insect(int Id ,double weight, int num) {//개체 변경 메서드
		for(int i = 0; i < Info_Name.size(); i++) {//리스트의 크기만큼 리스트의 값 순회
			if(Info_Name.get(i).getId() == Id) {//리스트에 저장된 객체의 id와 변경할 id가 같은 경우
				edit.setId(Info_Name.get(i).getId()); //edit의 아이디는 기존의 list에 저장된 id사용
				edit.setName(Info_Name.get(i).getName());//edit의 이름은 기존의 list에 저장된 이름사용
				edit.setWeight(weight);//edit의 무게는 변경할 무게 값 사용
				//새로 추가할 객체 edit 완성
				Info_Name.set(i, edit); //리스트에 포함된 ins를 대신해서 edit를 추가
			}
		}
		for(int i = 0; i < Info_Stock.size(); i++) {//리스트의 크기만큼 리스트의 값 순회
			if(Info_Stock.get(i).getId() == Id) {//리스트에 저장된 객체의 id와 변경할 id가 같은 경우
				edit2.setId(Info_Stock.get(i).getId()); //edit2의 아이디는 기존의 list에 저장된 id사용
				edit2.setName(Info_Stock.get(i).getName());//edit2의 이름은 기존의 list에 저장된 이름사용
				edit2.setNum(num);
				edit2.setName2(Info_Stock.get(i).getName2());
				//새로 추가할 객체 edit2 완성
				Info_Stock.set(i, edit2); //리스트에 포함된 sto를 대신해서 edit2를 추가
			}
		}
	}
}