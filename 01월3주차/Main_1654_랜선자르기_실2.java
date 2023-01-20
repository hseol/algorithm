
package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_1654_랜선자르기_실2.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 1. 21.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_1654_랜선자르기_실2 {
	static int K, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long max = 0;
		long min = 1;
		long mid = 0;
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int[] arr = new int[K];
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (max < arr[i]) {
				max = arr[i];
			}

		} // 입력 끝
		max++; //0이 계속 되는 경우가 생겨서.. 추가해줘야한다함.. ㅎㅎ 
		while (min < max) {
			mid = (min + max) / 2;
			long count = 0;
			for (int i = 0; i < arr.length; i++) {
				count += (arr[i] / mid);
			}
			if (count < N) {
				max = mid;
			} else {
				min = mid + 1;
			}
		} // 와일끝
		System.out.println(min - 1);

	}

}
