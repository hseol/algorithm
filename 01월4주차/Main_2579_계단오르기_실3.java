/**
 * 
 */
package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @FileName : Main_2579_계단오르기_실3.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 1. 29.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_2579_계단오르기_실3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stair = new int[N + 1];
		int[] count = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		count[1] = stair[1];
		if (N >= 2) {
			count[2] = stair[1] + stair[2]; // 0에서 2로 뛰어오른것보다는 당연히 1,2칸 둘다 밟는게 더 크니까
		}
		for (int i = 3; i <= N; i++) {
			count[i] = Math.max(count[i - 2], count[i - 3] + stair[i - 1]) + stair[i];// 두칸뛰어서 한 값이랑, 내 전에거 밟고 한번왔으면 그
																						// 전은 무조건 2칸전이니까 -1과 -3비교
		}

		System.out.println(count[N]);

	}

}
