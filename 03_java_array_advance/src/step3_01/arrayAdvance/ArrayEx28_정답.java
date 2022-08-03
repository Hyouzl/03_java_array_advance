package step3_01.arrayAdvance;

import java.util.Random;

/*
 * # 중복숫자 금지[2단계]
 * 
 * 1. arr배열에 1~10 사이의 랜덤 숫자 5개를 저장한다.
 * 2. 단 중복되는 숫자가 없어야 한다.
 */

//7:38
public class ArrayEx28_정답 {

	public static void main(String[] args) {
		
		int[] arr = new int[5];
		int[] isFrist = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		Random ran = new Random();
		int num;
		int i = 0;

		
		while (true) {
			num = ran.nextInt(10) + 1;
			if (i == 5) {
				for (int j = 0; j < 5; j++) {
					System.out.print(arr[j] + " ");
				}
				break;
			}
			else if (isFrist[num-1] == 0) {
				isFrist[num-1]++;
				arr[i] = num;
				i++;
			}
			else continue;
			
			
		}
		
		
		
	}
	
}
