package breedingManagement;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.lang.System.Logger;
import java.util.LinkedList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;
import javax.swing.JScrollPane;

public class GUIMenu {

	private JFrame frame;
	private JTable table;
	private JTextField TFName;
	private JTextField TFId;
	private JTextField TFWeight;
	private JTextField TFMeal;
	private JTextField TFCNum;
	private JTextField EditTFWeight;
	private JTextField DeleteIdTF;
	private JTextField TFICNum;
	private JTextField TFDate;
	private JTextField TFICENum;
	BreedingMode breedingMode = new BreedingMode();
	LogClass logger = new LogClass("log.txt");

	LinkedList<aliveInsect> name = logger.getINList();

	public GUIMenu(String num) {
		initialize();
	}
	
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(0, 0, 0, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 600);
		frame.setTitle("YID-Project(My Insect Diary)");
		frame.setResizable(true);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		table = new JTable();
		table.setEnabled(false);
		Object []column = {"개체번호","개체이름","개체무게","먹이종류","교체횟수","투입일"};
		Object[][] object = new Object[][] {};
		DefaultTableModel model = new DefaultTableModel(object, column);
		table.setModel(model);
		
		JLabel lblBreedingproject = new JLabel("BreedingProject");
		lblBreedingproject.setBackground(SystemColor.desktop);
		lblBreedingproject.setForeground(new Color(0, 0, 0));
		lblBreedingproject.setHorizontalAlignment(SwingConstants.CENTER);
		lblBreedingproject.setFont(new Font("굴림", Font.BOLD, 30));
		frame.getContentPane().add(lblBreedingproject, BorderLayout.NORTH);
		
		JScrollBar scrollBar = new JScrollBar();
		frame.getContentPane().add(scrollBar, BorderLayout.EAST);
		
		JSplitPane splitPane_1 = new JSplitPane();
		frame.getContentPane().add(splitPane_1, BorderLayout.WEST);
		
		JLabel SMode = new JLabel("모드선택");
		SMode.setFont(new Font("굴림", Font.BOLD, 12));
		splitPane_1.setLeftComponent(SMode);
		
