package step3_01.arrayAdvance;

import java.util.Scanner;

/*
문제1) 숫자 0이 플레이어이다. 
	    
	    1) left 2)right 3)up 4)down 5)되감기
		번호를 입력받고 해당위치로 이동 ==> 이동할때 값을 서로 교환한다. 
		 예) 1 ==> 
		
	    {1,2,3,4},
		{5,6,7,8},
		{9,10,11,12},
		{13,14,0,15}		
		 
		
문제2) 심화  ==> 한칸한칸이동할때마다 yx 에 배열에 이동한경로를 저장했다가 
 	5번입력시 ==> 왔던길로 되돌아가기 한다.
 	
*/

public class ArrayEx49_테스트문제2 {

	public static void main(String[] args) {
		
		int game[][] = {
					{1,2,3,4},
					{5,6,7,8},
					{9,10,11,12},
					{13,14,15,0}
				};
		
		int yx [][] = new int[10000][2];
		int player;
		int px = 0;
		int py = 0;
		int temp = 0;
		int cnt = 0;
		Scanner scan = new Scanner(System.in);
		
		
		while (true) {
			
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (game[i][j] == 0) {
						px = j;
						py = i;
					}
				}
			}
		player = game[py][px];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(game[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("1) left 2)right 3)up 4)down 5)되감기");
		System.out.println("번호 입력 : ");
		int move = scan.nextInt();
		
		if (move == 1) {
			if (px == 0) {
				System.out.println("이동 불가");
			}
			else {
				temp = game[py][px-1];	
				game[py][px-1] = player;
				game[py][px] = temp;
				yx[cnt][0] = px;
				yx[cnt][1] = py;
				cnt++;
 			}
		}
		else if (move == 2) {
			if (px == 3) {
				System.out.println("이동 불가");
			}
			else {
				temp = game[py][px+1];
				game[py][px+1] = player;
				game[py][px] = temp;
				yx[cnt][0] = px;
				yx[cnt][1] = py;
				cnt++;
			}
		}
		
		else if (move == 3) {
			if (py == 0) {
				System.out.println("이동 불가");
			}
			else {
				temp = game[py-1][px];
				game[py-1][px] = player;
				game[py][px] = temp;
				yx[cnt][0] = px;
				yx[cnt][1] = py;
				cnt++;
			}
		}
		else if (move == 4) {
			if (py == 3) {
				System.out.println("이동 불가");
			}
			else {
				temp = game[py+1][px];
				game[py+1][px] = player;
				game[py][px] = temp;
				yx[cnt][0] = px;
				yx[cnt][1] = py;
				cnt++;
			}
		}
		
		else if (move == 5) {
			int rtPx = yx[cnt-1][0];
			int rtPy = yx[cnt-1][1];
			game[rtPy][rtPx] = player;
			game[py][px] = temp;
		}
		
		}
		

	}

}
