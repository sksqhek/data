import java.util.*;

class regrigerator {
	String name;
	Cooker c = new Cooker();

	public void setname(int str) {
		switch (str) {
		case 1:
			name = "계란";
			c.cooking_method(name);
		case 2:
			name = "돼지고기";
			c.cooking_method(name);
		case 3:
			name = "소고기";
			c.cooking_method(name);
		case 4:
			name = "토마토";
			c.cooking_method(name);
		}
	}
}

interface Method
{
	
}

class Cooker implements Method {

	Scanner sc = new Scanner(System.in);

	public void cooking_method(String name) {

		switch (name) {
		case "계란":
			cooking_method2();
			break;
		case "돼지고기":
			cooking_method2();
			break;
		case "소고기":
			cooking_method2();
			break;
		case "토마토":
			cooking_method2();
			break;
		}
	}

	public void cooking_method2() {

		System.out.println("요리법 선택");
		System.out.println("1.날것  2.찜  3.튀김 4.굽기");
		int select = sc.nextInt();
		switch (select) {
		case 1:
			uncook();
			break;
		case 2:
			steamed();
			break;
		case 3:
			fry();
			break;
		case 4:
			grill();
			break;
		}
	}

	public void uncook() {
		System.out.println("날 것으로 조리");
	}; // 날것

	public void steamed() {
		System.out.println(" 찜으로 조리");
	}; // 찜

	public void fry() {
		System.out.println(" 튀김으로 조리");
	};// 튀김

	public void grill() {
		System.out.println(" 굽기로 조리");
	};

}

public class grillcooker extends Cooker {

	@Override
	public void grill() {
		System.out.println("1.raw 2.medium 3.well-done 숫자를 선택하세요");
		int ch = sc.nextInt();
		switch (ch) {
		case 1:
			System.out.println("생");
		case 2:
			System.out.println("중간");
		case 3:
			System.out.println("익힘");
		}
	}

	public static void main(String[] args) {
		regrigerator r = new regrigerator();
		Scanner sc = new Scanner(System.in);
		System.out.println("음식의 재료를 선택해주세요");
		System.out.println("1.계란 2.돼지고기  3.소고기, 4번.토마토 (숫자를 선택하시오)");
		int select;
		select = sc.nextInt();
		r.setname(select);
	}

}