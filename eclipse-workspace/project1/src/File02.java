import java.io.*;

import java.util.Scanner;

import java.io.IOException;

public class File02
{

	public static void main(String[] args) throws IOException
	{
// TODO Auto-generated method stub
		File f = new File("menulist.txt");
		Scanner in = new Scanner(new File("menulist.txt"));
		if (f.exists() == false) {
//파일 작성
			try ( // 객체를 생성하면 try종료 후 자동으로 close처리
					FileWriter fw = new FileWriter("menulist.txt", true);
					BufferedWriter bw = new BufferedWriter(fw);) {
				bw.write("4");
				bw.newLine();
				bw.write("1 아메리카노 1500"); // 버퍼에 데이터 입력
				bw.newLine(); // 버퍼에 개행 삽입
				bw.write("2 카페라떼 2000");
				bw.newLine();
				bw.write("3 콜라 1500");
				bw.newLine();
				bw.write("4 우유 1000");
				bw.newLine();
				bw.flush(); // 버퍼의 내용을 파일에 쓰기
			} catch (IOException e) {
				System.out.println(e);
			}
		} else			
		{
			// File f = new File("menulist.txt");
			// 파일 존재 여부 판단
			// if (f.isFile()) {
			// System.out.println("menulist.txt 파일이 있습니다.");
			// }

			// 파일 읽어 배열화
			int numItems = in.nextInt();

			int money;

			int change = 0;

			int min_price;

			int[] menu_num = new int[numItems];
			String[] menu_title = new String[numItems];
			int[] menu_price = new int[numItems];
			int i;

			for (i = 0; i < numItems; i++) {
				menu_num[i] = in.nextInt();
				menu_title[i] = in.next();
				menu_price[i] = in.nextInt();

			}

			min_price = menu_price[0];

			for (i = 0; i < menu_price.length; i++)

			{

				if (min_price > menu_price[i])

				{

					min_price = menu_price[i];

				}

			}

			System.out.println("어서오세요.");

			System.out.println("자판기 입니다.");

			do
			{

				System.out.printf("돈을 입력하세요: ");

				money = in.nextInt();

				change = change + money;

			} while (change < min_price);
			do

			{

				System.out.println("========================");

				System.out.println("          메   뉴 ");

				System.out.println("========================");

				for (i = 0; i < numItems; i++) {
					System.out.printf("%d %s %d\n", menu_num[i], menu_title[i], menu_price[i]);

				}

				System.out.println("========================");

				System.out.printf("입력한 돈은 %d원 입니다.\n", change);

				System.out.println("========================");

				System.out.printf("메뉴를 고르세요: ");

				switch (i)

				{

				case 1:

					System.out.printf("%d번 아메리카노를 고르셨습니다.\n", menu_num[i]);

					change = change - menu_price[i];

					break;

				case 2:

					System.out.printf("%d번 카페라떼를 고르셨습니다.\n", menu_num[i]);

					change = change - menu_price[i];

					break;

				case 3:

					System.out.printf("%d번 콜라를 고르셨습니다.\n", menu_num[i]);

					change = change - menu_price[i];

					break;

				case 4:

					System.out.printf("%d번 우유를 고르셨습니다.\n", menu_num[i]);

					change = change - menu_price[i];

					break;

				default:

					System.out.printf("메뉴 번호를 잘 못 누르셨습니다.\n");

					break;

				}

				System.out.printf("잔돈은 %d원 입니다.\n", change);

				System.out.printf("더 고르시겠습니까? [y/n]  ");

				int c;

				c = in.next().charAt(0);
				if (c == 'y' || c == 'Y')

				{

					System.out.printf("메뉴를 선택해주세요\n");

				}

				else if (c == 'n' || c == 'N')

				{

					System.out.printf("자판기를 종료합니다\n");

					break;

				}
			} while (change >= min_price);

			in.close();
		}
	}
}