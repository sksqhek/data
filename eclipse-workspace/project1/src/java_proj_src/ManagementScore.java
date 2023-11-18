package java_proj_src;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ManagementScore implements Serializable
{
	String names;
	int score;

	public ManagementScore(String names)
	{
		this.names = names;
	}

	public ManagementScore(int score)
	{
		this.score = score;
	}
	
	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return names + ":" + score;
	}
}