package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_13164_행복유치원_골5 {
	static int N, M, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		result = 0;
		int[] arr = new int[N];
		int[] diff = new int[N - 1];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 입력 끝
		if (M >= N) { // 조 개수가 인원 수랑 같으면 차이가없으니까 비용이 0
			System.out.println(result);
			return;
		}
		for (int i = 1; i < N; i++) {
			diff[i - 1] = arr[i] - arr[i - 1];
		} // 차이를 입력해유
		Arrays.sort(diff);
		for (int i = diff.length - M; i >= 0; i--) {
			result += diff[i];
		}
		System.out.println(result);

	}

}
/*
 * 센서랑 같은 문제였음 ㅋㅋ 대박 운좋다 이런 형식의 문제가 나오나보다 기억해둬야징
 */
