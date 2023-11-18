package chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;
import java.util.Arrays;

import javax.swing.*;

public class TCPChatClient extends JFrame
{
	JTextField jtf;
	JTextArea jta;
	BufferedImage img;
	InputStream is;
	OutputStream os;
	FileOutputStream fos;
	Socket sk;
	JFileChooser jfc;
	String ip;
	boolean isNew;
	File file;

	public TCPChatClient(String ip)
	{
		this.ip = ip;
		jtf = new JTextField(50);
		jta = new JTextArea();
		jfc = new JFileChooser();
		JScrollPane jsp = new JScrollPane(jta);//
		jta.setEditable(false);// JTextArea에 직접 입력 불가능(수정불가능)하게 해줌
		JButton btn = new JButton("전송");
		JButton btn_close = new JButton("종료");
		JButton btn_file = new JButton("파일");
		JPanel p = new JPanel();
		DataOutputStream dos;
		DataInputStream dis;
		p.add(jtf);
		p.add(btn);
		p.add(btn_close);
		p.add(btn_file);
		add(jsp, BorderLayout.CENTER);
		add(p, BorderLayout.SOUTH);
		setSize(800, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			sk = new Socket(ip, 9123);
			jta.append(ip + "님이 연결됐습니다" + "\n");
			is = sk.getInputStream();
			os = sk.getOutputStream();
		} catch (Exception e) {
			System.out.println("예외발생  : " + e.getMessage());
		}
		btn_close.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				try {
					jta.append(ip + "님이 종료하였습니다" + "\n");
					System.exit(0);
					sk.close();
				} catch (Exception e1) {
					System.out.println("예외발생 : " + e1.getMessage());
				}
			}
		});
		
		btn_file.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				openFile();
				send(); // 파일 전송방법??
			}
		});
		jtf.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String msg = jtf.getText();
				send();
				jtf.setText("");
			}
		});
		btn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String msg = jtf.getText();
				send();
				jtf.setText("");
			}
		});
		class ClientThread extends Thread
		{
			public void run()
			{
				byte[] data = new byte[100];
				while (true) {
					try {
						is.read(data);
						String msg = new String(data);
						jta.append(msg + "\n");
						jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
						// 자바의 스크롤을 밑으로 자동설정
						Arrays.fill(data, (byte) 0);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}// 이너 클래스의 끝
		ClientThread ct = new ClientThread();
		ct.start();
	}// 생성자의 끝

	public void exit()
	{
		System.exit(0);
	}// 종료 버튼의 "종료"기능

	protected void send()
	{
		String msg = jtf.getText();
		byte[] data = msg.getBytes();
		try {
			os.write(data);
		} catch (Exception e) {
			System.out.println("예외발생  :" + e.getMessage());
		}
	}

	protected void openFile()
	{
		jfc.showOpenDialog(this);
		file = jfc.getSelectedFile();
	}

	public static void main(String[] args)
	{
		//new TCPChatClient(args[0]);
		new TCPChatClient("127.0.0.1");
	}
}