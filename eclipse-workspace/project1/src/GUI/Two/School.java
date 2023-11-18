package GUI.Two;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

public class School {

	private List<Person> people = new ArrayList<>();
	private int count;

	public List<Person> getPeople() {
		return people;
	}
	
	public void setPeople(List<Person> people) {
		this.people = people;
	}

	public int getCount() {
		return count;
	}

	public void register() {

		back: while (true) {

			Menu.SubMenu();
			int select = 0;

			try {
				select = InputValue.InputInt();
			} catch (InputMismatchException e) {
				System.out.println("Only NUMBER");
				return;
			}

			switch (select) {

			case NUMBER.STUDENT:
				Student st = new Student();
				st.inputInfo();
				addPerson(st);
				break;

			case NUMBER.TEACHER:
				Teacher tch = new Teacher();
				tch.inputInfo();
				addPerson(tch);
				break;

			case NUMBER.STAFF:
				Staff stf = new Staff();
				stf.inputInfo();
				addPerson(stf);
				break;

			case NUMBER.PREVIOUS:
				break back;

			default:
				System.out.println("ERROR");
			}

		}

	}

	public void addPerson(Person person) {

		people.add(person);

	}

	public String Serching(String name) {
		
		String str="";

		if (people.size() > 0) {

			for (int i = 0; i < people.size(); i++) {
				if (name.equals(people.get(i).getName())) {
				
					str = people.get(i).getInfo();
					return str+"\nSearching COMPLETE";
				}
			}
		}
		
		return "\n"+name+" = NO Information\nSearching FAIL";

	}

	public String Delete(String name) {
		
		String str="";

		if (people.size() > 0) {

			for (int i = 0; i < people.size(); i++) {
				if (name.equals(people.get(i).getName())) {
					str = people.get(i).getName();
					people.remove(i).getName();
					
					return str+"\nDelete COMPLETE";
				}
				
			}

		}
		
		return "\n"+name+" = NO Information\nDelete FAIL";

	}

	public String PrintAll() {

		String str = "";

		if (people.size() > 0) {

			for (int i = 0; i < people.size(); i++) {

				if (people.get(i) instanceof Student) {
					str += "\n====Student INFO====\n";
					Student st = (Student) people.get(i);
					str += st.getInfo();
				} else if (people.get(i) instanceof Teacher) {
					str += "\n====Teacher INFO====\n";
					Teacher tch = (Teacher) people.get(i);
					str += tch.getInfo();
				} else if (people.get(i) instanceof Staff) {
					str += "\n====Staff INFO====\n";
					Staff stf = (Staff) people.get(i);
					str += stf.getInfo();
				}

			}
			
			return str;

		}
		
		return "NO Information";
	}
	
	public static void main(String[] args) {
		
		School sc=new School();
		String name = "";
		
		back: while (true) {

			Menu.MainMenu();
			int select = 0;

			try {
				select = InputValue.InputInt();
			} catch (InputMismatchException e) {
				System.out.println("Only NUMBER");
				return;
			}

			switch (select) {

			case NUMBER.INPUT:
				
				sc.register();
				
				break;

			case NUMBER.SEARCH:
				
				System.out.println("Search To Name : ");
				name = InputValue.InputStr();
				sc.Delete(name);

				break;

			case NUMBER.DELETE:
				
				System.out.println("Delete To Name : ");
				name = InputValue.InputStr();
				sc.Delete(name);

				break;

			case NUMBER.PRINTALL:

				sc.PrintAll();
				
				break;
				
			case NUMBER.EXIT:
				System.exit(0);
				break;

			default:
				System.out.println("ERROR");
			}

		}

	}
		
}


