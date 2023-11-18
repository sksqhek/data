package GUI.Two;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main
{

	public static void main(String[] args)
	{
		ArrayList<Person> people = new ArrayList<>();
		
		try
		{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.txt", true));
						
			Staff s = new Staff();
			s.setAddress("서울");
			s.setName("홍길동");
			s.setID("20201234");
			s.setDept("체육과");
			people.add(s);
			
			Student stu = new Student();
			stu.setAddress("서울");
			stu.setName("둘리");
			stu.setID("20205782");
			stu.setClassName("윤리 과학부");
			people.add(stu);			
			
			Teacher t = new Teacher();
			t.setAddress("서울");
			t.setName("도우너");
			t.setID("20208989");
			t.setSubject("천문");
			people.add(t);
			
			oos.writeObject(people);
			
			oos.close();
		}
		catch(Exception ex)
		{
			
		}
		
		
		ArrayList<Person> read_peaple = new ArrayList<>();//파일에서 다시 읽기 위해
		try
		{	
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.txt"));
			
			read_peaple = (ArrayList<Person>)ois.readObject();
			
			ois.close();
			
			for(Person p:read_peaple)
			{
				p.printAll();
			}
			
		}
		catch(Exception ex)
		{
			
		}
	}

}
