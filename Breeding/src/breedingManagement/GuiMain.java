 package breedingManagement;

import java.awt.EventQueue;

public class GuiMain {
	public static LogClass logger1= new LogClass("log.txt");
	public static void main(String[] args) {
		//����ȭ�� ������ �ҷ���
		logger1.getObject();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				//guiȣ��
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
