package net;

//package wipi_book_netserver;
import java.net.*;
import java.io.*;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2003
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author unascribed
 * @version 1.0
 */
public class EchoServer extends Thread {
	static int ClientCnt = 0;
	Socket sock = null;
	DataInputStream dis = null;
	DataOutputStream dos = null;

	/**
	 * 클라이언트 처리 쓰래드 생성자
	 * 
	 * @param socket
	 */
	public EchoServer(Socket socket) {
		ClientCnt++;
		System.out.println("전체 " + ClientCnt + " 명의 클라이언트가 접속했습니다.");
		try {
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (Exception e) {
		}
	}

	/**
	 * 클라이언트가 원하는 기능을 수행한다.
	 */
	public void run() {
		byte[] readdata = null;
		try {
			while (true) {
				int length = dis.read();
				readdata = new byte[length];
				int readlen = dis.read(readdata);
				String msg = new String(readdata);
				System.out.println(msg);
				if (readlen > 0) {
					
					if (msg.equals("접속자수")) {
						response(ClientCnt + "");
					}else
					{
						response(msg);
					}
				}				
				
				if (msg.equals("exit")) {
					ClientCnt--;
					System.out.println("클라이언트가 접속을 종료했습니다.");
					System.out.println("현재 " + ClientCnt + " 명의 클라이언트가 접속했습니다.");
					closeAll();
					break;
				}
			}
		} catch (Exception e) {
		}
	}

	/**
	 * Re>를 추가하여 다시 클라이언트에게 보낸다.
	 * 
	 * @param str
	 */
	private void response(String str) {
		try {
			String returnstr = "RE>" + str;
			dos.write((byte) returnstr.getBytes().length);
			dos.write(returnstr.getBytes());
		} catch (Exception e) {
		}
	}

	public void closeAll() {
		try {
			sock = null;
			dis = null;
			dos = null;
		} catch (Exception e) {
		}
	}

	/**
	 * 클라이 언트의 접속을 받아 들인다.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ServerSocket m_serversocket = null;
		try {
			m_serversocket = new ServerSocket(10000);
			while (true) {
				System.out.println("클라이언트의 접속을 기다리고 있습니다.");
				Socket socket = m_serversocket.accept();
				new EchoServer(socket).start();
			}
		} catch (Exception e) {
		}
	}
}