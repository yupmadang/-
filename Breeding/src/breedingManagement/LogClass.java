package breedingManagement;

import java.io.IOException;
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
	
}
