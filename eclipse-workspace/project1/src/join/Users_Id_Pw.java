//Users_Id_Pw.java
package join;

//아이디와 암호를 묶어서 처리하는 클래스
public class Users_Id_Pw
{	
	private String loginId = null;
	private String loginPw = null;

	String getLoginId()
	{
		return loginId;
	}

	void setLoginId(String loginId)
	{
		this.loginId = loginId;
	}

	String getLoginPw()
	{
		return loginPw;
	}

	void setLoginPw(String loginPw)
	{
		this.loginPw = loginPw;
	}
	@Override
	public boolean equals(Object obj)//아이디랑 암호가 같은지 검사 하는 함수
	{		
		return loginId.equals(((Users_Id_Pw)obj).getLoginId()) && 
				loginPw.equals(((Users_Id_Pw)obj).getLoginPw());
	}
}