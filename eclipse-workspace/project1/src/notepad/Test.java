package notepad;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.*;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
class Notepad extends JFrame
{

	private JTextArea fileContents = new JTextArea();
	private JLabel fileStatus = new JLabel("0 characters");
	private String fileName = "untitled";

	private Notepad thisWindow = this;
	private File file;
	private JFileChooser jfc = new JFileChooser(".");
	private String content;
	// JTextArea ta = new JTextArea(content, 40, 50);

	public void run()
	{
		this.setTitle(fileName + " -Notepad");

		JMenuBar menuBar = new JMenuBar();
		JMenu menuFile = new JMenu("File");

		JMenuItem newFile = new JMenuItem("New File");
		JMenuItem open = new JMenuItem("Open");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem exit = new JMenuItem("Exit");

		menuFile.add(newFile);
		menuFile.add(open);
		menuFile.add(save);
		menuFile.add(exit);

		menuBar.add(menuFile);
		this.add(menuBar);
		setJMenuBar(menuBar);

		// 새로운 파일
		newFile.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				fileContents.setText("");
			}
		});
		// open

		open.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				JFileChooser jc = new JFileChooser();
				if (jc.showOpenDialog(Notepad.this) == jc.APPROVE_OPTION) {

					try {
						File f = jc.getSelectedFile();
						BufferedReader br = new BufferedReader(new FileReader(f));
						String str = "";
						fileContents.setText("");

						while ((str = br.readLine()) != null) // 파일이 끝날때까지 읽어드림
						{
							fileContents.append(str);
						}

					} catch (Exception ex) {
					}
				}
			}
		});

		exit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				System.exit(0);				
			}			
		});

		fileStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		JScrollPane scrollPane = new JScrollPane(fileContents);

		this.add(scrollPane);
		this.add("South", fileStatus);
		setBounds(300, 300, 700, 500);
		setVisible(true);

	}
}

public class Test
{
	public static void main(String args[])
	{
		Notepad pad = new Notepad();
		pad.run();
	}
}
