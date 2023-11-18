//Monitor.java
package join;

import java.util.Scanner;

public class Monitor
{

	public static void bar()
	{
		for (int i = 0; i < 23; i++)
		{
			System.out.print("-");
		}
		System.out.println();
	}

	public static void main(String[] vnfjri123)
	{
		Id_Pw_Info ipi = new Id_Pw_Info();
		
		Id_Pw_proccess ipp = new Id_Pw_proccess(ipi);
				
		Scanner sc = new Scanner(System.in);
		String bridge = null;
		
		while (true)
		{
			bar();
			System.out.println("1.회원가입|2.로그인|3종료");
			bar();
			bridge = sc.nextLine();
			switch (bridge)
			{
			case "1":// 회원가입
				ipp.join();
				break;
			case "2":// 로그인
				boolean work = ipp.confirmIdPw();
				while (work)
				{
					/* switch(){case...업무 클래스} */}
				break;
			case "3":// 종료
				return;
			}
		}
	}
}