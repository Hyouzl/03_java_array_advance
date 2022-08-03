package step3_01.arrayAdvance;

import java.util.Random;
import java.util.Scanner;

//# 빙고 Ver1(플레이어 1명)

public class ArrayEx45_문제 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		int maxNum = 5; 
		int[][] bingo = new int[maxNum][maxNum];
		int[][] mark = new int[maxNum][maxNum];	
		int[] temp = new int[maxNum*maxNum];
		int size = 50;	
		int win = 0;
		
		// 중복을 제거한 랜덤숫자를 임시 저장 **
		for (int i=0; i < temp.length; i++) {
			temp[i] = ran.nextInt(size) + 1;
			for (int j = 0; j < i; j++) {
				if (temp[i] == temp[j]) { 
					i--; // 인덱스 i 값의 전인덱스값들과 겹치는 것이 있는지 확인. 있다면 인덱스 i 한개 뒤로..
				}
			}
		}
		
		// 중복을 제거한 랜덤숫자를 빙고판에 대입
		int k = 0;
		for (int i = 0; i < maxNum; i++) {
			for (int j = 0; j < maxNum; j++) {
				bingo[i][j] = temp[k];
				k++;
			}
		}
		
		
		
		while (true) {
			System.out.println("=============== BINGO GAME ===============");
			System.out.print("\t");
			for (int i = 0; i < maxNum; i++) {
				System.out.print(i + "\t");
			}
			System.out.println("\n");
			for (int i = 0; i < maxNum; i++) { //세로칸 ( Y칸 )
				System.out.print(i + "\t");
				for (int j = 0; j < maxNum; j++) { // 가로 빙고판.
					if (mark[i][j] == 0) { // 마크한 곳이 아니면..값 출력
						System.out.print(bingo[i][j] + "\t");
					}
					else {
						System.out.print("O\t"); // 마크한 곳이면 0으로 출력
					}
				}
				System.out.println("\n");
			}

			if (win == 1) { //좌표 묻기 전에 검사했을 때 빙고가 나온 상태면 게임 종료.
				System.out.println("게임종료");
				break;
			}
			
			System.out.print("y좌표 입력 : "); //2차원배열에 행은 Y좌표
			int meY = scan.nextInt();
			System.out.print("x좌표 입력 : "); //2차원배열에 열은 X좌표
			int meX = scan.nextInt();
			
			if (mark[meY][meX] == 0) { // 마크한 곳이 아닌 곳을 지정했다면 1로 변경
				mark[meY][meX] = 1;
			}
			
			// 가로검사
			for (int i = 0; i < maxNum; i++) {
				int cnt = 0; // 한 행마다 개수 초기화
				for (int j = 0; j < maxNum; j++) {
					if (mark[i][j] == 1) {
						cnt++; 
					}
				}
				if (cnt == 5) { // 한 행에서 빙고가 나오면 (마크한 곳이 5개) 이면 break. 
					win = 1;
					break;
				}
			}
			
			// 세로검사
			for (int j = 0; j < maxNum; j++) {
				int cnt = 0;
				for (int i = 0; i < maxNum; i++) {
					if (mark[i][j] == 1) {
						cnt++;
					}
				}
				if (cnt == 5) {
					win = 1;
					break;
				}
			}
			
			// 대각선 검사
			int cnt = 0;
			for (int i = 0; i < maxNum; i++) {
				if (mark[i][i] == 1) { //우대각선
					cnt++;
				}
			}
			if (cnt == 5) {
				win = 1;
			}
			
			cnt = 0;
			for (int i = 0; i < maxNum; i++) {
				if (mark[i][(maxNum-1)-i] == 1) { //좌대각선
					cnt++;
				}
			}
			if (cnt == 5) {
				win = 1;
			}
			
		}

		scan.close();
	}

}
