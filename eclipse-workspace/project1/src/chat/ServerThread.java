package chat;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

public class ServerThread extends Thread
{
	Socket sk;
	InputStream is;
	OutputStream os;

	public ServerThread(Socket sk)
	{
		this.sk = sk;
		try {
			is = sk.getInputStream();
			os = sk.getOutputStream();
		} catch (Exception e) {
			System.out.println("예외발생 " + e.getMessage());
		}
	}

	public void sendAll(byte[] data)
	{
		for (ServerThread st : TCPChatServer.list) {
			//
			try {
				st.os.write(data);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
	}

	public void run()
	{
		byte[] data = new byte[100];
		while (true) {
			try {
				is.read(data);
				sendAll(data);
				Arrays.fill(data, (byte) 0);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				break;
			}
		}
	}
}