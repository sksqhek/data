import java.lang.reflect.Method;

public class Solution
{

	public static void main(String args[])
	{
		Printer myPrinter = new Printer();//아래와 같이 어떤 객체든 받을수 있음  
		
		
		Integer[] intArray = {1,2,3};
		String[] stringAray = {"Hello", "World"};
		
		myPrinter.printArray(intArray);
		myPrinter.printArray(stringAray);
		
		////////클래스도 출력 테스트///////
		Myclass[] myclass = {new Myclass("jack1", "31"),
				new Myclass("jack2", "32"),
				new Myclass("jack3", "33"),
				new Myclass("jack4", "34"),
				new Myclass("jack5", "35"),
				};
		
		myPrinter.printArray(myclass);
		///////////////////////////////
		
		
		int count = 0;
		
		for(Method method:Printer.class.getDeclaredMethods())
		{
			String name = method.getName();
			
			if(name.equals("printArray"))
				count++;
		}
		
		if(count > 1)
			System.out.println("Method overloading is not allowed!");
	}
}

class Printer
{
	<T1> void printArray(T1[] arr)//어떤 객체 배열도 받아서 출력()
	{
		for(T1 t:arr)
		{
			System.out.println(t);
		}
	}
}

////////클래스도 출력 테스트///////
class Myclass
{
	String name1;
	String name2;
	
	Myclass(String n1, String n2)
	{
		name1 = n1;
		name2 = n2;
	}
	
	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return name1 + ":" + name2;
	}
}