package practice;

import java.util.Scanner;

public class Test
{
	public static void main(String[] args)
	{
		studentHak sh = new studentHak();
		
	}
}

abstract class student
{
	int bun;
	String name;
	int[] jum = new int[10];
	int tot;
	double ave;
	int max = 0;
	int min = 0;

	student()
	{

	}

	student(int bun, String name, int[] jum)
	{
		this.bun = bun;
		this.name = name;
		this.jum = jum;
	}

	public int getBun()
	{
		return bun;
	}

	public String getName()
	{
		return name;
	}

	public int[] getJum()
	{
		return jum;
	}

	public void setTot(int tot)
	{
		this.tot = tot;
	}

	public int getTot()
	{
		return tot;
	}

	public void setave(double ave)
	{
		this.ave = ave;
	}

	public double getAve()
	{
		return ave;
	}

	public void setMax(int max)
	{
		this.max = max;
	}

	public int getMax()
	{
		return max;
	}

	public void setMin(int min)
	{
		this.min = min;
	}

	public int getMin()
	{
		return min;
	}

	public abstract void acc();

	public abstract void score();

	public abstract void up();

	public abstract void down();

}

class studentHak extends student
{
	Scanner s = new Scanner(System.in);
	student[] ss = new student[10];
	int cnt = 0;

	public studentHak(int bun, String name, int[] jum)
	{
		super(bun, name, jum);
	}

	@Override
	public void acc()
	{
		for (int x = 0; x < jum.length; x++)
		{
			ss[x].setTot(x += jum[x]);
			ss[x].setave(x += (tot * 100 / 3) / 100);
		}
	}

	@Override
	public void score()
	{
		int max = jum[0];
		int min = 100;
		for (int x = 0; x < jum.length; x++)
		{
			if (jum[x] > max)
			{
				ss[x].setMax(jum[x]);
			}
			if (jum[x] < min)
				ss[x].setMin(jum[x]);
		}
	}

	@Override
	public void up()
	{
		for (int x = 0; x < ss.length - 1; x++)
		{
			for (int y = x + 1; y < ss.length; y++)
			{
				if (ss[x].tot > ss[y].tot)
				{
					student w = ss[x];
					ss[x] = ss[y];
					ss[x] = w;

				}

			}

		}

	}

	@Override
	public void down()
	{
		for (int x = 0; x < ss.length - 1; x++)
		{
			for (int y = x + 1; y < ss.length; y++)
			{
				if (ss[x].bun > ss[y].bun)
				{
					student w = ss[x];
					ss[x] = ss[y];
					ss[x] = w;

				}
			}

		}

	}

	studentHak()
	{
		while (true)
		{
			System.out.print("번호 입력:");
			int bun = s.nextInt();
			if (bun == -99)
				break;
			System.out.print("이름 입력:");
			String name = s.next();

			System.out.print("점수 입력:");
			int[] jum = new int[10];
			for (int x = 0; x < jum.length; x++)
			{
				jum[x] = s.nextInt();
			}
			ss[cnt] = new studentHak(bun, name, jum);
			cnt++;
		}
		s.close();

	}

	public void print()
	{
		System.out.println("정보 출력");
		System.out.print("번호\t이름\t");
		for (int x = 1; x < 11; x++)
		{
			System.out.print("점수" + x + "\t");
		}
		System.out.println("총점\t평균\t최고\t최저\n");

		for (int x = 0; x < ss.length; x++)
		{
			System.out.println(ss[x].getBun() + ss[x].getName() + ss[x].getJum() + ss[x].getTot() + ss[x].getAve()
					+ ss[x].getMax() + ss[x].getMin());
		}

	}
}