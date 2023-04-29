/**
 * 
 */
package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_10815_숫자카드_실5.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 4. 29.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_10815_숫자카드_실5 {

	/**
	 * @param args
	 */
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		StringTokenizer st;
//		Set<String> set = new HashSet<>();
//		int N = Integer.parseInt(br.readLine());
//		st = new StringTokenizer(br.readLine());
//		for (int i = 0; i < N; i++) {
//			set.add(st.nextToken());
//		}
//		int M = Integer.parseInt(br.readLine());
//		st = new StringTokenizer(br.readLine());
//		for (int i = 0; i < M; i++) {
//			if (set.contains(st.nextToken())) {
//				sb.append(1).append(" ");
//			} else {
//				sb.append(0).append(" ");
//			}
//		}
//		System.out.println(sb);
//
//	}
	static int N,M, arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int start, end;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);// 정렬된 배열

		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		while (M-- > 0) {
			start = 0;
			end = N - 1;
			int num = Integer.parseInt(st.nextToken());
			sb.append(Binary(num, start, end)).append(" ");
			
		}
		System.out.println(sb);

	}

	public static int Binary(int num, int start, int end) {
		int mid = (start + end) / 2;
		while (start <= end) {
			mid = (start + end) / 2;
			if (arr[mid] == num) {
				return 1;
			} else if (num > arr[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return 0;
	}
	

}
