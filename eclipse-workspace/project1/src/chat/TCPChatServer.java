package chat;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class TCPChatServer
{
	public static ArrayList<ServerThread> list;

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		list = new ArrayList<ServerThread>();
		try {
			ServerSocket ss = new ServerSocket(9123);
			System.out.println("서버가 가동되었습니다");
			while (true) {
				Socket sk = ss.accept();
				System.out.println("클라이언트가 접속했습니다");
				ServerThread st = new ServerThread(sk);
				list.add(st);
				st.start();
			}
		} catch (Exception e) {
			System.out.println("예외발생 :" + e.getMessage());
		}
	}
}