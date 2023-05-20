package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2473_세용액_골3 {
	static int N;
	static long number[], answer[];
	static long max = Long.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		number = new long[N];
		answer = new long[3];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			number[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(number);
		for (int i = 0; i < N; i++) {
			search(i);
		}
		Arrays.sort(answer);

		for (long i : answer) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}

	public static void search(int index) {
		int start = index + 1;
		int end = N - 1;
		while (start < end) {
			long mid = number[start] + number[end] + number[index];
			if (Math.abs(mid) < max) {
				max = Math.abs(mid);
				answer[0] = number[index];
				answer[1] = number[start];
				answer[2] = number[end];
			}
			if (mid <= 0) {
				start++;
			} else {
				end--;
			}
		}
	}

}
