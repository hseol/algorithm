package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @FileName : Main_1003_피보나치함수_실3.java
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
public class Main_1003_피보나치함수_실3 {
	static int T, zero, one, N;
	static Integer[][] fifi;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb;
		fifi = new Integer[41][2];
		fifi[0][0] = 1;
		fifi[0][1] = 0;
		fifi[1][0] = 0;
		fifi[1][1] = 1;
		// 0과 1의 호출횟수도 결국 쌓이니까.. 누적해서 쌓아올리는거지
		sb = new StringBuilder();
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());

			fibo(N);
			sb.append(fifi[N][0]).append(" ").append(fifi[N][1]).append("\n");
		}
		System.out.println(sb.toString());

	}

	public static Integer[] fibo(int n) {
		if (fifi[n][0] == null || fifi[n][1] == null) {// 아직한번도 탐색하지 않았으면
			fifi[n][0] = fibo(n - 1)[0] + fibo(n - 2)[0];
			fifi[n][1] = fibo(n - 1)[1] + fibo(n - 2)[1];
		}
		return fifi[n];

	}

}

/*
 * Integer 배열은 null로 초기화를 할 수 있다는걸 처음알았다.. ㅎㅎ 부끄럽다 그리고 저런식으로 이차원배열을 이용할 수
 * 있는것도... 처음알았다.. 부끄럽다...
 */