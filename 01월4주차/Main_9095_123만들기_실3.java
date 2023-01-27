
package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @FileName : Main_9095_123만들기_실3.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 1. 28.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_9095_123만들기_실3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int N;
		int arr[] = new int[11];
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			arr[1] = 1;
			arr[2] = 2;
			arr[3] = 4;

				for (int i = 4; i <= N; i++) {
					arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
				}
			System.out.println(arr[N]);
		}

	}

}

/* 왜 배열을 동적할당으로 받으면 인덱스에러가 나는걸까... 나는 궁금해.. */
