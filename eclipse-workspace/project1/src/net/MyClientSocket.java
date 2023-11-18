package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyClientSocket {
	
	public static void main(String args[])throws Exception
	{
		Scanner s = new Scanner(System.in);		
		Socket mySocket = new Socket("127.0.0.1", 8080); // 서버에 접속
		System.out.println("서버에 접속했습니다.");
		BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(mySocket.getOutputStream()));
		
		//ip보내기
		out.println(mySocket.getInetAddress().getHostAddress());
		out.flush();
		
		String msg = "";
		
		while(!(msg = s.nextLine()).equals("exit"))
		{
			out.println(msg);//서버로 보내기
			out.flush();
			
			System.out.println(in.readLine());//서버에서 받기
		}
	}

}
