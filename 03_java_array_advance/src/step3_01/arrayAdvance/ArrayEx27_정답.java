package step3_01.arrayAdvance;

import java.util.Scanner;

/*
 * # 숫자이동[2단계]
 * 
 * 1. 숫자2는 캐릭터이다.
 * 2. 숫자1을 입력하면, 캐릭터가 왼쪽으로
 * 	    숫자2를 입력하면, 캐릭터가 오른쪽으로 이동한다.
 * 3. 단, 좌우 끝에 도달했을 때, 예외처리를 해야한다.
 * 4. 숫자 1은 벽이다. 벽을 만나면 이동할 수 없다.
 * 5. 단, 숫자3을 입력하면, 벽을 격파할 수 있다.
 */

public class ArrayEx27_정답 {

	public static void main(String[] args) {
		
		int[] game = {0,0,1,0,2,0,0,1,0};
		int player = 0;
		int punch;
		
		Scanner scan = new Scanner(System.in);
		
		while (true) {
		
			for (int i = 0; i < 9; i++) {
				if (game[i] == 2) {
					player = i;
					System.out.print("옷 ");
				}
				else if (game[i] == 1) {
					System.out.print("1 ");
				}
				else if (game[i] == 0) {
					System.out.print("0 ");
				}
			}
			
			System.out.println();
			System.out.print("왼쪽(1) 오른쪽(2) 종료(0) : ");
			int choice = scan.nextInt();
		
			if (choice == 1) {
				if (player - 1 < 0) {
					continue;
				}
				else if (game[player - 1] == 1) {
					System.out.print("격파[3] 입력 : ");
					punch = scan.nextInt();
					if (punch == 3) {
						game[player - 1] = 2;
						game[player] = 0;
					}
					else continue;
				}
				else {
					game[player - 1] = 2;
					game[player] = 0;
				}
			}
			
			else if (choice == 2) {
				if (player + 1 >= game.length) {
					continue;
				}
				
				else if (game[player + 1] == 1) {
					System.out.print("격파[3] 입력 : ");
					punch = scan.nextInt();
					if (punch == 3) {
						game[player + 1] = 2;
						game[player] = 0;
					}
					else continue;
				}

				
				else {
					game[player + 1] = 2;
					game[player] = 0;
				}
				
			}
			
			else if (choice == 3) {
				System.out.println("종료");
				break;
			}
			
		
		}
		
		scan.close();
		
	}
	
}
