package GUI.Two;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class GUIApp extends JFrame {

	private static final String FILE_PATH = "data.dat";

	School sc = new School();

	Person p;
	JScrollPane sp, editscroll;
	JTextArea ta;

	JTable editjt;
	DefaultTableModel Storage;

	JButton register, delete, edit, search, modify, print, save, load;
	JButton btnST, btnTCH, btnSTF, btnSearchOK, btnSearchClose;
	JButton btnOK, btnCancel, btnClose;

	JDialog dialog1, dialog2, dialog3, editdialog;

	JLabel LBName, LBAddr, LBId, LBOther, editLabel;

	JTextField TFName, TFAddr, TFId, TFOther, TFSearchName;

	public GUIApp() {

		super("GUI APP");

		init();
		start();

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		setSize(500, 500);
		setVisible(true);

	}

	public void init() {

		ta = new JTextArea();
		getContentPane().add(new JScrollPane(ta), "Center");

		JPanel pn = new JPanel(new GridLayout(0, 1, 10, 10)) {

			public Insets getInsets() {
				return new Insets(10, 10, 10, 10);
			}
		};

		pn.setBackground(Color.BLACK);
		getContentPane().add(pn, "East");

		pn.add(register = new JButton("INSERT"));
		pn.add(edit = new JButton("EDIT"));
		pn.add(delete = new JButton("DELETE"));
		pn.add(print = new JButton("PRINT"));
		pn.add(save = new JButton("SAVE"));
		pn.add(load = new JButton("LOAD"));

		dialog1 = new JDialog(this, true);
		dialog2 = new JDialog(this, true);
		dialog3 = new JDialog(this, "==SEARCH==", true);
		editdialog = new JDialog(this, true);

		btnST = new JButton("STU");
		btnTCH = new JButton("TCR");
		btnSTF = new JButton("STF");
		btnClose = new JButton("Close");
		// EDIT

		JPanel editPN = new JPanel();
		JPanel editPN1 = new JPanel();

		editLabel = new JLabel("EDIT LIST");
		editdialog.setTitle("EDIT");
		editdialog.getContentPane().add(editLabel, "North");
		editPN.setBorder(new EmptyBorder(5, 5, 5, 5));
		editdialog.setContentPane(editPN);

		editscroll = new JScrollPane();
		editPN.add(editscroll);

		String[] column = { "JOB", "ID", "NAME", "ADDRESS", "Pub" };

		Storage = new DefaultTableModel(column, 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		editjt = new JTable(Storage);
		editjt.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		editjt.setAutoCreateRowSorter(true);
		editjt.setCellSelectionEnabled(rootPaneCheckingEnabled);
		editjt.setUpdateSelectionOnSort(true);
		editscroll.setViewportView(editjt);

		Storage.setColumnIdentifiers(column);
		
		

		editPN1.setLayout(new GridLayout(0, 1, 0, 23));
		editPN1.add(search = new LargeBTN("SEARCH"));
		editPN1.add(modify = new LargeBTN("MODIFY"));
		editPN1.add(delete = new LargeBTN("DELETE"));
		editdialog.getContentPane().add(editPN1);

		// end edit
		dialog1.setTitle("==INSERT==");
		dialog1.getContentPane().setLayout(new GridLayout(1, 0));
		dialog1.getContentPane().add(btnST);
		dialog1.getContentPane().add(btnTCH);
		dialog1.getContentPane().add(btnSTF);
		dialog1.getContentPane().add(btnClose);

		JPanel dialogPN1 = new JPanel();
		JPanel dialogPN2 = new JPanel();
		JPanel dialogPN3 = new JPanel();

		dialogPN1.setLayout(new GridLayout(4, 1));
		dialogPN2.setLayout(new GridLayout(4, 1));

		dialog2.getContentPane().add(dialogPN1, "West");
		dialog2.getContentPane().add(dialogPN2, "Center");
		dialog2.getContentPane().add(dialogPN3, "South");

		dialogPN1.add(LBName = new JLabel("Name"));
		dialogPN1.add(LBAddr = new JLabel("Address"));
		dialogPN1.add(LBId = new JLabel("ID"));
		dialogPN1.add(LBOther = new JLabel("OTHER"));

		dialogPN2.add(TFName = new JTextField());
		dialogPN2.add(TFAddr = new JTextField());
		dialogPN2.add(TFId = new JTextField());
		dialogPN2.add(TFOther = new JTextField());

		dialogPN3.add(btnOK = new JButton("OK"));
		dialogPN3.add(btnCancel = new JButton("Cancel"));

		JLabel label = new JLabel("Input Name");
		dialog3.getContentPane().add(label, "North");
		JPanel dialogPN4 = new JPanel();
		dialog3.getContentPane().add(dialogPN4, "Center");
		TFSearchName = new JTextField(20);
		dialogPN4.add(TFSearchName);
		btnSearchOK = new JButton("OK");
		btnSearchClose = new JButton("Cancel");
		dialogPN4.add(btnSearchOK);
		dialogPN4.add(btnSearchClose);

		MyHandler my = new MyHandler();
		register.addActionListener(my);
		edit.addActionListener(my);
		search.addActionListener(my);
		delete.addActionListener(my);
		print.addActionListener(my);
		save.addActionListener(my);
		load.addActionListener(my);

		btnST.addActionListener(my);
		btnTCH.addActionListener(my);
		btnSTF.addActionListener(my);
		btnOK.addActionListener(my);
		btnCancel.addActionListener(my);
		btnClose.addActionListener(my);

		btnSearchOK.addActionListener(my);
		btnSearchClose.addActionListener(my);

		ta.setEditable(false);

	}
	
	

	class MyHandler implements ActionListener {

		public void saveData()
		{
			FileOutputStream fos = null;
			ObjectOutputStream oos = null;

			try {

				fos = new FileOutputStream(FILE_PATH);
				oos = new ObjectOutputStream(fos);

				oos.writeObject(sc.getPeople());
				oos.flush();

			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, e2.getMessage());
			} finally {

				if (fos != null)
					try {
						fos.close();
					} catch (IOException e2) {
					}
				if (oos != null)
					try {
						oos.close();
					} catch (IOException e2) {
					}
			}
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {

			Object o = e.getSource();
			if (o == register) {
				dialog1.pack();
				dialog1.setLocation(500, 0);
				dialog1.setVisible(true);
			} else if (o == edit) {
				editdialog.setTitle("==Edit==");
				editdialog.pack();
				editdialog.setVisible(true);
			} else if (o == search) {
				editdialog.setTitle("==Search==");
				editdialog.pack();
				editdialog.setVisible(true);
			} else if (o == delete) {
				dialog3.setTitle("==Delete==");
				dialog3.pack();
				dialog3.setVisible(true);
			} else if (o == print) {
				if (sc.PrintAll() == null) {
					String str = "NO Information";
					ta.append(str + "\n");
				} else {
					String str = sc.PrintAll();
					ta.append(str + "\n");
				}
			} else if (o == save) {

				saveData();

			} else if (o == load) {

				FileInputStream fis = null;
				ObjectInputStream ois = null;
				
				Storage.setNumRows(0);//테이블 모두 지우기(이 코드가 없다면 로드 버튼을 누룰때 마다 계속 늘어남)
				
				try {

					fis = new FileInputStream(FILE_PATH);
					ois = new ObjectInputStream(fis);
					
					List<Person> people = (List<Person>) ois.readObject();
					sc.setPeople(people);
					
					for(Person p:people)//리스트에서 한개식 처리
					{
						String[] column = {p.getUnique(), p.getID(), p.getName(), p.getAddress(),p.getOther()};
						Storage.addRow(column);//만들어진 배열로 테이블에 추가
					}
					System.out.println(people);					

				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}

			} else if (o == btnST) {

				dialog2.setTitle("STU");
				LBId.setText("STNumber");
				LBOther.setText("Class");
				dialog2.pack();
				dialog2.setLocation(500, 30);
				dialog2.setVisible(true);
			} else if (o == btnTCH) {
				dialog2.setTitle("TCR");
				LBId.setText("TNumber");
				LBOther.setText("Subejct");
				dialog2.pack();
				dialog2.setLocation(500, 30);
				dialog2.setVisible(true);
			} else if (o == btnSTF) {
				dialog2.setTitle("STF");
				LBId.setText("STFNumber");
				LBOther.setText("Dept");
				dialog2.pack();
				dialog2.setLocation(500, 30);
				dialog2.setVisible(true);

			} else if (o == btnOK) {
				String name = TFName.getText();
				String address = TFAddr.getText();
				String id = TFId.getText();

				String other = TFOther.getText();
				
				String job = "";

				String title = dialog2.getTitle();
				System.out.println(title);
				String word = title.substring(0, 3);

				if (word.equals("STU")) {
					p = new Student();
					((Student) p).setClassName(other);
					((Student) p).setUnique("Student");
					job = "Student";
				} else if (word.equals("TCR")) {
					p = new Teacher();
					((Teacher) p).setSubject(other);
					((Teacher) p).setUnique("Teacher");
					job = "Teacher";
				} else if (word.equals("STF")) {
					p = new Staff();
					((Staff) p).setDept(other);
					((Staff) p).setUnique("Staff");
					job = "Staff";
				}
				p.setName(name);
				p.setAddress(address);
				p.setID(id);

				sc.addPerson(p);
				String[] column = {job,id,name,address,other};
				Storage.addRow(column);

				String str = "INSERT COMPLETE";
				ta.append(str + "\t Name==" + name + "\n");

				TFName.setText("");
				TFId.setText("");
				TFAddr.setText("");
				TFOther.setText("");
				TFName.requestFocus();
				
				saveData();
				
			} else if (o == btnCancel) {
				dialog2.dispose();
				TFName.setText("");
				TFId.setText("");
				TFAddr.setText("");
				TFOther.setText("");
			} else if (o == btnClose) {
				dialog1.dispose();
			}
			if (o == btnSearchOK) {
				String title = dialog3.getTitle();
				String word = title.substring(2, 8);
				System.out.println(word);
				if (word.equals("Search")) {
					String name = TFSearchName.getText();
					String msg = sc.Serching(name);

					ta.append(msg + "\n");
				} else {
					String name = TFSearchName.getText();
					String msg = sc.Delete(name);

					ta.append(msg + "\n");
				}
				TFSearchName.setText("");
			} else if (o == btnSearchClose) {
				dialog3.dispose();
			}
		}
	}

	public void start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new GUIApp();
	}

}
