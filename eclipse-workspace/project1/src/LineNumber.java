import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LineNumber
{

	public static void main(String[] args)
	{
		System.out.println("c:\\temp\\phone.txt 파일을 읽어 출력합니다.");
		try
		{
			Scanner fScanner = new Scanner(new FileReader("c:\\temp\\phone.txt"));
			int i=1;
			while(fScanner.hasNext())
			{
				System.out.println(i + ": " + fScanner.nextLine());
				i++;
			}
		} catch (IOException e)
		{
			System.out.println("입출력 오류가 발생했습니다.");
		}

	}

}
