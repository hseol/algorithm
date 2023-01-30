
package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_1932_정수삼각형_실1.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 1. 30.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_1932_정수삼각형_실1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Integer[][] tri = new Integer[N + 1][N + 1];
		int[][] sum = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int j = 1;
			while (st.hasMoreTokens()) {
				tri[i][j] = Integer.parseInt(st.nextToken());
				j++;
			}
		} // 입력끝
		sum[1][1] = tri[1][1];
		int ans = sum[1][1];
		if (N >= 2) {
			for (int i = 2; i <= N; i++) {
				for (int j = 1; j <= i; j++) {

					sum[i][j] = Math.max(sum[i - 1][j], sum[i - 1][j - 1]) + tri[i][j];

				}
			}
			
			for(int i=1;i<=N;i++) {
				ans = Math.max(ans, sum[N][i]);
			}
		}
		
		System.out.println(ans);

	}

}

/* 처음에 파스칼삼각형인줄알고 놀랐음ㅋㅋ 
integer 배열 사용하기 좋은 문제인듯 굿~ 
디피문제 이렇게 나오면 참 좋겠당 히히 
*/