/**
 * 
 */
package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @FileName : Main_12852_1로만들기2_실1.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 5. 19.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_12852_1로만들기2_실1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N= Integer.parseInt(br.readLine());
		int [] dp = new int[N+1];
		int[] trace = new int[N+1];
		trace[1] = -1;
		for(int i=2;i<=N;i++) {
			dp[i] = dp[i-1]+1;
			trace[i]= i-1;
			if(i%2==0) {
				if(dp[i]>(dp[i/2]+1)) {
					dp[i] =dp[i/2]+1;
					trace[i] = i/2;
				}
			}
			if(i%3==0) {
				if(dp[i]>(dp[i/3]+1)) {
					dp[i] =dp[i/3]+1;
					trace[i] =i/3;
				}
			}

		}
		int index=N;
		sb.append(dp[N]).append("\n");
		for(int i=0;i<=dp[N];i++) {
			sb.append(index).append(" ");
			index= trace[index];
		}
		System.out.println(sb);
		
	}

}
