package breedingManagement;
//ǥ������� �ٷ�� gui
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Window.Type;

public class DryGui implements ActionListener{
	private JFrame frame;
	private JTable table;
	private JTextField TFName;
	private JTextField TFId;
	private JTextField TFLen;
	private JTextField TFState;
	private JTextField TFLabel;
	//���Ͽ��� ���� �ҷ����� �߰��ϱ� ���� ����
	BreedingMode breedingMode = new BreedingMode();
	LogClass logger = new LogClass("log.txt");
	private JTextField TFDId;
	private JTextField TFDLen;
	private JTextField TFDLabel;
	private JTextField TFEId;
	private JTextField TFELabel;
	private JTextField TFEState;
	//gui������
	public DryGui() {
		initialize();
	}
	//gui�� �����ϴ� initialize�޼���
	private void initialize() {
		frame = new  JFrame();
		frame.setType(Type.UTILITY);
		frame.setBounds(100, 100, 450, 300);
		frame.setSize(1000, 500);
		frame.setResizable(false);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblBreedingproject = new JLabel("DryInsectMode");
		lblBreedingproject.setBackground(SystemColor.desktop);
		lblBreedingproject.setForeground(new Color(0, 0, 0));
		lblBreedingproject.setHorizontalAlignment(SwingConstants.CENTER);
		lblBreedingproject.setFont(new Font("����", Font.BOLD, 30));
		frame.getContentPane().add(lblBreedingproject, BorderLayout.NORTH);
		
		JSplitPane splitPane = new JSplitPane();
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setRightComponent(scrollPane);
		
		//���̺� ����� column�� �� �̸� ����
		table = new JTable();
		Object column[] = {"ǥ����ȣ", "ǥ���̸�", "ǥ������", "����", "��"};
		Object[][] object = new Object[][] {};
		DefaultTableModel model = new DefaultTableModel(object, column);
		table.setModel(model);
		
		//���̺��� �� column�� ���� ����
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(200);
		table.setEnabled(false);
		//table�� �ݿ�
		scrollPane.setViewportView(table);
		
		JSplitPane splitPane_1 = new JSplitPane();
		frame.getContentPane().add(splitPane_1, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("ǥ�����");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 12));
		splitPane_1.setLeftComponent(lblNewLabel);
		
