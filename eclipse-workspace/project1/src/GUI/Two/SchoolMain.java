package GUI.Two;

import java.util.InputMismatchException;

public class SchoolMain {
	
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


