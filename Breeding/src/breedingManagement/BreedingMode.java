package breedingManagement;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

public class BreedingMode implements Serializable{ 
	static LogClass logger = new LogClass("log.txt");
	private static final long serialVersionUID = 3499476101535632006L;
	
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
	
	public void Edit_Insect(int id, double weight, int num) { //개체 편집 메서드 구현
		for(int i = 0; i < logger.getINList().size(); i++) {
			if(logger.getINList().get(i).getId() == id) {
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

	public void Edit_Insect(int id, String label, String quality) {//표본 편집 메서드 구현
		for(int i = 0; i < logger.getDIList().size(); i++) {
			edit3.setId(id);
			edit3.setName(logger.getDIList().get(i).getName());
			edit3.setLength(logger.getDIList().get(i).getLength());
			edit3.setQuality(quality);
			edit3.setLabel(label);
			logger.getDIList().set(i, edit3);
		}
	}
}