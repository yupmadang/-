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
	//gui생성자
	public DryGui() {
		initialize();
	}
	//gui를 구성하는 initialize메서드
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
				table.updateUI();
			}
		});
		panel.add(Add);
		
		JButton Delete = new JButton("표본제거");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String id = TFId.getText();
					String label = TFLabel.getText();
					String len = TFLen.getText();
					//3가지 표본 정보와 일치할 경우 파일에서 그 객체를 제거
					for(DryInsect i : logger.getDIList()) {
						if((""+i.getId()).equals(id) && i.getLabel().equals(label) && i.getLength() == Double.parseDouble(len)) {
							logger.getDIList().remove(i);
							table.updateUI();
							
							try{
								//객체가 제거된 후 테이블 갱신
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
		//표본 상태를 관리하기 위한 이벤트 처리
		JButton Edit = new JButton("표본수정");
		Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//파일에 저장된 객체를 순회하여 일치하는 값이 있을 경우 state로 상채를 갱신함
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
		gbl_panel_1.rowHeights = new int[]{0, 15, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_6 = new JLabel("개체추가");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 0;
		panel_1.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JLabel lblNewLabel_1 = new JLabel("표본번호");
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
		
		JLabel lblNewLabel_2 = new JLabel("이름");
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
		
		JLabel lblNewLabel_3 = new JLabel("길이");
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
		
		JLabel lblNewLabel_4 = new JLabel("상태");
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
		
		JLabel lblNewLabel_5 = new JLabel("라벨");
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
