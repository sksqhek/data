package java_net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer
{
	//private static Set<String> names = new HashSet<>();
	//private static Set<PrintWriter> writers = new HashSet<>();
	private static HashMap<String, PrintWriter> names = new HashMap<>();//####이름과 쓰기소켓 묶어주기
	
	public static void main(String[] args) throws Exception
	{
		System.out.println("The chat server is running...");
		ExecutorService pool = Executors.newFixedThreadPool(500);
		try (ServerSocket listener = new ServerSocket(59001))
		{
			while (true)
			{
				pool.execute(new Handler(listener.accept()));
			}
		}
	}

	private static class Handler implements Runnable
	{
		private String name;
		private Socket socket;
		private Scanner in;
		private PrintWriter out;

		public Handler(Socket socket)
		{
			this.socket = socket;
		}

		public void run()
		{
			try
			{
				in = new Scanner(socket.getInputStream());
				out = new PrintWriter(socket.getOutputStream(), true);

				// Keep requesting a name until we get a unique one.
				while (true)
				{
					out.println("SUBMITNAME");
					name = in.nextLine();
					if (name == null)
					{
						return;
					}
					synchronized (names)
					{
						if (name.length() > 0 && !names.containsKey(name))//####이름이 존재 하는지 검사
						{
							//names.add(name);
							//names.put(name, null);
							break;
						}
					}
				}

				out.println("NAMEACCEPTED " + name);
				//for (PrintWriter writer : writers)				
				for (String key: names.keySet())//####
				{
					names.get(key).println("MESSAGE " + name + " has joined");
				}
				//writers.add(out);
				names.put(name, out);//####

				while (true)
				{
					String input = in.nextLine();
					
					if (input.startsWith("/w "))//####
					{
						String command[] = input.split(" ");//####
						if(command.length < 3)//####단어가 3개 이하라면 에러
							continue;						
						System.out.println(input + command.length);
						
						int tmplen = command[0].length() + command[1].length();//####명령어 귀속말할 이름의 길이 게산 
						String message = input.substring(tmplen + 2);//####메세지만 추출
						names.get(command[1]).println("MESSAGE " + name + " whisper: " + message);//####해당 이름에게만 메세지 보내기
						
					} else
					{
						if (input.toLowerCase().startsWith("/quit"))
						{
							return;
						}
						
						//for (PrintWriter writer : writers)
						for (String key: names.keySet())//####
						{
							//writer.println("MESSAGE " + name + ": " + input);
							names.get(key).println("MESSAGE " + name + ": " + input);//####
						}
					}
				}
			} catch (Exception e)
			{
				System.out.println(e);
			} finally
			{
				if (out != null)
				{
					//writers.remove(out);					
				}
				if (name != null)
				{
					System.out.println(name + " is leaving");
					names.remove(name);
					//for (PrintWriter writer : writers)
					for (String key: names.keySet())//####
					{
						//writer.println("MESSAGE " + name + " has left");
						names.get(key).println("MESSAGE " + name + " has left");//####
					}
				}
				try
				{
					socket.close();
				} catch (IOException e)
				{
				}
			}
		}
	}

}