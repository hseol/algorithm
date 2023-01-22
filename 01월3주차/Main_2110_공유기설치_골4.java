/**
 * 
 */
package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_2110_공유기설치_골4.java
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
public class Main_2110_공유기설치_골4 {

	/**
	 * @param args
	 * @throws IOException
	 */
	static int N, C, arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int start = 1;
		int end = arr[N - 1] - arr[0] + 1;
		int answer = 0;

		while (start < end) {
			int mid = (start + end) / 2;
			if (internet(mid) < C) {// 이걸로 나눠봤더니 공유기 개수 C가 안될때
				// 거리를 낮춰야해
				end = mid;
			} else {
				// 공유기개수가 C이상일때 한번 줄여본다.
				answer = mid;
				start = mid + 1;
			}
		}
		System.out.println(answer);

	}

	public static int internet(int mid) {
		int count = 1, last = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - last >= mid) {
				count++;
				last = arr[i];

			}
		}
		return count;
	}

}
