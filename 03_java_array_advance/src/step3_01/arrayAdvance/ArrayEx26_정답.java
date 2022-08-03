package step3_01.arrayAdvance;

import java.util.Scanner;

/* 
 * # 1 to 50[3단계] : 1 to 18
 * 
 * 1. 구글에서 1 to 50 이라고 검색한다.
 * 2. 1 to 50 순발력 게임을 선택해 게임을 실습해본다.
 * 3. 위 게임을 숫자범위를 좁혀 1 to 18로 직접 구현한다.
 * 4. 숫자 1~9는 front 배열에 저장하고,
 *    숫자 10~18은 back 배열에 저장한다.
 */


public class ArrayEx26_정답 {

	public static void main(String[] args) {
	
		final int SIZE = 9;
		
		int[] front = new int[SIZE];
		int[] back  = new int[SIZE];
		
		Scanner scan = new Scanner(System.in);
		
		
		
		for (int i = 0; i < 9; i++) {
			front[i] = i + 1;
		}
		for (int i = 0; i < 9; i++) {
			back[i] = i + 10;
		}
		
		int cnt = 0;
		int index;
		for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(front[j] + "\t");
				
					if ((j + 1) % 3 == 0) {
						System.out.println();
					}
				}
				System.out.print("[" + (i + 1) +"]의 인덱스 입력 : " );
				cnt++;
				index = scan.nextInt();
				front[i] = back[i];
			}
		
		for (int i = 0; i < 9; i++) {
			
			
		}
		
	}
	
}
		
		
	
	
