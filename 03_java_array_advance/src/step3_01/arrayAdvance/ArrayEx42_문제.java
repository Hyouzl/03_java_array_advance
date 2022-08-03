package step3_01.arrayAdvance;

import java.util.Scanner;

/*
 * 
 * # 나만의 마블
 * 
 * 옷 □ □ □ □ 
 * □ ■ ■ ■ □ 
 * □ ■ ■ ■ □ 
 * □ ■ ■ ■ □ 
 * □ □ □ □ □
 * 
 * 
 * 정답의 소스를 컴파일 해보고 동작을 파악하여 코드를 작성하기.
 * 
 */

public class ArrayEx42_문제 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		final int ROAD = 20;
		
		int[][] map = {
			{0,   1,  2,  3, 4},	
			{15, 20, 20, 20, 5},
			{14, 20, 20, 20, 6},
			{13, 20, 20, 20, 7},
			{12, 11, 10,  9, 8}
		};
		
		
		//화면 출력
	
		int player = 0;
		int pX = 0;
		int pY = 0;
		int temp = 0;

		while (true) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (map[i][j] == ROAD) System.out.print("■ ");
					else if (map[i][j] == player) {
						pY = i;
						pX = j;
						System.out.print("옷 ");
					}
					else System.out.println("□ ");
				}
				System.out.println();
			}
			
			System.out.println("1~3을 입력하세요 : ");
			int num = scan.nextInt();
			
			if (num == 1) {
				
				if (pX == 4) {
					pY++;
					map[pY--][pX] = map[pY][pX];
					map[pY][pX] = player;
					
				}
				else if (pY == 4) {
					pX--;
					map[pY][pX++] = map[pY][pX];
					map[pY][pX] = player;
				}
				else if (pX == 0 && pY <= 4) {
					pY--;
					map[pY++][pX] = map[pY][pX];
					map[pY][pX] = player;
				}
				else {
					pX++;
					map[pY][pX--] = map[pY][pX];
					map[pY][pX] = player;
				}
				
			}			
			
			else if (num == 2) {
				if (pX == 4) {
					pY += 2 ;
					map[pY-2][pX] = map[pY][pX];
					map[pY][pX] = player;
					
				}
				else if (pY == 4) {
					pX -= 2;
					map[pY][pX+2] = map[pY][pX];
					map[pY][pX] = player;
				}
				else if (pX == 0 && pY <= 4) {
					pY -= 2;
					map[pY+2][pX] = map[pY][pX];
					map[pY][pX] = player;
				}
				else {
					pX += 2;
					map[pY][pX-2] = map[pY][pX];
					map[pY][pX] = player;
				}
				
			}
			
	
		}
		
		else
		
		int player = 0;
		
		while(true) {
			
			// 화면출력
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == ROAD) 		  	System.out.print("■ ");
					else if (map[i][j] == player) 	System.out.print("P ");
					else 							System.out.print("□ ");
				}
				System.out.println();
			}
			System.out.println();

			
			// 입력받기
			System.out.print("1~3을 입력하세요 : ");
			int move = scan.nextInt();
			
			player += move;
			
			player %= 16;
			
		}

	}

}
