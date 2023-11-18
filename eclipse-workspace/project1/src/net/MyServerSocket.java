package net;

import java.io.*;
import java.net.*;

public class MyServerSocket {
	public static void main(String[] args) {
		try {
			ServerSocket myServerSocket = new ServerSocket(8080);
			System.out.println("클라이언트가 접속하길 기다리고 있습니다.");
			Socket mySocket = myServerSocket.accept(); // 클라이언트 접속때까지 대기

			System.out.println("클라이언트가 접속했습니다.");
			// 클라이언트 소켓에 스트림을 연결
			BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
			PrintWriter out = new PrintWriter(new OutputStreamWriter(mySocket.getOutputStream()));
												
			//클라이너트 ip 받기
			System.out.println("접속 클라이언트로 IP: " + in.readLine());
			
			// 클라이언트 소켓에 메시지 전송
			String msg = "";
			while ((msg = in.readLine()) != null) {//클라이언트에게서 받기
				out.println(msg);//클라이언트로 보내기
				out.flush();
				System.out.println("클라이언트에게 보낸 메시지: " + msg);
			}
			mySocket.close();
		} catch (MalformedURLException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}
}