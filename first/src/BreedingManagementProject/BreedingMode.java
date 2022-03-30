package BreedingManagementProject;

import java.util.Iterator;
import java.util.LinkedList;

public class BreedingMode { //��ü�� �߰�, ����, ����, ����� �޼��带 ���� Ŭ����
	
	LinkedList<Insect> Info_Name = new LinkedList<>();//��ũ�� ����Ʈ ����
	Insect ins; //��ü�߰�, ����, ����� ���� Insect���� ins
	//�����ڴ� �������� ������ �����Ϸ��� �ڵ����� ����Ʈ �����ڸ� ����
	Insect edit = new Insect();//�ڷ��� ������ ���� edit ����
	public void Add_Insect(int id, String name, double weight) {//��ü �߰� �޼ҵ�
		ins = new Insect(id, name, weight); //����Ʈ�� ������ ���� ��ü�� ����, ��ü�� ��ҿ��� id, name, weight ���� ���� �ʿ�
		Info_Name.add(ins);//����Ʈ�� ��ü�� ����
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
		while(ir.hasNext()) {//����Ʈ�� ���� ���� �ִ� ���
		    System.out.println(ir.next());//����Ʈ�� ���� ���
		}
	}
	
	public void Edit_Insect(int Id ,double weight) {//��ü ���� �޼���
		for(int i = 0; i < Info_Name.size(); i++) {//����Ʈ�� ũ�⸸ŭ ����Ʈ�� �� ��ȸ
			if(Info_Name.get(i).getId() == Id) {//����Ʈ�� ����� ��ü�� id�� ������ id�� ���� ���
				edit.setId(Info_Name.get(i).getId()); //edit�� ���̵�� ������ list�� ����� id���
				edit.setName(Info_Name.get(i).getName());//edit�� �̸��� ������ list�� ����� �̸����
				edit.setWeight(weight);//edit�� ���Դ� ������ ���� �� ���
				//���� �߰��� ��ü edit �ϼ�
				Info_Name.set(i, edit); //����Ʈ�� ���Ե� ins�� ����ؼ� edit�� �߰�
			}
		}
	}
}