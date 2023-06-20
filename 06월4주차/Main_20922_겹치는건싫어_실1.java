/**
 * 
 */
package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_20922_겹치는건싫어_실1.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 6. 20.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_20922_겹치는건싫어_실1 {
	static int N, K, arr[], numbers[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int result = 0;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		numbers = new int[100001];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int end = start;
		while (end < N) {
			if (numbers[arr[end]] == K) {// 내가 지금 접근하려는 애가 이미 다 찬 상태
				numbers[arr[start]]--;
				start++;
			} else {
				numbers[arr[end]]++;
				end++;
			}
			// System.out.println(end-start);
			result = Math.max(result, end - start);
		}
		System.out.println(result);

	}

}