		JPanel panel = new JPanel();
		splitPane_1.setRightComponent(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		//ǥ�� �߰� ��ư
		JButton Add = new JButton("ǥ���߰�");
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�߰��� ���� ���� ����
				Vector<String> vec = new Vector<>();
				String id = TFId.getText();
				//id�� �� ��� ����
				if(TFId.getText().isEmpty()) {
					return;
				}
				String name = TFName.getText();
				String len = TFLen.getText();
				String state = TFState.getText();
				String label = TFLabel.getText();
				
				
				logger.getDIList().add(new DryInsect(Integer.parseInt(id),name, Double.parseDouble(len),state,label));
				logger.PutObject();
				//���Ϳ� �� �߰�
				vec.add(id);
				vec.add(name);
				vec.add(len);
				vec.add(state);
				vec.add(label);

				TFId.setText("");
				TFName.setText("");
				TFLen.setText("");
				TFState.setText("");
				TFLabel.setText("");
				//model�� Ȱ���� ����Ʈ�� �ݿ�
				model.addRow(vec);
				logger.log(id+"�� �߰��Ͽ����ϴ�.");
				table.updateUI();
			}
		});
		panel.add(Add);
		
		JButton Delete = new JButton("ǥ������");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String id = TFDId.getText();
					String label = TFDLabel.getText();
					String len = TFDLen.getText();
					//3���� ǥ�� ������ ��ġ�� ��� ���Ͽ��� �� ��ü�� ����
					for(DryInsect i : logger.getDIList()) {
						if((""+i.getId()).equals(id) && i.getLabel().equals(label) && i.getLength() == Double.parseDouble(len)) {
							logger.getDIList().remove(i);
							table.updateUI();
							
							try{
								//��ü�� ���ŵ� �� ���̺� ����
								for(int j = 0;;j++) {
									model.removeRow(j);
									TFDId.setText("");
									TFDLen.setText("");
									TFDLabel.setText("");
									table.updateUI();
								}
								
							}catch (ArrayIndexOutOfBoundsException e2) {
								return;
							}
						}
					}
					logger.log(id+"�� �����Ͽ����ϴ�.");
				}catch (Exception e1) {
					return;
				}
			}
		});
		panel.add(Delete);
		//ǥ�� ���¸� �����ϱ� ���� �̺�Ʈ ó��
		JButton Edit = new JButton("ǥ������");
		Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//���Ͽ� ����� ��ü�� ��ȸ�Ͽ� ��ġ�ϴ� ���� ���� ��� state�� ��ä�� ������
				try{
					for(int i = 0; i < logger.getDIList().size(); i++) {
						int id = Integer.parseInt(TFEId.getText()); 
						String label = TFELabel.getText(); 
						String state = TFEState.getText(); 
					
						if(logger.getDIList().get(i).getId() == id && logger.getDIList().get(i).getLabel().equals(label)) {
							breedingMode.Edit_Insect(id, label, state);
							logger.PutObject();
						}
					}
					logger.log("���¸� �����Ͽ����ϴ�.");
				}catch (NumberFormatException e2) {
					return;
				}
					TFEId.setText("");
					TFEState.setText("");
					TFELabel.setText("");
					
					table.updateUI();
				}
		});
	
		panel.add(Edit);
		//���Ͽ� ���� ��ü�� ��� ���̺� �ҷ����� ��ư
		JButton View = new JButton("ǥ�����");
		View.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Vector<String> vec = new Vector<>();
					for(int i = 0; i < logger.getDIList().size(); i++) {
						vec.add(Integer.toString(logger.getDIList().get(i).getId()));
						vec.add(logger.getDIList().get(i).getName());
						vec.add(Double.toString(logger.getDIList().get(i).getLength()));
						vec.add(logger.getDIList().get(i).getQuality());
						vec.add(logger.getDIList().get(i).getLabel());
					}
				
					if(!vec.get(0).isEmpty()) {
					model.addRow(vec);
					}
					logger.log("��ü�� �ҷ��Խ��ϴ�.");
				}catch (ArrayIndexOutOfBoundsException e1) {
					return;
				}
				
				TFId.setText("");
				TFName.setText("");
				TFLen.setText("");
				TFState.setText("");
				TFLabel.setText("");
				logger.PutObject();
				table.updateUI();
			}
		});
		panel.add(View);
		//�ʱ�ȭ ��ư: ����ڰ� ���̺��� �ʹ� ����� ��� �̸� ���� ���̺��� �ʱ���·� ����
		JButton Clear = new JButton("�ʱ�ȭ");
		Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					for(int i = 0;; i++) {
						model.removeRow(i);
						table.updateUI();
					}
				}catch(ArrayIndexOutOfBoundsException e1) {
					logger.log("����Ʈ�� �ʱ�ȭ�Ͽ����ϴ�.");
					return;
				}
				
			}
		});
		panel.add(Clear);
		
		//gui ���̾ƿ��� ��ο� ���õ� �����
		JPanel panel_1 = new JPanel();
		splitPane.setLeftComponent(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 50, 0};
		gbl_panel_1.rowHeights = new int[]{0, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("ǥ����ȣ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		TFId = new JTextField();
		GridBagConstraints gbc_TFId = new GridBagConstraints();
		gbc_TFId.insets = new Insets(0, 0, 5, 0);
		gbc_TFId.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFId.gridx = 1;
		gbc_TFId.gridy = 0;
		panel_1.add(TFId, gbc_TFId);
		TFId.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("�̸�");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		TFName = new JTextField();
		GridBagConstraints gbc_TFName = new GridBagConstraints();
		gbc_TFName.insets = new Insets(0, 0, 5, 0);
		gbc_TFName.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFName.gridx = 1;
		gbc_TFName.gridy = 1;
		panel_1.add(TFName, gbc_TFName);
		TFName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("����");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 2;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		TFLen = new JTextField();
		GridBagConstraints gbc_TFLen = new GridBagConstraints();
		gbc_TFLen.insets = new Insets(0, 0, 5, 0);
		gbc_TFLen.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFLen.gridx = 1;
		gbc_TFLen.gridy = 2;
		panel_1.add(TFLen, gbc_TFLen);
		TFLen.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("����");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 3;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		TFState = new JTextField();
		GridBagConstraints gbc_TFState = new GridBagConstraints();
		gbc_TFState.insets = new Insets(0, 0, 5, 0);
		gbc_TFState.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFState.gridx = 1;
		gbc_TFState.gridy = 3;
		panel_1.add(TFState, gbc_TFState);
		TFState.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("��");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 4;
		panel_1.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		TFLabel = new JTextField();
		GridBagConstraints gbc_TFLabel = new GridBagConstraints();
		gbc_TFLabel.insets = new Insets(0, 0, 5, 0);
		gbc_TFLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFLabel.gridx = 1;
		gbc_TFLabel.gridy = 4;
		panel_1.add(TFLabel, gbc_TFLabel);
		TFLabel.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("ǥ������");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 5;
		panel_1.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("ǥ����ȣ");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 6;
		panel_1.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		TFDId = new JTextField();
		GridBagConstraints gbc_TFDId = new GridBagConstraints();
		gbc_TFDId.insets = new Insets(0, 0, 5, 0);
		gbc_TFDId.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFDId.gridx = 1;
		gbc_TFDId.gridy = 6;
		panel_1.add(TFDId, gbc_TFDId);
		TFDId.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("����");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 7;
		panel_1.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		TFDLen = new JTextField();
		GridBagConstraints gbc_TFDLen = new GridBagConstraints();
		gbc_TFDLen.insets = new Insets(0, 0, 5, 0);
		gbc_TFDLen.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFDLen.gridx = 1;
		gbc_TFDLen.gridy = 7;
		panel_1.add(TFDLen, gbc_TFDLen);
		TFDLen.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("��");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 8;
		panel_1.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		TFDLabel = new JTextField();
		GridBagConstraints gbc_TFDLabel = new GridBagConstraints();
		gbc_TFDLabel.insets = new Insets(0, 0, 5, 0);
		gbc_TFDLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFDLabel.gridx = 1;
		gbc_TFDLabel.gridy = 8;
		panel_1.add(TFDLabel, gbc_TFDLabel);
		TFDLabel.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("ǥ������");
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_11.gridx = 1;
		gbc_lblNewLabel_11.gridy = 9;
		panel_1.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("ǥ����ȣ");
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_12.gridx = 0;
		gbc_lblNewLabel_12.gridy = 10;
		panel_1.add(lblNewLabel_12, gbc_lblNewLabel_12);
		
		TFEId = new JTextField();
		GridBagConstraints gbc_TFEId = new GridBagConstraints();
		gbc_TFEId.insets = new Insets(0, 0, 5, 0);
		gbc_TFEId.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFEId.gridx = 1;
		gbc_TFEId.gridy = 10;
		panel_1.add(TFEId, gbc_TFEId);
		TFEId.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("��");
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_13.gridx = 0;
		gbc_lblNewLabel_13.gridy = 11;
		panel_1.add(lblNewLabel_13, gbc_lblNewLabel_13);
		
		TFELabel = new JTextField();
		GridBagConstraints gbc_TFELabel = new GridBagConstraints();
		gbc_TFELabel.insets = new Insets(0, 0, 5, 0);
		gbc_TFELabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFELabel.gridx = 1;
		gbc_TFELabel.gridy = 11;
		panel_1.add(TFELabel, gbc_TFELabel);
		TFELabel.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\uBCC0\uACBD\uC0C1\uD0DC");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 12;
		panel_1.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		TFEState = new JTextField();
		GridBagConstraints gbc_TFEState = new GridBagConstraints();
		gbc_TFEState.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFEState.gridx = 1;
		gbc_TFEState.gridy = 12;
		panel_1.add(TFEState, gbc_TFEState);
		TFEState.setColumns(10);
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
