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

/*
 * 백준에서 힌트를 보고 접근하기 시작 이분탐색+매개변수탐색 이렇게 많이 쓰는 것 같음 
 * 최대의~~ 것에서 최소거리 
 * 최소한의 ~~ 것에서 최대거리 이런식으로 문제가 많이 출제됨 
 * 이분탐색으로 범위를 줄여나가는 방식을 사용 
 * 이분탐색이 중심 알고리즘이라기 보다는... 내가 생각할 수 있는 범위를 빠르게 줄여주는 용도로 사용되는것 같음
 * 반박시 니 말이 맞음*/
