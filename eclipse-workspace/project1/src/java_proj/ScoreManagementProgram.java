package java_proj;

import java_proj_src.*;

public class ScoreManagementProgram
{

	public static void main(String[] args)
	{

		// 메소드 생성자
		Management mg = new Management();

		// 프로그램 실행
		do
		{

			// 메뉴 출력
			System.out.println("                            ");
			System.out.println("        +------------------+");
			System.out.println("        | 성적관리프로그램 |");
			System.out.println("        +------------------+");
			System.out.println("        |    1. 입력       |");
			System.out.println("        +------------------+");
			System.out.println("        |    2. 저장       |");
			System.out.println("        +------------------+");
			System.out.println("        |    3. 조회       |");
			System.out.println("        +------------------+");
			System.out.println("        |    4. 화면청소   |");
			System.out.println("        +------------------+");
			System.out.println("        |    5. 종료       |");
			System.out.println("        +------------------+");
			System.out.print("          ※선택 : ");

			// 메뉴 기능 메소드 호출
			mg.managementProgram();

			// 프로그램 종료
		} while (!mg.strM.equals("5"));
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("!!!!!!!!!             !!!!!!!!!");
		System.out.println("!!!!!!!!! PROGRAM END !!!!!!!!!");
		System.out.println("!!!!!!!!!             !!!!!!!!!");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
// 스캐너 Close
		mg.sc.close();

	}
}