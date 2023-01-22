package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_10816_숫자카드2_실4.java
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
public class Main_10816_숫자카드2_실4 {
	static int N, M, sangca[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// 상근이 갖고있는 카드 입력
		N = Integer.parseInt(br.readLine());
		sangca = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sangca[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sangca);
		// 구하려는 카드 목록
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int find = Integer.parseInt(st.nextToken());
			sb.append(upper(find) - lower(find)).append(" ");
		}

		System.out.println(sb.toString());
	}

	public static int upper(int target) {
		int start = 0, end = sangca.length;
		while (start < end) {
			int mid = (start + end) / 2;
			if (target < sangca[mid]) {// 그 지점
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}

	public static int lower(int target) {
		int start = 0, end = sangca.length;
		while (start < end) {
			int mid = (start + end) / 2;
			if (target <= sangca[mid]) {// 그 지점
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}
}

/* upper lower 는 헷갈리면 그냥 외우는게 좋을듯... 코드는 같아서.. 같은거 안같은거를 구별해놓자
 * 같은데도 계속 내려가보자 ->lower 
 * 같은데도 계속 올라가보자 ->upper*/
 