		JPanel panel = new JPanel();
		splitPane_1.setRightComponent(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton Add = new JButton("개체추가");			
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector<String> vec = new Vector<>();
				LinkedList<aliveInsect> list = logger.getINList();
				String id = TFId.getText();
				for(aliveInsect i : logger.getINList()) {
					if((""+i.getId()).equals(id)) {
						return;
					}
				}
				if(TFId.getText().isEmpty()) {
					return;
				}
				String name = TFName.getText();
				String weight = TFWeight.getText();
				String name2 = TFMeal.getText();
				String num = TFICNum.getText();
				String date = TFDate.getText();
				
				logger.getINList().add(new aliveInsect(Integer.parseInt(id), name, Double.parseDouble(weight), name2, Integer.parseInt(num),date));
				
				vec.add(id);
				vec.add(name);
				vec.add(weight);
				vec.add(name2);
				vec.add(num);
				vec.add(date);
				
				TFId.setText("");
				TFName.setText("");
				TFWeight.setText("");
				TFMeal.setText("");
				TFICNum.setText("");
				TFDate.setText("");
				
				model.addRow(vec);
				table.updateUI();
			}
		});
		panel.add(Add);
		
		JButton Delete = new JButton("개체제거");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String id = DeleteIdTF.getText();
					for(aliveInsect i : logger.getINList()) {
						if((""+i.getId()).equals(id)) {
							logger.getINList().remove(i);
							table.updateUI();
							return;
						}
					}
					table.updateUI();
				}catch (Exception e1) {
					return;
				}
			}
		});
		panel.add(Delete);
		
		JButton Edit = new JButton("개체편집");
		Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = TFCNum.getText(); 
				String weight = EditTFWeight.getText();
				String num = TFICENum.getText();
				for(int i = 0; i < logger.getINList().size(); i++) {
					if(logger.getINList().get(i).getId() == Integer.parseInt(id)) {
						breedingMode.Edit_Insect(Integer.parseInt(id), Double.parseDouble(weight), Integer.parseInt(num));
						table.updateUI();
					}
				}
			}
		});
		panel.add(Edit);
		
		JButton DryMode = new JButton("표본모드");
		DryMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				DryGui dryGui = new DryGui();
			}
		});
		panel.add(DryMode);
		
		JButton Manual = new JButton("설명서");
		Manual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				ManualGui manual = new ManualGui();
			}
		});
		
		JButton View = new JButton("목록출력");
		View.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				LinkedList<aliveInsect> name1 = logger.getINList();
				try{
					if(name1.isEmpty()) {
						return;
					}
				}catch (NumberFormatException e1) {
					return;
				}
				for(int i = 0; i < name1.size(); i++) {
					@SuppressWarnings("rawtypes")
					Vector vec = new Vector();
					vec.add(Integer.toString(name1.get(i).getId()));
					vec.add(name1.get(i).getName());
					vec.add(Double.toString(name1.get(i).getWeight()));
					vec.add(name1.get(i).getName2());
					vec.add(Integer.toString(name1.get(i).getNum()));
					vec.add(name1.get(i).getDate());
					model.addRow(vec);
				}

				table.updateUI();
			}
		});
		panel.add(View);
		panel.add(Manual);
		
		JButton End = new JButton("종료");
		End.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger.PutObject();
				System.exit(0);
			}
		});
		panel.add(End);
		
		JSplitPane splitPane = new JSplitPane();
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setRightComponent(scrollPane);
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		splitPane.setLeftComponent(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 50, 0};
		gbl_panel_1.rowHeights = new int[]{0, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel AddL = new JLabel("개체추가");
		GridBagConstraints gbc_AddL = new GridBagConstraints();
		gbc_AddL.insets = new Insets(0, 0, 5, 0);
		gbc_AddL.gridx = 1;
		gbc_AddL.gridy = 0;
		panel_1.add(AddL, gbc_AddL);
		
		JLabel Id = new JLabel("개체번호");
		GridBagConstraints gbc_Id = new GridBagConstraints();
		gbc_Id.insets = new Insets(0, 0, 5, 5);
		gbc_Id.anchor = GridBagConstraints.EAST;
		gbc_Id.gridx = 0;
		gbc_Id.gridy = 1;
		panel_1.add(Id, gbc_Id);
		
		TFId = new JTextField();
		GridBagConstraints gbc_TFId = new GridBagConstraints();
		gbc_TFId.insets = new Insets(0, 0, 5, 0);
		gbc_TFId.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFId.gridx = 1;
		gbc_TFId.gridy = 1;
		panel_1.add(TFId, gbc_TFId);
		TFId.setColumns(10);
		
		JLabel Name = new JLabel("이름");
		GridBagConstraints gbc_Name = new GridBagConstraints();
		gbc_Name.insets = new Insets(0, 0, 5, 5);
		gbc_Name.anchor = GridBagConstraints.EAST;
		gbc_Name.gridx = 0;
		gbc_Name.gridy = 2;
		panel_1.add(Name, gbc_Name);
		
		TFName = new JTextField();
		GridBagConstraints gbc_TFName = new GridBagConstraints();
		gbc_TFName.insets = new Insets(0, 0, 5, 0);
		gbc_TFName.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFName.gridx = 1;
		gbc_TFName.gridy = 2;
		panel_1.add(TFName, gbc_TFName);
		TFName.setColumns(10);
		
		JLabel Weight = new JLabel("무게");
		GridBagConstraints gbc_Weight = new GridBagConstraints();
		gbc_Weight.insets = new Insets(0, 0, 5, 5);
		gbc_Weight.anchor = GridBagConstraints.EAST;
		gbc_Weight.gridx = 0;
		gbc_Weight.gridy = 3;
		panel_1.add(Weight, gbc_Weight);
		
		TFWeight = new JTextField();
		GridBagConstraints gbc_TFWeight = new GridBagConstraints();
		gbc_TFWeight.insets = new Insets(0, 0, 5, 0);
		gbc_TFWeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFWeight.gridx = 1;
		gbc_TFWeight.gridy = 3;
		panel_1.add(TFWeight, gbc_TFWeight);
		TFWeight.setColumns(10);
		
		JLabel Meal = new JLabel("먹이종류");
		GridBagConstraints gbc_Meal = new GridBagConstraints();
		gbc_Meal.insets = new Insets(0, 0, 5, 5);
		gbc_Meal.anchor = GridBagConstraints.EAST;
		gbc_Meal.gridx = 0;
		gbc_Meal.gridy = 4;
		panel_1.add(Meal, gbc_Meal);
		
		TFMeal = new JTextField();
		GridBagConstraints gbc_TFMeal = new GridBagConstraints();
		gbc_TFMeal.insets = new Insets(0, 0, 5, 0);
		gbc_TFMeal.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFMeal.gridx = 1;
		gbc_TFMeal.gridy = 4;
		panel_1.add(TFMeal, gbc_TFMeal);
		TFMeal.setColumns(10);
		
		JLabel ICNum = new JLabel("교체횟수");
		GridBagConstraints gbc_ICNum = new GridBagConstraints();
		gbc_ICNum.anchor = GridBagConstraints.EAST;
		gbc_ICNum.insets = new Insets(0, 0, 5, 5);
		gbc_ICNum.gridx = 0;
		gbc_ICNum.gridy = 5;
		panel_1.add(ICNum, gbc_ICNum);
		
		TFICNum = new JTextField();
		GridBagConstraints gbc_TFICNum = new GridBagConstraints();
		gbc_TFICNum.insets = new Insets(0, 0, 5, 0);
		gbc_TFICNum.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFICNum.gridx = 1;
		gbc_TFICNum.gridy = 5;
		panel_1.add(TFICNum, gbc_TFICNum);
		TFICNum.setColumns(10);
		
		JLabel date = new JLabel("투입일");
		GridBagConstraints gbc_date = new GridBagConstraints();
		gbc_date.anchor = GridBagConstraints.EAST;
		gbc_date.insets = new Insets(0, 0, 5, 5);
		gbc_date.gridx = 0;
		gbc_date.gridy = 6;
		panel_1.add(date, gbc_date);
		
		TFDate = new JTextField();
		GridBagConstraints gbc_TFDate = new GridBagConstraints();
		gbc_TFDate.insets = new Insets(0, 0, 5, 0);
		gbc_TFDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFDate.gridx = 1;
		gbc_TFDate.gridy = 6;
		panel_1.add(TFDate, gbc_TFDate);
		TFDate.setColumns(10);
		
		JLabel EditL = new JLabel("개체편집");
		GridBagConstraints gbc_EditL = new GridBagConstraints();
		gbc_EditL.insets = new Insets(0, 0, 5, 0);
		gbc_EditL.gridx = 1;
		gbc_EditL.gridy = 7;
		panel_1.add(EditL, gbc_EditL);
		
		JLabel CNum = new JLabel("교체번호");
		GridBagConstraints gbc_CNum = new GridBagConstraints();
		gbc_CNum.anchor = GridBagConstraints.EAST;
		gbc_CNum.insets = new Insets(0, 0, 5, 5);
		gbc_CNum.gridx = 0;
		gbc_CNum.gridy = 8;
		panel_1.add(CNum, gbc_CNum);
		
		TFCNum = new JTextField();
		GridBagConstraints gbc_TFCNum = new GridBagConstraints();
		gbc_TFCNum.insets = new Insets(0, 0, 5, 0);
		gbc_TFCNum.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFCNum.gridx = 1;
		gbc_TFCNum.gridy = 8;
		panel_1.add(TFCNum, gbc_TFCNum);
		TFCNum.setColumns(10);
		
		JLabel EditWeight = new JLabel("변경무게");
		GridBagConstraints gbc_EditWeight = new GridBagConstraints();
		gbc_EditWeight.anchor = GridBagConstraints.EAST;
		gbc_EditWeight.insets = new Insets(0, 0, 5, 5);
		gbc_EditWeight.gridx = 0;
		gbc_EditWeight.gridy = 9;
		panel_1.add(EditWeight, gbc_EditWeight);
		
		EditTFWeight = new JTextField();
		GridBagConstraints gbc_EditTFWeight = new GridBagConstraints();
		gbc_EditTFWeight.insets = new Insets(0, 0, 5, 0);
		gbc_EditTFWeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_EditTFWeight.gridx = 1;
		gbc_EditTFWeight.gridy = 9;
		panel_1.add(EditTFWeight, gbc_EditTFWeight);
		EditTFWeight.setColumns(10);
		
		JLabel Cnum = new JLabel("교체횟수");
		GridBagConstraints gbc_Cnum = new GridBagConstraints();
		gbc_Cnum.anchor = GridBagConstraints.EAST;
		gbc_Cnum.insets = new Insets(0, 0, 5, 5);
		gbc_Cnum.gridx = 0;
		gbc_Cnum.gridy = 10;
		panel_1.add(Cnum, gbc_Cnum);
		
		TFICENum = new JTextField();
		GridBagConstraints gbc_TFICENum = new GridBagConstraints();
		gbc_TFICENum.insets = new Insets(0, 0, 5, 0);
		gbc_TFICENum.fill = GridBagConstraints.HORIZONTAL;
		gbc_TFICENum.gridx = 1;
		gbc_TFICENum.gridy = 10;
		panel_1.add(TFICENum, gbc_TFICENum);
		TFICENum.setColumns(10);
		
		JLabel DeleteL = new JLabel("개체제거");
		GridBagConstraints gbc_DeleteL = new GridBagConstraints();
		gbc_DeleteL.insets = new Insets(0, 0, 5, 0);
		gbc_DeleteL.gridx = 1;
		gbc_DeleteL.gridy = 11;
		panel_1.add(DeleteL, gbc_DeleteL);
		
		JLabel DeleteId = new JLabel("제거번호");
		GridBagConstraints gbc_DeleteId = new GridBagConstraints();
		gbc_DeleteId.anchor = GridBagConstraints.EAST;
		gbc_DeleteId.insets = new Insets(0, 0, 5, 5);
		gbc_DeleteId.gridx = 0;
		gbc_DeleteId.gridy = 12;
		panel_1.add(DeleteId, gbc_DeleteId);
		
		DeleteIdTF = new JTextField();
		GridBagConstraints gbc_DeleteIdTF = new GridBagConstraints();
		gbc_DeleteIdTF.insets = new Insets(0, 0, 5, 0);
		gbc_DeleteIdTF.fill = GridBagConstraints.HORIZONTAL;
		gbc_DeleteIdTF.gridx = 1;
		gbc_DeleteIdTF.gridy = 12;
		panel_1.add(DeleteIdTF, gbc_DeleteIdTF);
		DeleteIdTF.setColumns(10);
		

		frame.setVisible(true);
	}

}
