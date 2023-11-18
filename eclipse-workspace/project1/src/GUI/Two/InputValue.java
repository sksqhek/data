package GUI.Two;

import java.util.Scanner;

public class InputValue {
	
	static Scanner value = new Scanner(System.in);
	
	public static int InputInt() {
		
		int num = 0;
		num = value.nextInt();
		
		return num;
	}
	
	public static String InputStr() {
		
		String str;
		str = value.next();
		
		return str;
	}
	

}
