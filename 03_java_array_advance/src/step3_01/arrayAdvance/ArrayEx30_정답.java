package step3_01.arrayAdvance;

import java.util.Scanner;


/*
 * # ATM[4단계] : 전체 기능구현
 * 
 * 1. 회원가입
 * . id와 pw를 입력받아 가입
 * . 가입 시 돈 1000원 부여
 * . id 중복체크
 * 2. 회원탈퇴
 * . 로그인시에만 이용가능
 * 3. 로그인
 * . id와 pw를 입력받아 로그인
 * . 로그아웃 상태에서만 이용가능
 * 4. 로그아웃
 * . 로그인시에만 이용가능
 * 5. 입금
 * . 로그인시에만 이용가능
 * 6. 이체
 * . 로그인시에만 이용가능
 * 7. 잔액조회
 * . 로그인시에만 이용가능
 */


public class ArrayEx30_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int MAX = 5;
		
		int[] arId = new int[MAX];
		int[] arPw = new int[MAX];
		int[] arMoney = new int[MAX];
		
		int usrCnt = 0;
		int identifier = -1;
		
		String menu = "=== 메가IT ATM ===\n";
		menu += "1.회원가입\n2.회원탈퇴\n3.로그인\n4.로그아웃\n";
		menu += "5.입금\n6.이체\n7.잔액조회\n0.종료";
		
		
		while(true) {
			
			System.out.println(menu);
			
			int sel = scan.nextInt();
			int i;
			if(sel == 1) {
				System.out.print("회원가입 할 ID 입력 : ");
				arId[usrCnt] = scan.nextInt();
				for (i = usrCnt+1; i < MAX; i++) {
					if (arId[usrCnt] == arId[i]) {
						System.out.println("Id 중복 다시 입력.");
					}
				}
				
				if (i == MAX) {
					System.out.print("PW 입력 : ");
					arPw[usrCnt] = scan.nextInt();
					System.out.println("회원가입 완료 1000원 지급");
					arMoney[usrCnt] = 1000;
					usrCnt++;
				}	
			}
			else if(sel == 2) {
				if(identifier > 0) {
					System.out.println("[" + identifier + "]님 회원탈퇴");
				}
				else System.out.println("로그인 후 이용가능");
				
			}
			else if(sel == 3) {
				if (identifier == -1) {
				System.out.print("로그인 할 ID 입력 :");
				int logId = scan.nextInt();
				for (i = 0; i < MAX; i++) {
					if (arId[i] == logId) {
						System.out.print("PW 입력 : ");
						int logPw = scan.nextInt();
						if (logPw == arPw[i]) {
							System.out.println("[" + i + "] 님이 로그인");
							identifier = i;
						}
					}
					else System.out.println("아이디를 다시 확인하세요");
				}
				}
				else System.out.println("로그아웃 후 이용가능");
			}
			else if(sel == 4) {
				if (identifier == 1) {
					System.out.println("로그아웃 중 ..");
				}
				else System.out.println("로그인 후 이용가능");
				
			}
			else if(sel == 5) {
				 if (identifier > 0) {
							System.out.print("입금할 금액 입력 : ");
							int money = scan.nextInt();
							arMoney[identifier] += money;
					}
				 else System.out.println("로그인 후 이용 가능");
					
				}
			else if(sel == 6) {
				if (identifier > 0) {
					System.out.print("이체할 Id 입력 : ");
					int sendId = scan.nextInt();
					
					for (i = 0; i < MAX; i++) {
						if (sendId == arId[i]) {
							System.out.print("이체할 금액 입력 : ");
							int sendMoney = scan.nextInt();
							arMoney[i] += sendMoney;
							System.out.println("이체 완료");
						}
					}
				}
			}
			else if(sel == 7) {
				if (identifier > 0) {
					System.out.println("[" + identifier + "]님의 잔액은 " + arMoney[identifier] + "원 입니다.");
				}
				else System.out.println("로그인 후 이용 가능");
			}
		
			else if(sel == 0) {
				break;
			}
		}
	
	}
}

	

