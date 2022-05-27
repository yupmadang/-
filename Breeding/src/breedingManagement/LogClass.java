package breedingManagement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.FileHandler;
import java.util.logging.LogManager;
import java.util.logging.Logger;
//로그 파일을 생성하기 위한 클래스
public class LogClass {
	FileHandler fileHandler;
	LogManager logManager;
	Logger logger;
	
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
	public BreedingMode getObject(String fileName) {
		BreedingMode br = null;
		FileInputStream file;
		try {
			file = new FileInputStream("Breeding.txt");
			ObjectInputStream in = new ObjectInputStream(file);
			br = (BreedingMode) in.readObject();
			
			in.close();
			file.close();
			
		} catch (FileNotFoundException e) {
			return br;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return br;
	}
	
	//파일생성메서드 : 프로젝트가 종료되면 업데이트
		public void PutObject(BreedingMode mode ,String fileName) { 
			try {
				FileOutputStream file1 = new FileOutputStream("Breeding.txt");
				ObjectOutputStream out = new ObjectOutputStream(file1);
				out.writeObject(mode);
				
				out.close();
				file1.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
}
