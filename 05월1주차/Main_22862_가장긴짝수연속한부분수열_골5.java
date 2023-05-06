package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_22862_가장긴짝수연속한부분수열_골5.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 5. 2.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_22862_가장긴짝수연속한부분수열_골5 {
	static int N, K, check[];
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		check = new int[N];
		st = new StringTokenizer(br.readLine());
		int tmp = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num % 2 == 0) {
				check[i] = 1;
			} else {
				check[i] = 0;
				tmp++;
			}

		} // 입력 끝

		if (K >= tmp) {// 전체를 다 덮을만큼 k가 존재한다면
			System.out.println(N - tmp);
			return;
		}
		int start = 0;
		int end = 0;
		int remove = K;
		int count = 0;

		// 초기 생성
		while (end < N) {
			if (remove <= 0) {
				if (check[end] == 0) {
					if (check[start] == 1) {
						count--;
						start++;
					} else {
						remove++;
						start++;
					}
				} else { // check[end] 짝수면 remove 없어도 상관없으니까
					count++;
					end++;
				}
			} else if (remove > 0) {
				// end를 옮겨
				if (check[end] == 1) {
					count++;
					end++;
				} else {
					remove--;
					end++;
				}
			}
			answer = Math.max(answer, count);

		}
		System.out.println(answer);

	}

}
