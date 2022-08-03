package step3_01.arrayAdvance;

import java.util.Scanner;

/*
 *	# 관리비
*/

//28-
public class ArrayEx40_정답 {

	public static void main(String[] args) {
		
		int[][] apt = {
				{101, 102, 103},	
				{201, 202, 203},	
				{301, 302, 303}	
			};
			
		int[][] pay = {
			{1000, 2100, 1300},	
			{4100, 2000, 1000},	
			{3000, 1600,  800}
		};
			
		Scanner scan = new Scanner(System.in); 
		// 문제 1) 각층별 관리비 합 출력
		// 정답 1) 4400, 7100, 5400
		
		
		for (int i = 0; i <apt.length; i++) {
			int sum = 0;
			for (int j = 0; j < apt[i].length; j++) {
				sum += pay[i][j];
			}
			System.out.print(sum + " ");
		}
		System.out.println();
		
		// 문제 2) 호를 입력하면 관리비 출력
		// 예    2) 입력 : 202	관리비 출력 : 2000
		
		System.out.println("입력 : ");
		int hosu = scan.nextInt();
		
		for (int i = 0; i < apt.length; i++) {
			for (int j = 0; j < apt[i].length; j++) {
				if (hosu == apt[i][j]) {
					System.out.println("관리비 출력 : " + pay[i][j]);
				}
			}
		}
		
		System.out.println();
		
		
		// 문제 3) 관리비가 가장 많이 나온 집, 적게 나온 집 출력
		// 정답 3) 가장 많이 나온 집(201), 가장 적게 나온 집(303)
		
		int max = 0;
		int index1=0;
		int index2=0;

		
		for (int i = 0; i < apt.length; i++) {
			for(int j = 0; j < apt[i].length; j++) {
				if (max < pay[i][j]) { 
					max = pay[i][j];
					index1 = i;
					index2 = j;
				}
			}
		}
		
		System.out.println("관리비가 가장 많이 나온 집 : " + apt[index1][index2] + "호");
		int min = max;
		
		for (int i = 0 ; i < apt.length; i++)
		{
			for (int j = 0; j < apt[i].length; j++) {
				if (min > pay[i][j]) {
					min = pay[i][j];
					index1 = i;
					index2 = j;
				}
					
			}
		}
		
		System.out.println("가장 낮게 나온 집 : " + apt[index1][index2] + "호");
		
		System.out.println();
		
		// 문제 4) 호 2개를 입력하면 관리비 교체
		

		for (int i = 0; i < apt.length; i++) {
			for(int j = 0; j < apt[i].length; j++) {
				System.out.print(apt[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("교체할 2개 호수 입력 : ");
		int hosu1 = scan.nextInt();
		int hosu2 = scan.nextInt();
		index1 = 0;
		index2 = 0;
		int index3 = 0;
		int index4 = 0;
		int temp;

		for (int i = 0; i < apt.length; i++) {
			for(int j = 0; j < apt[i].length; j++) {
				if (hosu1 == apt[i][j]) {
					index1 = i;
					index2 = j;
				}
			}
		}
		for (int i = 0; i < apt.length; i++) {
			for(int j = 0; j < apt[i].length; j++) {
				if (hosu2 == apt[i][j]) {
					index3 = i;
					index4 = j;
				}
			}
		}
		
		
		temp = apt[index1][index2];
		apt[index1][index2] = apt[index3][index4];
		apt[index3][index4] = temp;
		
		for (int i = 0; i < apt.length; i++) {
			for(int j = 0; j < apt[i].length; j++) {
				System.out.print(apt[i][j] + " ");
			}
			System.out.println();
		}

	}

}
