package breedingManagement;

import java.awt.EventQueue;

public class GuiMain {


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMenu window = new GUIMenu();
					DryGui gui = new DryGui();
					ManualGui manual = new ManualGui();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
