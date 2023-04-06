/**
 * 
 */
package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_13144_ListofUniqueNumber_골4.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 4. 6.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_13144_ListofUniqueNumber_골4 {
	static int N;
	static boolean[] number;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int max = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (max < arr[i]) {
				max = arr[i]; // 최대값 찾기
			}
		} // 입력끝
		number = new boolean[max + 1];
		long count = 0;
		int start = 0;
		int end = 0;
		while (start < N) {
			while (end < N && !number[arr[end]]) { // 처음 가는 곳
				number[arr[end]] = true;
				end++;
			}
			count += end - start;
			number[arr[start++]] = false;

		}

		System.out.println(count);

	}

}
/*
 * 불린체크나 리스트.contains 확인해서 앞에서부터 탐색하면 무조건 메모리초과나 시간초과가 남 
 * 처음엔 포문 두개여서 그런줄 알았는데.. ㅠㅠ 메모리가 터무니 없이 작음 ㅋㅋㅋ 
 * 앞에서부터 찾다가 뒤에서 끝나면 앞을 땡기는걸로 범위를 줄여나가면서 카운트... 
 * 똑똑한 문제네... 
 * 
 * */
