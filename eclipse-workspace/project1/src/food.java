import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class food
{
	public food(String string, int i)
	{
	}

	public static void main(String[] args)
	{

		List<FoodName> list = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		int a = 0;
		while (true)
		{
			System.out.println("이름과 가격을 넣어주세요.");
			if (a == 0)
			{
				String F1 = scanner.next(); // 음식이름
				int P1 = scanner.nextInt(); // 가격
				FoodName name1 = new FoodName(F1, P1); // 저장
				list.add(name1);
			}
			a++;
			if (a == 1)
			{
				break; // 정지
			}
		}

		for (int i = 0; i < list.size(); i++) // 출력
		{
			System.out.println(list.get(i).getName() + "," + list.get(i).getPrice());
		}
	}
}

class FoodName
{
	String name;
	int price;
	public FoodName(String f, int p)
	{
		name = f;
		price = p;
	}
	public String getName()
	{
		return name;
	}
	public int getPrice()
	{
		return price;
	}
}