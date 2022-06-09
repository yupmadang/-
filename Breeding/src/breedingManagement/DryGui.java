package breedingManagement;
//표본목록을 다루는 gui
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
	//파일에서 값을 불러오고 추가하기 위한 선언
	BreedingMode breedingMode = new BreedingMode();
	LogClass logger = new LogClass("log.txt");
	private JTextField TFDId;
	private JTextField TFDLen;
	private JTextField TFDLabel;
	private JTextField TFEId;
	private JTextField TFELabel;
	private JTextField TFEState;
	//gui생성자
	public DryGui() {
		initialize();
	}
	//gui를 구성하는 initialize메서드
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
		lblBreedingproject.setFont(new Font("굴림", Font.BOLD, 30));
		frame.getContentPane().add(lblBreedingproject, BorderLayout.NORTH);
		
		JSplitPane splitPane = new JSplitPane();
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setRightComponent(scrollPane);
		
		//테이블 선언과 column의 값 이름 설정
		table = new JTable();
		Object column[] = {"표본번호", "표본이름", "표본길이", "상태", "라벨"};
		Object[][] object = new Object[][] {};
		DefaultTableModel model = new DefaultTableModel(object, column);
		table.setModel(model);
		
		//테이블의 각 column의 간격 설정
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(200);
		table.setEnabled(false);
		//table에 반영
		scrollPane.setViewportView(table);
		
		JSplitPane splitPane_1 = new JSplitPane();
		frame.getContentPane().add(splitPane_1, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("표본모드");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 12));
		splitPane_1.setLeftComponent(lblNewLabel);
		
		JPanel panel = new JPanel();
		splitPane_1.setRightComponent(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		//표본 추가 버튼
		JButton Add = new JButton("표본추가");
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//추가를 위한 벡터 선언
				Vector<String> vec = new Vector<>();
				String id = TFId.getText();
				//id가 빈 경우 종료
				if(TFId.getText().isEmpty()) {
					return;
				}
				String name = TFName.getText();
				String len = TFLen.getText();
				String state = TFState.getText();
				String label = TFLabel.getText();
				
				
				logger.getDIList().add(new DryInsect(Integer.parseInt(id),name, Double.parseDouble(len),state,label));
				logger.PutObject();
				//벡터에 값 추가
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
				//model을 활용한 리스트에 반영
				model.addRow(vec);
				logger.log(id+"를 추가하였습니다.");
				table.updateUI();
			}
		});
		panel.add(Add);
		
		JButton Delete = new JButton("표본제거");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String id = TFDId.getText();
					String label = TFDLabel.getText();
					String len = TFDLen.getText();
					//3가지 표본 정보와 일치할 경우 파일에서 그 객체를 제거
					for(DryInsect i : logger.getDIList()) {
						if((""+i.getId()).equals(id) && i.getLabel().equals(label) && i.getLength() == Double.parseDouble(len)) {
							logger.getDIList().remove(i);
							table.updateUI();
							
							try{
								//객체가 제거된 후 테이블 갱신
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
					logger.log(id+"를 제거하였습니다.");
				}catch (Exception e1) {
					return;
				}
			}
		});
		panel.add(Delete);
		//표본 상태를 관리하기 위한 이벤트 처리
		JButton Edit = new JButton("표본수정");
		Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//파일에 저장된 객체를 순회하여 일치하는 값이 있을 경우 state로 상채를 갱신함
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
					logger.log("상태를 수정하였습니다.");
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
		//파일에 가진 객체를 모두 테이블에 불러오는 버튼
		JButton View = new JButton("표본출력");
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
					logger.log("객체를 불러왔습니다.");
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
		//초기화 버튼: 사용자가 테이블이 너무 길어진 경우 이를 통해 테이블을 초기상태로 돌림
		JButton Clear = new JButton("초기화");
		Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					for(int i = 0;; i++) {
						model.removeRow(i);
						table.updateUI();
					}
				}catch(ArrayIndexOutOfBoundsException e1) {
					logger.log("리스트를 초기화하였습니다.");
					return;
				}
				
			}
		});
		panel.add(Clear);
		
		//gui 레이아웃과 페널에 관련된 선언부
		JPanel panel_1 = new JPanel();
		splitPane.setLeftComponent(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 50, 0};
		gbl_panel_1.rowHeights = new int[]{0, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("표본번호");
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
		
		JLabel lblNewLabel_2 = new JLabel("이름");
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
		
		JLabel lblNewLabel_3 = new JLabel("길이");
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
		
		JLabel lblNewLabel_4 = new JLabel("상태");
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
		
		JLabel lblNewLabel_5 = new JLabel("라벨");
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
		
		JLabel lblNewLabel_7 = new JLabel("표본제거");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 5;
		panel_1.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("표본번호");
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
		
		JLabel lblNewLabel_9 = new JLabel("길이");
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
		
		JLabel lblNewLabel_10 = new JLabel("라벨");
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
		
		JLabel lblNewLabel_11 = new JLabel("표본편집");
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_11.gridx = 1;
		gbc_lblNewLabel_11.gridy = 9;
		panel_1.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("표본번호");
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
		
		JLabel lblNewLabel_13 = new JLabel("라벨");
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
