
package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_2805_나무자르기_실2.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 1. 22.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_2805_나무자르기_실2 {
	static int N, M, tree[], max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tree = new int[N];
		max = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			if (max < tree[i]) {
				max = tree[i];// 제일 높은값 정하기
			}
		} // 입력 끝
		lower();

	}

	public static void lower() {
		int start = 0;
		int end = max;
		int mid = 0;
		long count;
		while (start < end) {
			mid = (start + end) / 2;// 나무의 길이
			count = 0;
			for (int i = 0; i < N; i++) {
				if (tree[i] - mid > 0) {
					count += tree[i] - mid;
				}
			}
			//System.out.println("count : "+count);
			if (count < M) {// 너무 높게 잘라서 길이를 줄여야지
				end = mid;
			} else {
				start = mid + 1; // 더 나무크기를 키울수있는지
			}

		}
		System.out.println(start-1);
	}

}
/*int, long 범위에 주의합시다.. ㅠ */
