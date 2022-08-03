package step3_01.arrayAdvance;


/*
 *	# 2차원배열 기본문제[3단계]
*/

//15-28
public class ArrayEx39_정답 {

	public static void main(String[] args) {
		
		int[][] arr = {
			{101, 102, 103, 104},
			{201, 202, 203, 204},
			{301, 302, 303, 304}
		}; 
		
		int[] garo = new int[3];
		int[] sero = new int[4];
		
		// 문제 1) 가로 합 출력
		// 정답 1) 410, 810, 1210
		
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				garo[i] += arr[i][j];
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(garo[i] + " ");
		}
		
		// 문제 2) 세로 합 출력
		// 정답 2) 603, 606, 609, 612

		System.out.println();
		
		for (int j = 0; j < arr[0].length; j++) {
			for (int i = 0; i < arr.length; i++) {
				sero[j] += arr[i][j];
			}
		}
	
		

		for(int j = 0; j < arr[0].length; j++) {
			System.out.print(sero[j] + " ");
		}

	}

}
