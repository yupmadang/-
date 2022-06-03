package breedingManagement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.logging.FileHandler;
import java.util.logging.LogManager;
import java.util.logging.Logger;
//로그 파일을 생성하기 위한 클래스
public class LogClass implements Serializable {

	private static final long serialVersionUID = 7429624065897161851L;
	FileHandler fileHandler;
	LogManager logManager;
	Logger logger;

	private static LinkedList<aliveInsect> Info_Name = new LinkedList<>();
	private static LinkedList<DryInsect> Info_DryInsect = new LinkedList<>();
	
	public LinkedList<aliveInsect> getINList(){
		return Info_Name;
	}
	public LinkedList<DryInsect> getDIList(){
		return Info_DryInsect;
	}
	
	public LogClass(String fileName) {
		try {
			logManager = LogManager.getLogManager();
			logger = logManager.getLogger(Logger.GLOBAL_LOGGER_NAME);
			fileHandler = new FileHandler(fileName);
			logger.addHandler(fileHandler);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	//로그에 내용을 저장하는 메서드
	public void log(String logMassage) {
		logger.info(logMassage);
	}
	//파일호출메서드: 기존에 저장된 파일을 프로그램이 시작시 호출
	public void getObject() {
		FileInputStream file;
		try {
			file = new FileInputStream("Breeding.txt");
			ObjectInputStream in = new ObjectInputStream(file);
			Info_Name = (LinkedList<aliveInsect>)in.readObject();

			in.close();
			file.close();
			
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//파일생성메서드 : 프로젝트가 종료되면 업데이트
		public void PutObject() { 
			try {
				FileOutputStream file1 = new FileOutputStream("Breeding.txt");
				ObjectOutputStream out = new ObjectOutputStream(file1);
				out.writeObject(Info_Name);
				out.writeObject(Info_DryInsect);
				
				out.close();
				file1.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
}
