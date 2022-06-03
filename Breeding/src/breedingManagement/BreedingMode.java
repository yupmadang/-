package breedingManagement;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class BreedingMode implements DryInsectInterface, BreedingInterface, Serializable{ 
	static LogClass logger = new LogClass("log.txt");
	private static final long serialVersionUID = 3499476101535632006L;
	
	//인터페이스를 다중상속 받은 BreedingMode클래스
	//객체를 저장할 링크드리스트 3개 선언

	
	//개체추가, 제거, 출력을 위한 객체와 편집을 위한 객체 생성
	aliveInsect ins; 
	aliveInsect edit = new aliveInsect();
	DryInsect dins;
	DryInsect edit3 = new DryInsect();
	Manual manual = new Manual();
	
	//설명서를 출력하기 위한 메서드
	public void Show_Manual() {
		try {
			BufferedReader buffer = new BufferedReader(new FileReader("Manual.txt"));
			while(true) {
				String str = buffer.readLine();
				if(str == null) {
					break;
				}
				
				System.out.println(str);
			}
			buffer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int size() {
		return logger.getINList().size();
	}
	
	public aliveInsect get(int idx) {
		return logger.getINList().get(idx); 
	}
	
	
	//참조한  인터페이스의 메서드 BreedingInterface
	

	
	@Override
	public void	Delete_Insect(int id) {//개체 삭제 메서드 구현
		for(int i = 0; i < logger.getINList().size(); i++) {
			if(logger.getINList().get(i).getId() == id) {
				logger.getINList().remove(i);
			}
		}
		for(int i = 0; i < logger.getDIList().size(); i++) {
			if(logger.getDIList().get(i).getId() == id) {
				logger.getDIList().remove(i);
			}
		}
	}
	
	@Override
	public void Edit_Insect(int id, double weight, int num) { //개체 편집 메서드 구현
		for(int i = 0; i < logger.getINList().size(); i++) {
			if(logger.getINList().get(i).getId() == id) {
				aliveInsect temp = logger.getINList().get(i);
				edit.setId(logger.getINList().get(i).getId());
				edit.setName(logger.getINList().get(i).getName());
				edit.setName2(logger.getINList().get(i).getName2());
				edit.setDate(logger.getINList().get(i).getDate());
				edit.setWeight(weight);
				edit.setNum(num);
				logger.getINList().set(i, edit);
				break;
			}
		}	
	}

	@Override
	public boolean Add_Insect(int id, String name, double weight, String stock, int num, String date) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Search_Insect(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Show_Insect() {
		// TODO Auto-generated method stub
		
	}
	
	//참조한  인터페이스의 메서드 BreedingInterface
	
/*	@Override
	public void Add_Insect(int id, String name, double length, String quality, String label) { //표본 추가 메서드 구현
		dins = new DryInsect(id, name, length, quality, label);
		Info_DryInsect.add(dins);
	}
	
	@Override
	public void Delete_Insect(int id, String name, double length) {//표본 제거 메서드 구현
		for(int i = 0; i < Info_DryInsect.size(); i++) {
			if(Info_DryInsect.get(i).getId() == id && Info_DryInsect.get(i).getLength() == length && Info_DryInsect.get(i).getName().equals(name)) {
				Info_DryInsect.remove(i);
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
				Info_DryInsect.set(i, edit3);
			}
		}
	}*/
}