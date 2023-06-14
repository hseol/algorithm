/**
 * 
 */
package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_11501_주식_실2.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 6. 14.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_11501_주식_실2 {
	static int N;
	static long arr[], stock, max,result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			arr = new long[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Long.parseLong(st.nextToken());
			}
			stock = 0;
			result = 0;
			max = arr[N - 1];
			for (int i = N - 2; i >= 0; i--) {
				if (arr[i] < max) { // 뒤에보다 더 작다면
					// 주식 사
					stock++;
					result -= arr[i];

				} else if (arr[i] > max) {
					if (stock > 0) { // 갖고있는 주식이 있다면 미리 팔어
						result += (stock * max);
						stock = 0;
					}
					max = arr[i];

				}
			}
			result += (stock * max);
			sb.append(result).append("\n");
		}
		System.out.println(sb);

	}

}
