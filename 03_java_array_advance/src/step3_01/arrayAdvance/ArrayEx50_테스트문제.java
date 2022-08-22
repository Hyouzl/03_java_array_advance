package step3_01.arrayAdvance;

import java.util.Scanner;

import javax.sql.rowset.serial.SQLOutputImpl;

/*
  
	문제1) 1 ~ 백만 사이의 숫자를 입력받고 가운데 숫자 출력 
	(단 ! 짝수자리의 수는 짝수자리라고 출력)
	예)  123 ==> 2
	예)  1234 ==> 짝수의 자리이다
	예)  1 ==> 1
	예)  1234567 ==> 4
	
	힌트) 자리수를 구하고 배열을 만든다음 하나씩 저장 
	예) ==> 123 ==> 3 ==> arr[] = new int[3];
	
*/

public class ArrayEx50_테스트문제 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자 입력 :");
		
		int num = scan.nextInt();
		int temp = num;
		int len = 0;
		
		while (true) {
			if (temp == 0) {
				break;
			}
			len++; 
			temp /= 10;
		}
	
		
		int[] arr = new int[len];
		
		int i = 0;
		while (true) {
			if (i == len) {
				break;
			}
			arr[i] = num % 10;
			num /= 10;
			i++;
		}
		
		if (len % 2 == 0) {
			System.out.println("짝수의 자리이다.");
		}
		
		else {
			System.out.println("==>" + arr[(len-1) / 2]);
		}
		
		
		
		
	}

}
