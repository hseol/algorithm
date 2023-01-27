
package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @FileName : Main_2775_부녀회장이될테야_브1.java
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
public class Main_2775_부녀회장이될테야_브1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T, K, N;
		int [][] apart;
		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			K = Integer.parseInt(br.readLine());
			N = Integer.parseInt(br.readLine());
			apart = new int [K+1][N+1];
			for(int i=1;i<=N;i++) {
				apart[0][i]=i;
			}//0층의 사람들
			
			for(int i =1;i<=K;i++) {
				for(int j=1;j<=N;j++) {
					apart[i][j] = apart[i][j-1]+apart[i-1][j];
				}
			}
			System.out.println(apart[K][N]);
		}
	}

}
