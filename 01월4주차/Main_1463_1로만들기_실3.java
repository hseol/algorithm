/**
 * 
 */
package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @FileName : Main_1463_1로만들기_실3.java
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
public class Main_1463_1로만들기_실3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] number = new int[N + 1];
		for (int i = 2; i <= N; i++) {
			number[i] = number[i - 1] + 1;
			if (i % 2 == 0) {// 2로 나누어 떨어지면
				number[i] = Math.min(number[i], number[i / 2] + 1);
			}
			if (i % 3 == 0) {// 3으로 나누어 떨어지면
				number[i] = Math.min(number[i], number[i / 3] + 1);
			}
		}
		System.out.println(number[N]);
	}

}
