package breedingManagement;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Window.Type;

public class ManualGui implements ActionListener{

	private JFrame frame;
	public Manual manual  = new Manual();
	private JTextArea textArea;
	private JLabel lblNewLabel_1;

	public ManualGui() {
		initialize();
	}
	//����gui�� �����ϴ� �޼���
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.setBounds(100, 100, 450, 300);
		frame.setSize(400, 600);
		frame.setResizable(false);
		
		JLabel lblNewLabel = new JLabel("����");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 30));
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.append(manual.getManual());
		scrollPane.setViewportView(textArea);
		
		lblNewLabel_1 = new JLabel("�� Ȱ���� ���ø� ���ڽ��ϴ�.");
		scrollPane.setColumnHeaderView(lblNewLabel_1);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
