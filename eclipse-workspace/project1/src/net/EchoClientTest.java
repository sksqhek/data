package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.*;

public class EchoClientTest {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		EchoClient echo = new EchoClient();
		echo.start(); // 서버로부터 데이터 읽기위한 쓰레드 실행
		try {
			while (true) {
				System.out.println("서버로 보낼 메시지를 입력하세요.(종료:exit)");
				String msg = s.next(); // 사용자로부터 보낼 메시지를 입력받음
				echo.sendMsg(msg); // 메시지 전송
				if (msg.equals("exit")) { // 종료
					System.out.println("접속을 종료합니다.");
					echo.closeAll(); // 소켓 종료
					if (echo != null)
						echo = null; // 쓰레드 종료
					break;
				}
			}
		} catch (Exception e) {
		}
	}
}

class EchoClient extends Thread {
	Socket mySocket = null;
	DataInputStream dis = null;
	DataOutputStream dos = null;

	/**
	 * 클라이언트 처리 쓰래드 생성자
	 * 
	 * @param socket
	 */
	public EchoClient() {
		try {
			mySocket = new Socket("127.0.0.1", 10000); // 서버에 접속
			System.out.println("서버에 접속했습니다.");
			dis = new DataInputStream(mySocket.getInputStream());
			dos = new DataOutputStream(mySocket.getOutputStream());
		} catch (Exception e) {
			System.out.println("서버에 접속할 수 없습니다.");
			System.exit(0);
		}
	}

	/**
	 * 서버가 보내는 메시지를 수신하는 기능을 수행한다.
	 */
	public void run() {
		byte[] readdata = null;
		try {
			while (true) {
				int length = dis.read();
				readdata = new byte[length];
				int readlen = dis.read(readdata);
				System.out.println(new String(readdata));
			}
		} catch (Exception e) {
		}
	}

	/**
	 * 서버에게 메시지를 보낸다.
	 * 
	 * @param str
	 */
	public void sendMsg(String msg) {
		try {
			dos.write((byte) msg.getBytes().length);
			dos.write(msg.getBytes());
			dos.flush();
		} catch (Exception e) {
		}
	}

	public void closeAll() {
		try {
			mySocket = null;
			dis = null;
			dos = null;
		} catch (Exception e) {
		}
	}
}
