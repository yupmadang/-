package breedingManagement;

import java.util.Iterator;
import java.util.LinkedList;

public class BreedingMode implements DryInsectInterface, BreedingInterface{ //�������̽��� ���߻�� ���� BreedingModeŬ����
	//��ü�� ������ ��ũ�帮��Ʈ 3�� ����
	LinkedList<InsectInfo> Info_Name = new LinkedList<>();
	LinkedList<Stock> Info_Stock = new LinkedList<>();
	LinkedList<DryInsect> Info_DryInsect = new LinkedList<>();
	
	//��ü�߰�, ����, ����� ���� ��ü�� ������ ���� ��ü ����
	InsectInfo ins; 
	InsectInfo edit = new InsectInfo();
	Stock sto;
	Stock edit2 = new Stock();
	DryInsect dins;
	DryInsect edit3 = new DryInsect();
	
	//������  �������̽��� �޼��� BreedingInterface
	
	@Override
	public void Add_Insect(int id, String name, double weight, String stock) {//��ü �߰� �޼��� ����
		ins = new InsectInfo(id, name, weight);
		sto = new Stock(id, name, stock);
		Info_Name.add(ins);
		Info_Stock.add(sto);		
	}
	
	@Override
	public void	Delete_Insect(int id) {//��ü ���� �޼��� ����
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
		System.out.println("��ü�� ���ſϷ��Ͽ����ϴ�.");
	}
	
	@Override
	public void Edit_Insect(int id, double weight, int num) { //��ü ���� �޼��� ����
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
	
	public void Search_Insect(int id) { //��ü �˻� �޼��� ����
		System.out.println("������ ��ü ��Ȳ�Դϴ�.");
		for(int i = 0; i < Info_Name.size(); i++) {
			if(Info_Name.get(i).getId() == id) {
				System.out.println(Info_Name.get(i));
			}
		}
		
		System.out.println("��ü�� ���� ��ü��Ȳ�Դϴ�.");
		for(int i = 0; i < Info_Stock.size(); i++) {
			if(Info_Stock.get(i).getId() == id) {
				System.out.println("������ ��ü ��Ȳ�Դϴ�.");
				System.out.println(Info_Stock.get(i));
			}
		}
	}
	
	@Override
	public void Show_Insect() { //��ü ��� �޼��� ����
		Iterator<InsectInfo> ir1 = Info_Name.iterator();
		Iterator<Stock> ir2 = Info_Stock.iterator();
		
		System.out.println("���� ��ü ��Ȳ�Դϴ�.");
		while(ir1.hasNext()) {
			System.out.println(ir1.next());	
		}
		
		System.out.println("��ü�� ���� ��ü��Ȳ�Դϴ�.");
		
		while(ir2.hasNext()) {
			System.out.println(ir2.next());	
		}
	}
	
	//������  �������̽��� �޼��� BreedingInterface
	
	@Override
	public void Add_Insect(int id, String name, double length, String quality, String label) { //ǥ�� �߰� �޼��� ����
		dins = new DryInsect(id, name, length, quality, label);
		Info_DryInsect.add(dins);
	}
	
	@Override
	public void Delete_Insect(String label) {//ǥ�� ���� �޼��� ����
		Iterator<DryInsect> ir1 = Info_DryInsect.iterator();
		while(ir1.hasNext()) {
			if(ir1.next().getLabel().equals(label)) {
				ir1.remove();
				System.out.println("������ ��ü�� �����Ǿ����ϴ�.");
			}
		}
	}
	
	@Override
	public void Edit_Insect(int id, String label, String quality) {//ǥ�� ���� �޼��� ����
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
	public void Search_DryInsect(int id) {//ǥ�� �˻� �޼��� ����
		for(int i = 0; i < Info_DryInsect.size(); i++) {
			if(Info_DryInsect.get(i).getId() == id) {
				System.out.println(Info_DryInsect.get(i));
			}
		}
	}
	
	@Override
	public void Show_DryInsect() {//ǥ�� ��� �޼��� ����
		Iterator<DryInsect> ir1 = Info_DryInsect.iterator();
		while(ir1.hasNext()) {
			System.out.println(ir1.next());
		}
	}
}