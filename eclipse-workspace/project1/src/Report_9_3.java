import java.util.Scanner;

import java.util.StringTokenizer;

class Student {

	StringTokenizer st;

	int num;

	String name;

	static int c, java, net, tot;

	void parsing(String temp) {

		StringTokenizer st = new StringTokenizer(temp, ",");

		//while (st.hasMoreTokens()) {
			//st.nextToken();
		//}
		
		num = Integer.parseInt(st.nextToken());
		name = st.nextToken();
		c = Integer.parseInt(st.nextToken());
		java = Integer.parseInt(st.nextToken());
		net = Integer.parseInt(st.nextToken());

	}

	public static void calTot() {

		tot = c + java + net;

	}

	StringBuffer StrAppend() {

		StringBuffer sb = new StringBuffer(num);

		sb.append(name);

		sb.append(tot);

		return sb;

	}

}

public class Report_9_3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Student s[] = new Student[3];

		String temp;

		for (int i = 0; i < s.length; i++) {

			s[i] = new Student();

			System.out.print("input num,name,c,java,net:  ");

			temp = sc.nextLine();

			s[i].parsing(temp);

			Student.calTot();

		}

		for (int i = 0; i < s.length; i++)

			System.out.println(s[i].StrAppend());

		sc.close();

	}

}