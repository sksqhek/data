import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.EmptyStackException;
import java.util.Stack;

public class ex1 {
	public static void main(String[] args) {
		boolean stop = false;
		int String;
		while (!stop) {
			System.out.println("수식 입력 : ");
			Scanner ex2 = new Scanner(System.in);
			Scanner sc = null;
			String postfix = ex2.nextLine();
			
			calculator obj = new calculator();
			
			Iterator<String> infix = obj.getConverted(postfix).iterator();
			
			System.out.println("중위표기식 : ");
			
			for (int i = 0; infix.hasNext(); i++) {
				System.out.print(infix.next());
			}
			
			System.out.println("\n 결과 : " + obj.getResult(postfix));
			System.out.println("계속 : Y, 종료 : N 입력");
			String yn = ex1.next();
			if (yn.equals("Y") || yn.equals("y")) {
				System.out.println("---------------------");
				continue;
			}
		}
		System.out.println("수식계산기가 종료되었습니다.");

	}

	private static String next() {
		return null;
	}

	public char charAt(int j) {
		return 0;
	}

	public int length() {
		return 0;
	}
}

//중위표기법에서 후위표기법 변경 클래스
class InToPost {
	private Stack theStack;
	private ex1 input;
	private String output = "";

	public InToPost(ex1 input2) {
		input = input2;
		int stackSize = input.length();
		theStack = new Stack(stackSize);
	}

	public String doTrans() {
		for (int j = 0; j < input.length(); j++) {
			char ch = input.charAt(j);
			switch (ch) {
			case '+':
			case '-':
				gotOper(ch, 1);
				break;
			case '*':
			case '/':
				gotOper(ch, 2);
				break;
			case '(':
				theStack.push(ch);
				break;
			case ')':
				gotParen(ch);
				break;
			default:
				output = output + ch;
				break;
			}
		}
		while (!theStack.isEmpty()) {
			output = output + theStack.pop();
		}
		System.out.println(output);
		return output;
	}

	public void gotOper(char opThis, int prec1) {
		while (!theStack.isEmpty()) {
			char opTop = theStack.pop();
			if (opTop == '(') {
				theStack.push(opTop);
				break;
			} else {
				int prec2;
				if (opTop == '+' || opTop == '-')
					prec2 = 1;
				else
					prec2 = 2;
				if (prec2 < prec1) {
					theStack.push(opTop);
					break;
				} else
					output = output + opTop;
			}
		}
		theStack.push(opThis);
	}

	public void gotParen(char ch) {
		while (!theStack.isEmpty()) {
			char chx = theStack.pop();
			if (chx == '(')
				break;
			else
				output = output + chx;
		}
	}

	public void main(String[] args) throws IOException {
		ex1 input = new ex1();
		String output;
		InToPost theTrans = new InToPost(input);
		output = theTrans.doTrans();
		System.out.println("Postfix is " + output + '\n');
	}

	class Stack {
		private int maxSize;
		private char[] stackArray;
		private int top;

		public Stack(int max) {
			maxSize = max;
			stackArray = new char[maxSize];
			top = -1;
		}

		public void push(char j) {
			stackArray[++top] = j;
		}

		public char pop() {
			return stackArray[top--];
		}

		public char peek() {
			return stackArray[top];
		}

		public boolean isEmpty() {
			return (top == -1);
		}
	}
}

//계산기 클래스
class calculator {
	public calculator() {
		// TODO Auto-generated constructor stub
	}

	private boolean isOperator(char ch) {
		if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%')
			return true;
		return false;
	}

	public Integer getResult(String output) {
		int a = 0, b = 0;
		int operatorCount = 0;
		int operandCount = 0;
		if (output.contentEquals("")) {
			System.out.println("식에 아무런 내용이 없습니다.");
			return null;
		}
		Scanner scan = new Scanner(output);
		Stack<Integer> result = new Stack<>();
		while (scan.hasNext()) {
			if (scan.hasNextInt()) {
				result.push(scan.nextInt());
				operandCount++;
				continue;
			}
			char operator = scan.next().charAt(0);
			if (!isOperator(operator)) {
				System.out.println("정상적인 연산자가 아닙니다.");
				return null;

			} else {
				try {
					b = result.pop();
					a = result.pop();
				} catch (EmptyStackException e) {
					System.out.println("피연산자의 개수가 부족합니다.");
					return null;
				}
				if (operator == '+') {
					result.push(a + b);
				} else if (operator == '-') {
					result.push(a - b);
				} else if (operator == '*') {
					result.push(a * b);
				} else if (operator == '/') {
					result.push(a / b);
				} else if (operator == '%') {
					result.push(a % b);
				}
				operatorCount++;
			}
		}
		scan.close();
		if (operandCount != operatorCount + 1) {
			System.out.println("연산자의 개수가 부족합니다.");
			return null;
		}
		return result.pop();
	}

	public Iterable<String> getConverted(String postfix) {
		String a = "", b = "";
		int operatorCount = 0;
		int operandCount = 0;
		if (postfix.equals("")) {
			System.out.println("식에 아무 내용도 없습니다.");
			return null;
		}
		Scanner scan = new Scanner(postfix);
		Stack<String> result = new Stack<>();
		while (scan.hasNext()) {
			if (scan.hasNextInt()) {
				result.push(scan.nextInt() + "");
				operandCount++;
				continue;
			}
			char operator = scan.next().charAt(0);
			if (!isOperator(operator)) {
				System.out.println("처리할 수 없는 문자가 있습니다.");
				return null;
			} else {
				try {
					b = result.pop();
					a = result.pop();
				} catch (EmptyStackException e) {
					System.out.println("피연산자의 개수가 부족합니다.");
					return null;
				}
				result.push("(" + a + "" + operator + "" + b + ")");
				operandCount++;
			}
		}
		scan.close();
		if (operandCount != operatorCount + 1) {
			System.out.println("연산자의 개수가 부족합니다.");
			return null;
		}
		String tempString = result.pop();
		Scanner tempScan = new Scanner(tempString);
		Stack<String> tempResult = new Stack<>();
		while (tempScan.hasNext()) {
			tempResult.push(tempScan.next());
		}
		return tempResult;
	}

}
