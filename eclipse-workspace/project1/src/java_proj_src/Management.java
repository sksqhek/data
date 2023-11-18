package java_proj_src;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Management
{
// 변수 선언 & 생성자 호출
	public Scanner sc = new Scanner(System.in);
	ArrayList<ManagementScore> nameslist = new ArrayList<ManagementScore>();
	ArrayList<ManagementScore> guklist = new ArrayList<ManagementScore>();
	ArrayList<ManagementScore> englist = new ArrayList<ManagementScore>();
	ArrayList<ManagementScore> sulist = new ArrayList<ManagementScore>();
	String names = null;
	int guk = 0, eng = 0, su = 0;
	public String strM = "0";

	@SuppressWarnings("unchecked")
	public void managementProgram()
	{
// 메뉴 선택
		strM = sc.nextLine();

		// 메뉴 실행
		switch (strM)
		{

		// 입력
		case "1":
			System.out.println("※등록하실 이름을 입력하세요.");
			System.out.print("※이름 : ");
			ManagementScore nl = new ManagementScore(sc.nextLine());
			nameslist.add(nl);
			System.out.println("※국어 점수를 입력하세요.");
			System.out.print("※국어 : ");
			ManagementScore gl = new ManagementScore(sc.nextInt());
			guklist.add(gl);
			System.out.println("※영어 점수를 입력하세요.");
			System.out.print("※영어 : ");
			ManagementScore el = new ManagementScore(sc.nextInt());
			englist.add(el);
			System.out.println("※수학 점수를 입력하세요.");
			System.out.print("※수학 : ");
			ManagementScore sl = new ManagementScore(sc.nextInt());
			sulist.add(sl);
			break;

		// 저장
		case "2":

			// 파일 내보내기
			try
			{
				FileOutputStream fosnames = new FileOutputStream(
						"namelist.txt");
				BufferedOutputStream bosnames = new BufferedOutputStream(fosnames);
				ObjectOutputStream outnames = new ObjectOutputStream(bosnames);
				outnames.writeObject(nameslist);

				FileOutputStream fosguk = new FileOutputStream(
						"guklist.txt");
				BufferedOutputStream bosguk = new BufferedOutputStream(fosguk);
				ObjectOutputStream outguk = new ObjectOutputStream(bosguk);
				outguk.writeObject(guklist);

				FileOutputStream foseng = new FileOutputStream(
						"englist.txt");
				BufferedOutputStream boseng = new BufferedOutputStream(foseng);
				ObjectOutputStream outeng = new ObjectOutputStream(boseng);
				outeng.writeObject(englist);

				FileOutputStream fossu = new FileOutputStream(
						"sulist.txt");
				BufferedOutputStream bossu = new BufferedOutputStream(fossu);
				ObjectOutputStream outsu = new ObjectOutputStream(bossu);
				outsu.writeObject(sulist);

				// Stream Close
				outnames.close();
				outguk.close();
				outeng.close();
				outsu.close();
			}

			// 에러 검출
			catch (Exception e)
			{
				System.out.printf("파일 저장 오류 : %s", e.getMessage());
			}
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println("!!!!!!!!                     !!!!!!!!");
			System.out.println("!!!!!!!!   저장 되었습니다   !!!!!!!!");
			System.out.println("!!!!!!!!                     !!!!!!!!");
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			break;

		// 조회
		case "3":

			// 파일 불러오기
			try
			{
				FileInputStream fisnames = new FileInputStream(
						"namelist.txt");
				BufferedInputStream bisnames = new BufferedInputStream(fisnames);
				ObjectInputStream innames = new ObjectInputStream(bisnames);

				FileInputStream fisguk = new FileInputStream(
						"guklist.txt");
				BufferedInputStream bisguk = new BufferedInputStream(fisguk);
				ObjectInputStream inguk = new ObjectInputStream(bisguk);

				FileInputStream fiseng = new FileInputStream(
						"englist.txt");
				BufferedInputStream biseng = new BufferedInputStream(fiseng);
				ObjectInputStream ineng = new ObjectInputStream(biseng);

				FileInputStream fissu = new FileInputStream("sulist.txt");
				BufferedInputStream bissu = new BufferedInputStream(fissu);
				ObjectInputStream insu = new ObjectInputStream(bissu);

				// 읽어온 Byte파일을 배열로 강제 형 변환
				Object objnames = innames.readObject();
				ArrayList<ManagementScore> readnames = (ArrayList<ManagementScore>) objnames;

				Object objguk = inguk.readObject();
				ArrayList<ManagementScore> readguk = (ArrayList<ManagementScore>) objguk;

				Object objeng = ineng.readObject();
				ArrayList<ManagementScore> readeng = (ArrayList<ManagementScore>) objeng;

				Object objsu = insu.readObject();
				ArrayList<ManagementScore> readsu = (ArrayList<ManagementScore>) objsu;

				System.out.println("+------------+---------+---------+---------+");
				System.out.println("|   이  름   |  국  어 |  영  어 |  수  학 |");
				System.out.println("+------------+---------+---------+---------+");
				// 강제 형 변환 한 파일 출력을 위한 for문
				for (int i = 0; i < readnames.size(); i++)
				{
					if (Objects.isNull(readnames.get(i)))
					{
					} else
					{
						System.out.printf("|   %-3s   |   %3s   |   %3s   |   %3s   |\n", readnames.get(i),
								readguk.get(i), readeng.get(i), readsu.get(i));
					}
				}

				// Stream Close
				innames.close();
				inguk.close();
				ineng.close();
				insu.close();
			}

			// 에러 검출
			catch (Exception e)
			{
				System.out.printf("파일 불러오기 오류 : %s", e.getMessage());
			}

			System.out.println("+------------+---------+---------+---------+");
			break;

// 화면 청소 메소드 호출
		case "4":

			clearScreen();

			break;

		// default
		default:

			break;
		}

	}

// 화면 청소 메소드 정의
	void clearScreen()
	{
		try
		{
			if (System.getProperty("os.name").contains("Windows"))
			{
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else
			{
				Runtime.getRuntime().exec("clear");
			}

		} catch (IOException | InterruptedException ex)
		{
		}
	}
}
