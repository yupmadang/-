package BreedingManagementProject;
import java.util.Iterator;
import java.util.LinkedList;
public class BreedingMode { //��ü�� �߰�, ����, ����, ����� �޼��带 ���� Ŭ����
	LinkedList<Insect> Info_Name = new LinkedList<>();//��ũ�� ����Ʈ ����
	LinkedList<Stock> Info_Stock = new LinkedList<>();//��ũ�� ����Ʈ ����
	Insect ins; //��ü�߰�, ����, ����� ���� Insect���� ins
	Insect edit = new Insect();
	Stock sto;
	Stock edit2 = new Stock();
	//�����ڴ� �������� ������ �����Ϸ��� �ڵ����� ����Ʈ �����ڸ� ����
	public void Add_Insect(int id, String name, double weight, String stock) {//��ü �߰� �޼ҵ�
		int num = 1;
		ins = new Insect(id, name, weight); //����Ʈ�� ������ ���� ��ü�� ����, ��ü�� ��ҿ��� id, name, weight ���� ���� �ʿ�
		sto = new Stock(id, name, stock, num);
		Info_Name.add(ins);//����Ʈ�� ��ü�� ����
		Info_Stock.add(sto);
	}
	public void Delete_Insect(int id) {//��ü ���� �޼���
		Iterator<Insect> ir = Info_Name.iterator();//Iterator�޼��带 ����ؼ� ��ȸ
		while(ir.hasNext()) {//����Ʈ�� ���� ���� �ִ� ���
			if(ir.next().getId() == id) {
				ir.remove();//ir�� ����Ű�� ��� ����
				System.out.println("������ ��ü�� �����Ͽ����ϴ�.");
			}
		}
	}
	public void ShowAll_Insect() {//��ü ��� �޼���
		Iterator<Insect> ir = Info_Name.iterator();//Iterator�޼��带 ����ؼ� ��ȸ
		Iterator<Stock> ir2 = Info_Stock.iterator();//Iterator�޼��带 ����ؼ� ��ȸ
		while(ir.hasNext()) {//����Ʈ�� ���� ���� �ִ� ���
		    System.out.println(ir.next());//����Ʈ�� ���� ���
		}
		while(ir2.hasNext()) {//����Ʈ�� ���� ���� �ִ� ���
		    System.out.println(ir2.next());//����Ʈ�� ���� ���
		}
	}
	
	public void Edit_Insect(int Id ,double weight, int num) {//��ü ���� �޼���
		for(int i = 0; i < Info_Name.size(); i++) {//����Ʈ�� ũ�⸸ŭ ����Ʈ�� �� ��ȸ
			if(Info_Name.get(i).getId() == Id) {//����Ʈ�� ����� ��ü�� id�� ������ id�� ���� ���
				edit.setId(Info_Name.get(i).getId()); //edit�� ���̵�� ������ list�� ����� id���
				edit.setName(Info_Name.get(i).getName());//edit�� �̸��� ������ list�� ����� �̸����
				edit.setWeight(weight);//edit�� ���Դ� ������ ���� �� ���
				//���� �߰��� ��ü edit �ϼ�
				Info_Name.set(i, edit); //����Ʈ�� ���Ե� ins�� ����ؼ� edit�� �߰�
			}
		}
		for(int i = 0; i < Info_Stock.size(); i++) {//����Ʈ�� ũ�⸸ŭ ����Ʈ�� �� ��ȸ
			if(Info_Stock.get(i).getId() == Id) {//����Ʈ�� ����� ��ü�� id�� ������ id�� ���� ���
				edit2.setId(Info_Stock.get(i).getId()); //edit2�� ���̵�� ������ list�� ����� id���
				edit2.setName(Info_Stock.get(i).getName());//edit2�� �̸��� ������ list�� ����� �̸����
				edit2.setNum(num);
				edit2.setName2(Info_Stock.get(i).getName2());
				//���� �߰��� ��ü edit2 �ϼ�
				Info_Stock.set(i, edit2); //����Ʈ�� ���Ե� sto�� ����ؼ� edit2�� �߰�
			}
		}
	}
}