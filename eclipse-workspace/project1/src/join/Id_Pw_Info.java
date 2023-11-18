//Id_Pw_Info.java
package join;

import java.util.ArrayList;

public class Id_Pw_Info
{
	//아이디랑 암호를 클래스로 저장
	ArrayList<Users_Id_Pw> listUser = new ArrayList<Users_Id_Pw>();
	

	Users_Id_Pw getlistUser(int idx)
	{
		return listUser.get(idx);
	}

	void setlistUser(Users_Id_Pw uip)
	{
		if(checkIdPw(uip) == true)//같은 아이디가 있는지 점사
			listUser.add(uip);
	}
	
	int getSize()
	{
		return listUser.size();
	}
	
	boolean checkIdPw(Users_Id_Pw uip)
	{
		for (int i = 0; i < listUser.size(); i++)
		{			
			if (uip.getLoginId().equals(listUser.get(i).getLoginId()))
			{
				System.out.println("같은 아이디가 있습니다.");
				return false;
			}
		}
		
		System.out.println("회원가입 성공.");
		return true;
	}
}
