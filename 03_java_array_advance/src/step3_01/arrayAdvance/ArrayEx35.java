package step3_01.arrayAdvance;

import java.util.Scanner;

/*
 * 
 * # 배열 컨트롤러[2단계] : 벡터(Vector)
 * 
 * 1. 추가
 * . 값을 입력받아 순차적으로 추가
 * 2. 삭제(인덱스)
 * . 인덱스를 입력받아 해당 위치의 값 삭제
 * 3. 삭제(값)
 * . 값을 입력받아 삭제
 * . 없는 값 입력 시 예외처리
 * 4. 삽입
 * . 인덱스와 값을 입력받아 삽입
 * 
 */



public class ArrayEx35 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] score = null;
		int elementCnt = 0;
		
		while (true) {
			
			for (int i=0; i<elementCnt; i++) {
				System.out.print(score[i] + " ");
			}
			System.out.println();
			
			System.out.println("[벡터 컨트롤러]");
			System.out.println("[1]추가");
			System.out.println("[2]삭제(인덱스)");
			System.out.println("[3]삭제(값)");
			System.out.println("[4]삽입");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if (sel == 1) {
				if (elementCnt == 0) {
					score = new int[elementCnt + 1]; //  int[0] 배열 1개 생성
				}
				else if (elementCnt > 0){ 
					int[] temp = score; //temp배열에 score 배열 옮기기 
					score = new int[elementCnt + 1]; // 배열 크기를 한칸늘림
					
					
					for (int i=0; i<elementCnt; i++) {
						score[i] = temp[i]; //score 배열 백업
					}
					
					temp = null;
				}
				System.out.print("[추가]성적 입력 : ");
				int data = scan.nextInt();
				// 배열 크기 늘리고 , 배열 값 추가. 
				score[elementCnt] = data;
				elementCnt++;
				//배열 값 추가 하고 배열 개수 업
			}
			else if (sel == 2) {
				System.out.print("[삭제]인덱스 입력 : ");
				int delIdx = scan.nextInt(); 
				
				if (elementCnt-1 < delIdx || delIdx < 0) { //배열 요소의 개수의 -1 은 배열인덱스의 마지막 따라서 그 수 보다 큰 인덱스 삭제 불가능
					System.out.println("[메세지]해당 위치는 삭제할 수 없습니다.");
					continue;
				}
				
				if (elementCnt == 1) { //배열요소가 1개만 있으면 배열 null로 초기화?
					score = null;
				}
				else if (elementCnt > 1) { // 배열요소가 1개보다 많으면
					int[] temp = score; // temp 에 score 배열 옮기기
					score = new int[elementCnt - 1]; // 지우려는 인덱스를 제외한 배열의 크기로 다시 셋팅(?)
					
					for (int i=0; i<delIdx; i++) {// 지우려는 인덱스 전까지 다시 스코어에 백업
						score[i] = temp[i];
					}
					for (int i=delIdx; i<elementCnt-1; i++) { // 지우려는 인덱스의 다음 인덱스 값 부터 백업
						score[i] = temp[i + 1];
					}
					temp = null; // temp 비우기
				}
				
				elementCnt--; //삭제한 인덱스 만큼 배열요소 카운트 다운.
			}
			else if (sel == 3) {
				System.out.print("[삭제]값 입력 : "); //삭제하려는 값 입력
				int delData = scan.nextInt();
				
				int delIdx = -1;
				for (int i=0; i<elementCnt; i++) { // 배열의 마지막까지 삭제하려는 값과 일치하는 게 있는지 확인
					if (score[i] == delData) {
						delIdx = i;
					}
				}
				
				if (delIdx == -1) { 
					System.out.println("[메세지]입력하신 값은 존재하지 않습니다.");
					continue;
				}
				
				if (elementCnt == 1) { // 요소가 한개밖에 없으면 그냥 초기화
					score = null;
				}
				else if (elementCnt > 1) { // 한개보다 많으면
					int[] temp = score; // temp 로 score 옮기기
					score = new int[elementCnt - 1]; // 삭제하려는 값을 제외한 배열의 크기로 다시 셋팅
					
					int j = 0;
					for (int i=0; i<elementCnt; i++) {
						if (i != delIdx) {
							score[j++] = temp[i]; // 삭제하려는 값의 인덱스가 아니면 score 배열에 temp값 백업.
						}
					}
					
					temp = null;
				}
				
				elementCnt--;				
			}
			else if (sel == 4) {
				System.out.print("[삽입]인덱스 입력 : ");
				int insertIdx = scan.nextInt();
				
				if (elementCnt < insertIdx || insertIdx < 0) { //배열의 마지막 인덱스 다음 인덱스보다 큰 값에는 삽입 불가능.
					System.out.println("[메세지]해당 위치는 삽입할 수 없습니다.");
					continue;
				}
				
				System.out.print("[삽입]값 입력 : ");
				int insertData = scan.nextInt();
				
				if (elementCnt == 0) {
					score = new int[elementCnt + 1]; 
				}
				else if (elementCnt > 0) {
					int[] temp = score;
					score = new int[elementCnt + 1];
					
					int j = 0;
					
					for (int i=0; i<elementCnt + 1; i++) {
						if (i != insertIdx) {
							score[i] = temp[j++]; //삽입하려는 인덱스의 값이 아닐 때 score값에 temp 백업
						}
					}
					temp = null;
				}
				
				score[insertIdx] = insertData; 
				elementCnt++;
			}
			else if (sel == 0) {
				break;
			}
		}

		scan.close();

	}

}