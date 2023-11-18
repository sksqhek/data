package project1;

public class Student extends Person
{
	public String name;
		
	public void print1()
	{
		System.out.println("Student:" + name);
	}
	
	public static void main(String args[])
	{
		Person x = new Student();
		
		x.name = "ȫ�浿";
		x.num = 123;
		
		x.print1();
	}
}

class Person{
	public String name;
	public int num;
	
	public void print1()
	{
		System.out.println("Person:" + name);
	}
}