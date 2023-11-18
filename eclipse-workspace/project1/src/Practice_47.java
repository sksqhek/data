import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Practice_47 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<BankAccount> account = new ArrayList<BankAccount>();
		// BankAccount account[] = new BankAccount[3];

		int i;
		String name;
		int money;
		int accountNum;
		int action;
		String fname;
		int idx;

		while (true) {

			System.out.print("원하시는 작업을 선택하세요(0-종료/1-열기/2-저장/3-계좌업무):");
			action = scan.nextInt();

			switch (action) {
			case 1:
				System.out.print("파일 이름을 입력하세요:");
				fname = scan.next();
				load(fname, account);
				break;
			case 2:
				System.out.print("파일 이름을 입력하세요:");
				fname = scan.next();
				save(fname, account);
				break;
			case 3:
				while (true) {
					System.out.print("원하는 작업을 선택하세요 (0-메인 메뉴/1-입금 /2-출금/3-계좌생성/4-전체계좌출력) : ");
					action = scan.nextInt();
					if (action == 0)
						break;

					switch (action) {
					case 1:
						idx = getAccountIndex(account);

						System.out.print("입금액을 입력하세요 : ");
						money = scan.nextInt();
						System.out.println("입금이 완료되었습니다.");
						account.get(idx).deposit(money);
						break;
					case 2:
						idx = getAccountIndex(account);

						System.out.print("출금액을 입력하세요 : ");
						money = scan.nextInt();
						System.out.println("출금이 완료되었습니다.");
						account.get(idx).withdraw(money);
						break;
					case 3:
						System.out.print("계죄번호을 입력하세요 : ");
						accountNum = scan.nextInt();
						System.out.print("예금주 이름을 입력하세요 : ");
						name = scan.next();
						System.out.print("잔고를 입력하세요 : ");
						money = scan.nextInt();

						BankAccount acc = new BankAccount(name, money, accountNum);
						account.add(acc);
						break;
					case 4:
						printAccount(account);
						break;
					}
				}
				break;
			case 0:
				scan.close();
				System.out.print("프로그램을 종료합니다.");
				return;
			}

		}
	}

	public static void printAccount(ArrayList<BankAccount> list) {
		System.out.println("현재 잔고 현황입니다.");
		System.out.println("계좌번호\t 계좌주\t 잔고");
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
	}

	public static int getAccountIndex(ArrayList<BankAccount> list) {
		int accountNum;
		int i;
		Scanner scan = new Scanner(System.in);

		System.out.print("업데이트할 계좌번호를 입력하세요 : ");
		accountNum = scan.nextInt();

		for (i = 0; i < list.size(); i++) {
			if (list.get(i).getAccountNum() == accountNum)
				break;
		}

		if (i == list.size())
			return -1;// 계좌 번호 못찾았을 경우

		return i;
	}

	public static void save(String fname, ArrayList<BankAccount> list) {
		try {
			PrintWriter pw = new PrintWriter(new File(fname));

			for (int i = 0; i < list.size(); i++) {
				pw.print(list.get(i).getAccountNum() +  "\t" + list.get(i).getOwner() +  "\t" + 
						list.get(i).balance() +  "\n");
			}

			pw.close();
		} catch (Exception ex) {

		}
	}

	public static void load(String fname, ArrayList<BankAccount> list) {
		String name;
		int money;
		int accountNum;
		
		list.clear();
		
		try {
			Scanner scan = new Scanner(new File(fname));

			while (scan.hasNext()) {
				accountNum = scan.nextInt();
				name = scan.next();
				money = scan.nextInt();
				
				BankAccount b = new BankAccount(name, money, accountNum);
				list.add(b);
			}

			scan.close();
			
			printAccount(list);
		} catch (Exception ex) {

		}
	}
}

class BankAccount {
	private String owner;
	private int accountNum;
	private int balance;

	public void setOwner(String o) {
		owner = o;
	}

	public void setBalance(int b) {
		balance = b;
	}

	public String getOwner() {
		return owner;
	}

	public int balance() {
		return balance;
	}

	public int getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}

	public String toString() {
		return accountNum + "\t" + owner +"\t" + balance;
	}

	public BankAccount() {
		this("모름", 0, 0);
	}

	public BankAccount(String owner, int balance, int accountNum) {
		this.owner = owner;
		this.balance = balance;
		this.accountNum = accountNum;
	}

	void deposit(int amount) {
		balance += amount;
	}

	void withdraw(int amount) {
		balance -= amount;
	}
}