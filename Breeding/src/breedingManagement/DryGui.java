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
	//gui������
	public DryGui() {
		initialize();
	}
	//gui�� �����ϴ� initialize�޼���
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.setBounds(100, 100, 450, 300);
		frame.setSize(800, 400);
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
				table.updateUI();
			}
		});
		panel.add(Add);
		
		JButton Delete = new JButton("ǥ������");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String id = TFId.getText();
					String label = TFLabel.getText();
					String len = TFLen.getText();
					//3���� ǥ�� ������ ��ġ�� ��� ���Ͽ��� �� ��ü�� ����
					for(DryInsect i : logger.getDIList()) {
						if((""+i.getId()).equals(id) && i.getLabel().equals(label) && i.getLength() == Double.parseDouble(len)) {
							logger.getDIList().remove(i);
							table.updateUI();
							
							try{
								//��ü�� ���ŵ� �� ���̺� ����
								for(int j = 0;;j++) {
									model.removeRow(j);
									TFId.setText("");
									TFName.setText("");
									TFLen.setText("");
									TFState.setText("");
									TFLabel.setText("");
									table.updateUI();
								}
								
							}catch (ArrayIndexOutOfBoundsException e2) {
								return;
							}
						}
					}
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
						int id = Integer.parseInt(TFId.getText()); 
						String label = TFLabel.getText(); 
						String state = TFState.getText(); 
					
						if(logger.getDIList().get(i).getId() == id && logger.getDIList().get(i).getLabel().equals(label)) {
							breedingMode.Edit_Insect(id, label, state);
							logger.PutObject();
						}
					}
				}catch (NumberFormatException e2) {
					return;
				}
					TFId.setText("");
					TFName.setText("");
					TFLen.setText("");
					TFState.setText("");
					TFLabel.setText("");
					
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
		gbl_panel_1.rowHeights = new int[]{0, 15, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_6 = new JLabel("��ü�߰�");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 0;
		panel_1.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JLabel lblNewLabel_1 = new JLabel("ǥ����ȣ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		TFId = new JTextField();
		GridBagConstraints gbc_TFId = new GridBagConstraints();
		gbc_TFId.insets = new Insets(0, 0, 5, 0);
		gbc_TFId.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFId.gridx = 1;
		gbc_TFId.gridy = 1;
		panel_1.add(TFId, gbc_TFId);
		TFId.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("�̸�");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		TFName = new JTextField();
		GridBagConstraints gbc_TFName = new GridBagConstraints();
		gbc_TFName.insets = new Insets(0, 0, 5, 0);
		gbc_TFName.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFName.gridx = 1;
		gbc_TFName.gridy = 2;
		panel_1.add(TFName, gbc_TFName);
		TFName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("����");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		TFLen = new JTextField();
		GridBagConstraints gbc_TFLen = new GridBagConstraints();
		gbc_TFLen.insets = new Insets(0, 0, 5, 0);
		gbc_TFLen.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFLen.gridx = 1;
		gbc_TFLen.gridy = 3;
		panel_1.add(TFLen, gbc_TFLen);
		TFLen.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("����");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		TFState = new JTextField();
		GridBagConstraints gbc_TFState = new GridBagConstraints();
		gbc_TFState.insets = new Insets(0, 0, 5, 0);
		gbc_TFState.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFState.gridx = 1;
		gbc_TFState.gridy = 4;
		panel_1.add(TFState, gbc_TFState);
		TFState.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("��");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		panel_1.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		TFLabel = new JTextField();
		GridBagConstraints gbc_TFLabel = new GridBagConstraints();
		gbc_TFLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFLabel.gridx = 1;
		gbc_TFLabel.gridy = 5;
		panel_1.add(TFLabel, gbc_TFLabel);
		TFLabel.setColumns(10);
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
