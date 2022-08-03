package step3_01.arrayAdvance;

import java.util.Scanner;

/*
 *	# 2차원배열 기본문제[2단계]
*/

//8:00 - 15
public class ArrayEx38_정답 {

	public static void main(String[] args) {
		
		int[][] arr = new int[3][3];
		
		int k = 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = 10 * k;
				k += 1;
			}
		}
		
		Scanner scan = new Scanner(System.in);
		
		// 문제 1) 인덱스 2개를 입력받아 값 출력
		// 예    1) 인덱스1 입력 : 1	인덱스2 입력 : 2
		//		   값 출력 : 60 
		
		System.out.print("인덱스1 입력 : ");
		int num1 = scan.nextInt();
		System.out.print("인덱스2 입력 : ");
		int num2 = scan.nextInt();
		
		System.out.println("값 출력 : " + arr[num1][num2]);
	
		
		// 문제 2) 값을 입력받아 인덱스 2개 출력
		// 예    2) 값 입력 : 60
		//		   인덱스1 출력 : 1	인덱스2 출력 : 2
		System.out.println();
		
		int num3;
		System.out.println("값 입력 : ");
		num3 = scan.nextInt();
		
		for (int i = 0; i < arr.length; i ++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (num3 == arr[i][j])
				System.out.println("인덱스1 출력 : " + i + " , 인덱스2 출력 : " + j);
			}
			}
		
		System.out.println();
		// 문제 3) 가장 큰 값의 인덱스 2개 출력
		// 정답 3) 2 2
		
		int max = 0;
		int maxIndex1 = 0;
		int maxIndex2 = 0;
		for (int i = 0; i < arr.length; i++){
			for (int j = 0; j < arr[i].length; j++) {
				if (max < arr[i][j]) {
					max = arr[i][j];
					maxIndex1 = i;
					maxIndex2 = j;
				}
			}
			
			
		}
		System.out.println("가장 큰 값의 인덱스1 출력 : " + maxIndex1 + " , 인덱스2 출력 : " + maxIndex2);
		System.out.println();
		
		// 문제 4) 값 2개를 입력받아 값 교체
		
		for (int i = 0; i < arr.length; i ++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("교체할 2개 값 입력 : ");
		int num4 = scan.nextInt();
		int num5 = scan.nextInt();
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				 if (num4 == arr[i][j])
					 arr[i][j] = num5;
				 else if (num5 == arr[i][j]) 
					 arr[i][j] = num4;
			}
		}
		
		for (int i = 0; i < arr.length; i ++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}


	}

}
