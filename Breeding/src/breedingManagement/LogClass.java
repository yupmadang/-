package breedingManagement;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.LogManager;
import java.util.logging.Logger;
//�α� ������ �����ϱ� ���� Ŭ����
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
	//�α׿� ������ �����ϴ� �޼���
	public void log(String logMassage) {
		logger.info(logMassage);
	}
	
}
