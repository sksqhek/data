//Id_Pw_proccess.java
package join;

import java.util.Scanner;

//아이랑 암호를 처리
public class Id_Pw_proccess
{
	Id_Pw_Info ipi;
	Scanner sc = new Scanner(System.in);

	public Id_Pw_proccess(Id_Pw_Info ipi)
	{
		this.ipi = ipi;
	}

	void join()
	{
		Users_Id_Pw uip = new Users_Id_Pw();

		System.out.print("아이디 : ");
		uip.setLoginId(sc.next());
		System.out.print("비밀번호 : ");
		uip.setLoginPw(sc.next());

		ipi.setlistUser(uip);
	}

	boolean confirmIdPw()
	{
		Users_Id_Pw uip = new Users_Id_Pw();

		System.out.print("아이디 : ");
		uip.setLoginId(sc.next());
		System.out.print("비밀번호 : ");
		uip.setLoginPw(sc.next());

		for (int i = 0; i < ipi.getSize(); i++)
		{
			if (uip.equals(ipi.getlistUser(i)))
			{
				System.out.println("로그인 합니다.");
				return true;
			}
		}
		System.out.println("입력한 아이디가 존재하지 않습니다. 아이디를 다시 한번 입력해 주세요.");
		return false;
	}

}