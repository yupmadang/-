 package breedingManagement;

import java.awt.EventQueue;

public class GuiMain {
	public static LogClass logger1= new LogClass("log.txt");
	public static void main(String[] args) {
		//직렬화한 파일을 불러옴
		logger1.getObject();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				//gui호출
				try {
					@SuppressWarnings("unused")
					GUIMenu window = new GUIMenu(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
