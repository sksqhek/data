package help;

import java.util.Scanner;

public class help_1
{
	public static void main(String[] vnfjri123)
	{
		Lotto lotto = new Lotto();
		Scanner sc = new Scanner(System.in);
		System.out.println("홍길동의 기묘한 로또모험");
		System.out.print("로또 긁는 횟수 : ");
		int a = sc.nextInt();
		lotto.lottoMachin(a);
	}
}

class Lotto
{
	private int count = 0;

	public void lottoMachin(int a)
	{
		count = a;
		int i = 0;
		//for (int value = 1; value <= count; value++)
		while(count > i)
		{
			int lottoNum1 = (int) (Math.random() * 45 + 1);
			int lottoNum2 = (int) (Math.random() * 45 + 1);
			int lottoNum3 = (int) (Math.random() * 45 + 1);
			int lottoNum4 = (int) (Math.random() * 45 + 1);
			int lottoNum5 = (int) (Math.random() * 45 + 1);
			int lottoNum6 = (int) (Math.random() * 45 + 1);
			if (lottoNum1 != lottoNum2 && lottoNum1 != lottoNum3 && lottoNum1 != lottoNum4 && lottoNum1 != lottoNum5
					&& lottoNum1 != lottoNum6 && lottoNum2 != lottoNum3 && lottoNum2 != lottoNum4
					&& lottoNum2 != lottoNum5 && lottoNum2 != lottoNum6 && lottoNum3 != lottoNum4
					&& lottoNum3 != lottoNum5 && lottoNum3 != lottoNum6 && lottoNum4 != lottoNum5
					&& lottoNum4 != lottoNum6 && lottoNum5 != lottoNum6)
			{
				System.out.println(lottoNum1 + "," + lottoNum2 + "," + lottoNum3 + "," + lottoNum4 + "," + lottoNum5
						+ "," + lottoNum6);
				System.out.println();
				i += 1;// 중복 된것 카운터 더해주기
			} 
		}
		count = 0;// 초기화
	}
}