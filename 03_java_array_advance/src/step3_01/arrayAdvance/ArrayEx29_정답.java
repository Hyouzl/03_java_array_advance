package step3_01.arrayAdvance;

import java.util.Random;

/*
 * # 숫자 야구 게임
 * 
 * 1. me에 1~9 사이의 숫자 3개를 저장
 *    (단, 중복되는 숫자는 저장 불가)
 * 2. com과 me를 비교해 정답을 맞출 때까지 반복
 * 3. 숫자와 자리가 같으면 		    strike += 1
 *    숫자만 같고 자리가 틀리면 	ball += 1
 * 예)
 * 정답 : 1 7 3
 * 3 1 5		: 2b
 * 7 5 1        : 1b
 * 1 5 6		: 1s
 * 1 7 3        : 1s 2b
 * 2 4 9        : 없음
 * 1 7 3        : 3s  > 게임종료
 * 
 */

public class ArrayEx29_정답 {

	public static void main(String[] args) {
		
		int[] com = {1,7,3};
		int[] me  = new int[3];
	
		
		Random ran = new Random();
		 
		while (true) {
			int strike = 0;
			int ball = 0;
			int[] isFirst = {0, 0, 0, 0, 0, 0, 0, 0};
			
			for (int i = 0; i < 3; i++) {
				int num = ran.nextInt(8);
				if (isFirst[num] == 0) {
					isFirst[num]++;
					me[i] = num + 1;
					}
				else return;
				}
		
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (com[i] == me[j]) {
						if (i == j) {
							strike++;
							ball++;
						}
						else ball++;
					}
				}
			}
		
		
		
			for (int i = 0; i < 3; i++) {
				System.out.print(me[i] + " ");
			}
			
			if (strike > 0) {
				System.out.println("\t: " + strike + "s" + ball + "b");
			}
			else if (strike == 0 && ball > 0) {
				System.out.println("\t: " + ball + "b");
			}
			else if (ball == 0) {
				System.out.println("\t: 없음 ");
			}
			else if (strike == 3) {
				System.out.println("\t: " + strike + "s >> 게임 종료");
				break;
			}
		
		}
		
		System.out.println("end");
		
	}
	
}
